package RevisaoP2.Questao4;

public class Funcionario {
    private int matricula;
    private String nome;
    private double salarioBase;
    private int nroDependentes;
    private boolean insalubridade;

    public Funcionario(int matricula, String nome, double salarioBase, int nroDependentes, boolean insalubridade) {
        this.matricula = matricula;
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.nroDependentes = nroDependentes;
        this.insalubridade = insalubridade;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public int getNroDependentes() {
        return nroDependentes;
    }

    public boolean isInsalubridade() {
        return insalubridade;
    }

    public void aumentaSalBase(double taxa) {
        this.salarioBase *= taxa;
    }

    public double inss() {
        return .11 * getSalarioBruto();
    }

    public double irpf() {
        return .15 * getSalarioBruto();
    }

    public double getSalarioBruto() {
        return salarioBase;
    }

    public double getSalarioLiquido() {
        return getSalarioBruto() - inss() - irpf();
    }

    @Override
    public String toString() {
        return "Funcionario [matricula=" + matricula + ", nome=" + nome + ", salarioBase=" + salarioBase
                + ", nroDependentes=" + nroDependentes + ", insalubridade=" + insalubridade + "]";
    }
}
