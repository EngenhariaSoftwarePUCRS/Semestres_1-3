package Trabalho02.src;

public class App {
    public static void main(String[] args) {
        // Without extension (txt), should be located inside mapas/ folder
        String fileName = "mapa3";
        int harbourAmount = 9;
        new Mapa(fileName, harbourAmount);
    }
}
