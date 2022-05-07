/**
for (int i = 1; i <= height; i++)
{
    for (int j = 1; j <= width; j++) 
    { 
        System.out.print("*"); 
    }
    System.out.println();
}
Imprimem um retângulo a partir de uma altura e uma largura como, por exemplo,

****
****
****
Escreva um programa que lê a altura, largura e o caractere a ser utilizado e então desenha o retângulo.

 */
import java.util.Scanner;
public class Ex9
{
    public static void main() {
        Scanner input = new Scanner(System.in);
        int height, width;
        String caracter;
        System.out.print("Digite a altura do quadrilátero: ");
        height = input.nextInt();
        System.out.print("Digite a largura do quadrilátero: ");
        width = input.nextInt();
        input.nextLine();
        System.out.print("Digite o caracter que vai preencher o quadrilátero: ");
        caracter = input.nextLine();
        for (int i = 1; i <= height; i++)
        {
            for (int j = 1; j <= width; j++) 
            { 
                System.out.print(caracter); 
            }
            System.out.println();
        }
    }
}
