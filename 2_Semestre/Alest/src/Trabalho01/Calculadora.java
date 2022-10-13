package Trabalho01;

import java.util.ArrayList;

public class Calculadora {
	
	static ArrayList<String> lst = new ArrayList<>();
	public static void main(String[] args) {
		lst.add("5 3");
		lst.add("2 -3");
	}

	static void multiplicacao() {
		double[] a = {Double.parseDouble(lst.get(0).split(" ")[0]), Double.parseDouble(lst.get(1).split(" ")[0])};
		double[] b = {Double.parseDouble(lst.get(0).split(" ")[1]), Double.parseDouble(lst.get(1).split(" ")[1])};
		double[] resultado = {(a[0] * a[1] - b[0] * b[1]), (a[0]*b[1] + b[0]*a[1])};
		System.out.println(resultado[0] + " " + resultado[1]);
	}

	static void divisao() {

	}

	static void inverso() {
		// divisao(a - b, a² + b²);
	}
}
