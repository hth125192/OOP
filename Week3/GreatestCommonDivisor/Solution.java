public class Solution {
    public static int gcd(int a, int b) {
        int tmp;
        while (b != 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }
        if (a < 0) {
            return -a;
        }
        return a;
    }

    public static void main(String []args) {
        int a = gcd(Integer.MIN_VALUE, -16);
        System.out.println(a);
    }
}
