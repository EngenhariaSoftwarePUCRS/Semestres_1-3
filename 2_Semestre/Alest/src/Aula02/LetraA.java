package Aula02;

public class LetraA {
    private int contador = 0;

    public void separaParImpar(int[] vet) {
        for (int i = 0; i < vet.length - 1; i++) {
            for (int j = 0; j < vet.length - 1 - i; j++) {
                if ((vet[j] % 2 != 0) && (vet[j + 1] % 2 == 0)) {
                    int aux = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = aux;
                }
                contador++;
            }
        }
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int valor) {
        this.contador = valor;
    }
}
