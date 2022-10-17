package Trabalho01;

import java.io.File;

public class AppTest {
    public static void main(String[] args) {
        String[] files = new String[11];
        files[0] = "calculos";
        for (int i = 1; i < 9; i++) {
            files[i] = "caso" + i;
        }
        for (int i = 9; i < files.length; i++) {
            files[i] = "teste" + (i - 8);
        }
        for (int i = 0; i < files.length; i++) {
            files[i] = "Trabalho01\\casosTeste\\" + files[i] + ".txt";
        }
        for (String file : files) {
            System.out.println(file);
            Sistema sys = new Sistema();
            sys.main(new File(file));
        }
    }
}
