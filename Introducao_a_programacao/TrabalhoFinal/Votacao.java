import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Votacao {

    ListaDeEleitores listaDeEleitores = new ListaDeEleitores();

    public void iniciar() throws FileNotFoundException {
        System.out.println("Inicializando o sistema...");
        
        System.out.printf("%nTotal de pessoas no cadastro: %d%n", listaDeEleitores.getQuantidadeEleitores());

        menu();
    }

    private void menu() {
        int choice;
        do {
            showMenu();
            choice = awaitMenuInput();
            switch (choice) {
                case 1:
                    // Adicionar Pessoa
                    break;

                case 2:
                    // Consultar por ID
                    break;

                case 3:
                    // Consultar por nome
                    break;

                case 4:
                    // Remover
                    break;

                case 5:
                    listaDeEleitores.listarPessoas();
                    break;

                case 6:
                    // Listar pessoas em ordem alfabética
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

    private void awaitInput() {
        System.out.println("Pressione qualquer tecla para continuar.");
        new Scanner(System.in).nextLine();
    }

    private int awaitMenuInput() {
        return new Scanner(System.in).nextInt();
    }

    private void showMenu() {
        System.out.println("/===============================================\\");
        System.out.println("|\tSISTEMA GERENCIADOR DE PESSOAS");
        System.out.println("|");
        System.out.println("| (1) Adicionar nova pessoa");
        System.out.println("| (2) Consultar pessoa por ID");
        System.out.println("| (3) Consultar pessoa por nome");
        System.out.println("| (4) Remover pessoa do cadastro");
        System.out.println("| (5) Listar pessoas na tela");
        System.out.println("| (6) Listar pessoas em ordem alfabética na tela");
        System.out.println("| (7) Salvar arquivo de dados");
        System.out.println("| (0) Sair");
        System.out.println();
        System.out.print("Selecione sua opção: ");
    }

    private void salvarDadosNoArquivo(String caminhoCompletoArquivo) {
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