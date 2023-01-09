package RevisaoP2.Questao4;

import Aula22.Material_Apoio.CadastroFuncionarios;

public class Main {
    public static void main(String[] args) {
        CadastroFuncionarios cf = new CadastroFuncionarios();
        System.out.println(cf);

        System.out.println("a. Quantidade de funcionários que tem dependentes");
        System.out.println(cf.quantidadeFuncionariosComDependentes());

        System.out.println(
                "b. Lista de strings com nome e a matricula de todos os funcionários cujo salário bruto é mais de 10% maior que o salário base");
        System.out.println(cf.getNomeMatriculaSalarioBrutoMaiorQueBase());

        // Estudo Genérico
        // Canil canil = new Canil();
        // System.out.println(canil);

        // System.out.println("a. Todos os cachorros com mais de 4 anos.");
        // for (int i = 0; i < canil.getAllOlderThan(4).size(); i++) {
        // System.out.println(canil.getAllOlderThan(4).get(i));
        // }

        // System.out.println("b. Quantidade de cachorros com mais de 15kg.");
        // System.out.println(canil.getAmountHeavierThan(15));

        // System.out.println("c. Cor do mais novo.");
        // System.out.println(canil.getCorFromOldest(2));

        // System.out.println("c. A média do peso dos cachorros com menos de 32kg.");
        // System.out.println(canil.getAvgWeightLighter(32));
    }
}
