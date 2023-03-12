package TrabalhoFinal_SimulacaoVotacaoEletronica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ListaDeEleitores {

    private final File eleitoresFile;
    private final int quantidadeEleitores;
    private final Eleitor[] eleitores;

    public ListaDeEleitores(File eleitoresFile) {
        this.eleitoresFile = eleitoresFile;
        this.quantidadeEleitores = contaEleitores();
        this.eleitores = new Eleitor[quantidadeEleitores];
        addEleitores();
    }

    private int contaEleitores() {
        int contador = 0;
        try {
            Scanner reader = new Scanner(eleitoresFile);
            // Pular cabeçalho
            reader.nextLine();
            while (reader.hasNext()) {
                contador++;
                reader.nextLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        }
        return contador;
    }

    private void addEleitores() {
        try {
            Scanner reader = new Scanner(eleitoresFile);
            // Pular cabeçalho
            reader.nextLine();
            for (int i = 0; reader.hasNext(); i++) {
                String fileLine = reader.nextLine();
                // Separa os conteúdos de cada linha na vírgula
                String[] fileLineContent = fileLine.split(",");
                int id = Integer.parseInt(fileLineContent[0].trim());
                String nome = fileLineContent[1].trim();
                String situacao = fileLineContent[2].trim();
                // Cria um novo eleitor com os atributos da linha
                Eleitor eleitor = new Eleitor(id, nome, situacao);
                // e insere no vetor de eleitores
                eleitores[i] = eleitor;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public int getQuantidadeEleitores() {
        return quantidadeEleitores;
    }

    public Eleitor[] getEleitores() {
        return eleitores;
    }

    public boolean existeEleitor(int numeroEleitor) {
        boolean existe = true;

        // Para cada eleitor na lista dos candidatos
        for (Eleitor eleitor : eleitores)
            // se ele existir e tiver o id igual ao do procurado
            if ((eleitor != null) && (eleitor.getId() == numeroEleitor))
                return existe;

        return !existe;
    }

    public Eleitor getEleitor(int numeroEleitor) {
        // Para cada eleitor na lista dos eleitores
        for (Eleitor eleitor : eleitores)
            // se ele existir e tiver o id igual ao do procurado
            if ((eleitor != null) && (eleitor.getId() == numeroEleitor))
                return eleitor;

        // Se não existir o candidato,
        // -o que não acontece, pois esse método só é chamado após o método
        // existeCandidato()-
        // vai devolver um novo Candidato "dummy"
        return new Eleitor();
    }

    public void ordenarEleitores() {
        // Ordena por id
        for (int i = 0; i < eleitores.length - 1; i++) {
            for (int j = 0; j < eleitores.length - 1 - i; j++) {
                // Se eu estiver comparando um eleitor que não existe
                // ou com algum eleitor que não existe
                if ((eleitores[j] == null) || (eleitores[j + 1] == null))
                    // pula esta iteração do laço
                    continue;
                int idEleitor = eleitores[j].getId();
                int idEleitorSeguinte = eleitores[j + 1].getId();
                if (idEleitor > idEleitorSeguinte)
                    troca(j);
            }
        }
    }

    public void ordenarEleitores(String qualquer) {
        // Ordena Alfabeticamente (2 letras)
        for (int i = 0; i < eleitores.length - 1; i++) {
            for (int j = 0; j < eleitores.length - 1 - i; j++) {
                // Se eu estiver comparando um eleitor que não existe
                // ou com algum eleitor que não existe
                if ((eleitores[j] == null) || (eleitores[j + 1] == null))
                    // pula esta iteração do laço
                    continue;
                String nomeEleitor = eleitores[j].getNome();
                String nomeEleitorSeguinte = eleitores[j + 1].getNome();
                char primeiraLetraNomeEleitor = nomeEleitor.charAt(0);
                char primeiraLetraNomeEleitorSeguinte = nomeEleitorSeguinte.charAt(0);
                char segundaLetraNomeEleitor = nomeEleitor.charAt(1);
                char segundaLetraNomeEleitorSeguinte = nomeEleitorSeguinte.charAt(1);
                if (primeiraLetraNomeEleitor > primeiraLetraNomeEleitorSeguinte)
                    troca(j);
                else {
                    if ((primeiraLetraNomeEleitor == primeiraLetraNomeEleitorSeguinte)
                            && (segundaLetraNomeEleitor > segundaLetraNomeEleitorSeguinte))
                        troca(j);
                }
            }
        }
    }

    private void troca(int j) {
        Eleitor aux = eleitores[j];
        eleitores[j] = eleitores[j + 1];
        eleitores[j + 1] = aux;
    }

    public void listarEleitores() {
        // Para cada eleitor no vetor de eleitores
        for (Eleitor eleitor : eleitores)
            // Se este não for nulo, pula uma linha e lista
            if (eleitor != null) {
                System.out.println();
                System.out.println(eleitor);
            }
    }

}
