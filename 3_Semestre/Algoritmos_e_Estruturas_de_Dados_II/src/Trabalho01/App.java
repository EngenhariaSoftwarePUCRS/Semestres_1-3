package Trabalho01;

import java.io.File;

public class App {
    public static void main(String[] args) {
        String filePath = args.length > 0 ? args[0]
                : "src/Trabalho01/macaquinhos.txt";
        new JungleGame(new File(filePath)).play();
    }
}
