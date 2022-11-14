package Semana14;

import java.util.Iterator;
import java.util.List;

public class BinaryTree<E extends Comparable<E>> extends GeneralTreeLinked<E> implements BinaryTreeTAD<E> {

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

    public BinaryTree() {
        refRoot = null;
    }

    public BinaryTree(E element) {
        refRoot = new Node(element);
    }

    @Override
    public boolean add(E element, E father, NodePosition position) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public E getLeft(E element) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E getRight(E element) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int countLeaves() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int countBranches() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int height() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int level(E element) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isRoot(E element) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isLeave(E element) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isBranch(E element) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<E> iterator(IteratorTreeType t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<E> traversalCentral() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
