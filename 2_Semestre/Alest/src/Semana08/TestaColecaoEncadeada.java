package estruturaEncadeada;

public class TestaColecaoEncadeada {

	public static void main(String[] args) {
		ColecaoEncadeada lst = new ColecaoEncadeada();
		
		System.out.println("Primeira Passada");
		lst.addFirst("10");
		System.out.println(lst);
		lst.addFirst("20");
		System.out.println(lst);
		lst.addFirst("30");
		System.out.println(lst);
		System.out.println(lst.get(0));
		System.out.println(lst.get(1));
		System.out.println(lst.get(2));
		
//		System.out.println(lst.get(3));   //ERRO
		
		lst.addLast("100");
		lst.addLast("200");
		lst.addLast("300");
		lst.addLast("400");
		System.out.println(lst);
		lst.removeFirst();
		System.out.println(lst);
		lst.removeFirst();
		System.out.println(lst);
		lst.removeFirst();
		System.out.println(lst);
		
		lst.removeLast();
		lst.removeLast();
		System.out.println(lst);
		
	
//		lst = new ColecaoEncadeada();
//		
//		System.out.println("\n\nSegunda Passada");
//		lst.addFirst("10");
//		System.out.println(lst);
//		lst.addFirst("20");
//		System.out.println(lst);
//		lst.addFirst("30");
//		System.out.println(lst);
//		System.out.println(lst.get(0));
//		System.out.println(lst.get(1));
//		System.out.println(lst.get(2));
//		
//		System.out.println(lst.get(3));   //ERRO
		
//		lst.addLast("100");
//		lst.addLast("200");
//		lst.addLast("300");
//		lst.addLast("400");
//		System.out.println(lst);
//		lst.removeFirst();
//		System.out.println(lst);
//		lst.removeFirst();
//		System.out.println(lst);
//		lst.removeFirst();
//		System.out.println(lst);
//		
//		lst.removeLast();
//		lst.removeLast();
//		System.out.println(lst);
	
	}

}
