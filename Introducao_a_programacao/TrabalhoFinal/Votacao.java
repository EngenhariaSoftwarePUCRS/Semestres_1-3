import java.util.InputMismatchException;
import java.util.Scanner;

public class Votacao {

    ListaDeCandidatos listaDeCandidatos = Main.listaDeCandidatos;
    ListaDeEleitores listaDeEleitores = Main.listaDeEleitores;

    public void iniciar() {
        int choice;
        do {
            System.out.println();
            showMenu();
            choice = inputInt();
            switch (choice) {
                case 1:
                    registrarNovoVoto();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Valor inválido!");
                    break;
            }
        } while (choice != 0);
    }

    private void registrarNovoVoto() {
        System.out.print("Digite seu número de eleitor: ");
        int numeroEleitor = inputInt();
        if (listaDeEleitores.existeNumero(numeroEleitor)) {
            Eleitor eleitorPorVotar = listaDeEleitores.getEleitor(numeroEleitor);
            if (eleitorPorVotar.getSituacao()) {
                boolean confirma;
                do {
                    System.out.println("Lista de candidatos: ");
                    System.out.println("=======================");
                    listaDeCandidatos.exibirCandidatos();
                    System.out.println();
                    Candidato candidatoPorVotar = pegarCandidato();
                    confirma = pegarConfirmacao();
                    if (confirma) {
                        candidatoPorVotar.adicionarVoto();
                        System.out.println("Sucesso! Seu voto foi registrado.");
                        eleitorPorVotar.votar();
                    }
                } while (!confirma);
            } else
                System.out.println("Infelizmente, você não está apto para votar.");
        } else
            System.out.println("Número não encontrado no sistema.");
    }

    private boolean pegarConfirmacao() {
        String escolha;
        boolean confirma = false;

        do {
            System.out.println();
            System.out.print("Confirma o voto (S/N)? ");
            escolha = inputString();
            if (escolha.equalsIgnoreCase("S"))
                confirma = true;
        } while (!(escolha.equalsIgnoreCase("S")) && !(escolha.equalsIgnoreCase("N")));

        return confirma;
    }

    private Candidato pegarCandidato() {
        Candidato candidatoPorVotar = new Candidato();
        boolean existeCandidato;
        int numeroCandidato;

        do {
            System.out.print("Digite o número do candidato: ");
            numeroCandidato = inputInt();
            existeCandidato = listaDeCandidatos.existeNumero(numeroCandidato);
            if (existeCandidato) {
                candidatoPorVotar = listaDeCandidatos.getCandidato(numeroCandidato);
                System.out.println();
                System.out.println("Candidato: ");
                System.out.println(candidatoPorVotar);
            } else
                System.out.println("Candidato não encontrado.");
        } while (!existeCandidato);

        return candidatoPorVotar;
    }

    private int inputInt() {
        Scanner input = new Scanner(System.in);
        int result = 0;

        try {
            result = input.nextInt();
        } catch (InputMismatchException e) {
            return inputInt();
        }

        return result;
    }
    
    private String inputString() {
        Scanner input = new Scanner(System.in);
        String result = "";

        try {
            result = input.nextLine();
        } catch (InputMismatchException e) {
            return inputString();
        }
        return result;
    }

    private void showMenu() {
        System.out.println("/======================\\");
        System.out.println("|\tVOTAÇÃO");
        System.out.println("|");
        System.out.println("| (1) Registrar novo voto");
        System.out.println("| (0) Voltar ao menu");
        System.out.println();
        System.out.print("Selecione sua opção: ");
    }
}