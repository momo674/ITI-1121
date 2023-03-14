public class NotEnoughMoneyException extends IllegalStateException {
    private double requested_sum;
    private double current_balance;
    public NotEnoughMoneyException(double sum, double balance){
        super("you do not have enough money to withdraw " + sum + "$.");
        this.requested_sum = sum;
        this.current_balance = balance;
        
    }

    public double getAmount(){ return this.requested_sum; }
    public double getBalance() {return this.current_balance; }
    public double getMissingAmount() {return (this.current_balance - this.requested_sum) * (-1); }

}