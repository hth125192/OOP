public class InvalidFundingAmountException extends BankException {
    /** constructor. */
    public InvalidFundingAmountException(double amount) {
        super("Số dư tài khoản không đủ $" + String.format("%.2f", amount)
                + " để thực hiện giao dịch");
    }
}
