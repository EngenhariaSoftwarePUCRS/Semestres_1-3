import java.util.InputMismatchException;
import java.util.Scanner;

public class Scanners {
    public static String inputString() {
        return new Scanner(System.in).nextLine();
    }

    public static int inputInt() {
        try {
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException ime) {
            return inputInt();
        }
    }
}
