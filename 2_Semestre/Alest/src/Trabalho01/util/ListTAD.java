package util;

/*********
 * Interface para o T.A.D. Lista.
 * 
 * @author Michael da Costa Móra
 * @param <E> Tipo dos dados armazenados na lista.
 */
public interface ListTAD<E> {
    /**********
     * Adiciona um elemento na última posição da lista.
     * 
     * @param element Elemento a ser adicionado.
     * @return true se a operação funcionou, false caso contrório.
     */
    public void add(E element);

    /**********
     * Adiciona o elemento fornecido em uma dada posição da lista.
     * 
     * @param index   posição da lista.
     * @param element Elemento a ser adicionado.
     * @return true se a operação funcionou, false caso contrório.
     */
    public void add(int index, E element);

    /**********
     * Remove o elemento armazenado na posição fornecida da lista.
     * 
     * @param pos posição da lista.
     */
    public E remove(int pos);

    /**********
     * Remove a primeira ocorróncia de um dado elemento da lista.
     * 
     * @param element Elemento a ser adicionado.
     */
    public E remove(E element);

    /**********
     * Recupera o elemento armazenado em uma dada posição da lista.
     * 
     * @param pos posição do elemento na lista.
     * @return Elemento armazenado na lista.
     */
    public E get(int pos);

    /**********
     * Atualiza a posição fornecida da lista, com o elemento fornecido.
     * 
     * @param index   posição da lista.
     * @param element Elemento a ser armazenado na lista.
     * @return true se a operação funcionou, false caso contrório.
     */
    public void set(int index, E element);

    /**********
     * Procura um elemento na lista, e retorna sua ocorróncia.
     * 
     * @param element Elemento a ser procurado.
     * @return referóncia para o elemento armazenado na lista.
     */
    // public E search(E element);

    /**********
     * Verifica se a lista estó vazia.
     * 
     * @return true se a lista estó vazia, false caso contrório.
     */
    public boolean isEmpty();

    /**********
     * Recupera a quantidade de elementos armazenados na lista.
     * 
     * @return Quantidade de elementos.
     */
    public int size();

    /********
     * Conta quantas ocorróncias de um dado elemento estóo armazenadas na lista.
     * 
     * @return A quantidade de ocorróncias do elemento fornecido.
     */
    public int count(E element);

    /**********
     * Remove todos os elementos da lista.
     */
    public void clean();

    /**********
     * Retorna uma representaóóo textual do conteódo da lista.
     * 
     * @return Um String com o conteódo da lista.
     */
    public String toString();

    /**********
     * Mótodos adicionais, para fins didóticos.
     *********/

    /********
     * Adiciona um elemento na primeira posição da lista.
     * 
     * @param element Elemento a ser adicionado.
     * @return true se a operação funcionou, false caso contrório.
     */
    public void addFirst(E element);

    /**********
     * Adiciona um elemento na última posição da lista.
     * 
     * @param element Elemento a ser adicionado.
     * @return true se a operação funcionou, false caso contrório.
     */
    public void addLast(E element);

    /********
     * Remove o elemento armazenado na primeira posição da lista.
     * 
     * @return Elemento removido da lista.
     */
    public E removeFirst();

    /********
     * Remove o elemento armazenado na última posição da lista.
     * 
     * @return Elemento removido da lista.
     */
    public E removeLast();

    /********
     * Recupera o elemento armazenado na primeira posição da lista.
     * 
     * @return Elemento armazenado na lista.
     */
    public E getFirst();

    /********
     * Recupera o elemento armazenado na última posição da lista.
     * 
     * @return Elemento armazenado na lista.
     */
    public E getLast();
}
