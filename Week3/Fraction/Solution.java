public class Solution {
    private int numerator;
    private int denominator = 1;

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    /** Set denominator. */
    void setDenominator(int denominator) {
        if (denominator != 0) {
            this.denominator = denominator;
        }
    }

    Solution(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator != 0) {
            this.denominator = denominator;
        }
    }

    int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        int tmp;
        while (b != 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    Solution reduce() {
        int i = gcd(numerator, denominator);
        numerator /= i;
        denominator /= i;
        if (denominator < 0) {
            numerator = - numerator;
            denominator = - denominator;
        }
        return this;
    }

    Solution add(Solution other) {
        int i = denominator * other.denominator;
        numerator = numerator * other.denominator + denominator * other.numerator;
        denominator = i;
        return this.reduce();
    }

    Solution subtract(Solution other) {
        int i = denominator * other.denominator;
        numerator = numerator * other.denominator - denominator * other.numerator;
        denominator = i;
        return this.reduce();
    }

    Solution multiply(Solution other) {
        numerator *= other.numerator;
        denominator *= other.denominator;
        return this.reduce();
    }

    Solution divide(Solution other) {
        if (other.numerator != 0) {
            numerator *= other.denominator;
            denominator *= other.numerator;
        }
        return this.reduce();
    }

    /** Compare fraction with object. */
    public boolean equals(Object obj) {
        if (obj instanceof Solution) {
            Solution other = (Solution) obj;
            return other.subtract(this).numerator == 0;
        }
        return false;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

}
