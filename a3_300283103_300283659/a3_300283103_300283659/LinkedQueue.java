/**
 * @author Marcel Turcotte, Guy-Vincent Jourdan and Mehrdad Sabetzadeh
 *         (University of Ottawa)
 * 
 * 
 */

// TODO:
// 1) keep track of size and implement a size() method
// 2) write a peek method

public class LinkedQueue<D> implements Queue<D> {

    private static class Elem<T> {
        private T value;
        private Elem<T> next;

        private Elem(T value, Elem<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Elem<D> front;
    private Elem<D> rear;

    public LinkedQueue() {
        front = rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(D newElement) {

        if (newElement == null) {
            throw new NullPointerException("Only non-null objects may be added to queue.");
            // could have been IllegalArgumentException but NPE seems
            // to be the norm
        }

        Elem<D> newElem;
        newElem = new Elem<D>(newElement, null);
        if (isEmpty()) {
            front = newElem;
            rear = newElem;
        } else {
            rear.next = newElem;
            rear = newElem;
        }
    }

    public D dequeue() {

        if (isEmpty()) {
            throw new IllegalStateException("Dequeue method called on an empty queue");
        }

        D returnedValue;
        returnedValue = front.value;

        if (front.next == null) {
            front = rear = null;
        } else {
            front = front.next;
        }

        return returnedValue;
    }

    public D peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException("peek method cannot be called on an empty queue");
        }

        D returnedValue = this.front.value;
        return returnedValue;
    }

    public int size() {
        if (this.isEmpty()) {return 0;}
        int counter = 0;
        Elem<D> cursor = this.front;
        while (cursor.next != null) {
            Elem<D> cursor_next = cursor.next;
            cursor = cursor_next;
            counter++;

        }

        return counter + 1;
    }

    public String toString() {

        StringBuffer returnedValue = new StringBuffer("[");

        if (!isEmpty()) {
            Elem<D> cursor = front;
            returnedValue.append(cursor.value);
            while (cursor.next != null) {
                cursor = cursor.next;
                returnedValue.append(", " + cursor.value);
            }
        }

        returnedValue.append("]");
        return returnedValue.toString();

    }
}
