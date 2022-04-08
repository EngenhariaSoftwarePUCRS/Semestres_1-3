import java.util.Scanner;
public class Lswitch {
    public static void main() {
        Scanner input = new Scanner(System.in);
        
        menu();
        int escolhida = input.nextInt();
        
        System.out.println("A operação escolhida foi: "+operacao(escolhida));
    }
    
    private static void menu() {
	System.out.println("\n/==========================================\\");
	System.out.println("|	BEM-VINDO AO PROGRAMA	");
	System.out.println("|");
	System.out.println("| ESCOLHA UMA DAS OPÇÕES ABAIXO PARA INICIAR	");
	System.out.println("| (1) Adição	");
	System.out.println("| (2) Subtração	");
	System.out.println("| (3) Divisão	");
	System.out.println("| (4) Multiplicação	");
	System.out.println("| (5) Resto da Divisão	");
	System.out.println("| (6) Divisão Inteira	");
	System.out.println("| (7) Potência	");
	System.out.println("\\==========================================/");
    }
    
    private static void operacao(int escolha) {
        
        switch(escolha) {
            case 1:
                Adicao();
                break;
            case 2:
                Subtracao();
                break;
            case 3:
                Divisao();
                break;
            case 4:
                Multiplicacao();
                break;
            case 5:
                Resto();
                break;
            case 6:
                DivisaoInteira();
                break;
            case 7:
                Potencia();
                break;
            default:
                System.out.println("Por favor, reinicie o programa.")
                break;
        }
    }

    private static int Adicao(int a, int b) {
        System.out.println("Adicao")
    }
    private static int Subtracao(int a, int b) {
        System.out.println("Subtracao")
    }
    private static int Divisao(int a, int b) {
        System.out.println("Divisao")
    }
    private static int Multiplicacao(int a, int b) {
        System.out.println("Multiplicacao")
    }
    private static int Resto(int a, int b) {
        System.out.println("Resto")
    }
    private static int DivisaoInteira(int a, int b) {
        System.out.println("DivisaoInteira")
    }
    private static int Potencia(int a, int b) {
        System.out.println("Potencia")
    }
}