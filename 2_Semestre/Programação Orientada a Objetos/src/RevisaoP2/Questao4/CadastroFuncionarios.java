package RevisaoP2.Questao4;

import java.util.List;

public class CadastroFuncionarios {
    public final int TAM = 5;
    private List<Funcionario> lstf;

    public CadastroFuncionarios() {
    }

    public CadastroFuncionarios(List<Funcionario> lstf) {
        this.lstf = lstf;
    }

    public List<Functionario> getFuncionarios() {
        return lstf;
    }

    public List<Funcionario> getInsalubridadeDependentes() {
        return null;
    }

    public long quantidadeFuncionariosComDependentes() {
        return lstf
                .stream()
                .filter(f -> (f.getNroDependentes() > 0))
                .count();
    }

    public double somatorioSalarioBruto() {
        return null;
    }

    public void aumentaSalarioInsalubres() {
        lstf
                .stream()
                .filter(f -> f.isInsalubridade())
                .forEach(f -> f.aumentaSalBase(.1));
    }

    public List<String> getNomeMatriculaSalarioBrutoMaiorQueBase() {
        return lstf
                .stream()
                .filter(f -> (f.getSalarioBruto() * 1.1 > f.getSalarioBase()))
                .map(f -> (f.getNome() + " - " + f.getMatricula()))
                .toList();
    }

    public double mediaSalarialDosQueNaoTemInsalubridade() {
        return lstf
                .stream()
                .filter(f -> !f.isInsalubridade())
                .mapToDouble(f -> f.getSalarioBase())
                .average()
                .getAsDouble();
    }

    public List<String> nomesDosQueTemMatriculaMenorQue500() {
        return lstf
                .stream()
                .filter(f -> f.getMatricula() < 500)
                .map(f -> f.getNome())
                .toList();
    }

    public double getSalarioLiquido(int matricula) {
        for (Funcionario funcionario : lstf)
            if (funcionario.getMatricula() == matricula)
                return funcionario.getSalarioLiquido();
        return null;
    }

    @Override
    public String toString() {
        return "CadastroFuncionarios [TAM=" + TAM + ", lstf=" + lstf + "]";
    }
}
