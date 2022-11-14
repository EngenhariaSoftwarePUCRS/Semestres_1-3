package Aula19.Exemplo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class App {
    public static void main(String args[]){
        Agenda a = new Agenda();
        a.add(new ItemAgenda("Zezinho","94763221"));
        a.add(new ItemAgenda("Fulano","94763221"));
        a.add(new ItemAgenda("Sicrano","94763221"));

        for(ItemAgenda i:a){
            System.out.println(i);
        }
    }
}