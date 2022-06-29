import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ListaDeEleitores {

    private int quantidadeEleitores;
    private Eleitor[] eleitores;
    private File eleitoresFile;

    public ListaDeEleitores(File eleitoresFile) {
        this.eleitoresFile = eleitoresFile;
        this.quantidadeEleitores = Util.getQuantidadePessoas(eleitoresFile);
        this.eleitores = new Eleitor[quantidadeEleitores];
        addEleitores();
    }

    public Eleitor[] getEleitores() {
        return eleitores;
    }

    public int getQuantidadeEleitores() {
        return quantidadeEleitores;
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

    private void addEleitores() {
        try {
            Scanner reader = new Scanner(eleitoresFile);
            reader.nextLine();
            for (int i = 0; reader.hasNext(); i++) {
                String fileLine = reader.nextLine();
                String[] fileLineContent = fileLine.split(",");
                int id = Integer.parseInt(fileLineContent[0]);
                String nome = fileLineContent[1];
                String situacao = fileLineContent[2];
                Eleitor eleitor = new Eleitor(id, nome, situacao);
                eleitores[i] = eleitor;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public void listarEleitoresAlfabetica() {
        Eleitor[] copiaEleitores = this.eleitores;
        for (int i = 0; i < copiaEleitores.length - 1; i++) {
            for (int j = 0; j < copiaEleitores.length - 1 - i; j++) {
                if ((copiaEleitores[j] == null) || (copiaEleitores[j + 1] == null))
                    continue;
                String nomeEleitor = copiaEleitores[j].getNome();
                String nomeEleitorSeguinte = copiaEleitores[j + 1].getNome();
                char letraNomeEleitor = nomeEleitor.charAt(0);
                char letraNomeEleitorSeguinte = nomeEleitorSeguinte.charAt(0);
                if (letraNomeEleitor > letraNomeEleitorSeguinte) {
                    Eleitor aux = copiaEleitores[j];
                    copiaEleitores[j] = copiaEleitores[j + 1];
                    copiaEleitores[j + 1] = aux;
                }
            }
        }
        for (Eleitor eleitor : copiaEleitores)
            if (eleitor != null) {
                System.out.println(eleitor);
                System.out.println();
            }
    }

    public void listarEleitores() {
        for (Eleitor eleitor : eleitores)
            if (eleitor != null) {
                System.out.println(eleitor);
                System.out.println();
            }
    }

}
