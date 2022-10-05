// import java.io.*;

// public class TestaLista {

// 	public static void mostraLista(ListTAD <String> l) {
// 		String s;
// 		int i = 0;
// 		try {
// 			s = l.get(i);
// 			while (s != null) {
// 				System.out.print(s + " ");
// 				i++;
// 				s = l.get(i);
// 			}
// 		}
// 		catch (IndexOutOfBoundsException ex) {}
		
// 		System.out.println(" Fim");
// 	}
// 	public static void main(String[] args) {
// 		// TODO Auto-generated method stub
		
// 		FileOutputStream saida = null;
// 		ObjectOutputStream oSaida = null;
// 		FileInputStream entrada = null;
// 		ObjectInputStream oEntrada = null;

// 									//
// 		ListTAD <String> l = new ListSimpleLinkedFull<>();	// = new SUA CLASSE AQUI;
// //		ListTAD <String> l = new ListArray<>(100);	// = new SUA CLASSE AQUI;
// 									//
// 		String s1 = new String("a");
// 		String s2 = new String("b");
// 		String s3 = new String("c");
// 		String s4 = new String("d");
// 		String s5 = new String("e");
		
// //add e remove(size()-1)		
// 		System.out.println("\n\nadd e remove(size()-1)\n");
// 		l.add(s1);
// 		l.add(s2);
// 		l.add(s3);
// 		l.add(s4);
// 		l.add(s5);
// 		mostraLista(l);
		
// 		l.remove(l.size()-1);
// 		mostraLista(l);
// 		l.remove(l.size()-1);
// 		mostraLista(l);
// 		l.remove(l.size()-1);
// 		mostraLista(l);
// 		l.remove(l.size()-1);
// 		mostraLista(l);
// 		l.remove(l.size()-1);
// 		mostraLista(l);


// //-------------------------------		
// //		add(0) e remove(0)		
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
// 			System.out.println("Não encontrou o elemento de nro 30!!");
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

// //-------------------------------		
		
// //-------------------------------		
// //		add(i) e remove(i)		
		
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
// 		} catch (IndexOutOfBoundsException ex){
// 			System.out.println("Não existe o elemento da pos 5");
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
		

// /*-------------------------------		
// 				getNext e getPrev()		
// 				System.out.println("\n\ngetNext e getPrev\n");
// 				l.add(s1);
// 				l.add(s2);
// 				l.add(s3);
// 				l.add(s4);
// 				l.add(s5);
// 				mostraLista(l);
				
// 				String aux;
// 				aux = l.get(0);
// 				while(aux != null)
// 				{
// 					System.out.print(aux + " ");
// 					aux = l.getNext();
// 				}
				
// 				System.out.println(" Fim");

// 				aux = l.get(l.size()-1);
// 				while(aux != null)
// 				{
// 					System.out.print(aux + " ");
// 					aux = l.getPrev();
// 				}
				
// 				System.out.println(" Fim");
				
// //				((ListDoubleLinked) l).removeAll();
// 				mostraLista(l);   ****/
				
// /**********
//  * Testando Serializable
//  */	
// 		System.out.println("\n\nTestando Serializable\n");
// 		l.add(0, s1);
// 		l.add(1, s5);
// 		l.add(1, s3);
// 		l.add(2, s4);
// 		l.add(1, s2);
// 		mostraLista(l);
		
// 		try {
// 			saida = new FileOutputStream("teste_java.dat");
// 			oSaida = new ObjectOutputStream(saida);
			
// 			oSaida.writeObject(l);
// 			oSaida.close();
			
// 			l = null;
// 		} catch(Exception e) {
// 			System.out.println("\n\nErro: " + e.getMessage());
// 		}
		
// 		try {
// 			entrada = new FileInputStream("teste_java.dat");
// 			oEntrada = new ObjectInputStream(entrada);
			
// 			l = (ListDoubleLinked<String>) oEntrada.readObject();
// 			oSaida.close();
			
// 			System.out.println("Mostrando lista após lida:");
// 			mostraLista(l);
// 		} catch(Exception e) {
// 			System.out.println("\n\nErro: " + e.getMessage());
// 		}
		
// 		ListSimpleLinkedFull<String> m = new ListSimpleLinkedFull<String>();
		
// 		m.add("1");
// 		m.add("2");
// 		m.add("3");
// 		m.add("2");
// 		m.add("1");
		
// 		System.out.println("Mostrando lista inicial:");
// 		mostraLista(m);
		
// 		m.removeAll("2");
		
// 		System.out.println("Mostrando lista apos removeAll\"(\"2\")");
// 		mostraLista(m);
				
// 		m.removeAll("1");
		
// 		System.out.println("Mostrando lista apos removeAll\"(\"1\")");
// 		mostraLista(m);
		
// 		String[] ar = {"10", "20", "30", "40", "50"};
// 		System.out.println("Deve ser false: "+ m.addAll(new String[0]));
// 		mostraLista(m);
		
// 		System.out.println("Deve ser false: "+ m.addAll(null));
// 		mostraLista(m);
			
// 		System.out.println("Deve ser true: "+ m.addAll(ar));
// 		mostraLista(m);
// 	}

// }

