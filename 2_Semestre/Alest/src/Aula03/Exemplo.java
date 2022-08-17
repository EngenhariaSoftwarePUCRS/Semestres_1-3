package Aula03;

public class Exemplo {
    int met1(int n) {
        int res = 0;

        // 4 * n
        for (int i = 0; i < n; i++)
            // 4 * n * n
            for (int j = 0; j < n; j++)
                // 4 * n * n * n
                for (int k = 0; k < n; k++)
                    // 8 * n * n * n * n
                    for (int l = 0; l < n; l++)
                        res += (i+j) * (k+l);

        // T(n) = 8n4 + 4n3 + 4n2 + 4n + 3
        return res;
    }
}
