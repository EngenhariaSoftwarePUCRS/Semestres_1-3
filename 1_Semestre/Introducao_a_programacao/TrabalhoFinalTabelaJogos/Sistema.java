import java.util.InputMismatchException;
import java.util.Scanner;

public class Sistema {

    ListaDePartidas listaDePartidas;
    TabelaDePontuacao tabelaDePontuacao;

    public Sistema() {
        this.listaDePartidas = new ListaDePartidas();
        this.tabelaDePontuacao = new TabelaDePontuacao();
    }

    public void inicializar() {
        int escolhaUsuario;
        do {
            mostrarOpcoes();
            System.out.print("\nEscolha uma opção: ");
            escolhaUsuario = scannerInt();

            switch (escolhaUsuario) {
                case 1:
                    exibirListaPartidas();
                    break;

                case 2:
                    consultarPartida();
                    break;

                case 3:
                    alterarNomeTime();
                    break;

                case 4:
                    exibirTabela();
                    break;

                case 5:
                    consultarTime();
                    break;

                case 6:
                    novaPartida();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Valor inválido!");
                    break;
            }
        } while (escolhaUsuario != 0);
    }

    private void mostrarOpcoes() {
        System.out.println("/==============================\\");
        System.out.println("| (1) Exibir Lista de Partidas");
        System.out.println("| (2) Consultar Partida");
        System.out.println("| (3) Alterar nome Time");
        System.out.println("| (4) Exibir Tabela");
        System.out.println("| (5) Consultar Time");
        System.out.println("| (6) Criar e Inserir Partida ");
        System.out.println("| (0) Sair");
    }

    private boolean exibirListaPartidas() {
        boolean achou = false;
        listaDePartidas.ordenarTabelaData();
        for (Partida partida : listaDePartidas.getPartidas())
            if (partida != null) {
                System.out.println(partida);
                achou = true;
            }

        if (!achou)
            System.out.println("Não existem partidas por serem exibidas.");
        return achou;
    }

    private void consultarPartida() {
        if (exibirListaPartidas()) {
            System.out.print("\nDigite o numero da partida que você deseja consultar: ");
            int consultaPartida = scannerInt();
            if (listaDePartidas.existePartida(consultaPartida))
                System.out.println(listaDePartidas.consultaPartida(consultaPartida));
            else
                System.out.println("Partida não encontrada");
        } else
            System.out.println("Não existem partidas para serem consultadas.");
    }

    private void alterarNomeTime() {
        System.out.print("\nDigite o nome do time que você deseja alterar: ");
        String timeAlterar = scannerString();
        if (tabelaDePontuacao.existeTime(timeAlterar)) {
            System.out.print("\nDigite o novo nome do time: ");
            String novoAlterarTime = scannerString();
            tabelaDePontuacao.alterarTime(timeAlterar, novoAlterarTime);
            listaDePartidas.alteraTimesPartida(timeAlterar, novoAlterarTime);
        } else
            System.out.println("Time não encontrado");
    }

    private void exibirTabela() {
        tabelaDePontuacao.ordenarTabelaPontuacao();
        for (Time time : tabelaDePontuacao.getTimes()) {
            if (time != null)
                System.out.println(time);
        }
    }

    private void consultarTime() {
        System.out.print("\nDigite o nome do time que você deseja consultar: ");
        String nomeTime = scannerString();
        if (tabelaDePontuacao.existeTime(nomeTime))
            System.out.println(tabelaDePontuacao.getTime(nomeTime));
        else
            System.out.println("Time não encontrado");
    }

    private boolean novaPartida() {
        Data dataPorInserir = pegarData();
        Time[] timesPorInserir = pegarTimes();
        if ((!tabelaDePontuacao.existeTime(timesPorInserir[0].getNomeTime()))
                && (!tabelaDePontuacao.inserirTime(timesPorInserir[0]))) {
            System.out.println("Lista cheia.");
            System.out.println("Não foi possível inserir o time e, por conseguinte, criar a partida.");
            return false;
        }
        if ((!tabelaDePontuacao.existeTime(timesPorInserir[1].getNomeTime()))
                && (!tabelaDePontuacao.inserirTime(timesPorInserir[1]))) {
            System.out.println("Lista cheia");
            System.out.println("Não foi possível inserir o time e, por conseguinte, criar a partida.");
            return false;
        }
        int[] placarPorInserir = pegarPlacar();
        listaDePartidas.inserePartida(dataPorInserir, timesPorInserir, placarPorInserir);
        Time time1 = tabelaDePontuacao.getTime(timesPorInserir[0].getNomeTime());
        time1.setPontuacao(
                time1.getPontuacao().atualizacaoPartida(placarPorInserir[0], placarPorInserir[1]));
        Time time2 = tabelaDePontuacao.getTime(timesPorInserir[1].getNomeTime());
        time2.setPontuacao(
                time2.getPontuacao().atualizacaoPartida(placarPorInserir[1], placarPorInserir[0]));

        return true;
    }

    private Data pegarData() {
        Data data = new Data();
        boolean dataValida = false;
        System.out.println("Informe a Data");

        do {
            System.out.print("Mês (1-12): ");
            data.setMes(scannerInt());
            dataValida = data.isValid();
        } while (!dataValida);
        do {
            System.out.print("Dia (1-31): ");
            data.setDia(scannerInt());
            dataValida = data.isValid();
        } while (!dataValida);
        do {
            System.out.print("Hora (0-23): ");
            data.setHora(scannerInt());
            dataValida = data.isValid();
        } while (!dataValida);
        do {
            System.out.print("Minuto (0-59): ");
            data.setMinuto(scannerInt());
            dataValida = data.isValid();
        } while (!dataValida);

        return data;
    }

    private Time[] pegarTimes() {
        Time[] times = new Time[2];

        System.out.print("Insira o Primeiro Time: ");
        times[0] = new Time(scannerString());
        System.out.print("Insira o Segundo Time: ");
        times[1] = new Time(scannerString());

        return times;
    }

    private int[] pegarPlacar() {
        int[] placar = new int[2];

        System.out.print("Quantos gols o primeiro time fez: ");
        placar[0] = scannerInt();

        System.out.print("Quantos gols o segundo time fez: ");
        placar[1] = scannerInt();

        return placar;
    }

    public int scannerInt() {
        try {
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            return scannerInt();
        }
    }

    public String scannerString() {
        try {
            return new Scanner(System.in).nextLine();
        } catch (InputMismatchException e) {
            return scannerString();
        }
    }

}