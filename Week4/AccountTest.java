public class AccountTest {
    public static void main(String []args) {
        Account acc = new Account();
        acc.addTransaction(2000.255,"deposit");
        acc.addTransaction(1000,"withdraw");
        acc.printTransaction();
    }
}
