package TrabalhoFinal_SimulacaoVotacaoEletronica;

import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class Sistema {
    private final static String ROOT_PATH = "src/TrabalhoFinal_SimulacaoVotacaoEletronica/";

    private static final String PATH_RESULTS_FILE = ROOT_PATH + "resultados.txt";
    private String pathCandidatosFile = ROOT_PATH + "candidatos.txt";
    private String pathEleitoresFile = ROOT_PATH + "eleitores.txt";
    private ListaDeCandidatos listaDeCandidatos;
    private ListaDeEleitores listaDeEleitores;
    private Votacao votacao;
    private String[][] tabelaResultados;
    private int qtdLinhasTabelaResultados;
    private int qtdColunasTabelaResultados;

    public void inicializar() {
        // Tenta iniciar o sistema com os arquivos na raiz do projeto
        // e iniciar uma votacao com esses eleitores e candidatos
        try {
            System.out.println("Inicializando o sistema...");
            System.out.println("Os arquivos estão na raiz do projeto?");
            if (!pegarConfirmacao()) {
                System.out.print("Digite o caminho do arquivo de candidatos: ");
                pathCandidatosFile = inputString();
                System.out.print("Digite o caminho do arquivo de eleitores: ");
                pathEleitoresFile = inputString();
            }
            File candidatosFile = new File(pathCandidatosFile);
            File eleitoresFile = new File(pathEleitoresFile);
            listaDeCandidatos = new ListaDeCandidatos(candidatosFile);
            listaDeEleitores = new ListaDeEleitores(eleitoresFile);
            votacao = new Votacao(listaDeCandidatos, listaDeEleitores);
            qtdLinhasTabelaResultados = listaDeCandidatos.getQuantidadeCandidatos() + 4;
            qtdColunasTabelaResultados = 5;
            tabelaResultados = new String[qtdLinhasTabelaResultados][qtdColunasTabelaResultados];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.printf("%nTotal de pessoas no cadastro: %d%n", listaDeEleitores.getQuantidadeEleitores());
            menu();
        }
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
                    listaDeCandidatos.ordenarCandidatos();
                    break;

                case 3:
                    // ordena por id e apresenta
                    listaDeEleitores.ordenarEleitores();
                    listaDeEleitores.listarEleitores();
                    break;

                case 4:
                    // ordena em ordem alfabética e apresenta
                    listaDeEleitores.ordenarEleitores("A-Z");
                    listaDeEleitores.listarEleitores();
                    break;

                case 5:
                    // Se a votação já foi encerrada
                    if (!votacao.getSituacao()) {
                        // Decide se todas as colunas da tabela vão ter o mesmo tamanho
                        // int[] larguraColunas = { 23 };
                        // ou define o tamanho de cada uma
                        int[] larguraColunas = { 9, 22, 25, 8, 15 };
                        exibeTabela(larguraColunas);
                    } else
                        System.out.println("A votação ainda não foi finalizada.");
                    break;

                case 6:
                    // Se a votação já foi encerrada
                    if (!votacao.getSituacao()) {
                        salvarArquivoResultados(PATH_RESULTS_FILE);
                    } else
                        System.out.println("A votação ainda não foi finalizada.");
                    break;

                // Caso de testes
                case -1:
                    System.out.print("qtdVotorPorSimular: ");
                    int qtdVotorPorSimular = inputInt();
                    System.out.print("chanceNulo: ");
                    int chanceNulo = inputInt();
                    votacao.simularVotacao(qtdVotorPorSimular, chanceNulo);
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

    private int inputInt() {
        // método de Scanner que só aceita entradas inteiras
        Scanner input = new Scanner(System.in);
        try {
            return input.nextInt();
        } catch (InputMismatchException e) {
            return inputInt();
        }
    }

    private void exibeTabela(int[] larguraColunas) {
        gerarTabelaResultados(larguraColunas);
        exibirTabelaResultados(larguraColunas);
    }

    private void gerarTabelaResultados(int[] larguraColunas) {
        int quantidadeCandidatos = listaDeCandidatos.getQuantidadeCandidatos();
        // Começa definindo o tamanho de cada coluna
        int larguraColuna0 = larguraColunas[0];
        int larguraColuna1 = larguraColunas[0];
        int larguraColuna2 = larguraColunas[0];
        int larguraColuna3 = larguraColunas[0];
        int larguraColuna4 = larguraColunas[0];
        if (larguraColunas.length == 5) {
            larguraColuna0 = larguraColunas[0];
            larguraColuna1 = larguraColunas[1];
            larguraColuna2 = larguraColunas[2];
            larguraColuna3 = larguraColunas[3];
            larguraColuna4 = larguraColunas[4];
        }

        // Setando cabeçalho da tabela
        tabelaResultados[0][0] = inflar("Codigo", larguraColuna0);
        tabelaResultados[0][1] = inflar("Candidato", larguraColuna1);
        tabelaResultados[0][2] = inflar("Partido", larguraColuna2);
        tabelaResultados[0][3] = inflar("Votos", larguraColuna3);
        tabelaResultados[0][4] = inflar("Votos Válidos", larguraColuna4);

        // Percorrendo as linhas com candidatos e adicionando na tabela suas informações
        for (int i = 1; i <= quantidadeCandidatos; i++) {
            String porcentagemVotosValidosCandidato = Double.toString(Math.round(
                    (Integer.parseInt(listaDeCandidatos.getVotosCandidatos()[i - 1]))
                            /
                            ((double) votacao.getQuantidadeVotosValidos())
                            * 100))
                    .concat("%");
            tabelaResultados[i][0] = inflar(listaDeCandidatos.getIdsCandidatos()[i - 1], larguraColuna0);
            tabelaResultados[i][1] = inflar(listaDeCandidatos.getNomesCandidatos()[i - 1], larguraColuna1);
            tabelaResultados[i][2] = inflar(listaDeCandidatos.getPartidosCandidatos()[i - 1], larguraColuna2);
            tabelaResultados[i][3] = inflar(listaDeCandidatos.getVotosCandidatos()[i - 1], larguraColuna3);
            tabelaResultados[i][4] = inflar(porcentagemVotosValidosCandidato, larguraColuna4);
        }

        // Nas três linhas subsequentes ao fim dos candidatos,
        // nas colunas do meio (2 e 3),
        // insere quantidade de votos nulos totais e validos
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

    private void exibirTabelaResultados(int[] larguraColunas) {
        int larguraColuna0 = larguraColunas[0];
        int larguraColuna1 = larguraColunas[0];
        int larguraColuna2 = larguraColunas[0];
        int larguraColuna3 = larguraColunas[0];
        int larguraColuna4 = larguraColunas[0];
        if (larguraColunas.length == 5) {
            larguraColuna0 = larguraColunas[0];
            larguraColuna1 = larguraColunas[1];
            larguraColuna2 = larguraColunas[2];
            larguraColuna3 = larguraColunas[3];
            larguraColuna4 = larguraColunas[4];
        }
        // para cada linha na tabela
        for (int i = 0; i < qtdLinhasTabelaResultados; i++) {
            // para cada coluna nessa linha
            for (int j = 0; j < qtdColunasTabelaResultados; j++) {
                String coluna = tabelaResultados[i][j];
                System.out.print("| ");
                if (coluna == null) {
                    if (j == 0)
                        System.out.print(inflar("", larguraColuna0));
                    if (j == 1)
                        System.out.print(inflar("", larguraColuna1));
                    if (j == 2)
                        System.out.print(inflar("", larguraColuna2));
                    if (j == 3)
                        System.out.print(inflar("", larguraColuna3));
                    if (j == 4)
                        System.out.print(inflar("", larguraColuna4));
                } else
                    System.out.print(coluna);
            }
            System.out.println();
        }
        System.out.println();
    }

    private String inflar(String porInflar, int quantoInflar) {
        // método que recebe uma String e devolve
        // com uma quantidade x de espaços no final
        // para padronizar uma tabela
        for (int i = porInflar.length(); i < quantoInflar; i++) {
            porInflar = porInflar.concat(" ");
        }
        return porInflar;
    }

    private void salvarArquivoResultados(String filePath) {
        try {
            // Pedindo para o usuário onde quer salvar o arquivo
            System.out.println("Onde você gostaria de salvar o seu arquivo?");
            filePath = inputString();
            // Cria um novo arquivo no caminho do parametro
            File file = new File(filePath);
            boolean sobreescrever = true;
            if (file.exists()) {
                System.out.println("Este arquivo já existe e terá de ser reescrito.");
                // Pergunta ao usuário se ele aceita sobreescrever o arquivo
                sobreescrever = pegarConfirmacao();
            } else {
                System.out.println("Arquivo não existente. Criando novo arquivo.");
                if (file.createNewFile())
                    System.out.println("Novo arquivo criado em: " + filePath);
            }

            if (sobreescrever) {
                // Cria um novo objeto para escrever no arquivo
                FileWriter fileWriter = new FileWriter(filePath);
                Candidato[] candidatos = listaDeCandidatos.getCandidatos();
                String codigoCandidato;
                String nomeCandidato;
                String partidoCandidato;
                String quantidadeVotosCandidato;
                // Na primeira linha do arquivo, pega a data e hora atual do sistema
                String fileLine = "Data/Hora: "
                        .concat(
                                new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss").format(Calendar.getInstance().getTime()))
                        .concat("\n");
                // e escreve no arquivo
                fileWriter.write(fileLine);
                // Para cada candidato na lista de candidatos
                for (Candidato candidato : candidatos) {
                    if (candidato != null) {
                        // Separa o candidato em Strings para por no arquivo
                        codigoCandidato = Integer.toString(candidato.getId()).trim();
                        nomeCandidato = candidato.getNome().trim();
                        partidoCandidato = candidato.getPartido().trim();
                        quantidadeVotosCandidato = Integer.toString(candidato.getQuandidadeVotos()).trim();
                        // Cria a linha do arquivo adicionando cada valor seguido por uma vírgula
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
                // No último "candidato" acontar pelos votos nulos
                fileWriter.write("000,NULO,NULO,".concat(Integer.toString(votacao.getQuantidadeVotosNulos()).trim()));
                fileWriter.close();
                System.out.println("Sucesso!");
                System.out.println("Arquivo salvo em: " + filePath);
                // caso o usuário não permita sobreescrever o arquivo
            } else
                System.out.println("Ok. Nada foi alterado.");
        } catch (IOException e) {
            System.out.println("Erro ao gerar arquivo de dados.");
            e.printStackTrace();
        }
    }

    private boolean pegarConfirmacao() {
        System.out.println();
        System.out.print("Confirma (S/N)? ");
        String escolha = inputString();

        if ("S".equalsIgnoreCase(escolha))
            return true;
        else if ("N".equalsIgnoreCase(escolha))
            return false;
        else
            return pegarConfirmacao();
    }

    private String inputString() {
        // método de Scanner que só aceita entradas em texto
        Scanner input = new Scanner(System.in);
        try {
            return input.nextLine();
        } catch (InputMismatchException e) {
            return inputString();
        }
    }

}
