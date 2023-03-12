package TrabalhoFinal_TabelaJogos;

import TrabalhoFinal_TabelaJogos.Date.Mes;

public class Data {

    private int minuto;
    private int hora;
    private int dia;
    private Mes mes;

    public Data() {
        this.minuto = 00;
        this.hora = 00;
        this.dia = 01;
        this.mes = new Mes(1);
    }

    public Data(int minuto, int hora, int dia, int mes) {
        this.minuto = minuto;
        this.hora = hora;
        this.dia = dia;
        this.mes = new Mes(mes);
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = new Mes(mes);
    }

    public int getMinuto() {
        return minuto;
    }

    public int getHora() {
        return hora;
    }

    public int getDia() {
        return dia;
    }

    public Mes getMes() {
        return mes;
    }

    public boolean isValid() {
        if ((minuto < 0) || (minuto > 59))
            return false;

        if ((hora < 0) || (hora > 23))
            return false;

        if ((dia < 1) || (dia > 31))
            return false;

        if (!mes.isValid(dia))
            return false;

        return true;
    }

    public String toString() {
        return (dia + "/" + mes +
                "\t" + hora + ":" + minuto);
    }
}
