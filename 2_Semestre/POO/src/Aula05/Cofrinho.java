package Aula05;

import Aula05.Material_Apoio.Moeda;
import Aula05.Material_Apoio.NomeMoeda;

public class Cofrinho implements CofrinhoInterface {

    private int qtdadeMoedas;
    private int limite;
    private double valor;
    private Moeda[] moedas;

    public Cofrinho() {
        this.limite = 2;
        moedas = new Moeda[limite];
    }

    public Cofrinho(Moeda[] moedas) {
        this.moedas = moedas;
        this.limite = moedas.length;
    }

    public Cofrinho(int limite) {
        this.limite = limite;
        moedas = new Moeda[limite];
    }

    public Cofrinho(Moeda[] moedas, int limite) {
        this.moedas = moedas;
        if (limite > moedas.length)
            this.limite = limite;
        else
            this.limite = moedas.length;
    }

    @Override
    public boolean insere(Moeda moeda) {
        if (qtdadeMoedas < limite) {
            moedas[qtdadeMoedas] = moeda;
            qtdadeMoedas++;
            valor += moeda.getValorReais();
            return true;
        }
        return false;
    }

    @Override
    public Moeda retira() {
        if (qtdadeMoedas > 0) {
            Moeda aux = moedas[qtdadeMoedas - 1];
            moedas[qtdadeMoedas - 1] = null;
            qtdadeMoedas--;
            valor -= aux.getValorReais();
            return aux;
        }
        return null;
    }

    @Override
    public int getQtdadeMoedas() {
        return qtdadeMoedas;
    }

    @Override
    public int getQtdadeMoedasTipo(NomeMoeda nomeMoeda) {
        int qtdadeMoedasTipo = 0;
        for (Moeda moeda : moedas)
            if (moeda.getNomeMoeda() == nomeMoeda)
                qtdadeMoedasTipo++;
        return qtdadeMoedasTipo;
    }

    @Override
    public int getValorTotalCentavos() {
        return (int)(valor * 100);
    }

    @Override
    public double getValorTotalReais() {
        return valor;
    }
    
}
