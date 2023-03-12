package Semana14;

public class Main {
    public static void main(String[] args) {
        BinaryTreeTAD<String> arvore = new BinaryTree<String>();
        arvore.add("Primeiro E", null, NodePosition.LEFT);
        arvore.add("Primeiro D", null, NodePosition.RIGHT);
        arvore.add("Segundo E", "PrimeiroE", NodePosition.LEFT);
        System.out.println(arvore);
    }
}
