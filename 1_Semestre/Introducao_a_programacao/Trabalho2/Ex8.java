/*8.Escreva laços aninhados que escrevam o seguinte padrão:

    [][][][]
    [][][][]
    [][][][]
    [][][][]*/
public class Ex8 {
    public static void main() {
        int largura = 4, altura = 4;
        for (int i = 0; i < largura; i++) {
            for (int j = 0; j < altura; j++) {
                System.out.print("[]");
            }
            System.out.println();
        }
    }
}
