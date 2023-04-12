package Trabalho01;

public class Monkey {
    private int id;
    private int evenTarget;
    private int oddTarget;
    private long evenCoconuts;
    private long oddCoconuts;

    public Monkey(int id, int evenTarget, int oddTarget, long evenCoconuts, long oddCoconuts) {
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

    public void receiveEvenCoconut(long coconutAmount) {
        this.evenCoconuts += coconutAmount;
    }

    public void receiveOddCoconut(long coconutAmount) {
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

    public long getCoconuts() {
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
