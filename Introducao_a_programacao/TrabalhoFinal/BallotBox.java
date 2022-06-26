import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BallotBox {

    private final int LIMIT = 5;
    private final String CAMINHO_ARQUIVO_DADOS = "pessoas.txt";
    PersonRegistration personRegistration = new PersonRegistration(LIMIT);

    public void initialize() throws FileNotFoundException {
        System.out.println("Inicializando o sistema...");

        System.out.println("Carregando arquivo de dados em " + CAMINHO_ARQUIVO_DADOS);
        try {
            this.getDataFrom(CAMINHO_ARQUIVO_DADOS);
            System.out.println("Arquivo de dados carregado com sucesso");
        } catch (FileNotFoundException e) {
            System.out.println("OPS!!! Arquivo de dados não localizado!");
            System.out.println("Sistema iniciado com banco de dados vazio");
        }
        System.out.printf("%nTotal de pessoas no cadastro: %d%n", personRegistration.getPeopleAmount());

        awaitInput();
        menu();
    }

    private void menu() {
        int choice;
        do {
            showMenu();
            choice = awaitMenuInput();
            switch (choice) {
                case 1:
                    addPerson(personRegistration);
                    System.out.println("Nova pessoa adicionada com sucesso!!!");
                    break;
                case 2:
                    consultarPessoaPorID();
                    break;
                case 5:
                    listarPessoas();
                    awaitInput();
                    break;
                case 7:
                    salvarDadosNoArquivo(CAMINHO_ARQUIVO_DADOS);
                    awaitInput();
                    break;
                default:
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

    private void consultarPessoaPorID() {
        Scanner input = new Scanner(System.in);
        System.out.println("Consultar pessoa no cadastro.");

        System.out.print("Digite o ID/Codigo a ser pesquisado: ");
        int id = input.nextInt();
        input.nextLine();

        Person p = personRegistration.pesquisarPessoa(id);
        if (p == null)
            System.out.println("Código não localizado no cadastro!");
        else
            mostrarDadosPessoa(p);
    }

    private void mostrarDadosPessoa(Person p) {
        System.out.println("Dados da pessoa");
        System.out.printf("\nID..: %d", p.getId());
        System.out.printf("\nNome: %s", p.getNome());
        System.out.println("");
    }

    private void addPerson(PersonRegistration cadastro) {
        Scanner input = new Scanner(System.in);
        System.out.println("Adicionando nova pessoa no cadastro");

        System.out.println("Código (ID): ");
        int id = input.nextInt();
        input.nextLine();

        System.out.println("Nome.......: ");
        String nome = input.nextLine();

        Person novaPessoa = new Person(id, nome);
        cadastro.addPerson(novaPessoa);

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

    private void listarPessoas() {
        Person[] pessoas = personRegistration.getPessoas();
        for (int i = 0; i < pessoas.length; i++) {
            Person p = pessoas[i];
            if (p != null)
                mostrarDadosPessoa(p);
        }
    }

    private void listarPessoasEmOrdemAlfabetica() {
        // TO DO
    }

    private void getDataFrom(String caminhoCompletoArquivo) throws FileNotFoundException {
        File file = new File(caminhoCompletoArquivo);
        Scanner fileReader = new Scanner(file);

        while (fileReader.hasNextLine()) {
            String fileLine = fileReader.nextLine();
            // 'splita' o conteudo da linha do arquivo em um array usando como separador a
            // virgula
            String[] fileLineContent = fileLine.split(",");

            // pega codigo e nome da linha do arquivo
            int codigo = Integer.parseInt(fileLineContent[0]); // converte um String em Int
            String nome = fileLineContent[1];

            // adiciona nova pessoa no cadastro
            Person p = new Person(codigo, nome);
            personRegistration.addPerson(p);
        }
        fileReader.close();
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
            Person[] pessoas = personRegistration.getPessoas();
            for (int i = 0; i < pessoas.length; i++) {
                if (pessoas[i] != null) {
                    Person p = pessoas[i];
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