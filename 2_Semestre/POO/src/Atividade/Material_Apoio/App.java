public class App {

    static Super s = new Super();

    public static void main(String[] args) throws Exception {

        int escolha;

        do {
            mostrarOpcoes();
            System.out.print("\n------------ MENU ------------");
            System.out.print("-----Escolha uma opção: ------");
            escolha = Inputs.inputInt();
            analiza(escolha);
        } while (escolha != 0);
    }

    private static void analiza(int escolha) {
        switch (escolha) {
            case 1:
                System.out.println("Opção escolhida: 1");
                s.criarTrem();
                break;

            case 2:
                System.out.println("Opção escolhida: 2");
                s.editarTrem();
                break;

            case 3:
                System.out.println("Opção escolhida: 3");
                s.listarTrens();
                break;

            case 4:
                System.out.println("Opção escolhida: 4");
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
}