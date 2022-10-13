package Trabalho01;

public class NumeroComplexo {
	private double parteReal;
	private double parteImaginaria;

	public NumeroComplexo() {}

	public NumeroComplexo(NumeroComplexo n) {
		this.parteReal = n.getParteReal();
		this.parteImaginaria = n.getParteImaginaria();
	}

	public NumeroComplexo(double parteReal, double parteImaginaria) {
		this.parteReal = parteReal;
		this.parteImaginaria = parteImaginaria;
	}

	public double getParteReal() {
		return parteReal;
	}

	public void setParteReal(double parteReal) {
		this.parteReal = parteReal;
	}

	public double getParteImaginaria() {
		return parteImaginaria;
	}

	public void setParteImaginaria(double parteImaginaria) {
		this.parteImaginaria = parteImaginaria;
	}

	public String toString() {
		return parteReal + " " + parteImaginaria + "i";
	}

	public NumeroComplexo soma(NumeroComplexo a, NumeroComplexo b) {
		double somaParteReal = a.getParteReal() + b.getParteReal();
		double somaParteImaginaria = a.getParteImaginaria() + b.getParteImaginaria();
		return new NumeroComplexo(somaParteReal, somaParteImaginaria);
	}

	public NumeroComplexo subtracao(NumeroComplexo a, NumeroComplexo b) {
		double subtracaoParteReal = a.getParteReal() - b.getParteReal();
		double subtracaoParteImaginaria = a.getParteImaginaria() - b.getParteImaginaria();
		return new NumeroComplexo(subtracaoParteReal, subtracaoParteImaginaria);
	}

	public NumeroComplexo multiplicacao(NumeroComplexo a, NumeroComplexo b) {
		double multiplicacaoParteReal = a.getParteReal() * a.getParteImaginaria() - b.getParteReal() * b.getParteImaginaria();
		double multiplicacaoParteImaginaria = a.getParteReal()*b.getParteImaginaria() + b.getParteReal()*a.getParteImaginaria();
		return new NumeroComplexo(multiplicacaoParteReal, multiplicacaoParteImaginaria);
	}

	public NumeroComplexo divisao(NumeroComplexo a, NumeroComplexo b) {
		double divisaoParteReal = a.getParteReal() / b.getParteReal();
		double divisaoParteImaginaria = a.getParteImaginaria() / b.getParteImaginaria();
		return new NumeroComplexo(divisaoParteReal, divisaoParteImaginaria);
	}

	public NumeroComplexo inverso() {
		double parteReal = getParteReal()
								/
		(quadrado(getParteReal()) + quadrado(getParteImaginaria()));
		double parteImaginaria = - getParteImaginaria()
											/
				(quadrado(getParteReal()) + quadrado(getParteImaginaria()));
									
		return (new NumeroComplexo(parteReal, parteImaginaria));
	}

	private double quadrado(double x) {
		return Math.pow(x, 2);
	}
}
