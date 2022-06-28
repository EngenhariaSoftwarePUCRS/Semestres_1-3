import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    private static File candidatosFile = new File("com\\leonardo\\candidatos.txt");
    private static File eleitoresFile = new File("com\\leonardo\\eleitores.txt");

    public static ListaDeCandidatos listaDeCandidatos = new ListaDeCandidatos(candidatosFile);
    public static ListaDeEleitores listaDeEleitores = new ListaDeEleitores(eleitoresFile);
    private static Votacao votacao = new Votacao();

    public static void main(String[] args) {
        System.out.println("Inicializando o sistema...");
        
        System.out.printf("%nTotal de pessoas no cadastro: %d%n", listaDeEleitores.getQuantidadeEleitores());

        menu();
    }

    private static void menu() {
        int choice;
        do {
            showMenu();
            choice = inputInt();
            switch (choice) {
                case 1:
                    votacao.iniciar();
                    break;

                case 2:
                    // Encerrar votação
                    break;

                case 3:
                    listaDeEleitores.listarEleitores();
                    break;

                case 4:
                    // Listar eleitores (Alf.)
                    break;

                case 5:
                    // Listar resultados
                    break;

                case 6:
                    // Gerar arquivo resultados
                    break;

                case 7:
                    // Salvar arquivo de dados
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Valor inválido!");
                    break;
            }
        } while (choice != 0);
    }

    private static int inputInt() {
        Scanner input = new Scanner(System.in);
        int result = 0;

        try {
            result = input.nextInt();
        } catch (InputMismatchException e) {
            inputInt();
        }

        return result;
    }

    private static void showMenu() {
        System.out.println("/===============================================\\");
        System.out.println("|\tSISTEMA GERENCIADOR DE VOTACAO");
        System.out.println("|");
        System.out.println("| (1) Iniciar votação");
        System.out.println("| (2) Encerrar votação");
        System.out.println("| (3) Listar eleitores");
        System.out.println("| (4) Listar eleitores (O.A.)");
        System.out.println("| (5) Listar resultados");
        System.out.println("| (6) Gerar arquivo resultados");
        System.out.println("| (0) Sair");
        System.out.println();
        System.out.print("Selecione sua opção: ");
    }

    private static void salvarDadosNoArquivo(String caminhoCompletoArquivo) {
        try {
            File arquivo = new File(caminhoCompletoArquivo);
            if (!arquivo.exists()) {
                System.out.println("Arquivo não existente. Criando novo arquivo.");
                if (arquivo.createNewFile()) {
                    System.out.println("Novo arquivo criado em: " + caminhoCompletoArquivo);
                }
            }

            FileWriter writer = new FileWriter(caminhoCompletoArquivo);
            Eleitor[] pessoas = listaDeEleitores.getEleitores();
            for (int i = 0; i < pessoas.length; i++) {
                if (pessoas[i] != null) {
                    Eleitor p = pessoas[i];
                    int codigo = p.getId();
                    String nome = p.getNome();
                    String linhaArquivo = Integer.toString(codigo).trim();
                    linhaArquivo = linhaArquivo.concat(",");
                    linhaArquivo = linhaArquivo.concat(nome.trim());
                    writer.write(linhaArquivo.concat("\n"));
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("ERRO AO ESCREVER ARQUIVO DE DADOS!!!");
            e.printStackTrace();
        }

    }
}