package Trabalho01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sistema {
    Stack<NumeroComplexo> pilha = new Stack<>();

    public void inicializar(String fileName) throws FileNotFoundException {
        try {
            File calculos = new File(fileName);
            Scanner reader = new Scanner(calculos);
            String next;
            while (reader.hasNext()) {
                next = reader.nextLine();
                newOperation(next);
            }
            reader.close();
        } catch (FileNotFoundException fnfe) {
            throw new FileNotFoundException();
        }
    }

    static final String ERROR_MSG = "Não há valores disponíveis para realizar a operação.";

    void newOperation(String next) {
        NumeroComplexo a, b;
        if (!stackNumbers(next))
            switch (next) {
                case "+":
                    a = pop();
                    b = pop();
                    add(CalculadoraComplexo.soma(a, b));
                    break;

                case "-":
                    a = pop();
                    b = pop();
                    add(CalculadoraComplexo.subtracao(a, b));
                    break;

                case "*":
                    a = pop();
                    b = pop();
                    add(CalculadoraComplexo.multiplicacao(a, b));
                    break;

                case "/":
                    a = pop();
                    b = pop();
                    add(CalculadoraComplexo.divisao(a, b));
                    break;

                case "inv":
                    a = pop();
                    add(CalculadoraComplexo.inverso(a));
                    break;

                case "chs":
                    a = pop();
                    add(CalculadoraComplexo.changeSign(a));
                    break;

                case "conj":
                    a = pop();
                    add(CalculadoraComplexo.conjugado(a));
                    break;

                case "abs":
                    a = pop();
                    add(new NumeroComplexo(CalculadoraComplexo.absolute(a), 0));
                    break;

                case "pop":
                    pop();
                    break;

                case "dup":
                    duplica();
                    break;

                case "swap":
                    swap();
                    break;

                default:
                    System.out.println("Operação (" + next + ") inválida.");
                    break;
            }
    }

    void add(NumeroComplexo n) {
        pilha.push(n);
    }

    boolean stackNumbers(String next) {
        try {
            String[] numeros = next.split(" ");
            double parteReal = Double.parseDouble(numeros[0]);
            double parteImaginaria = Double.parseDouble(numeros[1]);
            add(new NumeroComplexo(parteReal, parteImaginaria));
            return true;
        } catch (NumberFormatException nfe) {
            System.out.println(nfe);
            return false;
        }
    }

    NumeroComplexo pop() {
        return pilha.pop();
    }

    void duplica() {
        NumeroComplexo novo = new NumeroComplexo(pop());
        pilha.add(novo);
        pilha.add(novo);
    }

    void swap() {
        if (pilha.size() > 1) {
            NumeroComplexo aux1 = pop();
            NumeroComplexo aux2 = pop();
            pilha.add(aux2);
            pilha.add(aux1);
        } else
            System.out.println(ERROR_MSG);
    }
}
