/*7.O que os seguintes laços aninhados mostram na tela?
    for(int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 4; j++)
        {
            System.out.println(i + j);
        }
        System.out.println();
    }*/
public class Ex7 {
    public static void main() {
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println(i + j);
            }
            System.out.println();
        }
        System.out.println("O laço acima mostra a soma dos números 0, 1 e 2 com os números de 0-3");
    }
}
