import java.util.Scanner;
public class Codificador {
    public static void main() {
        Scanner input = new Scanner(System.in);
        String usuario;
        int operacao;
        String
     
        System.out.print("Digite seu nome: ");
        usuario = input.nextLine();
        
        menu(usuario);
        
        switch(operacao) {
            case 1:
                cifrar();
            case 2:
                decifrar();
        }
    }
    
    private static void menu(String usuario) {
        System.out.println("\n/==========================================\\");
        System.out.println("|    BEM-VINDO AO PROGRAMA, "+usuario.toUpperCase());
        System.out.println("|");
        System.out.println("| ESCOLHA UMA DAS OPÇÕES ABAIXO PARA INICIAR    ");
        System.out.println("| (1) CIFRAR    ");
        System.out.println("| (2) DECIFRAR    ");
        System.out.println("\\==========================================/");
    }
    
    private static String cifrar(String palavra) {
        
    }
}