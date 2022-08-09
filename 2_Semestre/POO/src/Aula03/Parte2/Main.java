package Aula03.Parte2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import Aula03.Parte2.Material_Apoio.Placa;
import Aula03.Parte2.Material_Apoio.Veiculo;

/*
    * 1. Do jeito que foi projetada, a classe “Veiculo” modela um veículo cujo tanque de combustível
    tem capacidade infinita. Altere a classe “Veiculo” de maneira que o tanque de combustível
    passe a ter uma capacidade finita.
    2. Reescreva o método “main” de maneira que o mesmo receba pelos argumentos da linha de
    comando a placa do veículo, a quantidade de combustível que o mesmo deve ser abastecido
    e a distância que ele deve percorrer e imprima: os dados do veículo, a distância efetivamente
    percorrida (com o combustível disponível) e o combustível remanescente no tanque. Faça
    consistência sobre a quantidade e o tipo dos parâmetros informados exibindo uma
    mensagem adequada se for o caso.
    3. Reescreva o método “main” da seguinte forma: crie um arranjo e armazene no mesmo 5
    veículos diferentes. Apresente para o usuário um menu com três opções: “1) Abastecer”, “2)
    dirigir” e “3) Fim”. A opção 1 solicita a placa do veículo a ser abastecido e a quantidade de
    combustível e, ao final da operação, exibe na tela a quantidade total de combustível no
    veículo após o abastecimento. A opção 2 solicita a placa do veículo que o usuário pretende
    dirigir e a distância a ser percorrida e, ao final da operação, imprime na tela a distância
    efetivamente percorrida e a quantidade de combustível remanescente no tanque. Tanto a
    opção 1 como a opção 2 devem exibir a mensagem “Veiculo não encontrado” caso a placa
    informada não conste do cadastro (arranjo). A opção 3 deve imprimir os dados de todos os
    veículos cadastrados e encerrar o programa.
    4. Escreva um novo código para o método “main”: crie uma instancia da classe “Placa” e informe
    a esta mesma placa para duas instancias de “Veiculo”. Exiba na tela as informações de cada
    veículo a partir do método “toString”. Em seguida, usando o método “setPais” da classe
    “Veiculo”, altere o país do segundo veículo e imprima novamente as informações dos dois
    veículos. Explique: por que as informações de ambos os veículos foram alteradas?
 */

public class Main {
    
    public static void main(String[] args) {
        System.out.print("Escolha a questão (2-4): ");
        int escolha = inputInt();
        switch (escolha) {
            case 2:
                mainDois();
                break;

            case 3:
                mainTres();
                break;

            case 4:
                mainQuatro();
                break;

            default:
                main(args);
        }
    }
    
    private static void mainDois() {
        String pais = "Brasil";
        String codigo = "JBA8C53";
        Double litros = Double.parseDouble("70");
        Double distancia = Double.parseDouble("680");
        Placa placa = new Placa(pais, codigo);
        Veiculo veiculo = new Veiculo(placa);
        veiculo.abastece(litros);
        System.out.println(veiculo);
        System.out.println(veiculo.dirige(distancia));
        System.out.println(veiculo);
    }
    
    private static void mainTres() {
        Veiculo[] veiculos = new Veiculo[5];
        for (int i = 0; i < veiculos.length; i++) {
            String codigo = generateRandomCodigo();
            veiculos[i] = new Veiculo(new Placa("Brasil", codigo));
        }
        for (Veiculo veiculo : veiculos) {
            System.out.println(veiculo);
        }
        int escolha;
        String codigo;
        boolean encontrado;
        do {
            displayMenu();
            escolha = new Scanner(System.in).nextInt();
            switch (escolha) {
                case 1:
                    // Abastecer
                    // System.out.print("País da placa: ");
                    // String pais = inputString();
                    System.out.print("Código da placa: ");
                    codigo = inputString();
                    encontrado = false;
                    for (Veiculo veiculo : veiculos) {
                        if (codigo.equals(veiculo.getPlaca().getCodigo())) {
                            encontrado = true;
                            System.out.print("Litros por abastecer: ");
                            double litrosPorAbastecer = inputDouble();
                            veiculo.abastece(litrosPorAbastecer);
                            System.out.println("Combustível no tanque: "+veiculo.getCombustivelNoTanque());
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Veículo não encontrado. Favor reiniciar o sistema.");
                    }
                    break;
            
                case 2:
                    // Dirigir
                    // System.out.print("País da placa: ");
                    // String pais = inputString();
                    System.out.print("Código da placa: ");
                    codigo = inputString();
                    encontrado = false;
                    for (Veiculo veiculo : veiculos) {
                        if (codigo.equals(veiculo.getPlaca().getCodigo())) {
                            encontrado = true;
                            System.out.print("Distância por percorrer: ");
                            double distanciaPorPercorrer = inputDouble();
                            System.out.println("Distância percorrida: " + veiculo.dirige(distanciaPorPercorrer));
                            System.out.println("Combustível no tanque: " + veiculo.getCombustivelNoTanque());
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Veículo não encontrado. Favor reiniciar o sistema.");
                    }
                    break;
        
                case 3:
                    // Fim
                    for (Veiculo veiculo : veiculos) {
                        System.out.println(veiculo);
                    }
                    System.out.println("Obrigado por utilizar!");
                    break;
            
                default:
                    mainTres();
            }
        } while (escolha != 3);
        
    }

    private static void mainQuatro() {
        Placa placa = new Placa("Brasil", generateRandomCodigo());
        Veiculo veiculo1 = new Veiculo(placa);
        Veiculo veiculo2 = new Veiculo(placa);
        System.out.println(veiculo1);
        System.out.println(veiculo2);
        veiculo2.setPais("Argentina");
        System.out.println(veiculo1);
        System.out.println(veiculo2);
        System.out.println("Foram alteradas as informações de ambos os veículos pois ambos compartilham da mesma exata placa, e o que foi alterado foi a placa.");
    }

    private static String generateRandomCodigo() {
        char[] letras = {(char)(new Random().nextInt(90 - 65) + 65), (char)(new Random().nextInt(90 - 65) + 65), (char)(new Random().nextInt(90 - 65) + 65), (char)(new Random().nextInt(90 - 65) + 65)};
        int[] numeros = {new Random().nextInt(9), new Random().nextInt(9), new Random().nextInt(9)};
        String codigo = "" + letras[0] + letras[1] + letras[2] + numeros[0] + letras[3] + numeros[1] + numeros[2];
        return codigo;
    }

    private static void displayMenu() {
        System.out.println("/=====================\\");
        System.out.println("| (1) Abastecer ");
        System.out.println("| (2) Dirigir ");
        System.out.println("| (3) Fim ");
        System.out.println("\\=====================/");
    }

    private static int inputInt() {
        try {
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException ime) {
            return inputInt();
        }
    }

    private static double inputDouble() {
        try {
            return new Scanner(System.in).nextDouble();
        } catch (InputMismatchException ime) {
            return inputDouble();
        }
    }

    private static String inputString() {
        try {
            return new Scanner(System.in).nextLine();
        } catch (InputMismatchException ime) {
            return inputString();
        }
    }
}