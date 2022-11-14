public class ModeloClasses {
    public static void main(String args[]){
        boolean valorBooleano = false;
        byte valorByte = 90;
        int valorInteiro = 59888;
        double valorDouble = 348.86;
        char valorCaracter = 'A';

        System.out.println("Exemplo de valor Booleano: " + valorBooleano);
        System.out.println("Exemplo de valor Byte: " + valorByte);
        System.out.println("Exemplo de valor Inteiro: " + valorInteiro);
        System.out.println("Exemplo de valor Double: " + valorDouble);
        System.out.println("Exemplo de valor Char: " + valorCaracter);
        
        valorBooleano = true;
        valorInteiro = valorInteiro * 2;
        valorDouble = valorDouble + valorInteiro;
        
        System.out.println("Novo valor booleano: " + valorBooleano);
        System.out.println("Novo valor inteiro: " + valorInteiro);
        System.out.println("Novo valor double: " + valorDouble);
        
    }
}
