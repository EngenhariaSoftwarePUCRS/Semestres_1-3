package Trabalho01;

public class Monkey {
    private int id;
    private int evenTarget;
    private int oddTarget;
    private int evenCoconuts;
    private int oddCoconuts;

    public Monkey(int id, int evenTarget, int oddTarget, int evenCoconuts, int oddCoconuts) {
        this.id = id;
        this.evenTarget = evenTarget;
        this.oddTarget = oddTarget;
        this.evenCoconuts = evenCoconuts;
        this.oddCoconuts = oddCoconuts;
    }

    public void throwCoconuts(Monkey evenTarget, Monkey oddTarget) {
        evenTarget.receiveEvenCoconut(evenCoconuts);
        this.evenCoconuts = 0;
        oddTarget.receiveOddCoconut(oddCoconuts);
        this.oddCoconuts = 0;
    }

    public void receiveEvenCoconut(int coconutAmount) {
        this.evenCoconuts += coconutAmount;
    }

    public void receiveOddCoconut(int coconutAmount) {
        this.oddCoconuts += coconutAmount;
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

    public int getCoconuts() {
        return evenCoconuts + oddCoconuts;
    }

    @Override
    public String toString() {
        return "Macaco " + id +
                " par -> " + evenTarget +
                " impar -> " + oddTarget +
                " cocos com número par de pedrinhas -> " + evenCoconuts +
                " cocos com número ímpar de pedrinhas -> " + oddCoconuts;
    }
}
