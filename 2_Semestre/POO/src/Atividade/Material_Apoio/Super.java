import java.util.ArrayList;
import java.util.Arrays;

public class Super {
    private GaragemLocomotivas garagemLocomotivas;
    private ArrayList<Locomotiva> locomotivas;
    private GaragemVagoes garagemVagoes;
    private ArrayList<Vagao> vagoes;
    private PatioDeManobras patioDeManobras;

    public Super() {
        garagemLocomotivas = new GaragemLocomotivas();
        locomotivas = new ArrayList<>(Arrays.asList(
                new Locomotiva(1, 2500, 50),
                new Locomotiva(2, 2500, 50),
                new Locomotiva(3, 2500, 50),
                new Locomotiva(4, 2500, 50),
                new Locomotiva(5, 2500, 50),
                new Locomotiva(6, 2500, 50)));
        for (Locomotiva l : locomotivas) {
            garagemLocomotivas.adicionaGaragem(l);
        }

        garagemVagoes = new GaragemVagoes();
        vagoes = new ArrayList<>(Arrays.asList(
                new Vagao(1, 50),
                new Vagao(2, 50),
                new Vagao(3, 50),
                new Vagao(4, 50),
                new Vagao(5, 50),
                new Vagao(6, 50)));
        for (Vagao v : vagoes) {
            garagemVagoes.adicionaGaragem(v);
        }

        patioDeManobras = new PatioDeManobras();
    }

    public GaragemLocomotivas getGaragemLocomotivas() {
        return garagemLocomotivas;
    }

    public ArrayList<Locomotiva> getLocomotivas() {
        return locomotivas;
    }

    public GaragemVagoes getGaragemVagoes() {
        return garagemVagoes;
    }

    public ArrayList<Vagao> getVagoes() {
        return vagoes;
    }

    public PatioDeManobras getPatioDeManobras() {
        return patioDeManobras;
    }

    public void criarTrem() {
        System.out.println("(1) Criando trem");
        int idTrem = pedirIdentificador();
        Trem novoTrem = new Trem(idTrem);
        System.out.println("Locomotivas: ");
        for (int i = 0; i < garagemLocomotivas.qtdade(); i++) {
            System.out.println(garagemLocomotivas.getPorPosicao(i));
        }
        System.out.print("Digite o identificador da primeira locomotiva: ");
        int idLocomotiva = Inputs.inputInt();
        Locomotiva novaLocomotiva = garagemLocomotivas.getPorId(idLocomotiva);
        novoTrem.engataLocomotiva(novaLocomotiva);
        novaLocomotiva.setTrem(novoTrem);
        patioDeManobras.adicionaPatio(novoTrem);
        System.out.println("Trem criado com sucesso e inserido no pátio!");
    }

    public Trem editarTrem() {
        System.out.println("(2) Editar trem");
        System.out.println("Trens no pátio: ");
        listarTrens();
        int idTrem = pedirIdentificador();
        return patioDeManobras.getPorId(idTrem);
    }

    public void editarTremInserirLocomotiva(Trem tremPorEditar) {
        System.out.println("(2.1) Inserir locomotiva");
        System.out.println("Locomotivas: ");
        for (int i = 0; i < garagemLocomotivas.qtdade(); i++) {
            System.out.println(garagemLocomotivas.getPorPosicao(i));
        }
        System.out.print("Digite o identificador da locomotiva: ");
        Locomotiva locomotivaPorAdicionar = garagemLocomotivas.getPorId(Inputs.inputInt());
        if (locomotivaPorAdicionar == null)
            System.out.println("Locomotiva inexistente, favor tentar novamente.");
        else {
            if (tremPorEditar.getQtdadeVagoes() == 0) {
                if (locomotivaPorAdicionar.livre()) {
                    tremPorEditar.engataLocomotiva(locomotivaPorAdicionar);
                    locomotivaPorAdicionar.setTrem(tremPorEditar);
                    System.out.println("Locomotiva adicionada com sucesso.");
                } else
                    System.out.println("Locomotiva indisponível!");
            } else
                System.out.println("Não é possível adicionar locomotivas após vagões.\nFavor remover vagões antes de tentar novamente.");
        }
    }

    public void editarTremInserirVagao(Trem tremPorEditar) {
        System.out.println("(2.2) Inserir vagao");
        System.out.println("Vagões: ");
        for (int i = 0; i < garagemVagoes.qtdade(); i++) {
            System.out.println(garagemVagoes.getPorPosicao(i));
        }
        System.out.print("Digite o identificador do vagão: ");
        Vagao vagaoPorAdicionar = garagemVagoes.getPorId(Inputs.inputInt());
        if (vagaoPorAdicionar == null)
            System.out.println("Vagão inexistente, favor tentar novamente.");
        else {
            if (vagaoPorAdicionar.livre()) {
                tremPorEditar.engataVagao(vagaoPorAdicionar);
                vagaoPorAdicionar.setTrem(tremPorEditar);
                System.out.println("Vagao adicionado com sucesso.");
            } else
                System.out.println("Esse vagão já está sendo utilizado.");
        }
    }

    public void editarTremRemoverUltimo(Trem tremPorEditar) {
        if (tremPorEditar.getQtdadeVagoes() > 0) {
            if (tremPorEditar.desengataVagao())
                System.out.println("Vagão desengatado com sucesso!");
            else
                System.out.println("Não há vagões para desengatar.");
        } else {
            if (tremPorEditar.desengataLocomotiva())
                System.out.println("Locomotiva desengatada com sucesso!");
            else
                System.out.println("Não foi possível remover a locomotiva.");
        }
    }

    public void editarTremListarLocomotivasLivres(Trem tremPorEditar) {
        for (Locomotiva locomotiva : locomotivas) {
            if (locomotiva.livre())
                System.out.println(locomotiva);
        }
    }

    public void editarTremListarVagoesLivres(Trem tremPorEditar) {
        for (Vagao vagao : vagoes) {
            if (vagao.livre())
                System.out.println(vagao);
        }
    }

    public void desfazerTrem(Trem tremPorDesfazer) {
        for (int i = 0; i < tremPorDesfazer.getQtdadeVagoes(); i++) {
            tremPorDesfazer.desengataVagao();
        }
        for (int i = 0; i < tremPorDesfazer.getQtdadeLocomotivas(); i++) {
            tremPorDesfazer.desengataLocomotiva();
        }
        patioDeManobras.adicionaPatio(tremPorDesfazer);
    }

    public void listarTrens() {
        for (int i = 0; i < patioDeManobras.qtdade(); i++) {
            System.out.println(patioDeManobras.getPorPosicao(i));
        }
    }

    public int pedirIdentificador() {
        System.out.print("Digite o identificador do trem: ");
        return Inputs.inputInt();
    }

}
