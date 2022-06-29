import java.util.InputMismatchException;
import java.util.Scanner;

public class Votacao {

    private ListaDeCandidatos listaDeCandidatos;
    private ListaDeEleitores listaDeEleitores;
    private int quantidadeVotosValidos;
    private int quantidadeVotosNulos;
    private int quantidadeVotos;
    private boolean situacao;

    public Votacao(ListaDeCandidatos listaDeCandidatos, ListaDeEleitores listaDeEleitores) {
        this.listaDeCandidatos = listaDeCandidatos;
        this.listaDeEleitores = listaDeEleitores;
        this.situacao = true;
    }

    public int getQuantidadeVotosValidos() {
        return this.quantidadeVotosValidos;
    }

    private double getPorcentagemVotosValidos() {
        if (this.quantidadeVotos == 0)
            return 0;
        return Math.round(this.quantidadeVotosValidos / (double) this.quantidadeVotos * 100);
    }

    public int getQuantidadeVotosNulos() {
        return this.quantidadeVotosNulos;
    }

    private double getPorcentagemVotosNulos() {
        if (this.quantidadeVotos == 0)
            return 0;
        return Math.round(this.quantidadeVotosNulos / (double) this.quantidadeVotos * 100);
    }

    public int getQuantidadeVotos() {
        return this.quantidadeVotos;
    }

    public boolean getSituacao() {
        return this.situacao;
    }

    public String toString() {
        return ("\nVotos Válidos:  " + this.quantidadeVotosValidos +
                "\t(" + this.getPorcentagemVotosValidos() + "%)" +
                "\nVotos Nulos:    " + this.quantidadeVotosNulos +
                "\t(" + this.getPorcentagemVotosNulos() + "%)" +
                "\nTotal de votos: " + this.quantidadeVotos +
                "\t(" + 100 + "%)");
    }

    public void iniciar() {
        if (situacao) {
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
        } else
            System.out.println("Esta votação já foi encerrada.");
    }

    public void encerrar() {
        if (situacao)
            this.situacao = false;
        else
            System.out.println("Esta votação já foi encerrada.");
        System.out.println("Votação encerrada.");
    }

    private void registrarNovoVoto() {
        System.out.print("Digite seu número de eleitor: ");
        int numeroEleitor = inputInt();
        // Se o código do eleitor existe
        if (listaDeEleitores.existeNumero(numeroEleitor)) {
            Eleitor eleitorPorVotar = listaDeEleitores.getEleitor(numeroEleitor);
            // Se o eleitor estiver apto a votar e ainda não votou
            if ((eleitorPorVotar.getSituacao()) && !(eleitorPorVotar.getJaVotou())) {
                System.out.println("Olá, " + eleitorPorVotar.getPrimeiroNome());
                boolean confirma = false;
                while (!confirma) {
                    System.out.println();
                    System.out.println("/=======================\\");
                    System.out.println("| Lista de candidatos: ");
                    listaDeCandidatos.listarCandidatos();
                    System.out.println();
                    System.out.print("Digite o número do candidato: ");
                    int numeroCandidato = inputInt();
                    // Se o código de candidato existe
                    if (listaDeCandidatos.existeNumero(numeroCandidato)) {
                        Candidato candidatoPorVotar = listaDeCandidatos.getCandidato(numeroCandidato);
                        System.out.println();
                        System.out.print("Candidato: ");
                        System.out.println(candidatoPorVotar.getNome());
                        System.out.print("Partido: ");
                        System.out.println(candidatoPorVotar.getPartido());
                        confirma = pegarConfirmacao();
                        if (confirma)
                            registrarVoto(candidatoPorVotar, eleitorPorVotar);
                    } else {
                        System.out.println("Candidato não encontrado.");
                        System.out.println("Seu voto foi computado como nulo.");
                        this.quantidadeVotosNulos++;
                        this.quantidadeVotos++;
                        break;
                    }
                }
                // Se o eleitor não estiver apto a votar
            } else
                System.out.println(
                        "Infelizmente, você não está apto para votar ou um voto já foi registrado em seu nome.");
            // Se o código do eleitor não existe
        } else
            System.out.println("Número não encontrado no sistema.");
    }

    private void registrarVoto(Candidato candidatoPorVotar, Eleitor eleitorPorVotar) {
        candidatoPorVotar.adicionarVoto();
        eleitorPorVotar.votar();
        this.quantidadeVotosValidos++;
        this.quantidadeVotos++;
        System.out.println("Sucesso! Seu voto foi registrado.");
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

    private int inputInt() {
        Scanner input = new Scanner(System.in);
        try {
            return input.nextInt();
        } catch (InputMismatchException e) {
            return inputInt();
        }
    }

    private String inputString() {
        Scanner input = new Scanner(System.in);
        try {
            return input.nextLine();
        } catch (InputMismatchException e) {
            return inputString();
        }
    }

    private void showMenu() {
        System.out.println("/========================\\");
        System.out.println("|\tVOTAÇÃO");
        System.out.println("|");
        System.out.println("| (1) Registrar novo voto");
        System.out.println("| (0) Voltar ao menu");
        System.out.println();
        System.out.print("Selecione sua opção: ");
    }

}