package TrabalhoExtra;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

import TrabalhoExtra.GrafoValorado.Aresta;

public class GrafoArquivo {
    public static GrafoValorado lerArquivoGrafo(String caminhoArquivo) {
        try {
            File file = new File(caminhoArquivo);
            Scanner reader = new Scanner(file);
            
            // Skip header
            reader.nextLine();

            int numVertices = reader.nextInt();
            reader.nextLine();

            GrafoValorado g = new GrafoValorado(numVertices);

            while (reader.hasNext()) {
                String[] line = reader.nextLine().split(" \\| ");

                int origin = line[0].charAt(0) - ((int)'A');
                int destination = line[1].charAt(0) - ((int)'A');
                int weight = Integer.parseInt(line[2]);

                g.adicionarAresta(origin, destination, weight);
            }

            reader.close();
            
            return g;
        } catch (FileNotFoundException fnfe) {
            System.out.println("Arquivo não encontrado!");
            return null;
        }
    }

    public static boolean salvarArquivoGrafo(GrafoValorado g, String caminhoArquivo) {
        try {
            File file = new File(caminhoArquivo);
            FileWriter fw = new FileWriter(file);

            fw.write("origem | destino | peso\n");
            fw.write(g.getNumeroVertices() + " vertices\n");

            // for (int i = 0; i < g.getNumeroVertices(); i++)
                // for (Aresta a : g.getAdjacentes(i)) {
                //     fw.write((char)(i + ((int)'A')) + " | " + (char)(a.w + ((int)'A')) + " | " + a.peso + "\n");

            return true;
        } catch (Exception e) {
            System.out.println("Erro ao salvar arquivo!");
            return false;
        }
    }
}
