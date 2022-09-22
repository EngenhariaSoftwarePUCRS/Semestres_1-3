package Atividade2;

public class App {

    static Super s = new Super();

    public static void main(String[] args) throws Exception {
        if (s.initialize(
                "locomotivas.txt",
                "vagoes.txt",
                "vagoesPassageiros.txt"
            )) {
            int escolha;
            do {
                System.out.println("\n------------ MENU ------------");
                mostrarOpcoes();
                System.out.print("\n-----Escolha uma opção: ");
                escolha = Scanners.inputInt();
                analiza(escolha);
            } while (escolha != 0);
        } else {
            System.out.println("Favor reiniciar o sistema e localizar os arquivos.");
        }
    }

    private static void analiza(int escolha) {
        switch (escolha) {
            case 1:
                s.criarTrem();
                break;

            case 2:
                if (s.getPatioDeManobras().qtdade() > 0) {
                    Trem tremPorEditar = s.editarTrem();
                    do {
                        mostrarOpcoesTrem(tremPorEditar.getIdentificador());
                        escolha = Scanners.inputInt();
                        switch (escolha) {
                            case 1:
                                s.editarTremInserirLocomotiva(tremPorEditar);
                                break;

                            case 2:
                                s.editarTremInserirVagao(tremPorEditar);
                                break;

                            case 3:
                                if ((s.getLocomotivas().size() == 1) && (s.getVagoes().isEmpty())) {
                                    System.out.println(
                                            "Não é possível remover a última locomotiva.\nDesmonte o trem para isso.");
                                } else
                                    s.editarTremRemoverUltimo(tremPorEditar);
                                break;

                            case 4:
                                s.editarTremListarLocomotivasLivres(tremPorEditar);
                                break;

                            case 5:
                                s.editarTremListarVagoesLivres(tremPorEditar);
                                break;

                            case 6:
                            default:
                                break;
                        }
                    } while (escolha != 6);
                    break;
                } else
                    System.out.println("Não há trens para serem editados.");

            case 3:
                if (s.listarTrens()) {
                } else
                    System.out.println("Não há trens para serem mostrados.");
                break;

            case 4:
                if (s.listarTrens()) {
                    int idTrem = s.pedirIdentificador("trem");
                    s.desfazerTrem(s.getPatioDeManobras().getPorId(idTrem));
                } else
                    System.out.println("Não há trens para serem desmontados.");
                break;

            case 0:
                System.out.println("Você encerrou o programa.");
                break;

            default:
                System.out.println("Opção inválida, favor reiniciar o sistema");
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

    private static void mostrarOpcoesTrem(int identificador) {
        System.out.println();
        System.out.println("Editando trem " + identificador);
        System.out.println("1- Inserir uma locomotiva (informar identificador) respeitando restrições");
        System.out.println("2- Inserir um vagão (informar identificador) respeitando restrições");
        System.out.println("3- Remover o último elemento do trem");
        System.out.println("4- Listar locomotivas livres");
        System.out.println("5- Listar vagões livres");
        System.out.println("6- Encerrar a edição do trem");
    }
}