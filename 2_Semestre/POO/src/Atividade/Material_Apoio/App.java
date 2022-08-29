public class App {

    static Super s = new Super();
    
    public static void main(String[] args) throws Exception {
        int escolha;
        do {
            System.out.println("\n------------ MENU ------------");
            mostrarOpcoes();
            System.out.print("\n-----Escolha uma opção: ");
            escolha = Inputs.inputInt();
            analiza(escolha);
        } while (escolha != 0);
    }

    private static void analiza(int escolha) {
        switch (escolha) {
            case 1:
                s.criarTrem();
                break;

            case 2:
                Trem tremPorEditar = s.editarTrem();
                do {
                    mostrarOpcoesTrem();
                    escolha = Inputs.inputInt();
                    switch (escolha) {
                        case 1:
                            s.editarTremInserirLocomotiva(tremPorEditar);
                            break;
                        
                        case 2:
                            s.editarTremInserirVagao(tremPorEditar);
                            break;
                        
                        case 3:
                            System.out.println("Opção 2.3: ");
                            break;

                        case 4:
                            System.out.println("Opção 2.4:");
                            break;
                        
                        case 5:
                            System.out.println("Opção 2.5");
                            break;
                        
                        case 6:
                            System.out.println("Opção 2.6");
                            break;
                    
                        default:
                            break;
                    }
                } while (escolha != 6);
                break;

            case 3:
                s.listarTrens();
                break;

            case 4:
                s.desfazerTrem();
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

    private static void mostrarOpcoesTrem() {
        System.out.println();
        System.out.println("1- Inserir uma locomotiva (informar identificador) respeitando restrições");
        System.out.println("2- Inserir um vagão (informar identificador) respeitando restrições");
        System.out.println("3- Remover o último elemento do trem");
        System.out.println("4- Listar locomotivas livres");
        System.out.println("5- Listar vagões livres");
        System.out.println("6- Encerrar a edição do trem");
    }
}