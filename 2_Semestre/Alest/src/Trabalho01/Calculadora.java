package Trabalho01;

import java.util.ArrayList;

public class Calculadora {
	
	public static void main(String[] args) {
		ArrayList<NumeroComplexo> lst = new ArrayList<>();

		NumeroComplexo a = new NumeroComplexo(4, -2);
		NumeroComplexo b = new NumeroComplexo(2, 2);
		lst.add(soma(a, b));
		lst.add(subtracao(a, b));
		lst.add(multiplicacao(a, b));
		lst.add(divisao(a, b));
		lst.add(inverso(a));
	}

	static NumeroComplexo soma(NumeroComplexo a, NumeroComplexo b) {
		return new NumeroComplexo().soma(a, b);
	}

	static NumeroComplexo subtracao(NumeroComplexo a, NumeroComplexo b) {
		return new NumeroComplexo().subtracao(a, b);
	}

	static NumeroComplexo multiplicacao(NumeroComplexo a, NumeroComplexo b) {
		return new NumeroComplexo().multiplicacao(a, b);
	}

	static NumeroComplexo divisao(NumeroComplexo a, NumeroComplexo b) {
		return new NumeroComplexo().divisao(a, b);
	}

	static NumeroComplexo inverso(NumeroComplexo n) {
		return new NumeroComplexo(n).inverso();
	}
}
