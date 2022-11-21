package Aula19.Material_Apoio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CadastroUsuarios implements Iterable<Usuario> {
    private List<Usuario> users;

    private static void inicializa(List<Usuario> lst,String fName)throws IOException{
        File file = new File(fName);
        Scanner s = new Scanner(file);
        String line = s.nextLine();
        while(s.hasNextLine()){
            line = s.nextLine();
            StringTokenizer st = new StringTokenizer(line,",");
            int id = Integer.parseInt(st.nextToken());
            String nome = st.nextToken();
            String sobrenome = st.nextToken();
            String email = st.nextToken();
            String sexo = st.nextToken();
            String ip = st.nextToken();
            Usuario u = new Usuario(id,nome,sobrenome,email,sexo,ip);
            lst.add(u);
        }
    }

    public CadastroUsuarios() throws IOException{
        users = new LinkedList<>();
        inicializa(users,"pessoas.txt");
    }

    @Override
    public Iterator<Usuario> iterator() {
        return users.iterator();
    }

    /**
     * Remover todos os usuários cujo endereço ip comece por um número indicado
retornando à quantidade de removidos (explorando iteradores)
     */
    public int removeAll(String ip) {
        int qtdRemovidos = 0;

        for (int i = 0; iterator().hasNext(); i++) {
            if (users.get(i).getIp().startsWith(ip)) {
                users.set(i, null);
                qtdRemovidos++;
            }
        }

        return qtdRemovidos;
    }

}