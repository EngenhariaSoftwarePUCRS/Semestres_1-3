public class CalculadoraMult {
    
    public static void main(){

        int aux = 1;
        
        for (int index = 1; index <= 10; index++) {
            aux = aux * index;
        }
        
        System.out.println("A multiplicação final é: " + aux);
        
    }
}