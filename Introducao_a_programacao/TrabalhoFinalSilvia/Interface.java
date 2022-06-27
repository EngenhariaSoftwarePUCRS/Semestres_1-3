import java.util.Scanner;

public class Interface {

    ListaDePartidas listaDePartidas = new ListaDePartidas();
    TabelaDePontuacao tabelaDePontuacao = new TabelaDePontuacao();

    public void iniciar() {
        Scanner input = new Scanner(System.in);

        int escolhaUsuario;
        do {
            mostrarOpcoes();
            System.out.print("\nEscolha uma opção: ");
            escolhaUsuario = input.nextInt();
            analiza(escolhaUsuario);
        } while (escolhaUsuario != 0);

    }

    private void analiza(int escolhaUsuario) {
        Scanner input = new Scanner(System.in);
        int quantidadePartidas = listaDePartidas.getQuantidadePartidas();
        switch (escolhaUsuario) {
            case 1:
                Data dataPorInserir = pegarData();
                Clube[] clubesPorInserir = pegarClubes();
                int[] placarPorInserir = pegarPlacar();
                listaDePartidas.inserePartida(dataPorInserir, clubesPorInserir, placarPorInserir);
                clubesPorInserir[0].setPontuacao(clubesPorInserir[0].getPontuacao().atualizacaoPartida(placarPorInserir[0], placarPorInserir[1]));
                tabelaDePontuacao.insereClube(clubesPorInserir[0]);
                clubesPorInserir[1].setPontuacao(clubesPorInserir[1].getPontuacao().atualizacaoPartida(placarPorInserir[1], placarPorInserir[0]));
                tabelaDePontuacao.insereClube(clubesPorInserir[1]);
                break;

            case 2:
                System.out.printf("Qual partida você quer excluir? (1-%d): ", quantidadePartidas);
                int indicePartidaPorExcluir = input.nextInt() - 1;
                if (listaDePartidas.excluiPartida(listaDePartidas.getPartida(indicePartidaPorExcluir)))
                    System.out.println("Partida excluida com sucesso.");
                else
                    System.out.println("Partida não encontrada.");
                break;

            case 3:
                System.out.printf("Qual partida você quer consultar? (1-%d): ", quantidadePartidas);
                int indicePartidaPorConsultar = input.nextInt() - 1;
                if (listaDePartidas.consultaPartida(listaDePartidas.getPartida(indicePartidaPorConsultar)))
                    System.out.println(listaDePartidas.getPartida(indicePartidaPorConsultar));
                else
                    System.out.println("Partida não encontrada.");
                break;

            case 4:
                //Alterar Nome Clube na Partida
                break;

            case 5:
                // Alterar Pontuacao na Partida
                break;

            case 6:
                listaDePartidas.exibirLista();
                break;

            case 7:
                // Ordernar por Data
                break;

            case 8:
                break;

            case 9:
                // Deletar Clube
                break;

            case 10:
                // Ver clube
                break;

            case 11:
                // Alterar nome Clube
                break;

            case 12:
                // Alterar pontuacao Clube
                break;

            case 13:
                tabelaDePontuacao.exibirTabela();
                break;

            case 14:
                tabelaDePontuacao.ordenarTabela();
                break;

            default:
                break;
        }
    }

    private void mostrarOpcoes() {
        System.out.println();
        System.out.println("1- Inserir Partida ");
        System.out.println("2- Excluir Partida");
        System.out.println("3- Consultar Partida");
        System.out.println("4- Alterar Nome do Clube na Partida");
        System.out.println("5- Alterar Pontuação da Partida");
        System.out.println("6- Exibir Lista de Partida");
        System.out.println("7- Ordernar Lista por Data");
        System.out.println("8- Inserir Clube na Tabela");
        System.out.println("9- Excluir Clube");
        System.out.println("10- Ver Clube");
        System.out.println("11- Alterar o Nome de Um Clube");
        System.out.println("12- Alterar a Pontuação de Um Clube");
        System.out.println("13- Exibir Tabela");
        System.out.println("14- Order Tabela");
        System.out.println();
        System.out.println("0- Sair");
    }

    private Data pegarData() {
        Data data = new Data();
        Scanner input = new Scanner(System.in);
        boolean dataValida = false;
        System.out.println("Informe a Data");

        do {
            System.out.print("Mês (1-12): ");
            data.setMes(input.nextInt());
            dataValida = data.validarData();
        } while (!dataValida);
        do {
            System.out.print("Dia (1-31): ");
            data.setDia(input.nextInt());
            dataValida = data.validarData();
        } while (!dataValida);
        do {
            System.out.print("Hora (0-23): ");
            data.setHora(input.nextInt());
            dataValida = data.validarData();
        } while (!dataValida);
        do {
            System.out.print("Minuto (0-59): ");
            data.setMinuto(input.nextInt());
            dataValida = data.validarData();
        } while (!dataValida);

        return data;
    }

    private Clube[] pegarClubes() {
        Clube[] clubes = new Clube[2];
        Scanner input = new Scanner(System.in);

        System.out.print("Insira o Primeiro Clube: ");
        clubes[0] = new Clube(input.nextLine());
        System.out.print("Insira o Segundo Clube: ");
        clubes[1] = new Clube(input.nextLine());

        return clubes;
    }

    private int[] pegarPlacar() {
        int[] placar = new int[2];
        Scanner input = new Scanner(System.in);

        System.out.print("Quantos gols o primeiro time fez: ");
        placar[0] = input.nextInt();

        System.out.print("Quantos gols o segundo time fez: ");
        placar[1] = input.nextInt();

        return placar;
    }

}