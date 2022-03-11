public class CalculadoraSoma {
    //4- Escreva um programa que calcula a soma dos dez primeiros números positivos, 1 + 2 + ... + 10
    public static void main() {

        int aux = 0;

        for (int index = 1; index <= 10; index++) {
            aux = aux + index;
        }

        System.out.println("A soma final é: " + aux);
    }
}
