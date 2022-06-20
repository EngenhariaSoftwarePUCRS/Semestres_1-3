public class Teste {
    public static void main(String[] args) {
        
        Eleitor e1 = new Eleitor(105, "Jacinto Coelho Matheus", Eleitor.SITUACAO_APTO);
        Eleitor e2 = new Eleitor(125, "Danilo Caio Guedes Amaral", Eleitor.SITUACAO_NAO_APTO);
        Eleitor e3 = new Eleitor(126, "Adilson Clezar Oliveira Varela", Eleitor.SITUACAO_APTO);
        Eleitor e4 = new Eleitor(134, "Romeu Correia de Saldanha", Eleitor.SITUACAO_APTO);

        TabelaEleitor tabela = new TabelaEleitor(3);
        if (!tabela.adicionarEleitor(e1)) 
            System.out.println("Erro ao inserir o "+e1.getNome());
        if (!tabela.adicionarEleitor(e2)) 
            System.out.println("Erro ao inserir o "+e2.getNome());
        if (!tabela.adicionarEleitor(e3)) 
            System.out.println("Erro ao inserir o "+e3.getNome());
        if (!tabela.adicionarEleitor(e4)) 
            System.out.println("Erro ao inserir o "+e4.getNome());

        tabela.listarEleitores();
    }
}
