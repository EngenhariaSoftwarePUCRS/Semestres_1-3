import java.util.Random;
import java.util.Scanner;

// (3,0) Interface: esta classe deve ser a da aplicação. É nessa classe que devem 
// estar as interações com o usuário. Deve prever um menu com as operações 
// mencionadas. A cada manipulação de uma partida no sistema, a tabela de 
// pontuação deve ser atualizada.
public class Interface {
    Time[] times = new Time[20];
    Partida[] partidas = new Partida[(times.length) * (times.length - 1)];

    public void iniciar() {
        System.out.println("Olá! Bem vindo.");
        System.out.println("Escolha uma opção para continuar: ");
        sobreOsTimes();
    }

    private void sobreOsTimes() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n=========================");
        System.out.println("(1) Criar Times");
        System.out.println("(2) Ver Times");
        System.out.println("(3) Ver Time");
        System.out.println("(4) Atualizar Times");
        System.out.println("(5) Deletar Times");
        System.out.println("(6) Auto preenchimento");
        System.out.println("(7) Avançar");
        System.out.println("=========================\n");
        int choice = getChoice(1, 7);
        switch (choice) {
            case 1:
                System.out.print("Digite o nome do time: ");
                String nomeTimePorAdicionar = new Scanner(System.in).nextLine();
                Time timePorAdicionar = new Time(nomeTimePorAdicionar);
                boolean lotado = true;
                for (int i = 0; i < times.length; i++) {
                    if (times[i] == null) {
                        times[i] = timePorAdicionar;
                        lotado = false;
                        break;
                    }
                }
                if (lotado)
                    System.out.println("Já existem 20 times. Operação Inválida.");
                sobreOsTimes();

            case 2:
                mostrarTimes();
                sobreOsTimes();

            case 3:
                choice = timesChoice();
                System.out.println(times[choice - 1]);
                sobreOsTimes();

            case 4:
                atualizarTime();
                sobreOsTimes();

            case 5:
                choice = timesChoice();
                times[choice - 1] = null;
                sobreOsTimes();

            case 6:
                for (int i = 0; i < times.length; i++) {
                    if (times[i] == null)
                        times[i] = new Time(TimesPadrao.times[i]);
                }
                sobreOsTimes();

            case 7:
                sobreAsPartidas();

            default:
                sobreOsTimes();

        }
    }

    private void atualizarTime() {
        Scanner input = new Scanner(System.in);
        int choice = timesChoice();
        Time timePorAlterar = times[choice - 1];
        System.out.println("\nO que você quer alterar do time " + timePorAlterar.getNome());
        System.out.println("(1) Alterar Nome                    ");
        System.out.println("(2) Alterar Pontos                  ");
        System.out.println("(3) Alterar Quantidade de Vitórias  ");
        System.out.println("(4) Alterar Quantidade de Empates   ");
        System.out.println("(5) Alterar Quantidade de Derrotas  ");
        System.out.println("(6) Alterar Gols Feitos             ");
        System.out.println("(7) Alterar Gols contras            ");
        System.out.println("(8) Alterar Saldo de Gols           ");
        System.out.println("(0) Nada                            ");
        choice = getChoice(0, 8);
        switch (choice) {
            case 0:
                sobreOsTimes();
                break;

            case 1:
                System.out.print("Escolha o novo nome: ");
                String nome = input.nextLine();
                timePorAlterar.setNome(nome);
                break;

            case 2:
                System.out.print("Escolha a nova pontuação: ");
                int pontuacaoFinal = input.nextInt();
                timePorAlterar.getPontuacao().setPontuacaoFinal(pontuacaoFinal);
                break;

            case 3:
                System.out.print("Escolha a quantidade de vitórias: ");
                int qtdVitorias = input.nextInt();
                timePorAlterar.getPontuacao().setQtdVitorias(qtdVitorias);
                break;

            case 4:
                System.out.print("Escolha a quantidade de empates: ");
                int qtdEmpates = input.nextInt();
                timePorAlterar.getPontuacao().setQtdEmpates(qtdEmpates);
                break;

            case 5:
                System.out.print("Escolha a quantidade derrotas: ");
                int qtdDerrotas = input.nextInt();
                timePorAlterar.getPontuacao().setQtdDerrotas(qtdDerrotas);
                break;

            case 6:
                System.out.print("Escolha a quantidade de gols feitos: ");
                int golsPro = input.nextInt();
                timePorAlterar.getPontuacao().setGolsPro(golsPro);
                break;

            case 7:
                System.out.print("Escolha a quantidade de gols contra: ");
                int golsContra = input.nextInt();
                timePorAlterar.getPontuacao().setGolsContra(golsContra);
                break;

            case 8:
                System.out.print("Escolha o novo saldo de gols: ");
                int saldoGols = input.nextInt();
                timePorAlterar.getPontuacao().setSaldoGols(saldoGols);
                break;

            default:
                sobreOsTimes();
                break;
        }
    }

    private void deletarTime() {
        int choice = timesChoice();
        times[choice - 1] = null;
    }

    private int timesChoice() {
        int qtdTimes = 0;
        for (int i = 0; i < times.length; i++) {
            if (times[i] != null) {
                qtdTimes++;
                System.out.printf("(%d) - %s%n", i + 1, times[i].getNome());
            }
        }
        System.out.println("\nEscolha um time: ");
        return getChoice(1, qtdTimes);
    }

    private void mostrarTimes() {
        for (int i = 0; i < times.length; i++) {
            if (times[i] != null)
                System.out.printf("(%d) - %s%n", i + 1, times[i].getNome());
        }
    }

    private int getChoice() {
        return new Scanner(System.in).nextInt();
    }

    private int getChoice(int min, int max) {
        System.out.printf("Digite um número entre %d e %d: ", min, max);
        return new Scanner(System.in).nextInt();
    }

    private void sobreAsPartidas() {
        System.out.println("Com os 20 times estabelecidos, agora bora ver das partidas.");
        Scanner input = new Scanner(System.in);
        System.out.println("\n=========================");
        System.out.println("(1) Criar Partidas");
        System.out.println("(2) Ver Partidas");
        // System.out.println("(3) Atualizar Partidas");
        // System.out.println("(4) Deletar Partidas");
        System.out.println("(5) Auto Completar Partidas");
        System.out.println("(6) Voltar");
        System.out.println("(7) Avançar");
        System.out.println("=========================\n");
        int choice = getChoice(1, 7);
        switch (choice) {
            case 1:
                Partida novaPartida;
                String dataNovaPartida = "";
                String horaNovaPartida = "";
                Time[] timesDoJogo = new Time[2];
                int[] scores = new int[2];
                System.out.print("Informar data e hora da partida? (S/n)\t");
                String informarDataEHora = input.next();
                boolean informouDataEHora = false;
                if (!(informarDataEHora.equalsIgnoreCase("S")) && !(informarDataEHora.equalsIgnoreCase("n"))) {
                    System.out.println("Resposta inválida!");
                    sobreAsPartidas();
                    break;
                }
                if (informarDataEHora.equalsIgnoreCase("S")) {
                    System.out.print("Informe a data (dd/MM/yyyy): ");
                    dataNovaPartida = input.nextLine();
                    input.nextLine();
                    System.out.print("Informe a hora (HH:mm): ");
                    horaNovaPartida = input.nextLine();
                    informouDataEHora = true;
                }
                System.out.println("Quais times participaram da partida: ");
                mostrarTimes();
                System.out.print("Time 1: ");
                choice = getChoice();
                timesDoJogo[0] = times[choice - 1];
                System.out.print("Time 2: ");
                choice = getChoice();
                timesDoJogo[1] = times[choice - 1];
                System.out.printf("Quantidade de gols do %s: ", timesDoJogo[0].getNome());
                choice = getChoice();
                scores[0] = choice;
                System.out.printf("Quantidade de gols do %s: ", timesDoJogo[1].getNome());
                choice = getChoice();
                scores[1] = choice;
                for (int i = 0; i < partidas.length; i++) {
                    if (partidas[i] == null) {
                        if (informouDataEHora)
                            novaPartida = new Partida(dataNovaPartida, horaNovaPartida, timesDoJogo, scores, i + 1);
                        else
                            novaPartida = new Partida(timesDoJogo, scores, i + 1);
                        partidas[i] = novaPartida;
                        break;
                    }
                }
                sobreAsPartidas();

            case 2:
                for (Partida partida : partidas) {
                    if (partida != null)
                        System.out.println(partida);
                }
                sobreAsPartidas();

            case 3:
                // Futuro
                sobreAsPartidas();

            case 4:
                // Futuro
                sobreAsPartidas();

            case 5:
                for (int i = 0; i < times.length; i++) {
                    for (int j = 0; j < times.length; j++) {
                        if (i == j)
                            continue;
                        int golsIemJ = getRandomScore();
                        int golsJemI = getRandomScore();

                        if (j > i) {
                            times[i].setPontuacao(
                                    times[i].getPontuacao().acrescentarGols(golsIemJ, golsJemI, golsIemJ, 0));
                            times[j].setPontuacao(
                                    times[j].getPontuacao().acrescentarGols(golsJemI, golsIemJ, 0, golsJemI));
                        } else {
                            times[i].setPontuacao(
                                    times[i].getPontuacao().acrescentarGols(golsIemJ, golsJemI, 0, golsIemJ));
                            times[j].setPontuacao(
                                    times[j].getPontuacao().acrescentarGols(golsJemI, golsIemJ, golsJemI, 0));
                        }

                        Time[] timesJogando = { times[i], times[j] };
                        int[] pontuacaoTimesJogando = { golsIemJ, golsJemI };

                        inserirPontuacao(timesJogando, pontuacaoTimesJogando);
                    }
                }
                sobreAsPartidas();

            case 6:
                sobreOsTimes();

            case 7:
                sobreATabela();

            default:
                sobreAsPartidas();
        }
    }

    private int getRandomScore() {
        return new Random().nextInt(5);
    }

    private void inserirPontuacao(Time[] timesJogando, int[] pontuacaoTimesJogando) {
        for (int i = 0; i < partidas.length; i++) {
            if (partidas[i] == null) {
                partidas[i] = new Partida(timesJogando, pontuacaoTimesJogando, i + 1);
                break;
            }
        }
    }

    private void sobreATabela() {
        System.out.println("Jogos jogados, vamos ver os resultados.");
        Scanner input = new Scanner(System.in);
        System.out.println("\n=========================");
        ordenarTabela();
        System.out.println("(1) Ver Tabela");
        System.out.println("(2) Atualizar Tabela");
        System.out.println("(3) Deletar Linha Tabela");
        System.out.println("(4) Voltar");
        System.out.println("(5) Sair");
        System.out.println("=========================\n");
        int choice = getChoice(1, 5);
        switch (choice) {
            case 1:
                exibirTabela();
                sobreATabela();

            case 2:
                atualizarTime();
                sobreATabela();

            case 3:
                deletarTime();
                sobreATabela();

            case 4:
                sobreAsPartidas();

            case 5:
                break;

            default:
                sobreATabela();
        }
    }

    private void exibirTabela() {
        for (Time time : times) {
            System.out.println(time);
        }
    }

    private void ordenarTabela() {
        int n = times.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++) {
                if (times[j].getPontuacao().getPontuacaoFinal() < times[j + 1].getPontuacao().getPontuacaoFinal())
                    troca(i, j, times);
                else if (times[j].getPontuacao().getPontuacaoFinal() == times[j + 1].getPontuacao().getPontuacaoFinal())
                    if (times[j].getPontuacao().getQtdVitorias() < times[j + 1].getPontuacao().getQtdVitorias())
                        troca(i, j, times);
                    else if (times[j].getPontuacao().getQtdVitorias() == times[j + 1].getPontuacao().getQtdVitorias())
                        if (times[j].getPontuacao().getSaldoGols() < times[j + 1].getPontuacao().getSaldoGols())
                            troca(i, j, times);
                        else if (times[j].getPontuacao().getSaldoGols() == times[j + 1].getPontuacao().getSaldoGols())
                            if (times[j].getPontuacao().getGolsPro() < times[j + 1].getPontuacao().getGolsPro())
                                troca(i, j, times);
            }
    }

    private void troca(int i, int j, Time[] times) {
        Time temp = times[j];
        times[j] = times[j + 1];
        times[j + 1] = temp;
    }

    // Tem utilidade?

    // public boolean adicionarClube() {
    // Scanner input = new Scanner(System.in);
    // System.out.println("Nome do Clube: ");
    // String nome = input.nextLine();
    // input.nextLine();
    // System.out.println("Pontuação Final: ");
    // int pontuacaoFinal = input.nextInt();
    // System.out.println("Gols Pro: ");
    // int golsPro = input.nextInt();
    // System.out.println("Gols Contra: ");
    // int golsContra = input.nextInt();
    // System.out.println("Gols em Casa: ");
    // int qtdGolsEmCasa = input.nextInt();
    // System.out.println("Gols Fora de Casa: ");
    // int qtdGolsForaDeCasa = input.nextInt();
    // System.out.println("Quantidade de Vitórias: ");
    // int qtdVitorias = input.nextInt();
    // System.out.println("Quantidade de Derrotas: ");
    // int qtdDerrotas = input.nextInt();
    // System.out.println("Quantidade de Empates: ");
    // int qtdEmpates = input.nextInt();

    // Pontuacao pontuacaoPorAdicionar = new Pontuacao(pontuacaoFinal, golsPro,
    // golsContra, qtdGolsEmCasa, qtdGolsForaDeCasa, qtdVitorias, qtdDerrotas,
    // qtdEmpates);
    // Time timePorAdicionar = new Time(nome, pontuacaoPorAdicionar);
    // for (int i = 0; i < times.length; i++) {
    // if (times[i] == null) {
    // times[i] = timePorAdicionar;
    // return true;
    // }
    // }

    // System.out.println("Operação impossível, já existem 20 times.");
    // return false;
    // }

    // public void excluirClube() {
    // Scanner input = new Scanner(System.in);
    // System.out.println("Selecione um clube para excluir: ");
    // mostrarClubes();
    // int choice = getChoice(1, 20);
    // times[choice - 1] = null;
    // }

    // public void exibirClube() {
    // Scanner input = new Scanner(System.in);
    // System.out.println("Selecione um clube para ver mais: ");
    // mostrarClubes();
    // int choice = getChoice(1, 20);
    // System.out.println(times[choice]);
    // }

    // private void mostrarClubes() {
    // System.out.println("Escolha um dos clubes do torneio: ");
    // for (int i = 0; i < times.length; i++) {
    // System.out.printf("(%d) %s%n", i + 1, times[i].getNome());
    // }
    // }

}
