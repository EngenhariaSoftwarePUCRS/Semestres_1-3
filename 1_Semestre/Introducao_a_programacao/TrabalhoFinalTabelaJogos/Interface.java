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
                if (!exibirListaDePartidas())
                    System.out.println("Não existem partidas por serem exibidas.");
                break;

            case 2:
                if (exibirListaDePartidas()) {
                    System.out.print("\nDigite o numero da partida que você deseja consultar: ");
                    int consultaPartida = inputInt.nextInt();
                    if (listaDePartidas.existePartida(consultaPartida))
                        System.out.println(listaDePartidas.consultaPartida(consultaPartida));
                    else
                        System.out.println("Partida não encontrada");
                } else
                    System.out.println("Não existem partidas para serem consultadas.");
                break;

            case 3:
                System.out.print("\nDigite o nome do time que você deseja alterar: ");
                String timeAlterar = inputString.nextLine();
                if (tabelaDePontuacao.existeTime(timeAlterar)) {
                    System.out.print("\nDigite o novo nome do time: ");
                    String novoAlterarTime = inputString.nextLine();
                    tabelaDePontuacao.alteraTime(timeAlterar, novoAlterarTime);
                    listaDePartidas.alteraTimesPartida(timeAlterar, novoAlterarTime);
                } else
                    System.out.println("Time não encontrado");
                break;

            case 4:
                exibirTabela();
                break;

            case 5:
                System.out.print("\nDigite o nome do time que você deseja consultar: ");
                String consultaTime = inputString.nextLine();
                if (tabelaDePontuacao.existeTime(consultaTime))
                    System.out.println(tabelaDePontuacao.consultaTime(consultaTime));
                else
                    System.out.println("Time não encontrado");
                break;

            case 6:
                Data dataPorInserir = pegarData();
                Time[] times = pegarTimes();
                if (!tabelaDePontuacao.existeTime(times[0].getNomeTime()))
                    if (!tabelaDePontuacao.insereTime(times[0])) {
                        System.out.println("Lista cheia");
                        break;
                    }
                if (!tabelaDePontuacao.existeTime(times[1].getNomeTime()))
                    if (!tabelaDePontuacao.insereTime(times[1])) {
                        System.out.println("Lista cheia");
                        break;
                    }
                int[] placarPorInserir = pegarPlacar();
                listaDePartidas.inserePartida(dataPorInserir, times, placarPorInserir);
                Time time1 = tabelaDePontuacao.consultaTime(times[0].getNomeTime());
                time1.setPontuacao(time1.getPontuacao().atualizacaoPartida(placarPorInserir[0], placarPorInserir[1]));
                Time time2 = tabelaDePontuacao.consultaTime(times[1].getNomeTime());
                time2.setPontuacao(time2.getPontuacao().atualizacaoPartida(placarPorInserir[1], placarPorInserir[0]));
                break;

            default:
                break;
        }
    }

    private static void mostrarOpcoes() {
        System.out.println();
        System.out.println("1- Exibir Lista de Partida");
        System.out.println("2- Consultar Partida");
        System.out.println("3- Alterar nome Time");
        System.out.println("4- Exibir Tabela");
        System.out.println("5- Consultar Time");
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

    private static Time[] pegarTimes() {
        Time[] times = new Time[2];

        System.out.print("Insira o Primeiro Time: ");
        times[0] = new Time(inputString.nextLine());
        System.out.print("Insira o Segundo Time: ");
        times[1] = new Time(inputString.nextLine());

        return times;
    }

    private static int[] pegarPlacar() {
        int[] placar = new int[2];

        System.out.print("Quantos gols o primeiro time fez: ");
        placar[0] = inputInt.nextInt();

        System.out.print("Quantos gols o segundo time fez: ");
        placar[1] = inputInt.nextInt();

        return placar;
    }

    private static boolean exibirListaDePartidas() {
        boolean achou = false;
        listaDePartidas.ordenarTabelaData();
        for (Partida partida : listaDePartidas.getPartidas())
            if (partida != null) {
                System.out.println(partida);
                achou = true;
            }
        return achou;
    }

    private static void exibirTabela() {
        tabelaDePontuacao.ordenarTabelaPontuacao();
        for (Time time : tabelaDePontuacao.getTimes()) {
            if (time != null)
                System.out.println(time);
        }
    }

}