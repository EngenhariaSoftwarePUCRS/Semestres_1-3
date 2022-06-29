import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class Sistema {

    private ListaDeCandidatos listaDeCandidatos;
    private ListaDeEleitores listaDeEleitores;
    private Votacao votacao;
    private String[][] tabelaResultados = new String[9][5];

    public void inicializar() {
        System.out.println("Inicializando o sistema...");

        try {
            File candidatosFile = new File("candidatos.txt");
            File eleitoresFile = new File("eleitores.txt");
            listaDeCandidatos = new ListaDeCandidatos(candidatosFile);
            listaDeEleitores = new ListaDeEleitores(eleitoresFile);
            votacao = new Votacao(listaDeCandidatos, listaDeEleitores);
        } catch (Exception e) {
            System.out.println("OPS!!! Arquivo de dados não localizado!");
            System.out.println("Sistema iniciado com banco de dados vazio");
        }

        System.out.printf("%nTotal de pessoas no cadastro: %d%n", listaDeEleitores.getQuantidadeEleitores());

        menu();
    }

    private void menu() {
        int choice;
        do {
            showMenu();
            choice = inputInt();
            switch (choice) {
                case 1:
                    votacao.iniciar();
                    break;

                case 2:
                    votacao.encerrar();
                    listaDeCandidatos.ordenarPorVotos();
                    break;

                case 3:
                    listaDeEleitores.ordenarEleitores(9);
                    listaDeEleitores.listarEleitores();
                    break;

                case 4:
                    listaDeEleitores.ordenarEleitores("AZ");
                    listaDeEleitores.listarEleitores();
                    break;

                case 5:
                    // Se a votação já foi encerrada
                    if (!votacao.getSituacao()) {
                        exibeTabelas();
                    } else
                        System.out.println("A votação ainda não foi finalizada.");
                    break;

                case 6:
                    // Se a votação já foi encerrada
                    if (!votacao.getSituacao()) {
                        salvarArquivoDados("resultados.txt");
                    } else
                        System.out.println("A votação ainda não foi finalizada.");
                    break;

                case 7:
                    // simularVotacao();
                    break;

                case 0:
                    System.out.println("Obrigado por utilizar!");
                    break;

                default:
                    System.out.println("Valor inválido!");
                    break;
            }
        } while (choice != 0);
    }

    private void salvarArquivoDados(String filePath) {
        boolean salvo = false;
        try {
            File file = new File(filePath);
            boolean sobreescrever = true;
            if (!file.exists()) {
                System.out.println("Arquivo não existente. Criando novo arquivo.");
                if (file.createNewFile()) {
                    System.out.println("Novo arquivo criado em: " + filePath);
                }
            } else {
                System.out.println("Este arquivo já existe.");
                sobreescrever = pegarConfirmacao();
            }

            if (sobreescrever) {
                FileWriter fileWriter = new FileWriter(filePath);
                Candidato[] candidatos = listaDeCandidatos.getCandidatos();
                String codigoCandidato;
                String nomeCandidato;
                String partidoCandidato;
                String quantidadeVotosCandidato;
                String fileLine = "Data/Hora: "
                        .concat(
                                new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").format(Calendar.getInstance().getTime()))
                        .concat("\n");
                fileWriter.write(fileLine);
                for (Candidato candidato : candidatos) {
                    if (candidato != null) {
                        codigoCandidato = Integer.toString(candidato.getId()).trim();
                        nomeCandidato = candidato.getNome().trim();
                        partidoCandidato = candidato.getPartido().trim();
                        quantidadeVotosCandidato = Integer.toString(candidato.getQuandidadeVotos()).trim();
                        fileLine = ""
                                .concat(codigoCandidato)
                                .concat(",")
                                .concat(nomeCandidato)
                                .concat(",")
                                .concat(partidoCandidato)
                                .concat(",")
                                .concat(quantidadeVotosCandidato)
                                .concat("\n");
                        fileWriter.write(fileLine);
                    }
                }
                fileWriter.write("000,NULO,NULO,".concat(Integer.toString(votacao.getQuantidadeVotosNulos()).trim()));
                fileWriter.close();
                System.out.println("Sucesso!");
                System.out.println("Arquivo salvo em: " + filePath);
            } else
                System.out.println("Ok. Nada foi alterado.");
        } catch (IOException e) {
            System.out.println("Erro ao gerar arquivo de dados.");
            e.printStackTrace();
        }
    }

    private boolean pegarConfirmacao() {
        String escolha;
        boolean confirma = false;

        do {
            System.out.println();
            System.out.print("Deseja sobreescrever (S/N)? ");
            escolha = inputString();
            if (escolha.equalsIgnoreCase("S"))
                confirma = true;
        } while (!(escolha.equalsIgnoreCase("S")) && !(escolha.equalsIgnoreCase("N")));

        return confirma;
    }

    private void exibeTabelas() {
        boolean face = false;
        int mostrarTabelas = -1;
        while (mostrarTabelas != 0) {
            face = !face;
            if (face) {
                gerarTabelaResultados(23);
                exibirTabelaResultados(23);
            } else {
                gerarTabelaResultados(9, 22, 25, 8, 15);
                exibirTabelaResultados(9, 22, 25, 8, 15);
            }
            System.out.println("Aperte 1 para alterar visualização da tabela ou 0 para voltar.");
            mostrarTabelas = inputInt();
        }
    }

    private void gerarTabelaResultados(int larguraColunas) {
        int quantidadeCandidatos = listaDeCandidatos.getQuantidadeCandidatos();

        // Setando cabeçalho da tabela
        tabelaResultados[0][0] = inflar("Codigo", larguraColunas);
        tabelaResultados[0][1] = inflar("Candidato", larguraColunas);
        tabelaResultados[0][2] = inflar("Partido", larguraColunas);
        tabelaResultados[0][3] = inflar("Votos", larguraColunas);
        tabelaResultados[0][4] = inflar("Votos Válidos", larguraColunas);

        // Percorrendo as linhas com candidatos
        for (int i = 1; i <= quantidadeCandidatos; i++) {
            tabelaResultados[i][0] = inflar(listaDeCandidatos.getIdsCandidatos()[i - 1], larguraColunas);
            tabelaResultados[i][1] = inflar(listaDeCandidatos.getNomesCandidatos()[i - 1], larguraColunas);
            tabelaResultados[i][2] = inflar(listaDeCandidatos.getPartidosCandidatos()[i - 1], larguraColunas);
            tabelaResultados[i][3] = inflar(listaDeCandidatos.getVotosCandidatos()[i - 1], larguraColunas);
            tabelaResultados[i][4] = inflar(Double
                    .toString(Math.round((Integer.parseInt(listaDeCandidatos.getVotosCandidatos()[i - 1]))
                            / (double) (votacao.getQuantidadeVotosValidos())))
                    .concat("%"), larguraColunas);
        }

        // Nas três linhas subsequentes ao fim dos candidatos, nas colunas do meio (2 e
        // 3), insere quantidade de votos
        tabelaResultados[quantidadeCandidatos + 1][2] = inflar("NULOS", larguraColunas);
        tabelaResultados[quantidadeCandidatos + 1][3] = inflar(Integer.toString(votacao.getQuantidadeVotosNulos()),
                larguraColunas);
        tabelaResultados[quantidadeCandidatos + 2][2] = inflar("Total votos", larguraColunas);
        tabelaResultados[quantidadeCandidatos + 2][3] = inflar(Integer.toString(votacao.getQuantidadeVotos()),
                larguraColunas);
        tabelaResultados[quantidadeCandidatos + 3][2] = inflar("Votos válidos", larguraColunas);
        tabelaResultados[quantidadeCandidatos + 3][3] = inflar(Integer.toString(votacao.getQuantidadeVotosValidos()),
                larguraColunas);
    }

    private void exibirTabelaResultados(int larguraColunas) {
        for (String[] linha : tabelaResultados) {
            for (String coluna : linha) {
                if (coluna == null)
                    System.out.print("  " + inflar("", larguraColunas));
                else
                    System.out.print("| " + coluna);
            }
            System.out.println();
        }
        System.out.println();
    }

    private void gerarTabelaResultados(int larguraColuna0, int larguraColuna1, int larguraColuna2, int larguraColuna3,
            int larguraColuna4) {
        int quantidadeCandidatos = listaDeCandidatos.getQuantidadeCandidatos();

        // Setando cabeçalho da tabela
        tabelaResultados[0][0] = inflar("Codigo", larguraColuna0);
        tabelaResultados[0][1] = inflar("Candidato", larguraColuna1);
        tabelaResultados[0][2] = inflar("Partido", larguraColuna2);
        tabelaResultados[0][3] = inflar("Votos", larguraColuna3);
        tabelaResultados[0][4] = inflar("Votos Válidos", larguraColuna4);

        // Percorrendo as linhas com candidatos
        for (int i = 1; i <= quantidadeCandidatos; i++) {
            tabelaResultados[i][0] = inflar(listaDeCandidatos.getIdsCandidatos()[i - 1], larguraColuna0);
            tabelaResultados[i][1] = inflar(listaDeCandidatos.getNomesCandidatos()[i - 1], larguraColuna1);
            tabelaResultados[i][2] = inflar(listaDeCandidatos.getPartidosCandidatos()[i - 1], larguraColuna2);
            tabelaResultados[i][3] = inflar(listaDeCandidatos.getVotosCandidatos()[i - 1], larguraColuna3);
            tabelaResultados[i][4] = inflar(Double
                    .toString(Math.round((Integer.parseInt(listaDeCandidatos.getVotosCandidatos()[i - 1]))
                            / (double) (votacao.getQuantidadeVotosValidos())))
                    .concat("%"), larguraColuna4);
        }

        // Nas três linhas subsequentes ao fim dos candidatos, nas colunas do meio (2 e
        // 3), insere quantidade de votos
        tabelaResultados[quantidadeCandidatos + 1][2] = inflar("NULOS", larguraColuna2);
        tabelaResultados[quantidadeCandidatos + 1][3] = inflar(Integer.toString(votacao.getQuantidadeVotosNulos()),
                larguraColuna3);
        tabelaResultados[quantidadeCandidatos + 2][2] = inflar("Total votos", larguraColuna2);
        tabelaResultados[quantidadeCandidatos + 2][3] = inflar(Integer.toString(votacao.getQuantidadeVotos()),
                larguraColuna3);
        tabelaResultados[quantidadeCandidatos + 3][2] = inflar("Votos válidos", larguraColuna2);
        tabelaResultados[quantidadeCandidatos + 3][3] = inflar(Integer.toString(votacao.getQuantidadeVotosValidos()),
                larguraColuna3);
    }

    private void exibirTabelaResultados(int larguraColuna0, int larguraColuna1, int larguraColuna2, int larguraColuna3,
            int larguraColuna4) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 5; j++) {
                String coluna = tabelaResultados[i][j];
                if (coluna == null) {
                    if (j == 0)
                        System.out.println("  " + inflar("", larguraColuna0));
                    if (j == 1)
                        System.out.println("  " + inflar("", larguraColuna1));
                    if (j == 2)
                        System.out.println("  " + inflar("", larguraColuna2));
                    if (j == 3)
                        System.out.println("  " + inflar("", larguraColuna3));
                    if (j == 4)
                        System.out.println("  " + inflar("", larguraColuna4));
                } else
                    System.out.println("| " + coluna);
            }
            System.out.println();
        }
        System.out.println();
    }

    private String inflar(String porInflar, int quantoInflar) {
        for (int i = porInflar.length(); i < quantoInflar; i++) {
            porInflar = porInflar.concat(" ");
        }
        return porInflar;
    }

    private int inputInt() {
        Scanner input = new Scanner(System.in);
        try {
            return input.nextInt();
        } catch (InputMismatchException e) {
            return inputInt();
        }
    }

    private String inputString() {
        Scanner input = new Scanner(System.in);
        try {
            return input.nextLine();
        } catch (InputMismatchException e) {
            return inputString();
        }
    }

    private void showMenu() {
        System.out.println("/===============================================\\");
        System.out.println("|\tSISTEMA GERENCIADOR DE VOTACAO");
        System.out.println("|");
        System.out.println("| (1) Iniciar votação");
        System.out.println("| (2) Encerrar votação");
        System.out.println("| (3) Listar eleitores (ID)");
        System.out.println("| (4) Listar eleitores (A-Z)");
        System.out.println("| (5) Listar resultados");
        System.out.println("| (6) Gerar arquivo resultados");
        System.out.println("| (0) Sair");
        System.out.println();
        System.out.print("Selecione sua opção: ");
    }

}