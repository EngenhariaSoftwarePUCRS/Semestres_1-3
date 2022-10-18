package Trabalho01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.EmptyStackException;
import java.util.Scanner;

import Trabalho01.util.Stack;

public class Sistema {
    private Stack<NumeroComplexo> pilha;
    private NumeroComplexo smallestNumber;
    private NumeroComplexo biggestNumber;
    private int biggestSize;
    private int cont;

    public Sistema() {
        pilha = new Stack<>();
        smallestNumber = new NumeroComplexo();
        biggestNumber = new NumeroComplexo();
    }

    public void inicializar() {
        File file = getFile();
        main(file);
        if (repetir()) {
            pilha = new Stack<>();
            smallestNumber = new NumeroComplexo();
            biggestNumber = new NumeroComplexo();
            biggestSize = 0;
            cont = 0;
            inicializar();
        }
    }

    private File getFile() {
        String filePath;
        File file;
        Scanner input = new Scanner(System.in);

        do {
            System.out.print("\nDigite o local/nome.txt do arquivo que deseja ler: ");
            filePath = input.nextLine();
            file = new File(filePath);
            if (!file.exists())
                System.out.println("Não foi possível encontrar seu arquivo( " + file + " ).\nTente novamente\n");
        } while (!file.exists());

        return file;
    }

    void main(File file) {
        String next = "";
        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNext()) {
                next = reader.nextLine();
                cont++;

                System.out.println("\nnewOperation(" + next + ")");
                if ("quit".equalsIgnoreCase(next))
                    break;

                newOperation(next);

                if (!pilha.isEmpty()) {
                    System.out.print("Pilha: " + pilha);

                    if (biggestNumber.compareTo(top()) < 0)
                        biggestNumber = top();

                    if (smallestNumber.compareTo(top()) > 0)
                        smallestNumber = top();

                    if (size() > biggestSize)
                        biggestSize = size();

                } else
                    System.out.println("Pilha vazia");
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("Erro na leitura de arquivo.\nFavor reiniciar o programa.");
        } catch (NullPointerException npe) {
            System.out.println(
                    "Não é possível adicionar valores nulos, favor reinicar o sistema e rever valores. at: " + next);
        } catch (EmptyStackException ese) {
            System.out.println("Pilha Vazia");
        } catch (ArithmeticException ae) {
            System.out.println(ae.getMessage());
        } catch (Exception e) {
            System.out.println("Unknown exception: " + e);
        } finally {
            System.out.println("\n\t===== RESULTADOS =====");
            System.out.println("|= Tamanho máximo da pilha: " + biggestSize);
            System.out.println("|= Tamanho final da pilha: " + size());
            System.out.println("|= Topo da pilha: " + top());
            System.out.println("\t=== EXTRAS ===");
            System.out.println("|= Quantidade de iterações: " + cont);
            System.out.println("|= Menor número encontrado: " + smallestNumber);
            System.out.println("|= Maior número encontrado: " + biggestNumber);
            System.out.println("\nObrigado por utilizar o programa!\n");
        }
    }

    private boolean repetir() {
        Scanner input = new Scanner(System.in);
        String repetir;

        do {
            System.out.print("\nDeseja executar novamente? (s/N): ");
            repetir = input.nextLine();
        } while (!(repetir.equalsIgnoreCase("s")) && !(repetir.equalsIgnoreCase("N")));

        return "s".equalsIgnoreCase(repetir);
    }

    private void newOperation(String next) {
        NumeroComplexo a;
        NumeroComplexo b;
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
                    try {
                        add(CalculadoraComplexo.divisao(a, b));
                    } catch (ArithmeticException ae) {
                        add(b);
                        add(a);
                        throw ae;
                    }
                    break;

                case "inv":
                    a = pop();
                    try {
                        add(CalculadoraComplexo.inverso(a));
                    } catch (ArithmeticException ae) {
                        add(a);
                        throw ae;
                    }
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

                case "":
                case " ":
                    break;

                default:
                    System.out.println("Operação (" + next + ") inválida.");
                    break;
            }
    }

    private void add(NumeroComplexo n) {
        if (n != null)
            pilha.push(n);
        else
            throw new NullPointerException();
    }

    private boolean stackNumbers(String next) {
        try {
            String[] numeros = next.split(" ");
            double parteReal = Double.parseDouble(numeros[0]);
            double parteImaginaria = Double.parseDouble(numeros[1]);
            add(new NumeroComplexo(parteReal, parteImaginaria));
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    private NumeroComplexo pop() {
        return pilha.pop();
    }

    private void duplica() {
        NumeroComplexo novo = new NumeroComplexo(pop());
        add(novo);
        add(novo);
    }

    private void swap() {
        if (size() > 1) {
            NumeroComplexo aux1 = pop();
            NumeroComplexo aux2 = pop();
            add(aux1);
            add(aux2);
        } else
            System.out.println("Não há valores disponíveis para realizar a operação swap().");
    }

    private NumeroComplexo top() {
        return pilha.top();
    }

    private int size() {
        return pilha.size();
    }
}
