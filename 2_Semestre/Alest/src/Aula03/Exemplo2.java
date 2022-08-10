package Aula03;

public class Exemplo2 {
    public int somaTudo(int[] lst) {
        int soma = 0;
        
        for (int i : lst) {
            soma += i;
            for (int j : lst)
                soma += j;
        }

        return soma;
    }
}
