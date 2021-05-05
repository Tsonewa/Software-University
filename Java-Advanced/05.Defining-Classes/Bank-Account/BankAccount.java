package BsnkAccount;

public class BankAccount {
    private final static double DEFAULT_INTEREST_RATE = 0.02;
    private static int bankAccountCount = 1;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private int id;
    private double balance;

    public BankAccount(){
        this.id = bankAccountCount++;
    }

    public int getId() {
        return id;
    }

    static void setInterestRate (double interest){
        BankAccount.interestRate = interest;
    }
    public void deposit (double deposit){
        this.balance += deposit;
    }
public double getInterestRate (int years) {
        return BankAccount.interestRate * years * this.balance;
}


}
