package Semana14;

import java.util.Iterator;
import java.util.List;


/**
 * Interface que descreve o TAD Árvore Binária.
 * @author Michael Mora, JÁlio Machado, Isabel Manssour
 */

public interface BinaryTreeTAD<E extends Comparable<E>> {

	/**
	 * Adiciona um novo nodo na Árvore.
	 * @param element Novo nodo a ser inserido.	
	 * @param father  Nodo após o qual será inserido o novo nodo, se null entÁo insere na raiz.
	 * @param position NodePosition.LEFT para filho da esquerda ou NodePosition.RIGHT para filho da direita.
	 * @return true se o elemento foi inserido
	 */
	boolean add(E element, E father, NodePosition position);

	/**
	 * Remove o nodo da Árvore, juntamente com todos os seus filhos.
	 * @param element Referência para o dado a ser removido.
	 * @return true se a Árvore contÁm o elemento especificado.
	 */
	boolean removeBranch(E element);

	/**
	 * Substitui a primeira ocorrência do elemento indicado por um novo elemento
	 * @param old elemento a ser substituÁdo
	 * @param element novo elemento
	 * @return elemento que foi substituÁdo ou null se o elemento nÁo estÁ na Árvore
	 */
	E set(E old, E element);

	/**
	 * Recupera o dado armazenado na raiz da Árvore.
	 * @return dado armazenado na raiz da Árvore. 
	 * @throws EmptyTreeException se a Árvore estÁ vazia.
	 */
	E getRoot();

	/**
	 * Altera o dado armazenado na raiz da Árvore
	 * @param element dado a ser armazenado na raiz da Árvore
	 * @throws EmptyTreeException se a Árvore estÁ vazia.
	 */
	void setRoot(E element);

	/**
	 * Recupera o dado armazenado no filho da esquerda do nodo da Árvore
	 * @param element Referência para o nodo a ser buscado.
	 * @return dado armazenado na esquerda do nodo informado. 
	 */
	E getLeft(E element);

	/**
	 * Recupera o dado armazenado no filho da direita do nodo da Árvore
	 * @param element Referência para o nodo a ser buscado.
	 * @return dado armazenado na direita do nodo informado. 
	 */
	E getRight(E element);

	/**
	 * Recupera o dado armazenado no pai do nodo da Árvore
	 * @param element Referência para o nodo a ser buscado.
	 * @return dado armazenado no pai do nodo informado. 
	 */
	E getFather(E element);

	/**
	 * Retorna true se a Árvore contÁm o elemento especificado
	 * @param element o elemento a ser buscado
	 * @return true se a Árvore contÁm o elemento especificado
	 */
	boolean contains(E element);

	/**
	 * Recupera a quantidade de nodos da Árvore.
	 * @return nÁmero de nodos. 
	 */
	int size();

	/**
	 * Recupera a quantidade de nodos da Árvore atravÁs de cÁlculo recursivo.
	 * @return nÁmero de nodos. 
	 */	
	int count();
	
	/**
	 * Recupera a quantidade de nodos folha da Árvore, atravÁs de cÁlculo recursivo.
	 * @return nÁmero de nodos. 
	 */	
	int countLeaves();

	/**
	 * Recupera a quantidade de nodos nÁo-folha da Árvore atravÁs de cÁlculo recursivo.
	 * @return nÁmero de nodos. 
	 */	
	int countBranches();

	/**
	 * Retorna a altura da Árvore.
	 * @return altura. 
	 */	
	int height();
	
	/**
	 * Retorna o nÁvel do do elemente "element".
	 * @param elemento para verificar.
	 * @return nÁvel do elemento.
	 */	
	int level(E element);

	/**
	 * Verifica se Árvore estÁ vazia.
	 * @return true se a Árvore estÁ vazia, false caso contrÁrio. 
	 */
	boolean isEmpty();
	
	/**
	 * Verifica se o elemento fornecido Á o raiz.
	 * @param elemento para verificar.
	 * @return true se o elemento for raiz, false caso contrÁrio. 
	 */
	boolean isRoot(E element);

	/**
	 * Verifica se o elemento fornecido Á folha.
	 * @param elemento para verificar.
	 * @return true se o elemento for folha, false caso contrÁrio. 
	 */
	boolean isLeave(E element);

	/**
	 * Verifica se o elemento fornecido nÁo Á folha.
	 * @param elemento para verificar.
	 * @return true se o elemento nÁo for folha, false caso contrÁrio. 
	 */
	boolean isBranch(E element);
	
	/**
	 * Instancia o iterador "default" para a Árvore Binária.
	 * @return iterador para a Árvore. 
	 */
	Iterator<E> iterator();

	/**
	 * Instancia um iterador para a Árvore Binária.
	 * @param tipo do iterador desejado: WIDTH, POST, PRE ou CENTRAL
	 * @return iterador para a Árvore.  
	 */
	Iterator<E> iterator(IteratorTreeType t);
	
	/**
	 * Percorre a Árvore em prÁ-ordem, retornando seus elementos. 	
	 * @return Lista com os nodos da Árvore em prÁ-ordem.
	 */
	List<E> traversalPre();
	
	/**
	 * Percorre a Árvore em pÁs-ordem, retornando seus elementos. 	
	 * @return Lista com os nodos da Árvore em pÁs-ordem.
	 */
	List<E> traversalPos();
	
	/**
	 * Percorre a Árvore em ordem central (ou in-fixa), retornando seus elementos. 	
	 * @return Lista com os nodos da Árvore em ordem central.
	 */
	List<E> traversalCentral();
	
	/**
	 * Percorre a Árvore em amplitude, retornando seus elementos. 	
	 * @return Lista com os nodos da Árvore, ordenados nÁvel a nÁvel, da esquerda para direita. 
	 */
	List<E> traversalWidth();
}