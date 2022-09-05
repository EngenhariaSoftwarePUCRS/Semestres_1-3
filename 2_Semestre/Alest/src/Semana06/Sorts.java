package Semana06;
import java.util.Random;

public class Sorts {

	private long iteracoes = 0;
	private long instrucoes = 0;
	private long tempoIni = 0, tempoFim = 0;

	public long getInstrucoes() {
		return instrucoes;
	}

	public void setInstrucoes(long instrucoes) {
		this.instrucoes = instrucoes;
	}

	public long getIteracoes() {
		return iteracoes;
	}

	public void setIteracoes(long iteracoes) {
		this.iteracoes = iteracoes;
	}

	public void incrIteracoes(long incr) {
		setIteracoes(getIteracoes() + incr);
	}

	public void incrInstrucoes(long instr) {
		setInstrucoes(getInstrucoes() + instr);
	}

	public void initClock() {
		tempoIni = tempoFim = System.nanoTime();
	}

	public double getClockSec() {
		double res;

		tempoFim = System.nanoTime();
		res =  ((double)tempoFim - (double)tempoIni) / (double)1_000_000_000.0;

		return res;
	}

	public void resetCounters() {
		setIteracoes(0);
		setInstrucoes(0);
		initClock();
	}

	public long[] geraVetor(int nroElem, int lim) {
		int dummy;
		long [] res = null;
		int cont = 0;
		Random rnd = new Random(System.nanoTime() * System.currentTimeMillis());

		if (nroElem >= 0) {

			res = new long[nroElem];

			while (cont < nroElem) {
				dummy = rnd.nextInt(lim)+1;
				dummy = rnd.nextInt(lim)+1;
				
				dummy = rnd.nextInt(lim)+1;
				res[cont++] = (long) dummy;
			}
		}
		return res;
	}

	public long[] geraVetorInv(int nroElem) {
		long [] res = null;
		
		if (nroElem > 0) {

			res = new long[nroElem];

			for (int i = nroElem -1; i >= 0; i--)
				res[i] = (long) nroElem - i;
		}
		return res;
	}

	public void quickSort(int[] v, int left, int right) {
		incrIteracoes(1);
		incrInstrucoes(1);


		if (right > left) {
			incrInstrucoes(7);

			int pivotIndex = left;  
			int pivotNewIndex = partition(v, left, right, pivotIndex);
			quickSort(v, left, pivotNewIndex-1);
			quickSort(v, pivotNewIndex+1, right);
		}  
	}

	private int partition(int [] array, int left, int right, int pivotIndex) {
		int aux;

		int pivotValue = array[pivotIndex];

		aux = array[pivotIndex];
		array[pivotIndex] = array[right];
		array[right] = aux;

		int storeIndex = left;
		incrInstrucoes(11);

		for (int i = left; i <= right-1; i++) {
			incrIteracoes(1);
			incrInstrucoes(5);

			if (array[i] < pivotValue) {
				incrInstrucoes(9);

				aux = array[storeIndex];
				array[storeIndex] = array[i];
				array[i] = aux;

				storeIndex = storeIndex + 1;
			}
		}

		aux = array[right];
		array[right] = array[storeIndex];
		array[storeIndex] = aux;
		incrInstrucoes(8);

		return storeIndex;
	}

	int[] insertSort(int[] v) {
		int i = 0;
		incrInstrucoes(1);
		while (i < v.length) {
			incrIteracoes(1);
			incrInstrucoes(6);
			findPos(v, i, v[i]);
			i = i + 1;
		}

		return v;
	}

	void findPos(int[] a, int tam, int value) {
		int i = tam - 1;
		incrInstrucoes(2);
		while (i >= 0 && a[i] > value) {
			incrInstrucoes(10);
			incrIteracoes(1);
			a[i + 1] = a[i];
			i = i - 1;
		}

		incrInstrucoes(3);
		a[i + 1] = value;
	}

	public int[] bubbleSort0(int [] v) {
		int aux; 
		int i;
		for (int j = 0; j < v.length - 1; j++) {
			for (i = 0; i < v.length - 1; i++) {
				incrIteracoes(1);
				if (v[ i ] > v[ i + 1 ]) {
					aux = v[i];
					v[ i ] = v[ i + 1 ];
					v[i + 1] = aux;
				}		         
			}

			if (i == 0)
				incrIteracoes(1);
		}

		return v;
	}

	public int[] bubbleSort1(int [] v) {
		boolean swapped;
		int aux;
		int i;
		do {
			swapped = false;
			for (i = 0; i < v.length - 1; i++) {
				incrIteracoes(1);
				if (v[ i ] > v[ i + 1 ]) {
					aux = v[i];
					v[ i ] = v[ i + 1 ];
					v[i + 1] = aux;
					swapped = true;
				}		         
			}

			if (i == 0)
				incrIteracoes(1);


		} while (swapped);

		return v;
	}

	public int[] bubbleSort2(int [] v) {
		boolean swapped;
		int aux; 
		int i, fim = v.length - 1;
		incrInstrucoes(3);
		do {
			swapped = false;
			incrInstrucoes(2);

			for (i = 0; i < fim; i++) {
				incrIteracoes(1);
				incrInstrucoes(7);

				if (v[ i ] > v[ i + 1 ]) {
					incrInstrucoes(11);
					aux = v[i];
					v[ i ] = v[ i + 1 ];
					v[i + 1] = aux;
					swapped = true;
				}
			}

			fim--;
			incrInstrucoes(3);
			if (i == 0)
				incrIteracoes(1);

		} while (swapped);

		return v;
	}

	public void mergeSort(int [] v, int inicio, int fim) {
		incrIteracoes(1);
		incrInstrucoes(1);
		if (inicio < fim) {
			int meio = (inicio + fim) / 2;
			mergeSort(v, inicio, meio);
			mergeSort(v, meio+1, fim);
			merge(v, inicio, meio, fim);
			incrInstrucoes(7);
		}
	}

	private void merge(int [] v, int inicio, int meio, int fim) {
		int nL = meio-inicio+1; int nR = fim-meio;
		int [] L = new int[nL]; int [] R = new int[nR];

		System.arraycopy(v, inicio, L, 0, nL);
		incrIteracoes(nL);

		System.arraycopy(v, meio+1, R, 0, nR);
		incrIteracoes(nR);

		incrInstrucoes(10);

		incrInstrucoes(1);
		int iL = 0; int iR = 0;
		for (int k=inicio; k<=fim; k++) {

			incrIteracoes(1);
			incrInstrucoes(4);

			if (iR < nR) {
				incrInstrucoes(1);
				if (iL < nL) {
					incrInstrucoes(7);
					if (L[iL] < R[iR]) v[k] = L[iL++];
					else v[k] = R[iR++];
				}
				else {
					v[k] = R[iR++];
					incrInstrucoes(5);
				}
			}
			else {
				v[k] = L[iL++];
				incrInstrucoes(5);
			}
		}
	}
}
