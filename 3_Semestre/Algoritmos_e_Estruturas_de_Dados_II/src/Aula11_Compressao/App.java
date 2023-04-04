package Aula11_Compressao;

public class App {
    public static void main(String[] args) {
        String a = "0 0 0 0 0 0 0 0 1 1 1 1 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1";
        String b = "0 0 0 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 0 0 0";
        String c = "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 1 1 1 ";
        compress(a);
        // 1000_0100_0110_1100;

        compress(b);
        // 1100_1110_0100;

        compress(c);
        // 0000_1111_1111_0100;
    }

    private static void compress(String s) {
        // While the bit doesnt change; i.e. --> 0000's or 1111's, and the bit is
        // smaller than 2 to the 4th power (15), convert this number between 0-15 to
        // binary and save this 4 bits into a new array
        // For example
        // "0 0 0 0 0 0 0 0 1 1 1 1 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1"
        // Has 8 zeroes, 4 ones, 6 zeroes, 12 ones
        // So we represent each of this numbers in binary
        // 1000_0100_0110_1100;
    }
}