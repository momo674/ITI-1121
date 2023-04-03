public class CircularQueue<E> implements Queue<E> {
    private E[] q;
    private int capacity = 1000;
    private int front, rear;
    

    public CircularQueue() {
        this.q = (E[]) new Object[this.capacity];
        this.rear = -1; //sentienel value denotes empty queue
        this.front = 0;
    }

    public CircularQueue (int cap) {
        this.capacity = cap;
        this.q = (E[]) new Object[this.capacity];
        this.rear = -1;
        this.front = 0;
    }

    public boolean isEmpty() {
        return rear == -1 ;
    }

    public boolean isFull() {
        return !isEmpty() && ((rear+1)%capacity == front);
    }

    public void enqueue (E o) {
        if (o == null) {
            throw new NullPointerException ("No null object in my queue ! ");
        }

        if (this.isFull()) {
            throw new IllegalStateException ("Queue full! ");
        }

        rear = (rear + 1) % capacity;
        q[rear] = o;
    }

    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException ("Queue empty!");
        }

        return q[front];
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("empty queue...");
        }
        E result = q[front];

        if (rear == front) { //dequeing is going to leave the queue empty
            rear = -1;
            front = 0;
        } 

        else { front = (front+1) % capacity ;}


    return result;
    }
    
}