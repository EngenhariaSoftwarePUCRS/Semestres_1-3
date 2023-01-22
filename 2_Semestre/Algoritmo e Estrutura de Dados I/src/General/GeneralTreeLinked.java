package br.pucrs.adt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GeneralTreeLinked<E extends Comparable<E>> implements GeneralTreeTAD<E>
{
	private Node refRoot;

	private final class Node implements Comparable<Node> {
		private Node father;
		private E item;
		private List<Node> subtrees;

		public Node(E element) {
			father = null;
			item = element;
			subtrees = new LinkedList<Node>();
		}

		public Node getFather() {
			return father;
		}
		public void setFather(Node n) {
			father = n;
		}
		public E getItem() {
			return item;
		}
		public void setItem(E element) {
			item = element;
		}
		public void addSubtree(Node n) {
			n.setFather(this);
			subtrees.add(n);
		}
		public boolean removeSubtree(Node n) {
			n.setFather(null);
			return subtrees.remove(n);
		}
		public Node getSubtree(int i) {
			if((i<0) || (i>=subtrees.size()))
				throw new IndexOutOfBoundsException();
			return subtrees.get(i);
		}
		public int countSubtrees() {
			return subtrees.size();
		}
		public int compareTo(Node o) {
			return this.getItem().compareTo(o.getItem());
		}
	}

	
	public GeneralTreeLinked()
	{
		refRoot = null;
	}

	public boolean add(E element, E father) {
		Node n = new Node(element);
		Node nAux = null;
		boolean res = false;
		//Verifica se está inserindo na raiz
		if (father == null) {
			//Atualiza o pai da raiz
			if (refRoot != null) {
				n.addSubtree(refRoot);
				refRoot.setFather(n);
			}
			//Atualiza a raiz
			refRoot = n;
			res = true;
		}
		//Insere no meio da árvore
		else {
			nAux = searchNodeRef(father, refRoot);
			if (nAux != null) {
				nAux.addSubtree(n);
				res = true;
			}
		}
		return res;
	}

	public boolean contains(E element)
	{
		Node nAux = searchNodeRef(element, refRoot);
		return (nAux != null);
	}
	private Node searchNodeRef(E element, Node target)
	{
		Node res = null;
		if (target != null) {
			if(target.getItem().equals(element)) {
				res = target;
			}
			else {
				Node aux = null;
				int i = 0;
				while((aux == null) && (i < target.countSubtrees())) {
					aux = searchNodeRef(element, target.getSubtree(i));
					i++;
				}
				res = aux;
			}
		}
		return res;
	}

	public E get(E element, int i) {
		E res = null;
		Node nAux = searchNodeRef(element, refRoot);
		if(nAux != null) {
			res = nAux.getSubtree(i).getItem();
		}
		return res;		
	}

	public E getFather(E element) {
		E res = null;
		Node nAux = searchNodeRef(element, refRoot);
		if(nAux != null) {
			if(nAux.getFather()!=null) {
				res = nAux.getFather().getItem();
			}
		}
		return res;
	}

	public E getRoot() {
		if(isEmpty())
			throw new EmptyTreeException();
		return refRoot.getItem();
	}

	public boolean isEmpty() {
		return (refRoot == null);
	}

	public boolean removeBranch(E element) {
		Node nAux = null;
		Node father = null;
		boolean rem = false;
		if (refRoot != null) {
			if (refRoot.getItem().equals(element)) {
				refRoot = null;
				rem = true;
			}
			else {
				nAux = searchNodeRef(element, refRoot);
				if (nAux != null) {
					father = nAux.getFather();
					father.removeSubtree(nAux);
					rem = true;
				}
			}
		}
		return rem;
	}

	public boolean remove(E element) {
		Node nAux = null;
		Node father = null;
		boolean rem = false;
		if (refRoot != null) {
			if (refRoot.getItem().equals(element)) {
				refRoot = null;
				rem = true;
			}
			else {
				nAux = searchNodeRef(element, refRoot);
				if (nAux != null) {
					father = nAux.getFather();
					father.removeSubtree(nAux);
					rem = true;
				}
			}
		}
		return rem;
	}
	
	public E set(E old, E element) {
		E res = null;
		Node nAux = searchNodeRef(old, refRoot);
		if (nAux != null) {
			res = old;
			nAux.setItem(element);
		}
		return res;
	}

	public void setRoot(E element) {
		if(isEmpty())
			throw new EmptyTreeException();
		refRoot.setItem(element);
	}

	public int count() {
		return count(refRoot);
	}
	private int count(Node target)
	{
		if (target == null) {
			return 0;
		}
		int total = 1;
		for(int i=0; i<target.countSubtrees(); i++)
			total += count(target.getSubtree(i));
		return total;
	}

	public List<E> traversalPos()
	{
		List<E> res = new ArrayList<E>();
		traversalPos(refRoot, res);
		return res;
	}
	private void traversalPos(Node n, List<E> res)
	{
		if (n != null) {
			for(int i=0; i<n.countSubtrees(); i++) {
				traversalPos(n.getSubtree(i), res);
			}
			res.add(n.getItem());
		}
	}

	public List<E> traversalPre()
	{
		List<E> res = new ArrayList<E>();
		traversalPre(refRoot, res);
		return res;
	}
	private void traversalPre(Node n, List<E> res)
	{
		if (n != null) {
			res.add(n.getItem());
			for(int i=0; i<n.countSubtrees(); i++) {
				traversalPre(n.getSubtree(i), res);
			}
		}
	}

	public List<E> traversalWidth() {
		QueueTAD<Node> fila = new Queue<Node>();
		Node atual = null;
		List<E> res = new ArrayList<E>();
		if (refRoot != null) {
			fila.enqueue(refRoot);
			while (!fila.isEmpty()) {
				atual = fila.dequeue();
				res.add(atual.getItem());
				for(int i=0; i<atual.countSubtrees(); i++) {
					fila.enqueue(atual.getSubtree(i));
				}
			}
		}
		return res;
	}    

	//***********************************************************
	//* Exercicios sobre estruturas em �rvores. N�o fazem parte 
	//* da interface padr�o. N�o entregar antes de passar o 
	//* exerc�cio.
	//***********************************************************

	public boolean hasRepeat(E el) { 
		int cont = 0;
		boolean res;
		if  (hasRepeat(el, refRoot, cont) <= 1)
			res = false;
		else
			res = true;

		return res;
	}

	private int hasRepeat(E el, Node n, int cont) {
		if (n != null) {
			if (el.equals(n.getItem()))
				cont ++;
			if (cont <= 1){
				for (int i = 0; ((i < n.countSubtrees()) && (cont <=1)); i++)
					cont += hasRepeat(el, n.getSubtree(i), cont);
			}
		}
		return cont;
	}


	public List<E> getInternalElelments() {
		return getInternalElements(refRoot, new ArrayList<E>());
	}

	private List<E> getInternalElements(Node n, List<E> lst) {
		List<E> auxL;

		if (n != null) {
			if ((n != refRoot) && (n.countSubtrees() > 0))
				lst.add(n.getItem());

			for (int i = 0; i < n.countSubtrees(); i++)
				lst = getInternalElements(n.getSubtree(i), lst);
		}

		return lst;
	}

	public int getPathSize(E element) {
		int res = -1;

		Node aux = getNodetoPathSize(element, refRoot);

		if (aux != null)
			while (aux != null) {
				aux = aux.getFather();
				res++;
			}

		return res;
	}

	private Node getNodetoPathSize(E element, Node n){
		Node res = null;

		if (n != null)
			if (element.equals(n.getItem()))
				res = n;
			else for (int i = 0; i < n.countSubtrees(); i++) {
				res = getNodetoPathSize(element, n.getSubtree(i));
				if (res != null)
					break;
			}

		return res;
	}

	public int countBiggerThan(E elem) {
		return countBiggerThan(elem, refRoot);
	}
	private int countBiggerThan(E elem, Node target)
	{
		if (target == null) {
			return 0;
		}
		int total = 0;

		if (target.getItem().compareTo(elem) > 0)
			total = 1;

		for(int i=0; i<target.countSubtrees(); i++)
			total += countBiggerThan(elem, target.getSubtree(i));
		return total;
	}

	public String toString() {
		StringBuilder str = new StringBuilder("");
		String res;
		int level = 0;

		if (refRoot == null)
			res = null;
		else {
//			toStringFunc(refRoot, str, level);
			toStringFunc(refRoot, str);
			res = str.toString();
		}
		return res;
	}

//	private void toStringFunc(Node<E> n, StringBuilder str, int level) {
//		String tabs;
//		
//		if (n != null){
//			str.append("tree(");
//			str.append(n.getItem());
//
//			level++;
//			for (int i = 0; i < n.subtrees.size(); i++){
//				str.append(",");
//				if (i == 0) {
//					str.append("\n");
//					tabs = tabFill(level);
////					str.append("\n");
//					str.append(tabs);
//				}
//				toStringFunc(n.subtrees.get(i), str, level);
//			}
//			
//			level--;
//			str.append(")");
////			str.append(",");
//			tabs = tabFill(level);
////			str.append("\n");
////			str.append(tabs);
//
//		}
//	}
	
	private void toStringFunc(Node n, StringBuilder str) {
		if (n != null){
			str.append(n.getItem());

			for (int i = 0; i < n.subtrees.size(); i++){
				str.append(",");
				toStringFunc(n.subtrees.get(i), str);
			}
		}
	}
	
	
	String tabFill(int level) {
		String res = "";
		
		for (int i = 0; i <= level; i++)
			res += "   ";
		
		return res;
	}
}
