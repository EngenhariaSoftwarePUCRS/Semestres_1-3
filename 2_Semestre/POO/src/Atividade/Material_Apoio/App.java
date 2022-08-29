import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {

        int escolha;

        do {
            mostrarOpcoes();
            System.out.print("\n------------ MENU ------------");
            System.out.print("-----Escolha uma opção: ------");
            escolha = Inputs.inputInt();
            analiza(escolha);
        } while (escolha != 0);

        GaragemLocomotivas garagemLocomotivas = new GaragemLocomotivas();
        ArrayList<Locomotiva> locomotivas = new ArrayList<>(Arrays.asList(
                new Locomotiva(1, 2500, 50),
                new Locomotiva(2, 2500, 50),
                new Locomotiva(3, 2500, 50),
                new Locomotiva(4, 2500, 50),
                new Locomotiva(5, 2500, 50),
                new Locomotiva(6, 2500, 50)));
        for (Locomotiva l : locomotivas) {
            garagemLocomotivas.adicionaGaragem(l);
        }
        GaragemVagoes garagemVagoes = new GaragemVagoes();
        ArrayList<Vagao> vagoes = new ArrayList<>(Arrays.asList(
                new Vagao(1, 50),
                new Vagao(2, 50),
                new Vagao(3, 50),
                new Vagao(4, 50),
                new Vagao(5, 50),
                new Vagao(6, 50)));
        for (Vagao v : vagoes) {
            garagemVagoes.adicionaGaragem(v);
        }
        PatioDeManobras patioDeManobras = new PatioDeManobras();

        // ------------------------------- PARTE 1 CRIAÇÃO -- //
        System.out.println("(1) Criando trem");
        System.out.print("Digite o identificador do trem: ");
        int idTrem = 1;// Inputs.inputInt();
        Trem novoTrem = new Trem(idTrem);
        System.out.println("Locomotivas: ");
        System.out.println(locomotivas);
        System.out.print("Digite o identificador da primeira locomotiva: ");
        int idLocomotiva = 1;// Inputs.inputInt();
        Locomotiva novaLocomotiva = garagemLocomotivas.getPorId(idLocomotiva);
        novoTrem.engataLocomotiva(novaLocomotiva);
        novaLocomotiva.setTrem(novoTrem);
        patioDeManobras.adicionaPatio(novoTrem);
        System.out.println("Trem criado com sucesso e inserido no pátio!");

        // ------------------------------- PARTE 2 EDIÇÃO -- //
        System.out.println("(2) Editar trem");
        System.out.println("Trens: ");
        for (int i = 0; i < patioDeManobras.qtdade(); i++) {
            System.out.println(patioDeManobras.getPorPosicao(i));
        }
        System.out.print("Digite o identificador do trem: ");
        idTrem = 1;// Inputs.inputInt();
        Trem tremPorEditar = patioDeManobras.getPorId(idTrem);
        // ------------------------------- PARTE 2.1 Ins Locomotiva -- //
        System.out.println("(2.1) Inserir locomotiva");
        System.out.println("Locomotivas: ");
        for (int i = 0; i < garagemLocomotivas.qtdade(); i++) {
            System.out.println(garagemLocomotivas.getPorPosicao(i));
        }
        System.out.println("Digite o identificador da locomotiva: ");
        Locomotiva locomotivaPorAdicionar = garagemLocomotivas.getPorId(Inputs.inputInt());
        tremPorEditar.engataLocomotiva(locomotivaPorAdicionar);
        System.out.println("Locomotiva adicionada com sucesso.");
        // ------------------------------- PARTE 2.2 Ins Vagao -- //
        System.out.println("(2.2) Inserir vagao");
        System.out.println("Vagões: ");
        for (int i = 0; i < garagemVagoes.qtdade(); i++) {
            System.out.println(garagemVagoes.getPorPosicao(i));
        }
        System.out.println("Digite o identificador do vagão: ");
        Vagao vagaoPorAdicionar = garagemVagoes.getPorId(Inputs.inputInt());
        tremPorEditar.engataVagao(vagaoPorAdicionar);
        System.out.println("Vagao adicionado com sucesso.");

        // ------------------------------- PARTE 3 VER --------------------------- //
        System.out.println("(3) Trens");
        for (int i = 0; i < patioDeManobras.qtdade(); i++) {
            System.out.println(patioDeManobras.getPorPosicao(i));
        }
    }

    private static void analiza(int escolha) {
        switch (escolha) {
            case 1:
                System.out.println("Opção escolhida: 1");
                break;

            case 2:
                System.out.println("Opção escolhida: 2");
                break;

            case 3:
                System.out.println("Opção escolhida: 3");
                break;

            case 4:
                System.out.println("Opção escolhida: 4");
                break;

            case 5:
                System.out.println("Você encerrou o programa.");
                break;
        }
    }

    private static void mostrarOpcoes() {
        System.out.println();
        System.out.println("1- Criar trem ");
        System.out.println("2- Editar um trem");
        System.out.println("3- Listar todos os trens já criados");
        System.out.println("4- Desfazer um trem");
        System.out.println("0- Fim");
    }
}