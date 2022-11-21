package RevisaoP2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Questao3 {
    private static final String[] palavras = { "Um", "Dois", "Três" };
    private static final String[] sinonimos = {
            "1", "Primeiro", "Simples",
            "2", "Segundo", "Par",
            "3", "Terceiro", "Trio" };
    private static Map<String, List<String>> dicSinonimos;

    public static void main(String[] args) {
        dicSinonimos = populaMapa();
        if (ehSinonimo("Um", "Primeiro"))
            System.out.println("É sinônimo");
        else
            System.out.println("Não é sinônimo");
    }

    public static boolean ehSinonimo(String palavra, String sinonimo) {
        for (String sin : dicSinonimos.get(palavra)) {
            if (sin.equals(sinonimo))
                return true;
        }
        return false;
    }

    // Versão 1 - Luiza
    // public static boolean ehSinonimo(String palavra, String sinonimo) {
    // // = valor da chave palavra (que é uma lista de string)
    // List<String> listaVelhaEFedida = dicSinonimos.get(palavra);
    // for (int i = 0; i < listaVelhaEFedida.size(); i++) {
    // if (listaVelhaEFedida.get(i).equals(sinonimo)) {
    // return true;
    // }
    // }
    // return false;
    // }

    private static Map<String, List<String>> populaMapa() {
        Map<String, List<String>> novoMapa = new HashMap<>();
        List<String> lista1 = new ArrayList<>();
        List<String> lista2 = new ArrayList<>();
        List<String> lista3 = new ArrayList<>();
        for (int j = 0; j < 3; j++) {
            lista1.add(sinonimos[j]);
            lista2.add(sinonimos[j + 3]);
            lista3.add(sinonimos[j + 6]);
        }
        novoMapa.put(palavras[0], lista1);
        novoMapa.put(palavras[1], lista2);
        novoMapa.put(palavras[2], lista3);
        return novoMapa;
    }
}
