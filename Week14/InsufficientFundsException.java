public class InsufficientFundsException extends BankException {
    /** constructor. */
    public InsufficientFundsException(double amount) {
        super("Số tiền không hợp lệ: $" + String.format("%.2f", amount));
    }
}
