package Aula_09;
import java.util.Scanner;

public class AreaLivreTerreno {

	public static void main(String[] args) {
		
		try (Scanner input = new Scanner(System.in)) {
			
			double larguraTerreno;
			double comprimentoTerreno;
			double areaTerreno;
			double larguraCasa;
			double comprimentoCasa;
			double areaCasa;
			double[] areaLivre = new double[2];
			
			System.out.print("Insira a largura do terreno: ");
			larguraTerreno = input.nextDouble();
			
			System.out.print("Insira o comprimento do terreno: ");
			comprimentoTerreno = input.nextDouble();
			
			areaTerreno = larguraTerreno * comprimentoTerreno;
			
			System.out.print("Insira a largura da casa: ");
			larguraCasa = input.nextDouble();
			
			System.out.print("Insira o comprimento da casa: ");
			comprimentoCasa = input.nextDouble();
			
			areaCasa = larguraCasa * comprimentoCasa;
			
			areaLivre[0] = areaTerreno - areaCasa;
			areaLivre[1] = (areaTerreno - areaCasa) / areaTerreno * 100;
			
			System.out.println("Voc� possui "+areaLivre[0]+"m� livres de terreno.");
			System.out.println("Isso equivalhe a "+areaLivre[1]+"% do total do terreno.");
			
		}
	}
}
