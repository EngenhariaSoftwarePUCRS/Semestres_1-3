import java.util.Scanner;
public class Main {
    public static void main() {
        try (Scanner input = new Scanner(System.in)) {
            double[] provas, trabalhos;
            int qtdProvas, qtdTrabalhos;
            double resultado;
            
            System.out.print("Quantas provas você tem: ");
            qtdProvas = input.nextInt();
            provas = new double[qtdProvas];
            for (int i = 1; i <= qtdProvas; i++) {
                System.out.print("Digite a nota da "+i+"ª prova: ");
                provas[i-1] = input.nextDouble();
            }
            
            System.out.print("Quantos trabalhos você tem: ");
            qtdTrabalhos = input.nextInt();
            trabalhos = new double[qtdTrabalhos];
            for (int i = 1; i <= qtdTrabalhos; i++) {
                System.out.print("Digite a nota do "+i+"º trabalho: ");
                trabalhos[i-1] = input.nextDouble();
            }
            
            resultado = calculaG1(provas, trabalhos);
            System.out.print("Você possui G1 = "+resultado);
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
    }
    
    private static double[] eliminaMenor(double[] valores) {
        int qtdValores = valores.length;
        double[] maiores = new double[qtdValores - 1];
        
        for (int i = 0; i < maiores.length; i++) {
            for (int j = 0; j < qtdValores; j++) {
                if (maiores [i] < valores [j]) {
                    double aux = maiores[i];
                    maiores[i] = valores[j];
                    valores[j] = aux;
                }
            }
        }
        
        return maiores;
    }
    
    private static double media(double[] valores) {
        int qtdValores = valores.length;
        double media, soma = 0;
        
        for (int i = 0; i < qtdValores; i++) {
            soma += valores[i];
        }
        media = soma / qtdValores;
        
        return media;
    }
    
    private static double calculaG1(double[] provas, double[] trabalhos) {
        double G1,
            MP = media(provas),
            MT = media(eliminaMenor(trabalhos));
        
        G1 = (6*MP + 4*MT) / 10;
        
        return G1;
    }

}