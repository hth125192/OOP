public class CheckingAccount extends Account {

    /** constructor. */
    public CheckingAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double num) {
        try {
            doWithdrawing(num);
        } catch (InsufficientFundsException | InvalidFundingAmountException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deposit(double num) {
        try {
            doDepositing(num);
        } catch (InvalidFundingAmountException | InsufficientFundsException e) {
            e.printStackTrace();
        }
    }
}
