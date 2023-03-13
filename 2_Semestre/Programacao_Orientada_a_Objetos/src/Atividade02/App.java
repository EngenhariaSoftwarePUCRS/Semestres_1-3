package Atividade02;

public class App {

    static Super s = new Super();
    final static String FILE_PATH = "src/Atividade02/";

    public static void main(String[] args) {
        if (s.initialize(
                FILE_PATH + "locomotivas.txt",
                FILE_PATH + "vagoes.txt",
                FILE_PATH + "vagoesPassageiros.txt")) {
            int escolha;
            do {
                System.out.println("\n------------ MENU ------------");
                mostrarOpcoes();
                escolha = Scanners.inputInt();
                analiza(escolha);
            } while (escolha != 0);
        } else
            System.out.println("Favor reiniciar o sistema e localizar os arquivos.");
    }

    private static void analiza(int escolha) {
        switch (escolha) {
            case 1:
                if (s.criarTrem()) {
                } else
                    System.out.println("Identificador já em uso.\nFavor tentar novamente.");
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
                                s.editarTremInserirVagaoPassageiro(tremPorEditar);
                                break;

                            case 4:
                                if ((tremPorEditar.getQtdadeLocomotivas() == 1)
                                        && (tremPorEditar.getQtdadeVagoes() == 0)
                                        && (tremPorEditar.getQtdadeVagoesPassageiros() == 0)) {
                                    System.out.println(
                                            "Não é possível remover a última locomotiva.\nDesmonte o trem para isso.");
                                } else
                                    s.editarTremRemoverUltimo(tremPorEditar);
                                break;

                            case 5:
                                s.editarTremListarLocomotivasLivres();
                                break;

                            case 6:
                                s.editarTremListarVagoesLivres();
                                break;

                            case 7:
                                s.editarTremListarVagoesPassageirosLivres();
                                break;

                            case 8:
                            default:
                                break;
                        }
                    } while (escolha != 8);
                    break;
                } else
                    System.out.println("Não há trens para serem editados.");
                break;

            case 3:
                if (s.listarTrens()) {
                } else
                    System.out.println("Não há trens para serem mostrados.");
                break;

            case 4:
                if (s.listarTrens()) {
                    int idTrem = s.pedirIdentificador("trem");
                    Trem tremPorEditar = s.getPatioDeManobras().getPorId(idTrem);
                    if ((tremPorEditar) == null)
                        System.out.println("Trem não encontrado.");
                    else
                        s.desfazerTrem(tremPorEditar);
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
        System.out.print("   Digite sua escolha: ");
    }

    private static void mostrarOpcoesTrem(int identificador) {
        System.out.println();
        System.out.println("Editando trem " + identificador);
        System.out.println("\t1- Inserir uma locomotiva");
        System.out.println("\t2- Inserir um vagão");
        System.out.println("\t3- Inserir um vagão de passageiros");
        System.out.println("\t4- Remover o último elemento do trem");
        System.out.println("\t5- Listar locomotivas livres");
        System.out.println("\t6- Listar vagões livres");
        System.out.println("\t7- Listar vagões de passageiros livres");
        System.out.println("\t8- Encerrar a edição do trem");
        System.out.print("\t   Digite sua escolha: ");
    }
}