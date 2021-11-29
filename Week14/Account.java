import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    public static final String CHECKING = "CHECKING";
    public static final String SAVINGS = "SAVINGS";
    protected long accountNumber;
    protected double balance;
    protected List<Transaction> transactionList = new ArrayList<>();

    /** constructor. */
    public Account() {
    }

    /** constructor. */
    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    /** doWithdrawing. */
    public void doWithdrawing(double num)
            throws InsufficientFundsException, InvalidFundingAmountException {
        if (num < 0) {
            throw new InsufficientFundsException(num);
        }
        if (balance - num < 0) {
            throw new InvalidFundingAmountException(num);
        }
        if (this instanceof SavingsAccount) {
            if (balance - num < 5000) {
                throw new InvalidFundingAmountException(num);
            }
            if (num > 1000) {
                throw new InsufficientFundsException(num);
            }
        }
        Transaction transaction = new Transaction(num, balance, balance - num);
        transactionList.add(transaction);
        if (this instanceof CheckingAccount) {
            transaction.type = Transaction.TYPE_WITHDRAW_CHECKING;
        } else {
            transaction.type = Transaction.TYPE_WITHDRAW_SAVINGS;
        }
        balance = balance - num;
    }

    /** doDepositing. */
    public void doDepositing(double num)
            throws InvalidFundingAmountException, InsufficientFundsException {
        if (num < 0) {
            throw new InsufficientFundsException(num);
        }
        Transaction transaction = new Transaction(num, balance, balance + num);
        transactionList.add(transaction);
        if (this instanceof CheckingAccount) {
            transaction.type = Transaction.TYPE_DEPOSIT_CHECKING;
        } else {
            transaction.type = Transaction.TYPE_DEPOSIT_SAVINGS;
        }
        balance = balance + num;
    }

    /** getTransactionHistory. */
    public String getTransactionHistory() {
        StringBuilder ans = new StringBuilder();
        ans.append("Lịch sử giao dịch của tài khoản ").append(this.accountNumber);
        ans.append(":").append("\n");
        for (Transaction transaction: transactionList) {
            ans.append(transaction.getTransactionSummary());
            ans.append("\n");
        }
        return String.valueOf(ans);
    }

    /** addTransaction. */
    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    public abstract void withdraw(double num);

    public abstract void deposit(double num);

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof  Account)) {
            return false;
        }
        Account other = (Account) obj;
        return other.accountNumber == this.accountNumber;
    }
}