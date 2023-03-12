package TrabalhoFinal_SimulacaoVotacaoEletronica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ListaDeCandidatos {

    private final File candidatosFile;
    private final int quantidadeCandidatos;
    private final Candidato[] candidatos;

    public ListaDeCandidatos(File candidatosFile) {
        this.candidatosFile = candidatosFile;
        this.quantidadeCandidatos = contaCandidatos();
        this.candidatos = new Candidato[quantidadeCandidatos];
        addCandidatos();
    }

    private int contaCandidatos() {
        int contador = 0;
        try {
            Scanner reader = new Scanner(candidatosFile);
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

    private void addCandidatos() {
        try {
            Scanner reader = new Scanner(candidatosFile);
            // Pular cabeçalho
            reader.nextLine();
            for (int i = 0; reader.hasNext(); i++) {
                String fileLine = reader.nextLine();
                // Separa os conteúdos de cada linha na vírgula
                String[] fileLineContent = fileLine.split(",");
                int id = Integer.parseInt(fileLineContent[0].trim());
                String nome = fileLineContent[1].trim();
                String partido = fileLineContent[2].trim();
                // Cria um novo candidato com os atributos da linha
                Candidato candidato = new Candidato(id, nome, partido);
                // e insere no vetor de candidatos
                candidatos[i] = candidato;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public int getQuantidadeCandidatos() {
        return quantidadeCandidatos;
    }

    public Candidato[] getCandidatos() {
        return candidatos;
    }

    public String[] getIdsCandidatos() {
        String[] idsCandidatos = new String[quantidadeCandidatos];

        for (int i = 0; i < idsCandidatos.length; i++)
            idsCandidatos[i] = Integer.toString(candidatos[i].getId());

        return idsCandidatos;
    }

    public String[] getNomesCandidatos() {
        String[] nomesCandidatos = new String[quantidadeCandidatos];

        for (int i = 0; i < nomesCandidatos.length; i++)
            nomesCandidatos[i] = candidatos[i].getNome();

        return nomesCandidatos;
    }

    public String[] getPartidosCandidatos() {
        String[] partidosCandidatos = new String[quantidadeCandidatos];

        for (int i = 0; i < partidosCandidatos.length; i++)
            partidosCandidatos[i] = candidatos[i].getPartido();

        return partidosCandidatos;
    }

    public String[] getVotosCandidatos() {
        String[] votosCandidatos = new String[quantidadeCandidatos];

        for (int i = 0; i < votosCandidatos.length; i++)
            votosCandidatos[i] = Integer.toString(candidatos[i].getQuandidadeVotos());

        return votosCandidatos;
    }

    public boolean existeCandidato(int numeroCandidato) {
        boolean existe = true;

        // Para cada candidato na lista dos candidatos
        for (Candidato candidato : candidatos)
            // se ele existir e tiver o id igual ao do procurado
            if ((candidato != null) && (candidato.getId() == numeroCandidato))
                return existe;

        return !existe;
    }

    public Candidato getCandidato(int numeroCandidato) {
        // Para cada candidato na lista dos candidatos
        for (Candidato candidato : candidatos)
            // se ele existir e tiver o id igual ao do procurado
            if ((candidato != null) && (candidato.getId() == numeroCandidato))
                return candidato;

        // Se não existir o candidato,
        // -o que não acontece, pois esse método só é chamado após o método
        // existeCandidato()-
        // vai devolver um novo Candidato "dummy"
        return new Candidato();
    }

    public void ordenarCandidatos() {
        // Bubble Sort por votos
        for (int i = 0; i < candidatos.length - 1; i++) {
            for (int j = 0; j < candidatos.length - 1 - i; j++) {
                // Se eu estiver comparando um eleitor que não existe
                // ou com algum eleitor que não existe
                if ((candidatos[j] == null) || (candidatos[j + 1] == null))
                    // pula esta iteração do laço
                    continue;
                int quantidadeVotosCandidato = candidatos[j].getQuandidadeVotos();
                int quantidadeVotosCandidatoSeguinte = candidatos[j + 1].getQuandidadeVotos();
                if (quantidadeVotosCandidato < quantidadeVotosCandidatoSeguinte) {
                    Candidato aux = candidatos[j];
                    candidatos[j] = candidatos[j + 1];
                    candidatos[j + 1] = aux;
                }
            }
        }
    }

    public void listarCandidatos() {
        // Para cada candidato no vetor de candidatos
        for (Candidato candidato : candidatos)
            // Se este não for nulo, pula uma linha e lista
            if (candidato != null) {
                System.out.println();
                System.out.println(candidato);
            }
    }

}
