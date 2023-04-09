package Trabalho01;

import java.util.List;

public class Monkey {
    private int id;
    private int evenTarget;
    private int oddTarget;
    private List<Coconut> coconuts;

    public Monkey(int id, int evenTarget, int oddTarget, List<Coconut> coconuts) {
        this.id = id;
        this.evenTarget = evenTarget;
        this.oddTarget = oddTarget;
        this.coconuts = coconuts;
    }

    public void throwCoconuts(Monkey evenTarget, Monkey oddTarget) {
        for (int i = 0; i < coconuts.size(); i++) {
            Coconut coconut = coconuts.get(0);
            int stonesInCoconut = coconut.getStonesAmount();
            if (stonesInCoconut % 2 == 0)
                evenTarget.receiveCoconut(coconut);
            else
                oddTarget.receiveCoconut(coconut);
            coconuts.remove(coconut);
        }
    }

    public void receiveCoconut(Coconut coconut) {
        this.coconuts.add(coconut);
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

    public List<Coconut> getCoconuts() {
        return coconuts;
    }

    @Override
    public String toString() {
        String stringifiedMonkey = "Macaco " + id +
                " par -> " + evenTarget +
                " impar -> " + oddTarget +
                " : " + coconuts.size() + " :";
        for (Coconut coconut : coconuts)
            stringifiedMonkey += coconut;
        return stringifiedMonkey;
    }
}
