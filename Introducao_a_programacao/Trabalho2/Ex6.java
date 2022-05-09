public class Ex6
{
    public static void main() {
        int valorEstacionamento = 6;
        int valorPacote = 81;
        int valorRecebido = 90;
        int vezesEstacionadas = valorRecebido / valorEstacionamento;
        
        System.out.println("A cada "+vezesEstacionadas+" idas ao estacionamento individuais, se tu tivesse comprado direto um pacote de "+valorPacote+" reais, tu teria economizado "+(valorRecebido-valorPacote)+" reais.");
        System.out.println("Ou seja; a cada 2 mêses tu ganharia 3 estacionamentos de graça");
        System.out.println("Ou, pensando pelo lado humano, já que a carona equivale a um estacionamento, a cada dois mêses três pessoas teriam um trajeto de brinde.");
    }
}
