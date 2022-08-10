package Aula03;

public class Main {
    public static void main(String[] args) {
        Exemplo2 exemplo2 = new Exemplo2();
        int[] lst = {5, 2, 3};
        for (int i : lst) System.out.printf("[%d]", i);
        System.out.println(" Soma de todos os elementos do vetor com todos os elementos: "+exemplo2.somaTudo(lst));
    }
}
