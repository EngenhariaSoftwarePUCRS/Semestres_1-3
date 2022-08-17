package Aula02;

public class LetraB {
    
    private int contador = 0;

    public void separaParImpar(int[] vet) {
        int qtdPares = 0, qtdImpares = 0;
        int[] pares;
        int[] impares;

        for (int i : vet) {
            if (i % 2 == 0)
                qtdPares++;
            else
                qtdImpares++;
        }

        pares = new int[qtdPares];
        impares = new int[qtdImpares];

        int posPar = 0;
        int posImpar = 0;
        for (int i = 0; i < vet.length; i++) {
            if (vet[i] % 2 == 0) {
                pares[posPar] = vet[i];
                posPar++;
            } else {
                impares[posImpar] = vet[i];
                posImpar++;
            }
            contador++;
        }
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int valor) {
        this.contador = valor;
    }
}
