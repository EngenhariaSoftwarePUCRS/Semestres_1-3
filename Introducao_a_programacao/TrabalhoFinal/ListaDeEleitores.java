import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ListaDeEleitores {
    
    private int quantidadeEleitores;
    private Eleitor[] eleitores;
    private File eleitoresFile = new File("com\\leonardo\\eleitores.txt");

    public ListaDeEleitores() {
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

    public void listarPessoas() {
        for (Eleitor eleitor : eleitores) {
            if (eleitor != null)
                System.out.println(eleitor);
        }
    }

}
