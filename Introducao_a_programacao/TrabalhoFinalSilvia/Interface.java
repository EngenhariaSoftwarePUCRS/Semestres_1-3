import java.util.Scanner;

public class Interface {

    static ListaDePartidas listaDePartidas = new ListaDePartidas();
    static TabelaDePontuacao tabelaDePontuacao = new TabelaDePontuacao();
    static Scanner inputInt = new Scanner(System.in);
    static Scanner inputString = new Scanner(System.in);

    public static void main(String[] args) {
        int escolhaUsuario;
        do {
            mostrarOpcoes();
            System.out.print("\nEscolha uma opção: ");
            escolhaUsuario = inputInt.nextInt();
            analiza(escolhaUsuario);
        } while (escolhaUsuario != 0);
    }

    private static void analiza(int escolhaUsuario) {
        switch (escolhaUsuario) {
            case 0:
                break;

            case 1:
                exibirListaDePartidas();
                break;

            case 2:
                System.out.print("\nDigite o numero da partida que você deseja consultar: ");
                int consultaPartida = inputInt.nextInt();
                if (listaDePartidas.existePartida(consultaPartida))
                    System.out.println(listaDePartidas.consultaPartida(consultaPartida));
                else
                    System.out.println("Partida não encontrada");
                break;

            case 3:
                System.out.print("\nDigite o nome do clube que você deseja alterar: ");
                String clubeAlterar = inputString.nextLine();
                if (tabelaDePontuacao.existeClube(clubeAlterar)) {
                    System.out.print("\nDigite o novo nome do clube: ");
                    String novoAlterarClube = inputString.nextLine();
                    tabelaDePontuacao.alteraClube(clubeAlterar, novoAlterarClube);
                } else
                    System.out.println("Clube não encontrado");
                break;

            case 4:
                exibirTabela();
                break;

            case 5:
                System.out.print("\nDigite o nome do clube que você deseja consultar: ");
                String consultaClube = inputString.nextLine();
                if (tabelaDePontuacao.existeClube(consultaClube))
                    System.out.println(tabelaDePontuacao.consultaClube(consultaClube));
                else
                    System.out.println("Clube não encontrado");
                break;

            case 6:
                Data dataPorInserir = pegarData();
                Clube[] clubes = pegarClubes();
                if (!tabelaDePontuacao.existeClube(clubes[0].getNomeClube()))
                    if(!tabelaDePontuacao.insereClube(clubes[0])) {
                        System.out.println("Lista cheia");
                        break;
                    }
                if (!tabelaDePontuacao.existeClube(clubes[1].getNomeClube()))
                    if(!tabelaDePontuacao.insereClube(clubes[1])) {
                        System.out.println("Lista cheia");
                        break;
                    }
                int[] placarPorInserir = pegarPlacar();
                listaDePartidas.inserePartida(dataPorInserir, clubes, placarPorInserir);
                Clube clube1 = tabelaDePontuacao.consultaClube(clubes[0].getNomeClube());
                clube1.setPontuacao(clube1.getPontuacao().atualizacaoPartida(placarPorInserir[0], placarPorInserir[1]));
                Clube clube2 = tabelaDePontuacao.consultaClube(clubes[1].getNomeClube());
                clube2.setPontuacao(clube2.getPontuacao().atualizacaoPartida(placarPorInserir[1], placarPorInserir[0]));
                break;

            default:
                break;
        }
    }

    private static void mostrarOpcoes() {
        System.out.println();
        System.out.println("1- Exibir Lista de Partida");
        System.out.println("2- Consultar Partida");
        System.out.println("3- Alterar nome Clube");
        System.out.println("4- Exibir Tabela");
        System.out.println("5- Consultar Clube");
        System.out.println("6- Criar e Inserir Partida ");
        System.out.println();
        System.out.println("0- Sair");
    }

    private static Data pegarData() {
        Data data = new Data();
        boolean dataValida = false;
        System.out.println("Informe a Data");

        do {
            System.out.print("Mês (1-12): ");
            data.setMes(inputInt.nextInt());
            dataValida = data.validarData();
        } while (!dataValida);
        do {
            System.out.print("Dia (1-31): ");
            data.setDia(inputInt.nextInt());
            dataValida = data.validarData();
        } while (!dataValida);
        do {
            System.out.print("Hora (0-23): ");
            data.setHora(inputInt.nextInt());
            dataValida = data.validarData();
        } while (!dataValida);
        do {
            System.out.print("Minuto (0-59): ");
            data.setMinuto(inputInt.nextInt());
            dataValida = data.validarData();
        } while (!dataValida);

        return data;
    }

    private static Clube[] pegarClubes() {
        Clube[] clubes = new Clube[2];

        System.out.print("Insira o Primeiro Clube: ");
        clubes[0] = new Clube(inputString.nextLine());
        System.out.print("Insira o Segundo Clube: ");
        clubes[1] = new Clube(inputString.nextLine());

        return clubes;
    }

    private static int[] pegarPlacar() {
        int[] placar = new int[2];

        System.out.print("Quantos gols o primeiro time fez: ");
        placar[0] = inputInt.nextInt();

        System.out.print("Quantos gols o segundo time fez: ");
        placar[1] = inputInt.nextInt();

        return placar;
    }

    private static void exibirListaDePartidas() {
        listaDePartidas.ordenarTabelaData();
        for (Partida partida : listaDePartidas.getPartidas())
            if (partida != null)
                System.out.println(partida);
    }

    private static void exibirTabela() {
        tabelaDePontuacao.ordenarTabela();
        for (Clube clube : tabelaDePontuacao.getClubes()) {
            if (clube != null)
                System.out.println(clube);
        }
    }

}