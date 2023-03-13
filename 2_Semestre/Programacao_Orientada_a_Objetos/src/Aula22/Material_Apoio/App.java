package Aula22.Material_Apoio;

/*
1)    Altere a classe CadastroFuncionarios de maneira que a mesma disponha de métodos para:
a.    Retornar uma lista com todos os funcionários que recebem insalubridade e tem dependentes.
b.    Retornar a quantidade de funcionários que tem dependentes.
c.    Retornar o somatório do valor do salário bruto de todos os funcionários que ganham mais de 5000.
d.    Aplicar uma taxa de aumento (ex: 1.2 para 20%) em todos os funcionários que recebem insalubridade.
e.    Retornar uma lista de strings com nome e a matricula de todos os funcionários cujo salário bruto é mais de 10% maior que o salário base.
f.    Retornar a média salarial dos funcionários que não recebem insalubridade.
g.    Retornar a lista dos primeiros nomes dos funcionários cujos números de matrícula são menores que 500.
h.    Retornar o salário líquido de um funcionário específico ou -1 se o funcionário não for encontrado.
 
2)    Escreva uma aplicação que cria uma instância de cadastro de funcionários e imprime todas as consultas do exercício 1.

*/
public class App {
  public static void main(String args[]) {
    CadastroFuncionarios cf = new CadastroFuncionarios();
    System.out.println(cf);

    System.out
        .println("a.    Retornar uma lista com todos os funcionários que recebem insalubridade e tem dependentes.");
    System.out.println("R: " + cf.getInsalubridadeDependentes());
    linha();

    System.out.println("b.    Retornar a quantidade de funcionários que tem dependentes.");
    System.out.println("R: " + cf.quantidadeFuncionariosComDependentes());
    linha();

    System.out.println(
        "c.    Retornar o somatório do valor do salário bruto de todos os funcionários que ganham mais de 5000.");
    System.out.println("R: " + cf.somatorioSalarioBruto());
    linha();

    System.out.println(
        "d.    Aplicar uma taxa de aumento (ex: 1.2 para 20%) em todos os funcionários que recebem insalubridade.");
    cf.aumentaSalarioInsalubres();
    System.out.println(cf);
    linha();

    System.out.println(
        "e.    Retornar uma lista de strings com nome e a matricula de todos os funcionários cujo salário bruto é mais de 10% maior que o salário base.");
    System.out.println("R: " + cf.getNomeMatriculaSalarioBrutoMaiorQueBase());
    linha();

    System.out.println("f.    Retornar a média salarial dos funcionários que não recebem insalubridade.");
    System.out.println("R: " + cf.mediaSalarialDosQueNaoTemInsalubridade());
    linha();

    System.out.println(
        "g.    Retornar a lista dos primeiros nomes dos funcionários cujos números de matrícula são menores que 500.");
    System.out.println("R: " + cf.nomesDosQueTemMatriculaMenorQue500());
    linha();

    System.out.println(
        "h.    Retornar o salário líquido de um funcionário específico ou -1 se o funcionário não for encontrado.");
    System.out.println("R(180): " + cf.getSalarioLiquido(180));
    System.out.println("R(30): " + cf.getSalarioLiquido(30));
    linha();
  }

  private static void linha() {
    System.out.println("==========================================================================================");
  }
}