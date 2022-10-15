package Trabalho01.util;

public class ListSimpleLinked<T> implements ListTAD<T> {

	private class Node {

		private Node refNext;
		private T item;

		public Node() {
			refNext = null;
			item = null;
		}

		public Node(T elem, Node n) {
			this.item = elem;
			refNext = n;
		}

		public void setNext(Node no) {
			refNext = no;
		}

		public Node getNext() {
			return refNext;
		}

		public void setElem(T o) {
			item = o;
		}

		public T getElem() {
			return item;
		}
	}

	private Node refHead = null;
	private Node refTail = null;
	private int qtdElem = 0;

	public void add(T element) {
		Node novo = new Node(element, null);

		if (refHead == null)
			refHead = refTail = novo;
		else {
			refTail.setNext(novo);
			refTail = novo;
		}

		qtdElem++;
	}

	public void addFirst(T d) {
		Node novo = new Node(d, refHead);

		if (refHead == null)
			refTail = novo;

		refHead = novo;

		qtdElem++;
	}

	public void addLast(T d) {
		Node novo = new Node(d, null);

		if (refTail == null)
			refHead = refTail = novo;
		else {
			refTail.setNext(novo);
			refTail = novo;
		}

		qtdElem++;
	}

	public void addLastAlt(T d) {
		Node novo = new Node(d, null);
		Node aux;
		int i;

		if (refHead != null) {
			aux = refHead;
			for (i = 1; i < qtdElem; i++)
				aux = aux.getNext();
			aux.setNext(novo);
			refTail = novo;
		} else
			refHead = refTail = novo;

		qtdElem++;
	}

	public void add(int index, T element) {
		Node ant;
		Node novo;
		Node prox = null;
		int i;

		if ((index >= 0) && (index <= qtdElem)) {
			novo = new Node();
			novo.setElem(element);

			if (index == 0) {
				novo.setNext(refHead);
				if (refTail == null)
					refTail = novo;
				refHead = novo;
			} else {
				ant = refHead;
				for (i = 1; i < index; i++)
					ant = ant.getNext();
				if (index == qtdElem)
					refTail = novo;
				prox = ant.getNext();
				ant.setNext(novo);
				novo.setNext(prox);
			}

			qtdElem++;
		} else
			throw new IllegalArgumentException("Índice inválido -> " + index);
	}

	public T removeFirst() {
		T auxD = null;

		if (refHead != null) {
			auxD = refHead.getElem();

			refHead = refHead.getNext();
			if (refHead == null)
				refTail = null;

			qtdElem--;
		}

		return auxD;
	}

	public T removeLast() {
		T auxD = null;
		Node aux;

		if (refHead != null) {
			if (refHead.getNext() == null) {
				auxD = refHead.getElem();
				refHead = null;
				refTail = null;
			} else {
				aux = refHead;
				while (aux.getNext().getNext() != null)
					aux = aux.getNext();
				auxD = aux.getNext().getElem();
				aux.setNext(null);
				refTail = aux;
			}

			qtdElem--;
		}

		return auxD;
	}

	public T remove(int index) {
		Node aux;
		Node ant;
		Node prox;
		T auxD = null;
		int i;

		if ((index >= 0) && (index < qtdElem)) {
			if (index == 0) {
				auxD = refHead.getElem();
				refHead = refHead.getNext();

				if (refHead == null)
					refTail = null;
			} else {
				ant = aux = refHead;
				for (i = 1; i <= index; i++) {
					ant = aux;
					aux = aux.getNext();
				}

				auxD = aux.getElem();
				prox = aux.getNext();

				ant.setNext(prox);

				if (aux == refTail)
					refTail = ant;
			}

			qtdElem--;
		} else
			throw (new IndexOutOfBoundsException());

		return auxD;
	}

	public T remove(T element) {
		T res = null;
		Node aux;
		Node ant;

		ant = aux = refHead;
		while (aux != null && !aux.getElem().equals(element)) {
			ant = aux;
			aux = aux.getNext();
		}

		if (aux != null) {
			res = aux.getElem();
			qtdElem--;

			if (qtdElem == 0)
				refHead = refTail = null;
			else {
				if (aux == refHead)
					refHead = refHead.getNext();
				else
					ant.setNext(aux.getNext());

				if (aux == refTail)
					refTail = ant;
			}
		}

		return res;
	}

	public int removeAll(T dado) {
		int res = 0;
		Node aux, ant;

		if (refHead != null) {
			aux = ant = refHead;
			while (aux != null) {
				if (aux.getElem().equals(dado)) {
					if (refHead == aux) {
						refHead = aux.getNext();
						aux = ant = refHead;
					} else
						ant.setNext(aux.getNext());
					if (refTail == aux)
						refTail = ant;

					res++;
					qtdElem--;
				} else
					ant = aux;

				aux = aux.getNext();
			}
		}

		return res;
	}

	public boolean addAll(T[] ar) {
		boolean res = true;

		if (ar == null || ar.length == 0)
			res = false;
		else
			for (T x : ar)
				add(x);

		return res;
	}

	public T getFirst() {
		T res = null;

		if (refHead != null)
			res = refHead.getElem();

		return res;
	}

	public T getLast() {
		T res = null;

		if (refTail != null)
			res = refTail.getElem();

		return res;
	}

	public T get(int pos) {
		T res = null;
		Node aux;
		int i;

		if ((pos >= 0) && (pos < qtdElem)) {
			if (refHead != null) {
				aux = refHead;
				for (i = 1; i <= pos; i++)
					aux = aux.getNext();

				res = aux.getElem();
			}
		} else
			throw (new IndexOutOfBoundsException());

		return res;
	}

	public void set(int index, T element) {
		Node aux = refHead;

		for (int i = 0; aux != null && i < index; i++)
			aux = aux.getNext();

		if (aux != null)
			aux.setElem(element);
		else
			throw new IndexOutOfBoundsException("Nodo inválido!");
	}

	public int size() {
		return qtdElem;
	}

	public boolean isEmpty() {
		return refHead == null;
	}

	public int count(T dado) {
		int cont = 0;
		Node aux = refHead;

		while (aux != null) {
			if (dado.equals(aux.getElem()))
				cont++;
			aux = aux.getNext();
		}

		return cont;
	}

	public void clean() {
		refHead = refTail = null;
		qtdElem = 0;
	}

	public void reverse() {
		Node novaLista = null;
		Node aux;

		while (!this.isEmpty()) {
			aux = refHead;
			refHead = refHead.getNext();
			aux.setNext(novaLista);
			novaLista = aux;
		}

		refHead = novaLista;
	}

	public int updateAll(T dado, T novoDado) {
		int cont = 0;
		Node aux = refHead;

		while (aux != null) {
			if (dado.equals(aux.getElem())) {
				aux.setElem(novoDado);
				cont++;
			}
			aux = aux.getNext();
		}

		return cont;
	}

	public String toString() {
		Node aux = refHead;
		String res = "| ";

		while (aux != null) {
			res = res + aux.getElem().toString() + " | ";
			aux = aux.getNext();
		}

		return res;
	}
}