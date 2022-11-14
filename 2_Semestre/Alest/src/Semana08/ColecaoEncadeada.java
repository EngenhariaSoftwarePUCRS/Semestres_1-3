package Semana08;


public class ColecaoEncadeada {
	private class Node {

		private Node refNext;
		private String item;
		
		public Node() {
			this(null, null);
		}

		public Node(String elem) {
			this(elem, null);
		}
		
		public Node(String elem, Node n) {
			this.item = elem;
			refNext = n;
		}

		public void setNext(Node no) {
			refNext = no;
		}
		
		public Node getNext() {
			return refNext;
		}
		
		public void setElem(String o) {
			item = o;
		}
		
		public String getElem() {
			return item;
		}
	}
	
	private Node refHead = null;
//	    private Node refTail = null;
	private int qtdElem = 0;
	
	public int size() {
		return qtdElem;
	}
	
	public void addFirst(String d) {
		Node novo = new Node(d);	
		//if (refHead == null)
		//	refTail = novo;
		novo.setNext(refHead);
		refHead = novo;			
		qtdElem++;
	}

	public String get(int pos){
		String res = null;
		Node aux;
		int i;
		
		if ((pos >= 0) && (pos < qtdElem)) {
			if(refHead != null) {
				aux = refHead;
				for(i = 1 ; i <= pos; i++)
					aux = aux.getNext();
			
				res = aux.getElem();
				}
			}
		else 
			throw(new IndexOutOfBoundsException());
		
		return res;
	}

	public void set(int index, String element) {
		Node aux = refHead;
		
		for (int i = 0; aux != null && i < index; i++)
			aux = aux.getNext();
		
		if (aux != null)
			aux.setElem(element);
		else
			throw new IllegalArgumentException();
	}
	
	public String toString() {
		String s = "";
		
		for(int i = 0; i < qtdElem; i++)
			s = s + get(i) + " ";
		
		return s;
	}
	
	public void addLast(String d) {
		Node novo = new Node(d);
		Node aux, ant;
		
		if (refHead == null)
			refHead = novo;
		else {
			ant = aux = refHead;
			
			while(aux != null) {
				ant = aux;
				aux = aux.getNext();
			}
			
			ant.setNext(novo);
		}
		
		qtdElem++;
	}
	

	public void addLastAlt(String d) {
		Node novo = new Node(d);
		Node aux;
		int cont;
		
		if (refHead == null)
			refHead = novo;
		else {
			aux = refHead;
			
			for (int i = 1; i < qtdElem; i++)
				aux = aux.getNext();
			
			aux.setNext(novo);
		}
		
		qtdElem++;
	}

	public void add(int index, String element) {
		Node ant, novo, prox = null;
		int i;
	
		if ((index >= 0) && (index <= qtdElem)) {
			novo = new Node();
			novo.setElem(element);
	
			if (index == 0) {
				novo.setNext(refHead);
				refHead = novo;
			} else {
				ant = refHead;
				for (i = 1; i < index; i++)
					ant = ant.getNext();

				prox = ant.getNext();
				ant.setNext(novo);
				novo.setNext(prox);
			}
		
			qtdElem++;
		}
		else
			throw(new IndexOutOfBoundsException());
	}

	public String removeFirst() {
		String auxD = null;
		
		if (refHead != null) {
			auxD = refHead.getElem();
			refHead = refHead.getNext();
			qtdElem--;
		}
		
		return auxD;
	}

	public String removeLast() {
		String auxD = null;
		Node aux;
	
		if (refHead != null) {
			if (refHead.getNext() == null) {
				auxD = refHead.getElem();
				refHead = null;    
			} else {
				aux = refHead;
				while(aux.getNext().getNext() != null) 
					aux = aux.getNext();
			
				auxD = aux.getNext().getElem();
				aux.setNext(null);
			}
			qtdElem--;
		}

		return auxD;
	}

	public String remove(int index) {
		Node aux, ant, prox;
		String auxD = null;
		int i;
		
		if ((index >=0) && (index < qtdElem)) {
			if (index == 0)	{
				auxD = refHead.getElem();
				refHead = refHead.getNext();
			} else {
				ant = aux = refHead;
				for (i = 1; i <= index; i++) {
					ant = aux;
					aux = aux.getNext();
				}
	
				auxD = aux.getElem();
				prox = aux.getNext();
				
				ant.setNext(prox);
			}
			
			qtdElem --;
		}    	
		else
			throw(new IndexOutOfBoundsException());
		
		return auxD;
	}
//
//		public String remove(String element) {
//			String res = null;
//			Node aux, ant; 
//			
//			ant = aux = refHead;
//			while(aux != null && !aux.getElem().equals(element)) {
//				ant = aux;
//				aux = aux.getNext();
//			}
//			
//			if (aux != null) {
//				res = aux.getElem();
//				qtdElem--;
//				
//				if (qtdElem == 0)
//					refHead = refTail = null;
//				else {
//					  if (aux == refHead) 
//						  refHead = refHead.getNext();
//					  else
//						  ant.setNext(aux.getNext());
//					
//					  if (aux == refTail)
//						  refTail = ant;
//				}
//			}
//			
//			return res;
//		}
//		
//
//		public String getFirst() {
//			String res = null;
//			
//			if (refHead != null)
//				res = refHead.getElem();
//			
//			return res;
//		}
//
//		public String getLast() {
//			String res = null;
//			
//			if (refTail != null)
//				res = refTail.getElem();
//			
//			return res;
//		}
}
