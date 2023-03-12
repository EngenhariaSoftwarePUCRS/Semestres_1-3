package TrabalhoFinal_FecheACaixa;

public class FecheACaixa {
    private Jogador jogador;
    private Tabuleiro tabuleiro;
    private int nroJogadas;
    private int pontosPerdidos;
    private int qtdCasas;

    public void iniciar() {
        System.out.print("Digite seu nome: ");
        jogador = new Jogador(Scanners.inputString());
        tabuleiro = new Tabuleiro();
        nroJogadas = 0;
        pontosPerdidos = 0;
        qtdCasas = tabuleiro.getCasas().length;
        boolean terminou;
        do {
            rodada();
            terminou = encerrar();
        } while (!terminou);
    }

    private void rodada() {
        nroJogadas++;
        tabuleiro.mostrar();
        System.out.println("\tRodada nº" + nroJogadas);
        System.out.printf("O que você quer fazer, %s?%n", jogador);
        System.out.println("(1) Ver pontos desperdiçados");
        System.out.println("(2) Jogar Dados");
        int choice = Scanners.inputInt();
        if (choice == 1)
            System.out.printf("Pontos desperdiçados: %d%n", pontosPerdidos);
        else if (choice == 2) {
            int pontos = tabuleiro.jogarDados();
            System.out.printf("Você tirou %d nos dados.%n", pontos);
            System.out.println("(1) Fechar Casa");
            System.out.println("(2) Desperdiçar Pontos");
            choice = Scanners.inputInt();
            if (choice == 1) {
                if (fecharQuatroCasas(pontos))
                    return;
                if (fecharTresCasas(pontos))
                    return;
                if (fecharDuasCasas(pontos))
                    return;
                if (fecharUmaCasa(pontos))
                    return;
            }
            System.out.println("Pontos desperdiçados");
            pontosPerdidos += pontos;
        } else
            System.out.println("Opção Inválida");
    }

    public boolean fecharUmaCasa(int pontos) {
        for (int i = 0; i < qtdCasas; i++)
            if ((i + 1 == pontos) && (tabuleiro.getCasas()[i].isAberto())) {
                System.out.printf("Deseja fechar a casa %d? (S/n)%n", i + 1);
                String resposta = Scanners.inputString();
                if (resposta.equalsIgnoreCase("S")) {
                    int[] casasPorFechar = { i };
                    tabuleiro.fecharCasas(casasPorFechar);
                    return true;
                }
            }
        return false;
    }

    public boolean fecharDuasCasas(int pontos) {
        for (int i = 0; i < qtdCasas; i++) {
            for (int j = 0; j < qtdCasas; j++) {
                if (i >= j)
                    continue;
                if (((i + 1 + j + 1) == pontos) &&
                        (tabuleiro.getCasas()[i].isAberto() &&
                                tabuleiro.getCasas()[j].isAberto())) {
                    System.out.printf("Deseja fechar as casas %d e %d? (S/n)%n", i + 1, j + 1);
                    String resposta = Scanners.inputString();
                    if (resposta.equalsIgnoreCase("S")) {
                        int[] casasPorFechar = { i, j };
                        tabuleiro.fecharCasas(casasPorFechar);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean fecharTresCasas(int pontos) {
        for (int i = 0; i < qtdCasas; i++)
            for (int j = 0; j < qtdCasas; j++) {
                if (i >= j)
                    continue;
                for (int k = 0; k < qtdCasas; k++) {
                    if (j >= k)
                        continue;
                    if (((i + 1 + j + 1 + k + 1) == pontos) &&
                            (tabuleiro.getCasas()[i].isAberto() &&
                                    tabuleiro.getCasas()[j].isAberto() &&
                                    tabuleiro.getCasas()[k].isAberto())) {
                        System.out.printf("Deseja fechar as casas %d, %d e %d? (S/n)%n", i + 1, j + 1, k + 1);
                        String resposta = Scanners.inputString();
                        if (resposta.equalsIgnoreCase("S")) {
                            int[] casasPorFechar = { i, j, k };
                            tabuleiro.fecharCasas(casasPorFechar);
                            return true;
                        }
                    }
                }
            }
        return false;
    }

    public boolean fecharQuatroCasas(int pontos) {
        for (int i = 0; i < qtdCasas; i++) {
            for (int j = 0; j < qtdCasas; j++) {
                if (i >= j)
                    continue;
                for (int k = 0; k < qtdCasas; k++) {
                    if (j >= k)
                        continue;
                    for (int l = 0; l < qtdCasas; l++) {
                        if (k >= l)
                            continue;
                        if (((i + 1 + j + 1 + k + 1 + l + 1) == pontos)
                                && (tabuleiro.getCasas()[i].isAberto()
                                        && tabuleiro.getCasas()[j].isAberto()
                                        && tabuleiro.getCasas()[k].isAberto()
                                        && tabuleiro.getCasas()[l].isAberto())) {
                            System.out.printf("Deseja fechar as casas %d, %d, %d e %d? (S/n)%n", i + 1, j + 1, k + 1,
                                    l + 1);
                            String resposta = Scanners.inputString();
                            if (resposta.equalsIgnoreCase("S")) {
                                int[] casasPorFechar = { i, j, k, l };
                                tabuleiro.fecharCasas(casasPorFechar);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean encerrar() {
        System.out.println("Deseja encerrar o jogo? (S/n)");
        String resposta = Scanners.inputString();
        if ((resposta.equalsIgnoreCase("S"))
                || (tabuleiro.qtdCasasFechadas() == qtdCasas)) {
            if (tabuleiro.qtdCasasFechadas() == qtdCasas) {
                System.out.println("Todas as casas foram fechadas.");
            }
            System.out.println("Obrigado por jogar.");
            System.out.printf("Total de pontos: %d%n", pontosPerdidos);
            return true;
        }
        return false;
    }
}
