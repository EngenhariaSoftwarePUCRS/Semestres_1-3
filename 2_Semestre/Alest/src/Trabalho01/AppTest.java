package Trabalho01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import Trabalho01.util.Timer;

public class AppTest {
    static final String ROOT_FILE_PATH = "src\\casosTeste\\";

    public static void main(String[] args) throws IOException {
        int choice;

        do {
            System.out.println("(1) Criar novo arquivo e testá-lo");
            System.out.println("(2) Testar todos arquivos na pasta casosTeste");
            System.out.println("(0) Sair");
            System.out.print("Escolha uma opção: ");
            choice = inputInt();
            handleChoice(choice);
        } while (choice != 0);

        System.out.println("Obrigado por utilizar o programa!");
    }

    private static void handleChoice(int choice) throws IOException {
        switch (choice) {
            case 1:
                createNewTest();
                break;

            case 2:
                readAllFiles(ROOT_FILE_PATH);
                break;

            case 0:
                break;

            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    private static void createNewTest() throws IOException {
        File file = createNewFile();
        int lineAmount;
        Sistema sys = new Sistema();
        Timer timer = new Timer();

        do {
            System.out.print("Digite quantas linhas você quer no arquivo\n ou 0 para um tamanho aleatório:  ");
            lineAmount = inputInt();
            if (lineAmount < 0)
                System.out.println("Apenas números naturais são permitidos.");
        } while (lineAmount < 0);

        writeOperationsFile(lineAmount, file);

        timer.start();
        sys.main(file);
        timer.finish();

        System.out.println(timer);
    }

    private static File createNewFile() {
        Scanner input = new Scanner(System.in);
        String newFileName;
        File newFile;

        System.out.print("Digite o nome.txt do arquivo que deseja criar: ");
        do {
            newFileName = input.nextLine();
            newFile = new File(ROOT_FILE_PATH + newFileName);
            if (newFile.exists())
                System.out.println("Um arquivo com este nome já existe, tente novamente.");
        } while (newFile.exists());
        System.out.println(newFile + " salvo com sucesso.");

        return newFile;
    }

    private static void writeOperationsFile(int lineAmount, File file) throws IOException {
        FileWriter fw = new FileWriter(file);
        ArrayList<String> operations = getOperations(lineAmount);

        for (String operation : operations)
            fw.write(operation + "\n");

        fw.close();
    }

    private static ArrayList<String> getOperations(int amount) {
        ArrayList<String> operations = new ArrayList<>();
        amount = amount <= 0 ? getRandom(1, 5000) : amount;

        // Começa a pilha com dois números, visto que uma operação daria erro sempre
        if (amount > 2)
            operations.add(getRandom(0, 999) + " " + getRandom(0, 999));
        if (amount > 3)
            operations.add(getRandom(0, 999) + " " + getRandom(0, 999));

        for (int i = 1; i < amount - 3; i++) {
            if (isNumber(operations.get(i)) && isNumber(operations.get(i - 1)))
                operations.add(getOperation(10));
            else
                // Se as últimas duas operações não forem números,
                // posso realizar menos operações
                operations.add(getOperation(5));
        }

        // Imprime a pilha e termina o arquivo
        if (amount > 1)
            operations.add("print");
        operations.add("quit");

        return operations;
    }

    private static String getOperation(int limit) {
        final String[] OPERACOES = { "chs", "conj", "abs", "pop", "dup", "inv", "+", "-", "*", "/", "swap" };

        // Aumenta levemente a chance de inserir um número ao invés de uma operação
        if (getRandom(0, 100) % 2 == 0)
            // acrescenta um número de até 3 dígitos na pilha
            return getRandom(0, 999) + " " + getRandom(0, 999);
        else
            // adiciona uma das operações
            return OPERACOES[getRandom(0, limit)];
    }

    private static boolean isNumber(String str) {
        try {
            Integer.parseInt(str.split(" ")[0]);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private static void readAllFiles(String filesPath) {
        File[] files = new File(filesPath).listFiles();
        Sistema sys = new Sistema();
        Timer timer = new Timer();

        timer.start();
        for (File file : files) {
            System.out.println(file);
            sys.main(file);
        }
        timer.finish();

        System.out.println(timer);
    }

    private static int getRandom(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }

    private static int inputInt() {
        try {
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException ime) {
            return inputInt();
        }
    }
}
