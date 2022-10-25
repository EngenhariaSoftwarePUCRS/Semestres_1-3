package Aula22.Exemplos;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;

public class App {
/* 
    public static <T> Double somatorio(List<T> lst,Condicao<T> condicao,Operacao<T> operacao){
        Double somatorio = 0.0;
        for(T obj:lst){
            if (condicao.verifica(obj)){
                somatorio += operacao.calcula(obj);
            }
        }
        return somatorio;
    }
*/
    public static <T> Double somatorio(List<T> lst,Predicate<T> condicao,Function<T,Double> operacao){
        Double somatorio = 0.0;
        for(T obj:lst){
            if (condicao.test(obj)){
                somatorio += operacao.apply(obj);
            }
        }
        return somatorio;
    }

    public static void main(String[] args) throws Exception {
        // Cria uma lista de funcionarios
        int TAM = 100;
        List<Funcionario> lstf = new LinkedList<>();
        Random r = new Random();
        for (int i = 0; i < TAM; i++) {
            int matricula = r.nextInt(300) + 100;
            String nome = "Fulano" + i;
            boolean insalubridade = r.nextBoolean();
            int nroDep = r.nextInt(4);
            double salBase = (r.nextDouble() * 15000) + 500;
            Funcionario f = new Funcionario(matricula, nome, salBase, nroDep, insalubridade);
            lstf.add(f);
        }
        //----------------------------
        /* 
        Condicao<Funcionario> condicao = f->f.getInsalubridade();
        Operacao<Funcionario> impostos = f->f.inss()+f.irpf();
        
        Double gastosComImpostos = somatorio(lstf,condicao,impostos);
        System.out.println("Gastos com impostos dos insalubres: "+gastosComImpostos);

        Condicao<Funcionario> condicao = f->f.getNroDependentes() > 2;
        Operacao<Funcionario> impostos = f->f.getSalarioLiquido();

        Double gastosComSalarios = somatorio(lstf,condicao,impostos);
        System.out.println("Gastos com salarios: "+gastosComSalarios);
        */
        //----------------------------

        Predicate<Funcionario> insalubres = f->f.getInsalubridade();
        Function<Funcionario,Double> impostos = f->f.inss() + f.irpf();

        //Double gastosComImpostos = somatorio(lstf,insalubres,impostos);
        //System.out.println("Gastos com impostos dos insalubres: "+gastosComImpostos);

        Double gastosComImpostos = somatorio(lstf,f->f.getInsalubridade(),f->f.inss() + f.irpf());
        System.out.println("Gastos com impostos dos insalubres: "+gastosComImpostos);

        //----------------------------

        // Aumenta o salário base dos funcionários em 10%
        lstf.forEach(f->f.aumentaSalBase(1.1));

        // Imprime os dados de todos os funcionários
        lstf.forEach(f->System.out.println(f));

        Consumer<Funcionario> aumentaSalario = f->f.aumentaSalBase(1.1);
        Consumer<Funcionario> imprimeFuncionario = f->System.out.println(f);
        lstf.forEach(aumentaSalario.andThen(imprimeFuncionario));
        
        //----------------------------

        boolean temFamiliaNumerosa = lstf.stream().anyMatch(f->f.getNroDependentes()>5);

        boolean naotemFamiliaNumerosa = lstf.stream().noneMatch(f->f.getNroDependentes()>5);

        boolean todosGanhamMaisDe2000 = lstf.stream().allMatch((f->f.getSalarioLiquido()>2000.0));

        Funcionario nomeComD = lstf.stream()
            .filter(f->f.getNome().charAt(0) == 'D')
            .findFirst()
            .orElse(null);

        double maiorSalario = lstf.stream().mapToDouble(f->f.getSalarioLiquido()).max().orElse(0.0);
        double menorSalario = lstf.stream().mapToDouble(f->f.getSalarioLiquido()).min().orElse(0.0);
        double mediaSalarial = lstf.stream().mapToDouble(f->f.getSalarioLiquido()).average().orElse(0.0);
        double somatorio = lstf.stream().mapToDouble(f->f.getSalarioLiquido()).sum();

        //----------------------------

        Map<Integer,List<Funcionario>> funcQtdDep = lstf
            .stream()
            .collect(Collectors.groupingBy(f->f.getNroDependentes()));

        Map<Integer,List<String>> nomesQtdDep = lstf
            .stream()
            .collect(Collectors.groupingBy(f->f.getNroDependentes(),
                     Collectors.mapping(f->f.getNome(), Collectors.toList())));
        
        Map<Integer,String> strnomesQtdDep = lstf
            .stream()
            .collect(Collectors.groupingBy(f->f.getNroDependentes(),
                     Collectors.mapping(f->f.getNome(), Collectors.joining(","))));
        
        Map<Integer,Long> QtdadePorQtdDep = lstf
            .stream()
            .collect(Collectors.groupingBy(f->f.getNroDependentes(),
                     Collectors.mapping(f->f.getNome(), Collectors.counting())));

        //----------------------------

        Stream<String> turma1 = Stream.of("Andre","Luiz","Carlos");
        Stream<String> turma2 = Stream.of("Pedro","Ana","Bernardo");
        Stream<Stream<String>> todasTurmas = Stream.of(turma1,turma2);
        Stream<String> todosAlunos = todasTurmas.flatMap(Stream->Stream);

        //----------------------------
    }
}