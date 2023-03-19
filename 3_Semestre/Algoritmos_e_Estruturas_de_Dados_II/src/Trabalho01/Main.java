package Trabalho01;

public class Main {
    public static void main(String[] args) {
        String filePath = args.length > 0 ? args[0]
                : "src/Trabalho01/macaquinhos.txt";
        new JungleGame(filePath);
    }
}
