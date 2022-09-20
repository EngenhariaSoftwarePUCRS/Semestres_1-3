package Atividade2;

public abstract class ElementoTrem {
    protected int identificador;
    protected double capacidadeCarga;
    protected Trem trem;
    
    public ElementoTrem(int identificador, double capacidadeCarga) {
        this.identificador = identificador;
        this.capacidadeCarga = capacidadeCarga;
        this.trem = null;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    public Trem getTrem() {
        return trem;
    }

    public void setTrem(Trem trem) {
        this.trem = trem;
    }

    public boolean livre() {
        return trem == null;
    }

    public String toString() {
        return "ElementoTrem capacidadeCarga=" + capacidadeCarga + ", identificador=" + identificador + ", trem=" + trem + "]";
    }
}
