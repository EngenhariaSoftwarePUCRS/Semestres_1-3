package Trabalho01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import Trabalho01.util.Timer;

public class AppTest {
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
    }

    private static void handleChoice(int choice) throws IOException {
        switch (choice) {
            case 1:
                createNewFile();
                break;

            case 2:
                readAllFiles("Trabalho01\\casosTeste");
                break;

            case 0:
                break;

            default:
                System.out.println("Opção inválida");
                break;
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

    private static void createNewFile() throws IOException {
        Scanner input = new Scanner(System.in);
        String newFileName;
        File newFile;
        FileWriter fw;
        String operation;
        int qtdLinhas;
        Sistema sys;
        Timer timer;
        final String[] OPERACOES = { "+", "-", "*", "/", "inv", "chs", "conj", "abs", "pop", "dup", "swap" };

        System.out.print("Digite o nome do arquivo que deseja criar: ");
        do {
            newFileName = input.nextLine();
            newFile = new File("Trabalho01\\casosTeste\\" + newFileName);
            if (newFile.exists())
                System.out.println("Um arquivo com este nome já existe, tente novamente.");
        } while (newFile.exists());

        System.out.print("Digite quantas linhas você quer no arquivo: ");
        qtdLinhas = inputInt();
        fw = new FileWriter(newFile);
        operation = getRandom(0, 999) + " " + getRandom(0, 999);
        fw.write(operation + "\n");
        operation = getRandom(0, 999) + " " + getRandom(0, 999);
        fw.write(operation + "\n");
        for (int i = 0; i < qtdLinhas; i++) {
            if (getRandom(0, 100) % 2 == 0)
                operation = getRandom(0, 999) + " " + getRandom(0, 999);
            else
                operation = OPERACOES[getRandom(0, 10)];
            fw.write(operation + "\n");
        }
        fw.write("quit");
        fw.close();
        System.out.println(newFile + " salvo com sucesso.");
        sys = new Sistema();
        timer = new Timer();

        timer.start();
        sys.main(newFile);
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
