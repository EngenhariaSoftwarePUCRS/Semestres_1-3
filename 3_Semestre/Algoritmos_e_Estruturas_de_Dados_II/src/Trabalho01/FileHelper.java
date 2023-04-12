package Trabalho01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileHelper {
    public static Scanner fileScanner(File file) {
        try {
            return new Scanner(file);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error finding especified file.\n" + fnfe);
            return null;
        } catch (Exception e) {
            System.out.println("Unknown error reading file.\n" + e);
            return null;
        }
    }

    public static int countLines(File file) {
        try {
            try {
                String fileName = file.getName();
                return Integer.parseInt(fileName.substring(0, 4));
            } catch (InputMismatchException ime) {
                Scanner reader = new Scanner(file);
                int lineAmount = 0;
                while (reader.hasNext()) {
                    lineAmount++;
                    reader.nextLine();
                }
                reader.close();
                return lineAmount - 1;
            }
        } catch (FileNotFoundException fnfe) {
            return -1;
        }
    }
}
