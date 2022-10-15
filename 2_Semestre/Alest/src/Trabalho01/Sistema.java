package Trabalho01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sistema {
    Stack<NumeroComplexo> pilha = new Stack<>();
    int cont = 0;

    public void inicializar(String fileName) throws FileNotFoundException, NullPointerException {
        try {
            File calculos = new File(fileName);
            Scanner reader = new Scanner(calculos);
            String next;
            while (reader.hasNext()) {
                next = reader.nextLine();
                newOperation(next);
                // Linhas 454-457
                if (pilha.top().getParteReal() == 0 && pilha.top().getParteImaginaria() == 0)
                    System.out.println("Número zerado");
                if (cont == 453)
                    System.out.println("bugo na próxima");
                cont++;
            }
            reader.close();
            System.out.println("Quantidade de iterações: " + cont);
            System.out.println("Tamanho da pilha: " + pilha.size());
            System.out.println("Topo da pilha: " + pilha.top());
            System.out.println(pilha);
        } catch (FileNotFoundException fnfe) {
            throw new FileNotFoundException(
                    "Não conseguimos encontrar seu arquivo, favor reiniciar o sistema e tentar novamente.");
        }
    }

    static final String ERROR_MSG = "Não há valores disponíveis para realizar a operação.";

    void newOperation(String next) throws NullPointerException {
        NumeroComplexo a;
        NumeroComplexo b;
        if (!stackNumbers(next))
            switch (next) {
                case "+":
                    a = pop();
                    b = pop();
                    add(CalculadoraComplexo.soma(a, b), "+");
                    break;

                case "-":
                    a = pop();
                    b = pop();
                    add(CalculadoraComplexo.subtracao(a, b), "-");
                    break;

                case "*":
                    a = pop();
                    b = pop();
                    add(CalculadoraComplexo.multiplicacao(a, b), "*");
                    break;

                case "/":
                    a = pop();
                    b = pop();
                    add(CalculadoraComplexo.divisao(b, a), "/");
                    break;

                case "inv":
                    a = pop();
                    add(CalculadoraComplexo.inverso(a), "inv");
                    break;

                case "chs":
                    a = pop();
                    add(CalculadoraComplexo.changeSign(a), "chs");
                    break;

                case "conj":
                    a = pop();
                    add(CalculadoraComplexo.conjugado(a), "conj");
                    break;

                case "abs":
                    a = pop();
                    add(new NumeroComplexo(CalculadoraComplexo.absolute(a), 0), "abs");
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

    void add(NumeroComplexo n, String msg) throws NullPointerException {
        if (n != null)
            pilha.push(n);
        else
            throw new NullPointerException(
                    "Não é possível adicionar valores nulos, favor reinicar o sistema e rever valores. at: " + msg);
    }

    boolean stackNumbers(String next) {
        try {
            String[] numeros = next.split(" ");
            double parteReal = Double.parseDouble(numeros[0]);
            double parteImaginaria = Double.parseDouble(numeros[1]);
            add(new NumeroComplexo(parteReal, parteImaginaria), "stackNumbers");
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    NumeroComplexo pop() {
        return pilha.pop();
    }

    void duplica() {
        NumeroComplexo novo = new NumeroComplexo(pop());
        add(novo, "duplica");
        add(novo, "duplica");
    }

    void swap() {
        if (pilha.size() > 1) {
            NumeroComplexo aux1 = pop();
            NumeroComplexo aux2 = pop();
            add(aux1, "swap");
            add(aux2, "swap");
        } else
            System.out.println(ERROR_MSG);
    }
}
