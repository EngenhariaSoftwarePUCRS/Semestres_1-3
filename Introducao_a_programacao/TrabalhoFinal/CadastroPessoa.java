public class CadastroPessoa {
    
    private int limite;
    private Pessoa[] pessoas;

    public CadastroPessoa(int limite) {
        this.limite = limite;
        pessoas = new Pessoa[this.limite];
    }

    private void InicializarCadastro() {
        for(int i=0; i < limite; i++)
        {
            pessoas[i] = null;
        }
    }
    public void adicionarPessoa(Pessoa novaPessoa) {
        int posicaoLivre = this.retornarPrimeiraPosicaoLivre();
        if(posicaoLivre < this.limite)
            this.pessoas[posicaoLivre] = novaPessoa;
    }

    private int retornarPrimeiraPosicaoLivre() {
        int posicaoLivre = -1;

        for(int i =0; i < limite; i++)
            if(pessoas[i] == null && posicaoLivre == -1)
                posicaoLivre = i;

        return posicaoLivre;
    }

    public Pessoa[] getPessoas() {
        return this.pessoas;
    }

    public  int quantidadePessoas() {
        int quantidade = 0;

        for(int i = 0; i < pessoas.length; i++) 
            if(pessoas[i] != null) quantidade++;

        return quantidade;
    }

    public Pessoa pesquisarPessoa(int id) {
        boolean achou = false;
        Pessoa pessoaEncontrada = null;
        int i = 0;

        while(!achou && i<pessoas.length) {
            if(pessoas[i]!=null && pessoas[i].getId()==id) {
                achou = true;
                pessoaEncontrada = pessoas[i];
            }
            i++;
        }
        return pessoaEncontrada;
    }

    public Pessoa pesquisarPessoa(String nome) {
        boolean achou = false;
        Pessoa pessoaEncontrada = null;
        int i = 0;

        while(!achou && i<pessoas.length) {
            if(pessoas[i] != null && pessoas[i].getNome().toLowerCase() == nome.toLowerCase()) {
                achou = true;
                pessoaEncontrada = pessoas[i];
            }
            i++;
        }
        return pessoaEncontrada;
    }

    public boolean removerPessoa(int id) {
        boolean removeu = false;
        int i = 0;

        while(!removeu && i < pessoas.length) {
            if(pessoas[i] != null && pessoas[i].getId() == id)  {
                removeu = true;
                pessoas[i] = null; //aqui removeu setando null na posicao do vetor
            }
            i++;
        }

        return removeu;
    }
}