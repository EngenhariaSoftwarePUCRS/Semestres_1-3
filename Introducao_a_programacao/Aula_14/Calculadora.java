import java.util.Scanner;
public class Calculadora {
    public static void main() {
        Scanner input = new Scanner(System.in);
        String usuario;
        int operacao;
        double resultado = 0;
     
        System.out.print("Digite seu nome: ");
        usuario = input.nextLine();
        
        menu(usuario);
        operacao = input.nextInt();
                    
        System.out.print("Digite o primeiro número: ");
        double a = input.nextDouble();
        
        System.out.print("Digite o segundo número: ");
        double b = input.nextDouble();
        
        switch(operacao) {            
            case 1:
                resultado = Adicao(a, b);
                break;
            case 2:
                resultado = Subtracao(a, b);
                break;
            case 3:
                resultado = Divisao(a, b);
                break;
            case 4:
                resultado = Multiplicacao(a, b);
                break;
            case 5:
                resultado = Resto(a, b);
                break;
            case 6:
                resultado = DivisaoInteira(a, b);
                break;
            case 7:
                resultado = Potencia(a, b);
                break;
            default:
                System.out.println("Por favor, reinicie o programa.");
                break;
        }
        
        System.out.println("O resultado da operação foi: "+resultado);
    }
    
    private static void menu(String usuario) {
        System.out.println("\n/==========================================\\");
        System.out.println("|    BEM-VINDO AO PROGRAMA, "+usuario.toUpperCase());
        System.out.println("|");
        System.out.println("| ESCOLHA UMA DAS OPÇÕES ABAIXO PARA INICIAR    ");
        System.out.println("| (1) Adição    ");
        System.out.println("| (2) Subtração    ");
        System.out.println("| (3) Divisão    ");
        System.out.println("| (4) Multiplicação    ");
        System.out.println("| (5) Resto da Divisão    ");
        System.out.println("| (6) Divisão Inteira    ");
        System.out.println("| (7) Potência    ");
        System.out.println("\\==========================================/");
    }

    private static double Adicao(double a, double b) {
        return a + b;
    }
    private static double Subtracao(double a, double b) {
        return a - b;
    }
    private static double Divisao(double a, double b) {
        return a / b;
    }
    private static double Multiplicacao(double a, double b) {
        return a * b;
    }
    private static double Resto(double a, double b) {
        return a % b;
    }
    private static double DivisaoInteira(double a, double b) {
        return (int)a / (int)b;
    }
    private static double Potencia(double a, double b) {
        return Math.pow(a, b);
    }
}