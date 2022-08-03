/*
    2. Construa os seguintes métodos sobre arranjos
    a. Método que retorna quantas ocorrências de um elemento estão na
    lista
    int nOcorrencias(int[] l, Integer el)
    b. Método que retorna true se l tem elementos repetidos
    boolean hasRepeat(int[] l)
    c. Método que retorna o número de elementos repetidos em l
    int nroRepeat(int[] l)
    d. Método que retorna uma lista de elementos repetidos de l
    int[] listRepeat(int[] l)
    e. Método que retorna a união de l1 e l2
    int[] union(int[] l1, int[] l2)
    f. Método que retorna a intersecção de l1 e l2
    int[] intersect(int[] l1, int[] l2)
 */
public class Ex02 {
    public static void main(String[] args) {
        int[] lista = {3, 2, 4, 1, 2, 0, 0, 4, 5, 3, 2};
        int[] l2 = {3, 2, 1, 4};

        // Letra A:
        int elemento = 2;
        System.out.printf("Existe(m) %d ocorrências de %d na lista.", ocorrencias(elemento, lista), elemento);

        // Letra B:
        System.out.println();
        System.out.print(hasRepeat(lista));

        // Letra C:
        System.out.println();
        System.out.printf("Existe(m) %d números repetidos na lista.", nroRepeat(lista));

        // Letra D:
        // Obs: 0 não conta
        System.out.println();
        int[] repetidos = listRepeat(lista);
        for (int i : repetidos) {
            if (i != 0)
                System.out.printf("[%d] ", i);
        }

        // Letra E:
        int[] uniao = union(lista, l2);
        for (int i : uniao) {
            System.out.printf("[%d] ", i);
        }
    }

    public static int ocorrencias(int elemento, int[] lista) {
        int qtdOcorrencias = 0;

        for (int i : lista)
            if (i == elemento)
                qtdOcorrencias++;

        return qtdOcorrencias;
    }

    public static boolean hasRepeat(int[] l) {
        for (int i = 0; i < l.length; i++) {
            for (int j = 0; j < l.length; j++) {
                if (i == j) continue;
                if (l[i] == l[j]) return true;
            }
        }

        return false;
    }

    public static int nroRepeat(int[] l) {
        int nroRepeat = 0;
        int[] jaFoi = new int[l.length];
        
        for (int i = 0; i < l.length; i++) {
            for (int j = 0; j < l.length; j++) {
                if (i == j) continue;
                if ((l[i] == l[j]) && (!contains(l[i], jaFoi))) {
                    jaFoi[nroRepeat] = l[i];
                    nroRepeat++;
                    break;
                }
            }
        }

        return nroRepeat;
    }

    private static boolean contains (int i, int[] vetor) {
        for (int j : vetor)
            if (i == j) return true;
        return false;
    }

    public static int[] listRepeat(int[] l) {
        int[] repetidos = new int[l.length];

        for (int i = 0; i < l.length; i++) {
            for (int j = 0; j < l.length; j++) {
                if (i == j) continue;
                if ((l[i] == l[j]) && (!contains(l[i], repetidos))) {
                    repetidos[i] = l[i];
                    break;
                }
            }
        }

        return repetidos;
    }

    public static int[] union(int[] l1, int[] l2) {
        int[] uniao = new int[l1.length + l2.length];

        int k = 0;
        for (int i = 0; i < uniao.length; i++) {
            if (i < l1.length) {
                uniao[i] = l1[k];
                k++;
            }
            else {
                // zerarK();
                uniao[i] = l2[k];
                k++;
            }
        }

        return uniao;
    }
    
}
