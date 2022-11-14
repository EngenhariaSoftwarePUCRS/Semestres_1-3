package Semana07;

public class TestaColecaoLinear{

	private static void mostraLista(ColecaoEncadeada l) {
				String s;
				int i = 0;
			
				for (i = 0; i < l.size(); i++){
					s = l.get(i);				
					System.out.print(s + " ");
				}
					
				System.out.println(" Fim");

		System.out.println("Fim mostraLista()");
	}

	public static void main(String[] args) {
		ColecaoEncadeada l = new ColecaoEncadeada();	
		String s1 = new String("a");
		String s2 = new String("b");
		String s3 = new String("c");
		String s4 = new String("d");
		String s5 = new String("e");

		//addFirst()
		System.out.println("\n\n addFirst()\n");
		l.addFirst(s1);
		l.addFirst(s2);
		l.addFirst(s3);
		l.addFirst(s4);
		l.addFirst(s5);
		mostraLista(l);
		//	System.exit(0);
		//Fim do primeiro teste. Comentar ou descomentar o exit(0).

// 		//-------------------------------		
// 		//	add() no final		
// 		System.out.println("\n\n add() \n");
// 		ColecaoEncadeada l = new ColecaoEncadeada();
// 		l.addLast(s1);
// 		l.addLast(s2);
// 		l.addLast(s3);
// 		l.addLast(s4);
// 		l.addLast(s5);
// 		mostraLista(l);		
// //		System.exit(0);
// 		//Fim do segundo teste. Comentar ou descomentar o exit(0).

// 		//-------------------------------		
// 		//	get()		
// 		System.out.println("\n\n get() \n");
// 		mostraLista(l);
		
// 		for (int i = 0; i < l.size(); i++)
// 			System.out.println("i = " + i + "  get(i) = " + l.get(i));

// 		try {
// 			System.out.println(l.get(30));
// 			System.out.println("Encontrou o elemento de nro 30!!  :-( ");
// 		}
// 		catch (IndexOutOfBoundsException ex) {
// 			System.out.println("N�o encontrou o elemento de nro 30!!");
// 		}
// 		try {
// 			System.out.println(l.get(-1));
// 			System.out.println("Encontrou o elemento de nro -1!!  :-( ");
// 		}
// 		catch (IndexOutOfBoundsException ex) {
// 			System.out.println("N�o encontrou o elemento de nro -1!!");
// 		}

		
// 		l.remove(4);
// 		mostraLista(l);
// 		l.remove(3);
// 		mostraLista(l);
// 		l.remove(2);
// 		mostraLista(l);
// 		l.remove(1);
// 		mostraLista(l);
// 		l.remove(0);
// 		mostraLista(l);


// 		//-------------------------------		
// 		//		add(0) e remove(0)		
// 		System.out.println("\n\nadd(0) e remove(0)\n");
// 		l.add(0,s1);
// 		l.add(0,s2);
// 		l.add(0,s3);
// 		l.add(0,s4);
// 		l.add(0,s5);

// 		try {
// 			System.out.println(l.get(30));
// 		}
// 		catch (IndexOutOfBoundsException ex) {
// 			System.out.println("N�o encontrou o elemento de nro 30!!");
// 		}

// 		mostraLista(l);

// 		l.remove(0);
// 		mostraLista(l);
// 		l.remove(0);
// 		mostraLista(l);
// 		l.remove(0);
// 		mostraLista(l);
// 		l.remove(0);
// 		mostraLista(l);
// 		l.remove(0);
// 		mostraLista(l);

// 		//-------------------------------		

// 		//-------------------------------		
// 		//		add(i) e remove(i)		

// 		System.out.println("\n\nadd(i) e remove(i)\n");
// 		l.add(0, s1);
// 		l.add(1, s5);
// 		l.add(1, s3);
// 		l.add(2, s4);
// 		l.add(1, s2);
// 		mostraLista(l);

// 		l.remove(0);
// 		mostraLista(l);
// 		l.remove(0);
// 		mostraLista(l);
// 		l.remove(0);
// 		mostraLista(l);
// 		l.remove(0);
// 		mostraLista(l);
// 		l.remove(0);
// 		mostraLista(l);

// 		l.add(0, s4);
// 		l.add(0, s1);
// 		l.add(2, s5);
// 		l.add(1, s3);
// 		l.add(1, s2);
// 		mostraLista(l);

// 		try {
// 			l.remove(5);
// 		}
// 		catch (IndexOutOfBoundsException ex){
// 			System.out.println("N�o existe o elemento da pos 5");
// 		}
// 		mostraLista(l);
// 		l.remove(0);
// 		mostraLista(l);
// 		l.remove(3);
// 		mostraLista(l);
// 		l.remove(1);
// 		mostraLista(l);
// 		l.remove(0);
// 		mostraLista(l);
// 		l.remove(0);
// 		mostraLista(l);

	}

}