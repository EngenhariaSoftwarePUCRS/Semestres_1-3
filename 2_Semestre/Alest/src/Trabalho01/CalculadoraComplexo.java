package Trabalho01;

public abstract class CalculadoraComplexo {
	static NumeroComplexo soma(NumeroComplexo a, NumeroComplexo b) {
		double somaParteReal = a.getParteReal() + b.getParteReal();
		double somaParteImaginaria = a.getParteImaginaria() + b.getParteImaginaria();
		return new NumeroComplexo(somaParteReal, somaParteImaginaria);
	}

	static NumeroComplexo subtracao(NumeroComplexo a, NumeroComplexo b) {
		double subtracaoParteReal = a.getParteReal() - b.getParteReal();
		double subtracaoParteImaginaria = a.getParteImaginaria() - b.getParteImaginaria();
		return new NumeroComplexo(subtracaoParteReal, subtracaoParteImaginaria);
	}

	static NumeroComplexo multiplicacao(NumeroComplexo a, NumeroComplexo b) {
		double multiplicacaoParteReal = (a.getParteReal() * b.getParteReal())
				- (a.getParteImaginaria() * b.getParteImaginaria());
		double multiplicacaoParteImaginaria = ((a.getParteReal() * b.getParteImaginaria())
				+ (b.getParteReal() * a.getParteImaginaria()));
		return new NumeroComplexo(multiplicacaoParteReal, multiplicacaoParteImaginaria);
	}

	static NumeroComplexo divisao(NumeroComplexo a, NumeroComplexo b) {
		double denominador = (quadrado(b.getParteReal()) + quadrado(b.getParteImaginaria()));
		handleDenominadorZero(denominador);
		double numeradorReal = ((a.getParteReal() * b.getParteReal())
				+ (a.getParteImaginaria() * b.getParteImaginaria()));
		double numeradorImaginario = ((b.getParteReal() * a.getParteImaginaria())
				- (a.getParteReal() * b.getParteImaginaria()));
		double divisaoParteReal = numeradorReal / denominador;
		double divisaoParteImaginaria = numeradorImaginario / denominador;
		return new NumeroComplexo(divisaoParteReal, divisaoParteImaginaria);
	}

	static NumeroComplexo inverso(NumeroComplexo n) {
		NumeroComplexo novo = new NumeroComplexo(n);
		double denominador = quadrado(novo.getParteReal()) + quadrado(novo.getParteImaginaria());
		handleDenominadorZero(denominador);
		double parteReal = novo.getParteReal() / denominador;
		double parteImaginaria = -novo.getParteImaginaria() / denominador;
		novo.setParteReal(parteReal);
		novo.setParteImaginaria(parteImaginaria);
		return novo;
	}

	static NumeroComplexo changeSign(NumeroComplexo n) {
		NumeroComplexo novo = new NumeroComplexo(n);
		if (novo.getParteReal() != 0)
			novo.setParteReal(-novo.getParteReal());
		if (novo.getParteImaginaria() != 0)
			novo.setParteImaginaria(-novo.getParteImaginaria());
		return novo;
	}

	static NumeroComplexo conjugado(NumeroComplexo n) {
		return new NumeroComplexo(n.getParteReal(), -n.getParteImaginaria());
	}

	static double absolute(NumeroComplexo n) {
		return raiz(quadrado(n.getParteReal()) + quadrado(n.getParteImaginaria()));
	}

	private static double quadrado(double x) {
		return Math.pow(x, 2);
	}

	private static double raiz(double x) {
		return Math.sqrt(x);
	}

	private static void handleDenominadorZero(double denominador) {
		if (denominador == 0)
			throw new ArithmeticException("Não é possível dividir por zero.");
	}
}
