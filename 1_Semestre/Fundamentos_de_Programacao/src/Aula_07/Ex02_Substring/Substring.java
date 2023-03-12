package Aula_07.Ex02_Substring;

public class Substring {
    // O que o programa abaixo imprime na tela?
    public static void main(String[] args) {
        String str = "Harry";
        int n = str.length();
        String mystery = str.substring(0, 1) + str.substring(n - 1, n);
        System.out.println(mystery);
    }
}