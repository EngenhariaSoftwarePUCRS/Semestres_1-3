package Data;

public class Mes {
    String nome;
    int numero;
    int quantidadeDias;

    public Mes(int numero) {
        this.numero = numero;
        switch (numero) {
            case 1:
                this.nome = "Janeiro";
                this.quantidadeDias = 31;
                break;

            case 2:
                this.nome = "Fevereiro";
                this.quantidadeDias = 28;
                break;

            case 3:
                this.nome = "Março";
                this.quantidadeDias = 31;
                break;

            case 4:
                this.nome = "Abril";
                this.quantidadeDias = 30;
                break;

            case 5:
                this.nome = "Maio";
                this.quantidadeDias = 31;
                break;

            case 6:
                this.nome = "Junho";
                this.quantidadeDias = 30;
                break;

            case 7:
                this.nome = "Julho";
                this.quantidadeDias = 31;
                break;

            case 8:
                this.nome = "Agosto";
                this.quantidadeDias = 31;
                break;

            case 9:
                this.nome = "Setembro";
                this.quantidadeDias = 30;
                break;

            case 10:
                this.nome = "Outubro";
                this.quantidadeDias = 31;
                break;

            case 11:
                this.nome = "Novembro";
                this.quantidadeDias = 30;
                break;

            case 12:
                this.nome = "Dezembro";
                this.quantidadeDias = 31;
                break;

            default:
                break;
        }
    }

    public int getNumero() {
        return this.numero;
    }

    public int getQuantidadeDias() {
        return this.quantidadeDias;
    }

    public boolean isValid(int dia) {
        if ((numero == 2) &&
                (dia > 28))
            return false;
        else {
            if ((((numero <= 7) && (numero % 2 == 0)) ||
                    ((numero > 7) && (numero % 2 == 1)))
                    && (dia > 30))
                return false;
        }

        return true;
    }

}
