package TrabalhoExtra;

public class BuscaEmProfundidade {
    private boolean[] visitados;
    private int[] antecessor;
    public int[] preordem;
    public int[] posordem;
    private int contador;
    
    public BuscaEmProfundidade(GrafoValorado g, int verticeOrigem) {
        int numeroVertices = g.getNumeroVertices(); // numero de vertices do grafo, ou seja o tamanho do grafo
        this.visitados = new boolean[numeroVertices]; // vetor de visitados (se o vertice ja foi visitado ou nao)
        this.antecessor = new int[numeroVertices]; // vetor de antecessores, ou seja o pai de cada vertice
        this.preordem = new int[numeroVertices]; // vetor de preordem --> ordem que o vertice foi visitado
        this.posordem = new int[numeroVertices]; 
        this.contador = 0; // contador para preordem e posordem

        buscar(g, verticeOrigem); //método que é chamado recursivamente para explorar os vértices não visitados a partir do vértice origem/inicial
    }

    private void buscar(GrafoValorado g, int vertice){ // metodo recursivo para buscar em profundidade
        visitados[vertice] = true; // marca o vertice como visitado
        preordem[vertice] = contador++; // marca a ordem que o vertice foi visitado

        
        for (GrafoValorado.Aresta aresta : g.getAdjacencia(vertice)) { // para cada vertice adjacente ao vertice atual;
            int verticeAdjacente = aresta.w; // pega o vertice adjacente

            if (!visitados[verticeAdjacente]) { // se o vertice adjacente NÃO foi visitado
                antecessor[verticeAdjacente] = vertice; // marca o vertice atual como pai do vertice adjacente
                
                buscar(g, verticeAdjacente); // chama o metodo recursivamente para o vertice adjacente
            }
        }
        //lembrando: for each é um for que percorre todos os elementos de uma lista, array, etc. 
        //Sua sintaxe é: for (tipo nomeVariavel : nomeLista) { ... }; 
        //Escolhemos usa-lo aqui, pois ele é mais simples e mais legível do que o for tradicional.    

        posordem[vertice] = contador++; // marca a ordem que o vertice foi visitado

    }

    public void imprimirResultado() {
        // imprimir os arrais de visitados, antecessor, preordem e posordem.
        // preordem e posordem devem mostrar o caminho percorrido em pre e pos ordem;
        System.out.println("Visitados: ");
        for (int i = 0; i < visitados.length; i++) { // para cada vertice
            System.out.print(visitados[i] + " "); // imprime se foi visitado ou nao
        }

        System.out.println("\nAntecessor: ");
        for (int i = 0; i < antecessor.length; i++) {
            System.out.print(antecessor[i] + " ");
        }

        System.out.println("\nPreordem: ");
        for (int i = 0; i < preordem.length; i++) {
            System.out.print(preordem[i] + " ");
        }

        System.out.println("\nPosordem: ");
        for (int i = 0; i < posordem.length; i++) {
            System.out.print(posordem[i] + " ");
        }

    }
}
