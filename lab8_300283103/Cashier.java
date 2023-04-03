public class Cashier {
    private Queue<Customer> queue;
    private Customer currentCustomer;
    private int totalCustomerWaitTime;
    private int customersServed;
    private int totalItemsServed;

    public Cashier() {
        this.queue = new ArrayQueue<Customer>();
        this.totalCustomerWaitTime = 0;
        this.customersServed = 0;
        this.totalItemsServed = 0;
        this.currentCustomer = null;
    }

    public void addCustomer(Customer c) {
        this.queue.enqueue(c);
    }

    public int getQueueSize() {
        return this.queue.size();
    }

    public void serveCustomers(int currentTime) {
        if (!this.queue.isEmpty()) {

            if (this.currentCustomer == null) {
                this.currentCustomer = this.queue.dequeue();
                this.customersServed++;
                
            }
            
            this.totalCustomerWaitTime += currentTime;

            this.currentCustomer.serve();
            this.totalItemsServed ++;
            if (this.currentCustomer.getNumberOfItems() == 0) {
                this.currentCustomer = null;
                
            }
        }
        if (this.queue.isEmpty() && this.currentCustomer != null) {
            this.totalCustomerWaitTime = this.currentCustomer.getArrivalTime();

            this.currentCustomer.serve();
            this.totalItemsServed++;
            if (this.currentCustomer.getNumberOfItems() == 0) {
                this.currentCustomer = null;
                
            }
        }
    }

    public int getTotalCustomerWaitTime() {
        return this.totalCustomerWaitTime;
    }

    public int getTotalCustomersServed() { return this.customersServed; }
    public int getTotalItemsServed() { return this.totalItemsServed; }

    public String toString() {
        String result = "The total number of customers served is " + this.customersServed + "\n" + "The average number of items per customer was " + (this.totalItemsServed/this.customersServed) + "\n" +  "The average waiting time (in seconds) was " + (this.totalCustomerWaitTime/this.customersServed);
        return result;
    }
}