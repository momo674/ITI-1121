import java.util.Random;

public class Customer {
    private int arrivalTime;
    private int initialNumberOfItems;
    private  int numberOfItems;
    public static int MAX_NUM_ITEMS = 25; //???

    public Customer (int time) {
        this.arrivalTime = time;
        
        Random generator;
        generator = new Random();

        this.initialNumberOfItems = generator.nextInt(MAX_NUM_ITEMS-1)+1;
        this.numberOfItems = this.initialNumberOfItems;
        

    }

    public int getArrivalTime() {
        return this.arrivalTime;
    }

    public int getNumberOfItems() {
        return this.numberOfItems;
    }

    public int getNumberOfServedItems() {
        return this.initialNumberOfItems - this.numberOfItems;
    }

    public void serve() {
        this.numberOfItems --;
    }
}