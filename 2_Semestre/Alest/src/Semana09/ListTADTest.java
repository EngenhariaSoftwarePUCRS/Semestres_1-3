import org.junit.*;
import static org.junit.Assert.*;

public class ListTADTest {

	private ListTAD<String> myList = new ListSimpleLinkedFull<String>();
	//private ListTAD<String> myList = new ListDoubleLinked<String>();
	//private ListArray<String> myList = new ListArray<String>(10);
	
	@Before
	public void limpaLst() {
		myList.clean();
		assertEquals("Deve estar vazia: ", true, myList.isEmpty());
		assertEquals("Deve ter 0 elementos: ", 0, myList.size());
	}
	
	@Test
	public final void testSize() {
		assertEquals("Deve ter 0 elementos: ", 0, myList.size());
		
		myList.add("0");
		assertEquals("Size 1 = ", 1, myList.size());
		
		myList.add("2");
		assertEquals("Size 2 = ", 2, myList.size());
		
		myList.clean();
		assertEquals("Size 0 = ", 0, myList.size());
	}

	@Test
	public final void testAddD() {
		myList.add("0");
		assertEquals("Primeiro Elem:", "0", myList.getFirst());
		assertEquals("Ultimo Elem:", "0", myList.getLast());
		
		myList.add("1");
		myList.add("2");
		myList.add("3");
		myList.add("4");
		assertEquals("0 1 2 3 4 ", myList.toString());
		assertEquals("Ultimo Elem:", "4", myList.getLast());
	}

	@Test
	public final void testCount() {
		assertEquals("Lista Vazia ", 0, myList.count("X"));

		myList.add("X");
		assertEquals("Um elem-Prim Pos ", 1, myList.count("X"));

		myList.add("2");
		myList.add("3");
		myList.add("X");
		myList.add("5");
		myList.add("6");
		myList.add("7");
		myList.add("X");
		myList.add("X");
		assertEquals("Nove na lista ", 4, myList.count("X"));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public final void testGetExc1(){
		myList.get(0);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public final void testGetExc2(){
		myList.add("0");
		myList.get(1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public final void testGetExc3(){
		myList.get(-1);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public final void testGet() {
		myList.add("0");
		assertEquals("Pega 0 ", "0", myList.get(0));

		myList.add("1");
		myList.add("2");
		myList.add("3");
		myList.add("4");
		myList.add("5");
		myList.add("6");
		myList.add("7");
		myList.add("8");
		assertEquals("Pega 1 ", "1", myList.get(1));
		assertEquals("Pega 2 ", "2", myList.get(2));
		assertEquals("Pega 3 ", "3", myList.get(3));
		assertEquals("Pega 4 ", "4", myList.get(4));
		assertEquals("Pega 5 ", "5", myList.get(5));
		assertEquals("Pega 6 ", "6", myList.get(6));
		assertEquals("Pega 7 ", "7", myList.get(7));
		assertEquals("Pega 8 ", "8", myList.get(8));
		myList.get(9);	
	}	

	@Test
	public final void testGetFirst() {
		assertEquals("Vazia:", null, myList.getFirst());
		
		myList.add("0");
		assertEquals("Vazia:", "0", myList.getFirst());

		myList.add("1");
		myList.add("2");
		myList.add("3");
		assertEquals("Vazia:", "0", myList.getFirst());
	}

	@Test
	public final void testGetLast() {
		assertEquals("Vazia:", null, myList.getLast());
		
		myList.add("0");
		assertEquals("Vazia:", "0", myList.getLast());

		myList.add("1");
		myList.add("2");
		myList.add("3");
		assertEquals("Vazia:", "3", myList.getLast());

	}

	@Test
	public final void testAddFirst() {
		myList.addFirst("0");
		assertEquals("Primeiro Elem:", "0", myList.getFirst());
		assertEquals("Ultimo Elem:", "0", myList.getLast());
		assertEquals("Qtde 1:", 1, myList.size());
		
		myList.addFirst("1");
		assertEquals("Primeiro Elem:", "1", myList.getFirst());
		assertEquals("Ultimo Elem:", "0", myList.getLast());
		assertEquals("Qtde 2:", 2, myList.size());
	}

	@Test
	public final void testAddLast() {
		myList.addLast("0");
		assertEquals("Primeiro Elem:", "0", myList.getFirst());
		assertEquals("Ultimo Elem:", "0", myList.getLast());
		assertEquals("Qtde 1:", 1, myList.size());
		
		myList.addLast("1");
		assertEquals("Primeiro Elem:", "0", myList.getFirst());
		assertEquals("Ultimo Elem:", "1", myList.getLast());

		assertEquals("Qtde 2:", 2, myList.size());
	}
	
	@Test
	public final void testAddLastAlt() {
		myList.addLast("0");
		assertEquals("Primeiro Elem:", "0", myList.getFirst());
		assertEquals("Ultimo Elem:", "0", myList.getLast());
		assertEquals("Qtde 1:", 1, myList.size());
		
		myList.addLast("1");
		assertEquals("Primeiro Elem:", "0", myList.getFirst());
		assertEquals("Ultimo Elem:", "1", myList.getLast());

		assertEquals("Qtde 2:", 2, myList.size());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public final void testAddIntD0() {
		myList.add(1, "1");
	}

	@Test
	public final void testAddIntD1() {
		assertEquals("Lista deve estar vazia", true, myList.isEmpty());
		assertEquals("Deve ter 0 elementos: ", 0, myList.size());

		myList.add(0, "1");
		assertEquals("Deve ter 1 elementos: ", 1, myList.size());
		assertEquals("Primeiro Elem:", "1", myList.getFirst());
		assertEquals("Ultimo Elem:", "1", myList.getLast());


		myList.add(1, "2");
		assertEquals("Deve ter 2 elementos: ", 2, myList.size());
		assertEquals("Primeiro Elem:", "1", myList.getFirst());
		assertEquals("Ultimo Elem:", "2", myList.getLast());

		
		myList.add(2, "4");
		assertEquals("Deve ter 3 elementos: ", 3, myList.size());
		
		myList.add(3, "5");
		assertEquals("Deve ter 4 elementos: ", 4, myList.size());
		
		myList.add(2, "3");
		assertEquals("Deve ter 5 elementos: ", 5, myList.size());
		assertEquals("pega 2", "3", myList.get(2));
		
		myList.add(0,"0");
		assertEquals("pega 0", "0", myList.get(0));
		assertEquals("Deve ter 6 elementos: ", 6, myList.size());
		
		for (int i = 0; i < myList.size(); i++)
			assertEquals("Laï¿½o: Pega" + i, String.valueOf(i),myList.get(i));
		
		assertEquals("Primeiro Elem:", "0", myList.getFirst());
		assertEquals("Ultimo Elem:", "5", myList.getLast());

	}

	@Test(expected=IndexOutOfBoundsException.class)
	public final void testRemoveInt1() {
		myList.remove(0);
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public final void testRemoveInt2() {
		myList.remove(-1);
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public final void testRemoveInt3() {
		myList.addFirst("0");
		myList.remove(1);
	}

	@Test
	public final void testRemoveInt4() {
		String res;
		
		myList.addFirst("0");
		res = myList.remove(0);
		assertEquals("Fica vazia:", true, myList.isEmpty());
		assertEquals("0 elementos:", 0, myList.size());
		assertEquals("Retorno: ", "0", res);
		assertEquals("Retorno getLast: ", null, myList.getLast());
		
		myList.addLast("0");
		myList.addLast("1");
		myList.addLast("2");
		myList.addLast("3");
		myList.addLast("4");
		myList.addLast("5");
		myList.addLast("6");
		
		res = myList.remove(0);
		assertEquals("Nï¿½o fica vazia:", false, myList.isEmpty());
		assertEquals("6 elementos:", 6, myList.size());
		assertEquals("Retorno: ", "0", res);
		
		res = myList.remove(5);
		assertEquals("Nï¿½o fica vazia:", false, myList.isEmpty());
		assertEquals("5 elementos:", 5, myList.size());
		assertEquals("Retorno: ", "6", res);
		assertEquals("Retorno getLast: ", "5", myList.getLast());

		for (int i = 0; i < myList.size(); i++)
			assertEquals("Valor " + i, String.valueOf(i+1), myList.get(i));
		
		res = myList.remove(3);
		assertEquals("Nï¿½o fica vazia:", false, myList.isEmpty());
		assertEquals("4 elementos:", 4, myList.size());
		assertEquals("Elemento 2 ï¿½ 3", "3", myList.get(2));
		assertEquals("Elemento 3 ï¿½ 5", "5", myList.get(3));
		assertEquals("Retorno: ", "4", res);

	}
	
	@Test
	public final void testRemoveFirst() {
		String res;
		
		res = myList.removeFirst();
		assertEquals("Retorno: ", null, res);
		
		myList.addFirst("0");
		res = myList.removeFirst();
		assertEquals("Fica vazia:", true, myList.isEmpty());
		assertEquals("0 elementos:", 0, myList.size());
		assertEquals("Retorno: ", "0", res);
		assertEquals("Retorno getLast: ", null, myList.getLast());

		
		myList.addFirst("1");
		myList.addFirst("0");
		res = myList.removeFirst();
		assertEquals("Nï¿½o fica vazia:", false, myList.isEmpty());
		assertEquals("1 elementos:", 1, myList.size());
		assertEquals("Retorno: ", "0", res);
		assertEquals("Retorno getLast: ", "1", myList.getLast());
	}

	@Test
	public final void testRemoveLast() {
		String res;
		
		res = myList.removeLast();
		assertEquals("Retorno: ", null, res);
		
		myList.addFirst("0");
		res = myList.removeLast();
		assertEquals("Fica vazia:", true, myList.isEmpty());
		assertEquals("0 elementos:", 0, myList.size());
		assertEquals("Retorno: ", "0", res);
		assertEquals("Retorno getLast: ", null, myList.getLast());

		
		myList.addFirst("1");
		myList.addFirst("0");
		res = myList.removeLast();
		assertEquals("Nï¿½o fica vazia:", false, myList.isEmpty());
		assertEquals("1 elementos:", 1, myList.size());
		assertEquals("Retorno: ", "1", res);
		assertEquals("Retorno getLast: ", "0", myList.getLast());
	}

	@Test
	public final void testRemoveD() {
		String res;
		String x = new String("X");
		String x1 = new String("X");
		String x2 = new String("X");
		
		res = myList.remove("X");
		assertEquals("Retorno: ", null, res);

		myList.addFirst("0");
		res = myList.remove("X");
		assertEquals("Nï¿½o fica vazia:", false, myList.isEmpty());
		assertEquals("1 elementos:", 1, myList.size());
		assertEquals("Retorno: ", null, res);
		assertEquals("Retorno getLast: ", "0", myList.getLast());
		
		myList.clean();
		
		myList.addFirst(x);
		res = myList.remove("X");
		assertEquals("Fica vazia:", true, myList.isEmpty());
		assertEquals("0 elementos:", 0, myList.size());
		assertSame("Retorno: ", x, res);
		assertEquals("Retorno getLast: ", null, myList.getLast());
		
		myList.addFirst("0");
		myList.addFirst(x);
		res = myList.remove("X");
		assertEquals("Nï¿½o fica vazia:", false, myList.isEmpty());
		assertEquals("1 elementos:", 1, myList.size());
		assertSame("Retorno: ", x, res);
		assertEquals("Retorno getLast: ", "0", myList.getLast());
		
		myList.addLast("1");
		myList.addLast(x1);
		myList.addLast("3");
		myList.addLast(x2);
		res = myList.remove("X");
		assertEquals("Nï¿½o fica vazia:", false, myList.isEmpty());
		assertEquals("4 elementos:", 4, myList.size());
		assertSame("Retorno: ", x1, res);
		assertSame("Retorno getLast: ", x2, myList.getLast());
		
		res = myList.remove("X");
		assertEquals("Nï¿½o fica vazia:", false, myList.isEmpty());
		assertEquals("3 elementos:", 3, myList.size());
		assertSame("Retorno: ", x2, res);
		assertEquals("ï¿½ltimo: ", "3", myList.getLast());
	}

	@Test
	public final void testIsEmpty() {
		assertEquals("Deve estar vazia: ", true, myList.isEmpty());
		myList.add("0");
		assertEquals("Nï¿½o deve estar vazia: ", false, myList.isEmpty());
		myList.remove(0);
		assertEquals("Deve estar vazia: ", true, myList.isEmpty());
	}


}
