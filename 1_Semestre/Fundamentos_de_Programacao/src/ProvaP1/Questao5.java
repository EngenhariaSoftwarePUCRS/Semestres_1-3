package ProvaP1;

import java.util.Scanner;

public class Questao5 {
    public static void main(String[] args) {
        int a, b;
        Scanner t = new Scanner(System.in);
        a = t.nextInt();
        b = t.nextInt();

        while (a > b) {
            if (a % 2 == 0)
                b = b * 2;
            else
                b = b + 1;
            a--;
        }
        a++;
        b--;
        System.out.println(a);
        System.out.println(b);
    }
}
