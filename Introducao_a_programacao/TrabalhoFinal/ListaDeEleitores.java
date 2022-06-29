import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ListaDeEleitores {

    private int quantidadeEleitores;
    private Eleitor[] eleitores;
    private File eleitoresFile;

    public ListaDeEleitores(File eleitoresFile) {
        this.eleitoresFile = eleitoresFile;
        this.contaEleitores();
        this.eleitores = new Eleitor[quantidadeEleitores];
        addEleitores();
    }

    private void contaEleitores() {
        try {
            Scanner reader = new Scanner(eleitoresFile);
            // Pular cabeçalho
            reader.nextLine();
            while (reader.hasNext()) {
                this.quantidadeEleitores++;
                reader.nextLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
        }
    }

    public Eleitor[] getEleitores() {
        return eleitores;
    }

    public int getQuantidadeEleitores() {
        return quantidadeEleitores;
    }

    private void addEleitores() {
        try {
            Scanner reader = new Scanner(eleitoresFile);
            reader.nextLine();
            for (int i = 0; reader.hasNext(); i++) {
                String fileLine = reader.nextLine();
                String[] fileLineContent = fileLine.split(",");
                int id = Integer.parseInt(fileLineContent[0].trim());
                String nome = fileLineContent[1].trim();
                String situacao = fileLineContent[2].trim();
                Eleitor eleitor = new Eleitor(id, nome, situacao);
                eleitores[i] = eleitor;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public boolean existeNumero(int numeroEleitor) {
        boolean existe = true;

        for (Eleitor eleitor : eleitores)
            if ((eleitor != null) && (eleitor.getId() == numeroEleitor))
                return existe;

        return !existe;
    }

    public Eleitor getEleitor(int numeroEleitor) {
        for (Eleitor eleitor : eleitores)
            if ((eleitor != null) && (eleitor.getId() == numeroEleitor))
                return eleitor;
        return new Eleitor();
    }

    public void ordenarEleitores(String qualquer) {
        for (int i = 0; i < eleitores.length - 1; i++) {
            for (int j = 0; j < eleitores.length - 1 - i; j++) {
                if ((eleitores[j] == null) || (eleitores[j + 1] == null))
                    continue;
                String nomeEleitor = eleitores[j].getNome();
                String nomeEleitorSeguinte = eleitores[j + 1].getNome();
                char letraNomeEleitor = nomeEleitor.charAt(0);
                char letraNomeEleitorSeguinte = nomeEleitorSeguinte.charAt(0);
                if (letraNomeEleitor > letraNomeEleitorSeguinte) {
                    Eleitor aux = eleitores[j];
                    eleitores[j] = eleitores[j + 1];
                    eleitores[j + 1] = aux;
                }
            }
        }
    }

    public void ordenarEleitores(int qualquer) {
        for (int i = 0; i < eleitores.length - 1; i++) {
            for (int j = 0; j < eleitores.length - 1 - i; j++) {
                if ((eleitores[j] == null) || (eleitores[j + 1] == null))
                    continue;
                int idEleitor = eleitores[j].getId();
                int idEleitorSeguinte = eleitores[j + 1].getId();
                if (idEleitor > idEleitorSeguinte) {
                    Eleitor aux = eleitores[j];
                    eleitores[j] = eleitores[j + 1];
                    eleitores[j + 1] = aux;
                }
            }
        }
    }

    public void listarEleitores() {
        for (Eleitor eleitor : eleitores)
            if (eleitor != null) {
                System.out.println();
                System.out.println(eleitor);
            }
    }

}
