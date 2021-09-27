public class Solution {
    public static long fibonacci(long n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0 || n == 1) {
            return n;
        }
        long f0 = 0;
        long f1 = 1;
        long f = 1;
        for (int i = 2; i <= n; i++) {
            if (Long.MAX_VALUE - f1 < f0) {
                return Long.MAX_VALUE;
            }
            f = f1 + f0;
            f0 = f1;
            f1 = f;
        }
        return f;
    }

    public static void main(String []args) {
        long f = fibonacci(93);
        System.out.println(f);
    }
}
