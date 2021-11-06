public class ExpressionTest {
    /** main. */
    public static void main(String[] args) {
        Expression s = new Square(new Addition(
                new Subtraction(new Square(new Numeral(10)), new Numeral(3)),
                new Multiplication(new Numeral(4), new Numeral(3))));
        System.out.println(s.toString());
        System.out.println(s.evaluate());
        s = new Division(s, new Numeral(0));
        System.out.println(s.toString());
        System.out.println(s.evaluate());
    }
}
