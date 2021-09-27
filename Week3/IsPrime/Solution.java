public class Solution {
    public static boolean isPrime(int n) {
        if (n == 2 || n == 3) {
            return true;
        }
        if (n < 2 || n % 6 != 1 && n % 6 != 5) {
            return false;
        }
        for (int i = 2; i <= Math.round(Math.sqrt(n)); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String []args) {
        boolean check = isPrime(Integer.MAX_VALUE);
        System.out.println(check);
    }
}
