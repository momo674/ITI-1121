public class LinkedQueue<D> implements Queue<D> {
    private static class Elem<T> {
        private T value;
        private Elem<T> next;
        private Elem (T value, Elem<T> next) {
            this.value = value;
            this.next = next;
        }
    }
    private Elem<D> front; 
    private Elem<D> rear;
    public LinkedQueue(){              
        front = rear = null; //optional !/!?!?/!?////!??????????1!!!!!^668327 vnbdfh /*//**// */ */
    }
    public boolean isEmpty() {
        return this.front == null;
    }

    public void enqueue(D newElement) {
        if (newElement == null) {
            throw new NullPointerException("No null in my queue!");
        }
        else {
            Elem<D> newElem = new Elem<D>(newElement, null);

            if (this.isEmpty()) { 
                this.front = this.rear = newElem;
            }

            else {
                this.rear.next = newElem;
                this.rear = newElem;
            }

        }
    }

    public D dequeue() {
        //precondition: queue must not be empty!

        if (this.isEmpty()) {
            throw new IllegalStateException ("Empty queue!");
        }

        else {
            D result = front.value;

            // special case: single element in the queue

            if (this.front.next == null) {
                front = rear = null;
            }

            else {
                this.front = front.next;
            }
            return result;
        }
        
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer("[");

        if (!isEmpty()){
            Elem<D> cursor = front;
            buffer.append(cursor.value);
            
            while (cursor.next != null){
                cursor = cursor.next;
                buffer.append(", ");
                buffer.append(cursor.value);
            }
        }

        buffer.append("]");

        return buffer.toString();
    }


}
