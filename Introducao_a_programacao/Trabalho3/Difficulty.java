import java.util.Scanner;

public class Difficulty {

    private Matriz easy = new Matriz(4, 4);
    private Matriz medium = new Matriz(6, 6, 0, 20);
    private Matriz hard = new Matriz(8, 8, 10, 40);
    private Matriz impossible = new Matriz(10, 10, 0, 100);

    public Matriz level() {
        int choice = menu();
        switch (choice) {
            case 1:
                return easy;
            case 2:
                return medium;
            case 3:
                return hard;
            case 4:
                return impossible;
            default:
                System.out.println("Tente novamente! Valor inválido.");
                return level();
        }
    }

    public int menu() {
        Scanner input = new Scanner(System.in);

        System.out.println("/==============================\\");
        System.out.println("|\tDIFICULDADE\t");
        System.out.println("| (1) - Fácil - 1/2 Jogadores");
        System.out.println("| (2) - Médio - 3/4 Jogadores");
        System.out.println("| (3) - Difícil - 5+ Jogadores");
        System.out.println("| (4) - Impossível - 1 PC");
        System.out.println("\\==============================/");

        return input.nextInt();
    }
}
