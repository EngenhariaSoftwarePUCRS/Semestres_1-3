package Ex03;

/*
 * O dono de uma rede de bares da cidade nos
    encomendou um sistema em Java para rodar em
    tablets, para controlar o acesso de clientes ao bar.
    O proprietário deseja que, ao entrar no bar, cliente
    informe seu nome, cpf, idade e gênero. A qualquer
    momento, ele deseja ser capaz de consultar quem
    são as pessoas que estão no bar, se alguém com
    um determinado CPF está no bar, quantas são as
    pessoas e qual a distribuição por gênero
    (percentual de clientes masculinos e femininos). Ao
    sair, o cliente deve informar seu CPF, para registrar
    sua saída.
    Modele este sistema (defina classes, com seus
    atributos e métodos) e implemente-o.
 */
public class Main {
   public static void main(String[] args) {
      Cliente lucas = new Cliente("Lucas", "03360050088", 20, 'M');
      Cliente luiza = new Cliente("Luiza", "12378954621", 21, 'F');
      Cliente lazaro = new Cliente("Lazaro", "15946875421", 22, 'M');
      Restaurante restaurante = new Restaurante();
      restaurante.addCliente(lucas);
      restaurante.addCliente(luiza);
      restaurante.addCliente(lazaro);

      Cliente[] clientes = restaurante.getClientes();
      System.out.println("Estão no restaurante: ");
      for (Cliente cliente : clientes) {
         if (cliente.getNome() != null) {
            System.out.println(cliente);
            pulaLinha();
         }
      }

      System.out.printf("A pessoa de cpf %s", luiza.getCpf());
      System.out.print(restaurante.isNoRestaurante(luiza.getCpf()) ? " " : " não ");
      System.out.println("está no restaurante.");
      pulaLinha();

      restaurante.sair(lazaro.getCpf());

      clientes = restaurante.getClientes();
      for (Cliente cliente : clientes)
         if (cliente != null)
            if (cliente.getNome() != null) {
               System.out.println(cliente);
               pulaLinha();
            }
      restaurante.getDistribuicaoClientes();
   }

   private static void pulaLinha() {
      System.out.println("==================");
   }
}
