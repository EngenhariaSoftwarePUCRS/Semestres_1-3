package Aula05;

import Aula05.Material_Apoio.Moeda;
import Aula05.Material_Apoio.NomeMoeda;

public class App {
    public static void main(String[] args) {
        Cofrinho cofrinhoDoLucca = new Cofrinho(10);
        System.out.println(cofrinhoDoLucca.insere(new Moeda(NomeMoeda.Cinquenta)));
        System.out.println(cofrinhoDoLucca.insere(new Moeda(NomeMoeda.VinteCinco)));
        System.out.println(cofrinhoDoLucca.insere(new Moeda(NomeMoeda.Cinquenta)));
        System.out.println(cofrinhoDoLucca.insere(new Moeda(NomeMoeda.Cinquenta)));
        System.out.println(cofrinhoDoLucca.insere(new Moeda(NomeMoeda.VinteCinco)));
        System.out.println(cofrinhoDoLucca.insere(new Moeda(NomeMoeda.Cinquenta)));
        System.out.println(cofrinhoDoLucca.insere(new Moeda(NomeMoeda.Dez)));
        System.out.println(cofrinhoDoLucca.insere(new Moeda(NomeMoeda.Cinquenta)));
        System.out.println(cofrinhoDoLucca.insere(new Moeda(NomeMoeda.VinteCinco)));
        System.out.println(cofrinhoDoLucca.insere(new Moeda(NomeMoeda.Cinquenta)));
        System.out.println("Quantidade: " + cofrinhoDoLucca.getQtdadeMoedas());
        System.out.println("Qtd moedas de 1 real: " + cofrinhoDoLucca.getQtdadeMoedasTipo(NomeMoeda.Um));
        System.out.println("Qtd moedas de 50 cents: " + cofrinhoDoLucca.getQtdadeMoedasTipo(NomeMoeda.Cinquenta));
        System.out.println("Valor total (centavos): " + cofrinhoDoLucca.getValorTotalCentavos());
        System.out.println("Valor total (reais): " + cofrinhoDoLucca.getValorTotalReais());
        System.out.println("Debug 1:" + cofrinhoDoLucca.retira());
        System.out.println("Debug 2:" + cofrinhoDoLucca.retira());
        System.out.println("Valor total (centavos - sem 2 últimas): " + cofrinhoDoLucca.getValorTotalCentavos());
    }
}
