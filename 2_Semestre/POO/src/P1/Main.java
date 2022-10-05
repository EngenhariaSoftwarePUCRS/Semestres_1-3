package P1;

public class Main {
    public static void main(String[] args) {
        Veiculo[] veiculos = new Veiculo[3];

        veiculos[0] = new Carro(1, 20, "Algo");
        veiculos[1] = new Moto(2, 3, "fsdlkj");
        veiculos[2] = new Bicicleta(0, 15);
    }
}