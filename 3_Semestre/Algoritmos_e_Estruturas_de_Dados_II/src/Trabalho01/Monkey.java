package Trabalho01;

import java.util.Arrays;

public class Monkey {
    private int id;
    private int evenTarget;
    private int oddTarget;
    private Coconut[] coconuts;

    public Monkey(int id, int evenTarget, int oddTarget, Coconut[] coconuts) {
        this.id = id;
        this.evenTarget = evenTarget;
        this.oddTarget = oddTarget;
        this.coconuts = coconuts;
    }

    public int getId() {
        return id;
    }

    public int getEvenTarget() {
        return evenTarget;
    }

    public int getOddTarget() {
        return oddTarget;
    }

    public Coconut[] getCoconuts() {
        return coconuts;
    }

    @Override
    public String toString() {
        String stringifiedMonkey = "Macaco " + id +
                " par -> " + evenTarget +
                " impar -> " + oddTarget +
                " : " + coconuts.length + " :";
        for (Coconut coconut : coconuts)
            stringifiedMonkey += coconut;
        return stringifiedMonkey;
    }
}
