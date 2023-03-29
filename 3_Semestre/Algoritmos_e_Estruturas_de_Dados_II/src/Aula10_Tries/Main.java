package Aula10_Tries;

public class Main {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.adicionar("MARIA");
        t.adicionar("MARIANA");
        t.adicionar("MONGE");
        t.adicionar("MONTANA");
        t.adicionar("MARGARINA");
        t.adicionar("PESADO");
        t.adicionar("PESO");
        t.adicionar("PEDIDO");
        t.imprimir();
        boolean includesMaria = t.buscar("MARIA");
        boolean includesMario = t.buscar("MARIO");
        
        if (includesMaria)
            System.out.println("Inclui MARIA");
        if (includesMario)
            System.out.println("Inclui MARIO");
            
    }
}
