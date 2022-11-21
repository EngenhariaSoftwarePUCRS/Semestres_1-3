package RevisaoP2.Questao4;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Funcionario> lstf = new ArrayList<Funcionario>();
        int[] matriculas = { new Random().nextInt(1000), new Random().nextInt(1000), new Random().nextInt(1000),
                new Random().nextInt(1000), new Random().nextInt(1000) };
        String[] nomes = { "Felipe", "Luiza", "Murilo", "Lucca", "Gabriel" };
        double[] salariosBase = { new Random().nextInt(10000), new Random().nextInt(10000), new Random().nextInt(10000),
                new Random().nextInt(10000), new Random().nextInt(10000) };
        int[] nroDependentes = { new Random().nextInt(10), new Random().nextInt(10), new Random().nextInt(10),
                new Random().nextInt(10), new Random().nextInt(10) };
        boolean[] insalubridades = { new Random().nextBoolean(), new Random().nextBoolean(), new Random().nextBoolean(),
                new Random().nextBoolean(), new Random().nextBoolean() };
        for (int i = 0; i < 5; i++) {
            lstf.add(new Funcionario(matriculas[i], nomes[i], salariosBase[i], nroDependentes[i], insalubridades[i]));
        }
        CadastroFuncionarios cf = new CadastroFuncionarios(lstf);
        System.out.println(cf);
        System.out.println("Quantidade de Funcionários com Dependentes: " + cf.quantidadeFuncionariosComDependentes());
        System.out.println("Nome e Matricula de quem tem o salario bruto maior do que o base: ");
        for (int i = 0; i < cf.getNomeMatriculaSalarioBrutoMaiorQueBase().size(); i++) {
            System.out.println(cf.getNomeMatriculaSalarioBrutoMaiorQueBase().get(i));
        }
    }
}
