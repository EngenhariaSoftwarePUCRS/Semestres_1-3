package Aula04_AnaliseAlgoritmosOrdenacao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import arrays.ArrayUtils;
import aula04_analise_algortimos_ordenacao.BubbleSort;
import aula04_analise_algortimos_ordenacao.InsertionSort;
import aula04_analise_algortimos_ordenacao.MergeSort;

public class AnaliseOrdenacao {
    final static int QUANTIDADE_VALORES = 1_000;

    public static void main(String[] args) throws IOException {
        File file = new File("src/Aula04_AnaliseAlgoritmosOrdenacao/output.csv");
        FileWriter fw = new FileWriter(file);
        fw.write("N;Bubble;Insertion;Merge;Quick\n");

        for (int n = 5; n <= QUANTIDADE_VALORES; n++) {
            int[] meuArrayOriginal = new int[n];
            int[] meuArrayBubble = new int[n];
            int[] meuArrayInsertion = new int[n];
            int[] meuArrayMerge = new int[n];
            int[] meuArrayQuick = new int[n];

            ArrayUtils.preencherArrayComValoresInteirosAleatorios(meuArrayOriginal, 100, true);
            ArrayUtils.clonarArray(meuArrayOriginal, meuArrayBubble);
            ArrayUtils.clonarArray(meuArrayOriginal, meuArrayInsertion);
            ArrayUtils.clonarArray(meuArrayOriginal, meuArrayMerge);
            ArrayUtils.clonarArray(meuArrayOriginal, meuArrayQuick);

            BubbleSort bubble = new BubbleSort();
            InsertionSort insertion = new InsertionSort();
            MergeSort merge = new MergeSort();
            QuickSort quick = new QuickSort();

            bubble.ordenar(meuArrayBubble);
            insertion.ordenar(meuArrayInsertion);
            merge.ordenar(meuArrayMerge);
            quick.ordenar(meuArrayQuick);

            fw.write(n + ";" + bubble.getOperacoes() + ";" + insertion.getOperacoes() + ";" + merge.getOperacoes() + ";"
                    + quick.getOperacoes() + "\n");
        }

        fw.close();
    }
}
