package Aula01;
public class Aula01 {
    public static void main(String[] args) {
        CaixaRegistradora caixa = new CaixaRegistradora();
        // Adiciona três itens
        caixa.addItem(1.99);
        caixa.addItem(2.99);
        caixa.addItem(1.50);
        System.out.println(caixa.getTotal()); // Saída: 6,48
        System.out.println(caixa.getNumItens()); // Saída: 3
        caixa.limpa();
        System.out.println(caixa.getTotal()); // Saída: 0
        System.out.println(caixa.getNumItens()); // Saída: 0
    }
}