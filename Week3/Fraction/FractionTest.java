public class FractionTest {
    public static void main(String []args) {
        Solution ps1 = new Solution(6, -8);

        Solution ps2 = new Solution(-7, -4);

        Solution ps3 = new Solution(5, -2);
        Solution ps4 = new Solution(-3, 7);
        Solution ps5 = new Solution(0, 1);
        Solution ps6 = new Solution(4, 3);

        ps6.setDenominator(0);

        Solution ps7 = new Solution(9, -8);

        System.out.println(ps1.reduce());

        System.out.println(ps1.add(ps2));

        System.out.println(ps1.subtract(ps3));

        System.out.println(ps1.multiply(ps4));

        System.out.println(ps1.divide(ps5));

        System.out.println(ps1.divide(ps6));

        System.out.println(ps1.equals(-3/4));

        System.out.println(ps1.equals(ps7));
    }
}
