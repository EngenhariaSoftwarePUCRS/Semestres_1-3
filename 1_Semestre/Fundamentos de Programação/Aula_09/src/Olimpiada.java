import java.util.Scanner;

public class Olimpiada {

    public static void main(String[] args) {
        
        try (Scanner input = new Scanner(System.in)) {
            double[] notas = new double[6];
            
            for (int i = 0; i < 6; i++) {
                System.out.print("Insira a nota nº "+(i+1)+": ");
                notas[i] = input.nextDouble();
            }
            
            for (int j = 0; j < notas.length; j++) {
                System.out.println("Nota: "+notas[j]);
            }
            
            System.out.println("A média final foi: "+/*media*/(quatroMaiores(notas)));
        }

    }
    
    private static double[] quatroMaiores(double[] notas) {
        double[] topNotas = new double[4];
        int i = 0;
        for (int j = notas.length-1; j >= 0; j--) {
            if (notas[j] > notas[j-1]) {
                System.out.println("Nota j: "+notas[j]);
                topNotas[i] = notas[j];
                i++;
            }
            System.out.println("Nota i: "+notas[i]);
        }
        return topNotas;
    }
    
    private static double media(double[] notas) {
        System.out.println(notas);
        double soma = 0.0;
        for (int i = 0; i < notas.length; i++) {
            soma = soma + notas[i];
        }
        double media = soma/notas.length;
        return media;
    }
}
