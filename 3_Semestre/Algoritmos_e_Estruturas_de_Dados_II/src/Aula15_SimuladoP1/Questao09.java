package Aula15_SimuladoP1;

public class Questao09 {
    // a) 00000000011111100000011111
    // 9x0’s + 6x1's + 6x0’s + 5x1's = 26 bits
    // 1001 0110 0110 0101 --> 16/26 = 61%

    // b) 00000011111100000000111100
    // 6x0's + 6x1's + 8x0's + 4x1's + 2x0's = 26 bits
    // 0110 0110 1000 0100 0010 --> 20/26 = 76%

    // c) 11111111111111111110000000
    // 15x1's + 0x0's + 4x1's + 7x0's = 26 bits
    // 1111 0000 0100 0111 --> 16/26 = 61%

    public String decimalToBinary(int decimal) {
        String binary = "";
        while (decimal > 0) {
            binary += decimal % 2;
            decimal /= 2;
        }
        return binary;
    }

    public static void main(String[] args) {
        String input = "00000000011111100000011111";
        String output = "";
        boolean isZeroCurrently = input.charAt(0) == '0';
        int count = 0;
        int maxCount = 15;
        for (int i = 0; i < input.length(); i++) {
            if (count > maxCount) {
                maxCount = count;
                isZeroCurrently = !isZeroCurrently;
            }
            if (input.charAt(i) == '0' && isZeroCurrently) {
                count++;
            } else if (input.charAt(i) == '1' && !isZeroCurrently) {
                count++;
            } else {
                count = 0;
            }
        }
    }
}
