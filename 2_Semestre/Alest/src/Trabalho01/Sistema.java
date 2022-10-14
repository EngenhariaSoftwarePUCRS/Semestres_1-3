package Trabalho01;

import java.util.ArrayList;

public class Sistema {
	
	public static void main(String[] args) {
		ArrayList<NumeroComplexo> lst = new ArrayList<>();
		String[] operacoes = {"soma", "subtração", "inverso", "changeSign", "conjugado", "modulo"};

		NumeroComplexo a = new NumeroComplexo(1, -2);
		NumeroComplexo b = new NumeroComplexo(-2, -3);
		NumeroComplexo c = new NumeroComplexo(5, 2);
		lst.add(sum(a, b));
		lst.add(sub(a, b));
		// lst.add(mul(a, b));
		// lst.add(div(a, b));
		lst.add(inv(c));
		lst.add(chs(c));
		lst.add(conj(c));
		lst.add(abs(c));

		System.out.println("{");
		for (int i = 0; i < lst.size(); i++) {
			System.out.println("\t" + operacoes[i] + ": " + lst.get(i)+", ");
		}
		System.out.println("}");
	}

	static NumeroComplexo sum(NumeroComplexo a, NumeroComplexo b) {
		return CalculadoraComplexo.soma(a, b);
	}

	static NumeroComplexo sub(NumeroComplexo a, NumeroComplexo b) {
		return CalculadoraComplexo.subtracao(a, b);
	}

	static NumeroComplexo mul(NumeroComplexo a, NumeroComplexo b) {
		return CalculadoraComplexo.multiplicacao(a, b);
	}

	static NumeroComplexo div(NumeroComplexo a, NumeroComplexo b) {
		return CalculadoraComplexo.divisao(a, b);
	}

	static NumeroComplexo inv(NumeroComplexo n) {
		return CalculadoraComplexo.inverso(n);
	}

	static NumeroComplexo chs(NumeroComplexo n) {
		return CalculadoraComplexo.changeSign(n);
	}

	static NumeroComplexo conj(NumeroComplexo n) {
		return CalculadoraComplexo.conjugado(n);
	}

	static NumeroComplexo abs(NumeroComplexo n) {
		return new NumeroComplexo(CalculadoraComplexo.absolute(n), 0);
	}
}
