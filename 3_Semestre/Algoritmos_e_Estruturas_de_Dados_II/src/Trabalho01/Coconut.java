package Trabalho01;

public class Coconut {
    private int stonesAmount;

    public Coconut(int stonesAmount) {
        this.stonesAmount = stonesAmount;
    }

    public int getStonesAmount() {
        return stonesAmount;
    }

    public void setStonesAmount(int stonesAmount) {
        this.stonesAmount = stonesAmount;
    }

    @Override
    public String toString() {
        return " " + stonesAmount;
    }
}
