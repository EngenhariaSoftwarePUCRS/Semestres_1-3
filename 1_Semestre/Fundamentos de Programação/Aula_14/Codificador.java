package Aula_14;
import java.util.Scanner;

public class Codificador {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int escolha;
        String
            palavra,
            novaPalavra = null;
        
        menu();
        escolha = input.nextInt();
        
        System.out.print("Escreva uma palavra: ");
        input.nextLine(); palavra = input.nextLine();
        
        switch(escolha) {
            default:
                System.out.println("Por favor, reinicie o programa.");
                break;
            case 1:
                novaPalavra = transform(palavra, "cifrar");
                break;
            case 2:
                novaPalavra = transform(palavra, "decifrar");
                break;
        }
        
        System.out.printf("Palavra: %s --> Cifrada: %s \n", palavra, novaPalavra);
    }
    
    private static void menu() {
        System.out.println("\n/==========================================\\");
        System.out.println("|    BEM-VINDO AO PROGRAMA ");
        System.out.println("|");
        System.out.println("| ESCOLHA UMA DAS OPÇÕES ABAIXO PARA INICIAR    ");
        System.out.println("| (1) CIFRAR    ");
        System.out.println("| (2) DECIFRAR    ");
        System.out.println("\\==========================================/");
    }
    
    private static String transform(String palavra, String operacao) {
        palavra = palavra.toLowerCase();
        
        if (operacao.equals("cifrar")) {
            palavra = palavra
                .replaceAll("a", "w")
                .replaceAll("e", "y")
                .replaceAll("i", "h");
        } else {
            palavra = palavra
                .replaceAll("w", "a")
                .replaceAll("y", "e")
                .replaceAll("h", "i");
        }
        
        return palavra;
    }
}