package Aula05;

import Aula05.Material_Apoio.Moeda;
import Aula05.Material_Apoio.NomeMoeda;

public interface CofrinhoInterface {
    public boolean insere (Moeda moeda);
        /* – insere uma moeda no cofrinho. Como um
        “cofrinho” tem capacidade limitada, deve retornar true se conseguiu inserir a moeda
        e false caso contrário; */
    public Moeda retira ( );
        /* – retira do cofrinho a última moeda inserida (se esta operação
        for chamada várias vezes deve ir retirando todas as moedas na ordem inversa em que
        foram inseridas). Deve retornar a moeda retirada ou “null” caso o cofrinho esteja vazio; */
    public int getQtdadeMoedas ( );
        /* – informa quantas moedas estão guardadas no cofrinho;*/
    public int getQtdadeMoedasTipo (NomeMoeda nomeMoeda);
        /* – informa quantas moedas de um certo tipo estão guardadas no cofrinho; */
    public int getValorTotalCentavos ( );
        /* – informa o valor total armazenado no cofrinho (em centavos);*/
    public double getValorTotalReais ( );
        /* – informa o valor total armazenado no cofrinho (em reais).*/
}
