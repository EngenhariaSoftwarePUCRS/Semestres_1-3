import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ListaDeCandidatos {

    private int quantidadeCandidatos;
    private Candidato[] candidatos;
    private File candidatosFile;

    public ListaDeCandidatos(File candidatosFile) {
        this.candidatosFile = candidatosFile;
        this.contaCandidatos();
        this.candidatos = new Candidato[quantidadeCandidatos];
        addCandidatos();
    }

    private void contaCandidatos() {
        try {
            Scanner reader = new Scanner(candidatosFile);
            // Pular cabeçalho
            reader.nextLine();
            while (reader.hasNext()) {
                this.quantidadeCandidatos++;
                reader.nextLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        }
    }

    public Candidato[] getCandidatos() {
        return candidatos;
    }

    public int getQuantidadeCandidatos() {
        return quantidadeCandidatos;
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

    private void addCandidatos() {
        try {
            Scanner reader = new Scanner(candidatosFile);
            reader.nextLine();
            for (int i = 0; reader.hasNext(); i++) {
                String fileLine = reader.nextLine();
                String[] fileLineContent = fileLine.split(",");
                int id = Integer.parseInt(fileLineContent[0].trim());
                String nome = fileLineContent[1].trim();
                String partido = fileLineContent[2].trim();
                Candidato candidato = new Candidato(id, nome, partido);
                candidatos[i] = candidato;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public boolean existeNumero(int numeroCandidato) {
        boolean existe = true;

        for (Candidato candidato : candidatos)
            if ((candidato != null) && (candidato.getId() == numeroCandidato))
                return existe;

        return !existe;
    }

    public Candidato getCandidato(int numeroCandidato) {
        for (Candidato candidato : candidatos)
            if ((candidato != null) && (candidato.getId() == numeroCandidato))
                return candidato;
        return new Candidato();
    }

    public void listarCandidatosVotos() {
        Candidato[] copiaCandidatos = this.candidatos;
        for (int i = 0; i < copiaCandidatos.length - 1; i++) {
            for (int j = 0; j < copiaCandidatos.length - 1 - i; j++) {
                if ((copiaCandidatos[j] == null) || (copiaCandidatos[j + 1] == null))
                    continue;
                int quantidadeVotosCandidato = copiaCandidatos[j].getQuandidadeVotos();
                int quantidadeVotosCandidatoSeguinte = copiaCandidatos[j + 1].getQuandidadeVotos();
                if (quantidadeVotosCandidato > quantidadeVotosCandidatoSeguinte) {
                    Candidato aux = copiaCandidatos[j];
                    copiaCandidatos[j] = copiaCandidatos[j + 1];
                    copiaCandidatos[j + 1] = aux;
                }
            }
        }
        for (Candidato candidato : copiaCandidatos)
            if (candidato != null) {
                System.out.println();
                System.out.print(candidato);
                System.out.println("\nQuantidade de votos: " + candidato.getQuandidadeVotos());
            }
    }

    public void listarCandidatos() {
        for (Candidato candidato : candidatos)
            if (candidato != null) {
                System.out.println();
                System.out.println(candidato);
            }
    }

}
