public class Palindrome {
    public static void main(String[] args) {
        String s = args[0];
        int N = s.length();
        boolean isPalindrome = true;
        for (int i = 0; i < N/2; i++) {
            if (s.charAt(i) != s.charAt(N-1-i)) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println("Seu nome é um palíndromo? "+ isPalindrome);
    }
}