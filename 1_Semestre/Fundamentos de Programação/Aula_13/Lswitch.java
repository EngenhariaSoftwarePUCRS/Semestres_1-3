import java.util.Scanner;
public class Lswitch {
    public static void main() {
        Scanner input = new Scanner(System.in);
        
        menu();
        int escolhido = input.nextInt();
        
        System.out.println("O idioma escolhido foi: "+idioma(escolhido));
    }
    
    private static void menu() {
	System.out.println("\n/==========================================\\");
	System.out.println("|	BEM-VINDO AO PROGRAMA	");
	System.out.println("|");
	System.out.println("| ESCOLHA UMA DAS OPÇÕES ABAIXO PARA INICIAR	");
	System.out.println("| (1) Inglês	");
	System.out.println("| (2) Alemão	");
	System.out.println("| (3) Francês	");
	System.out.println("\\==========================================/");
    }
    
    private static String idioma(int escolha) {
        String idioma;
        
        switch(escolha) {
            case 1:
                idioma = "English";
                break;
            case 2:
                idioma = "Deutsch";
                break;
            case 3:
                idioma = "Français";
                break;
            default:
                idioma = "Português";
                break;
        }
        
        return idioma;
    }
}