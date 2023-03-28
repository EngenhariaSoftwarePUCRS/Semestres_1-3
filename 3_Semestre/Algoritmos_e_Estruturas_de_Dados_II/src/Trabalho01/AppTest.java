package Trabalho01;

import java.io.File;

public class AppTest {
    public static void main(String[] args) {
        String filesPath = args.length > 0 ? args[0]
                : "src/Trabalho01/Casos_de_Testes_dos_Macaquinhos_T1_20230327";
        File[] files = new File(filesPath).listFiles();

        for (File file : files) {
            System.out.println(file);
            // new JungleGame(file).play();
        }
    }
}
