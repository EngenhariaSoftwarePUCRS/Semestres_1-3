public class Data {

    private int mes;
    private int dia;
    private int hora;
    private int minuto;

    public Data() {
        this.mes = 01;
        this.dia = 01;
        this.hora = 00;
        this.minuto = 00;
    }

    public Data(int mes, int dia, int hora, int minuto) {
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.minuto = minuto;
    }

    public void setMes(int mes){
        this.mes = mes;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public int getMes() {
        return mes;
    }

    public int getDia() {
        return dia;
    }

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public boolean validarData() {
        boolean valido = true;
        
        if (
            (mes < 1 || mes > 12) ||
            (dia < 1 || dia > 31) ||
            (hora < 0 || hora > 23) ||
            (minuto < 0 || minuto > 59)
        ) valido = false;

        return valido;
    }

    public String toString() {
        return (
            "\nData =" +
            "\t" + dia + "/" + mes +
            "\t" + hora + ":" + minuto
        );
    }
}
