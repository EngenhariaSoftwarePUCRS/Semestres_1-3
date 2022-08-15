public class Exercicios {
    public int func1(int n) {
        n = Math.abs(n);
        // 5(n + cont) + 4
        // 5*n + 5*(2^n) + 4
        int s = 0, cont = 1; // 2C

        while (n > 0) { // 1
            cont *= 2; // 2
            n -= 1; // 2
        }

        for (int i = 0; i < cont; i++) { // 1C + 1 + 2
            s += 1; // 2
        }

        return s; // 1C
    }

    public int func2(int n) {
        n = Math.abs(n);
        // 4 + 5(log_2-n + 1)
        int cont = 0; //1C
        while (n > 0) { //1
            n /= 2; //2
            cont += 1; //2
        }
        cont++; //2C
        return cont; //1C
    }

    public int func3(int n) {
        // 5C + 
        int i, j;
        int S;
        S = n * 2; //2C
        int passei = 0;

        for (i = 0; i < n; i++) //1C + 1 + 2
            { S = i; //1
                for (j = 0; j < i; j++) //1C + 1 + 2
                    { S = S + j; //2
                        /*System.out.println(S)*/; passei++;} //3
            passei++; }

        return passei; //1C
    }
}
