public class Transaction {
    public static final int TYPE_DEPOSIT_CHECKING = 1;
    public static final int TYPE_WITHDRAW_CHECKING = 2;
    public static final int TYPE_DEPOSIT_SAVINGS = 3;
    public static final int TYPE_WITHDRAW_SAVINGS = 4;
    public int type;
    private final double amount;
    private final double initialBalance;
    private final double finalBalance;

    /** constructor. */
    public Transaction(double amount, double initialBalance, double finalBalance) {
        this.amount = amount;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
    }

    /** getTransactionTypeString. */
    private String getTransactionTypeString(int type) {
        switch (type) {
            case Transaction.TYPE_DEPOSIT_CHECKING:
                return "Nạp tiền vãng lai";
            case Transaction.TYPE_WITHDRAW_CHECKING:
                return "Rút tiền vãng lai";
            case Transaction.TYPE_DEPOSIT_SAVINGS:
                return "Nạp tiền tiết kiệm";
            case Transaction.TYPE_WITHDRAW_SAVINGS:
                return "Rút tiền tiết kiệm";
            default:
                return "";
        }
    }

    /** getTransactionSummary. */
    public String getTransactionSummary() {
        return "- Kiểu giao dịch: " + getTransactionTypeString(this.type)
                + ". Số dư ban đầu: $"  + String.format("%.2f", this.initialBalance)
                + ". Số tiền: $" +  String.format("%.2f", this.amount)
                + ". Số dư cuối: $" +  String.format("%.2f", this.finalBalance) + ".";
    }
}
