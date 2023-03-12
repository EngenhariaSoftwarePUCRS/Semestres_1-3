package Semana_17;

public class OrdenacaoBubbleSort {

    public static void main(String args[]) {
        int myArray[] = { 9, 8, 7, 6, 5, 1, 2, 4, 3 };
        char[] felipe = { 'f', 'e', 'l', 'i', 'p', 'e' };
        bubbleSort(myArray);
        sortByCharacter(felipe);

        System.out.print("Array ordenado: \n[ ");
        for (int i = 0; i < myArray.length - 1; i++)
            System.out.printf("%d, ", myArray[i]);
        System.out.printf("%d ]", myArray[myArray.length - 1]);

        System.out.println("\nNome ordenado: ");
        for (char c : felipe)
            System.out.print(c);
    }

    public static void bubbleSort(int vetor[]) {
        int n = vetor.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (vetor[j] > vetor[j + 1]) {
                    // troca arr[j+1] and arr[j]
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
    }

    private static void sortByCharacter(char[] vetor) {
        int n = vetor.length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (vetor[j] > vetor[j + 1]) {
                    char temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
    }
}
