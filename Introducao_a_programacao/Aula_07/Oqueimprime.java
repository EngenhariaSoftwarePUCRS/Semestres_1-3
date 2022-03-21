 public class Oqueimprime {
    public static void main() {
        String str = "Harry";
        int n = str.length();
        String mystery = str.substring(0, 1) + str.substring(n - 1, n);
        System.out.println(mystery);
    }
}