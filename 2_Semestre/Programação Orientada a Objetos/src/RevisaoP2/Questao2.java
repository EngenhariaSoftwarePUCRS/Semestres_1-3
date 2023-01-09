package RevisaoP2;

import java.util.ArrayList;
import java.util.List;

public class Questao2 {
    public static void main(String[] args) {
        List<Integer> arr1 = populaLista(new ArrayList<>(), 1, 3, 1);
        List<Integer> arr2 = populaLista(new ArrayList<>(), 7, 9, 1);
        List<Integer> nova = intercala(arr1, arr2);
        printResult(nova);
    }

    public static List<Integer> intercala(List<Integer> arr1, List<Integer> arr2) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arr1.size(); i++) {
            list.add(arr1.get(i));
            list.add(arr2.get(i));
        }
        return list;
    }

    // public static List<Integer> intercala(List<Integer> arr1, List<Integer> arr2)
    // {
    // List<Integer> nova = new ArrayList<>();
    // for (int i = 0; i < arr1.size(); i++) {
    // nova.add(arr1.get(i));
    // nova.add(arr2.get(i));
    // }
    // return nova;
    // }

    // Versão 1 - Luiza
    // public static List<Integer> intercala(List<Integer> arr1, List<Integer> arr2)
    // {
    // List<Integer> intercala = new ArrayList<Integer>(); // Lista não é uma
    // classe, é uma interface,
    // // logo precisa escolher uma lista do Java para usar,
    // // ou criar sua própria
    // // intercala.add(arr1.get(0));

    // for (int i = 0; i < arr1.size(); i++) {
    // intercala.add(arr1.get(i));
    // intercala.add(arr2.get(i));
    // }
    // return intercala;
    // }

    private static List<Integer> populaLista(ArrayList<Integer> arr, int min, int max, int step) {
        for (int i = min; i <= max; i += step)
            arr.add(i);
        return arr;
    }

    private static void printResult(List<Integer> list) {
        String result = "[ ";
        for (Integer i : list)
            result += (i + ", ");
        // Remove alst comma from result and add closing square brackets
        result = result.substring(0, result.length() - 2) + " ]";
        System.out.println(result);
    }
}
