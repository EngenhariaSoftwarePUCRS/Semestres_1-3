package RevisaoP2.Questao1;

public class Main {
	public static void main(String[] args) {
		Produto<Integer, Double> telefone = new Produto<Integer, Double>(1010, "Samsung", 2499.99);
		System.out.println(telefone);
	}
}