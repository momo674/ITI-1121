public class Account{
    private double savings;
    public Account(){
        this.savings = 0;
    }
    public void deposit(double sum){
        this.savings += sum;
        System.out.println("new balance=" + this.savings +"$");
    }

    public double getBalance() { return this.savings; }

    public void withdraw (double sum) {
        if (sum > this.savings){
            throw new NotEnoughMoneyException(sum, this.savings);
        }
        this.savings -= sum;
        System.out.println("new balance=" + this.savings +"$");
    }
}