import java.util.Scanner;
public class fahrenheit {
    public static void main() {
        
        Scanner input = new Scanner(System.in);
        
        double temp_fahrenheit;
        double temp_celsius;
    
        System.out.println("Temperatura em ºF: ");
        temp_fahrenheit = input.nextDouble();
        temp_celsius = ((temp_fahrenheit - 32) * 5/9);
        System.out.println("O equivalente em Celsius é: "+temp_celsius+"ºC");
        
        System.out.println("Temperatura em ºC: ");
        temp_celsius = input.nextDouble();
        temp_fahrenheit = ((temp_celsius) * 9/5 + 32);
        System.out.println("O equivalente em Fahrenheit é: "+temp_fahrenheit+"ºF");
    }
}