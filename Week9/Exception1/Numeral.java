public class Numeral extends Expression {
    private double value;

    public Numeral(double value) {
        this.value = value;
    }

    public Numeral() {

    }

    @Override
    public String toString() {
        return "" + (int) value;
    }

    @Override
    public double evaluate() {
        return value;
    }
}