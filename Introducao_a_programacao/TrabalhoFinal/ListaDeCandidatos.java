import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ListaDeCandidatos {
    
    private int quantidadeCandidatos;
    private Candidato[] candidatos;
    private File candidatosFile;

    public ListaDeCandidatos(File candidatosFile) {
        this.candidatosFile = candidatosFile;
        this.quantidadeCandidatos = Util.getQuantidadePessoas(candidatosFile);
        this.candidatos = new Candidato[quantidadeCandidatos];
        addCandidatos();
    }
    
    public Candidato[] getCandidatos() {
        return candidatos;
    }

    public int getQuantidadeCandidatos() {
        return quantidadeCandidatos;
    }

    private void addCandidatos() {
        try {
            Scanner reader = new Scanner(candidatosFile);
            reader.nextLine();
            for (int i = 0; reader.hasNext(); i++) {
                String fileLine = reader.nextLine();
                String[] fileLineContent = fileLine.split(",");
                int id = Integer.parseInt(fileLineContent[0]);
                String nome = fileLineContent[1];
                String partido = fileLineContent[2];
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
            if (candidato != null)
                if (candidato.getId() == numeroCandidato)
                    return existe;
                    
        return !existe;
    }

    public Candidato getCandidato(int numeroCandidato) {
        for (Candidato candidato : candidatos)
            if (candidato.getId() == numeroCandidato)
                return candidato;
        return new Candidato();
    }

    public void exibirCandidatos() {
        for (Candidato candidato : candidatos)
            if (candidato != null) {
                System.out.println();
                System.out.println(candidato);
            }
    }

}
