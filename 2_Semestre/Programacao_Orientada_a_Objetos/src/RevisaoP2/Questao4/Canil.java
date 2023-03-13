package RevisaoP2.Questao4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Canil {
    private List<Cachorro> lstc;

    public Canil() {
        lstc = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            String nome = "Cachorro " + i;
            int idade = r.nextInt(20);
            String raca = "Cachorro Tipo " + r.nextInt(10);
            String cor = "(" + r.nextInt(255) + ", " + r.nextInt(255) + ", " + r.nextInt(255) + ")";
            double peso = r.nextDouble(100);
            Cachorro cachorro = new Cachorro(nome, idade, raca, cor, peso);
            lstc.add(cachorro);
        }
        lstc.add(new Cachorro("Pongo", 2, "dalmata", "branco", 30));
    }

    public List<Cachorro> getLstc() {
        return lstc;
    }

    public List<Cachorro> getAllOlderThan(int idade) {
        return lstc.stream()
                .filter(c -> c.getIdade() > idade)
                .toList();
    }

    public long getAmountHeavierThan(double peso) {
        return lstc.stream()
                .filter(cachorro -> cachorro.getPeso() > peso)
                .count();
    }

    public String getCorFromOldest(int idade) {
        return lstc.stream()
                .filter(c -> c.getIdade() == idade)
                .map(c -> c.getCor())
                .findAny()
                .orElse("-1");

    }

    public double getAvgWeightLighter(double limit) {
        return lstc.stream()
                .filter(c -> c.getPeso() < limit)
                .mapToDouble(c -> c.getPeso())
                .average()
                .orElse(0);
    }

    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder();
        lstc.forEach(c -> str.append(c.toString() + "\n"));
        return str.toString();
    }
}
