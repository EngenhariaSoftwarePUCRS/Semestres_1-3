import java.util.Scanner;

public class Olimpiada {

    public static void main(String[] args) {
        
        try (Scanner input = new Scanner(System.in)) {
            double[] notas = new double[6];
            
            for (int i = 0; i < 6; i++) {
                //System.out.print("Insira a nota nº "+(i+1)+": ");
                notas[i] = (i+1);//input.nextDouble();
            }
            
            System.out.println("A média final foi: "+media(quatroMaiores(notas)));
        }
    }
    
    private static double[] quatroMaiores(double[] notas) {
        double[] topNotas = new double[4];
        return topNotas;
    }
    
    private static double media(double[] notas) {
        double soma = 0.0;
        for (int i = 0; i < notas.length; i++) {
            soma = soma + notas[i];
        }
        double media = soma/notas.length;
        return media;
    }
}
