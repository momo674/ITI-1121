import java.util.NoSuchElementException;

public class OrderedList implements OrderedStructure {

    // Implementation of the doubly linked nodes (nested-class)

    private static class Node {

        private Comparable value;
        private Node previous;
        private Node next;

        private Node(Comparable value, Node previous, Node next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }

    // Instance variables

    private Node head;

    // Representation of the empty list.

    public OrderedList() {
        // Your code here.
        Node dummy = new Node(null, null, null);
        dummy.next = dummy;
        dummy.previous = dummy;
        this.head = dummy;

    }

    // Calculates the size of the list

    public int size() {
        if (this.head.next == (this.head)) {// emptylist
            return 0;
        }

        else {
            int counter = 0;
            Node cursor = this.head;
            while (!cursor.next.equals(this.head)) {
                cursor = cursor.next;
                counter++;
            }
            return counter ;
        }

    }

    public Object get(int pos) {
        if (pos > this.size() - 1 || pos < 0) {
            throw new IndexOutOfBoundsException(pos);
        } else {
            Node cursor = head;
            int i = -1;
            while (i < pos) {
                cursor = cursor.next;
                i++;
            }
            return cursor.value;
        }

    }

    // Adding an element while preserving the order

    public boolean add(Comparable o) {
        if (o == null) {
            throw new NullPointerException("object cant be null");
        } else if (!(o instanceof Comparable)) {
            throw new IllegalArgumentException("object is not of type Comparable");
        }

        else {
            Node obj = new Node(o, null, null); // our object as a node
            if (this.size() == 0) { // empty list
                this.head.next = obj;
                this.head.previous = obj;
                obj.next = this.head;
                obj.previous = this.head;
                return true;
            }

            Node cursor = this.head.next;

            while (!cursor.equals(head)) { //checking if it can fit between
                if (obj.value.compareTo(cursor.value) <= 0) {
                    Node cursor_previous = cursor.previous;
                    cursor_previous.next = obj;
                    cursor.previous = obj;
                    obj.next = cursor;
                    obj.previous = cursor_previous;
                    return true;
                }
                cursor = cursor.next;
            }
            //ading to end
            cursor = this.head.previous;
            this.head.previous = obj;
            obj.next = this.head;
            cursor.next = obj;
            obj.previous = cursor;
            return true;


            
        }
    }

    // Removes one item from the position pos.

    public void remove(int pos) {
        // Remove line below and add your implementation.
        if (pos > this.size() - 1 || pos < 0) {
            throw new IndexOutOfBoundsException(pos);
        }

        else {
            if (this.size() == 1) { // only one item in list
                this.head.next.next = null;
                this.head.next.previous = null;
                this.head.next = this.head;
                this.head.previous = this.head;
                return;
            }

            else if (pos == this.size() - 1) { // removing end of a list
                Node end = this.head.previous;
                Node new_end = this.head.previous.previous;
                this.head.previous = new_end;
                new_end.next = this.head;
                this.head.previous = end.previous;
                end.previous.next = this.head;
                end.previous = null;
                end.next = null;
                return;
                //end.value = null;
                //end = null;
                
            }
            else if (pos == 0) { // removing the beginning of a list
                Node front = this.head.next;
                Node front_new = front.next;
                this.head.next = front_new;
                front_new.previous = this.head;
                front.next = null;
                front.previous = null;
                front.value = null;
                front = null;
                return;

            }

            else { // general case
                Node cursor = head;
                int i = -1;
                while (i < pos) {
                    cursor = cursor.next;
                    i++;
                }
                Node cursor_previous = cursor.previous;
                Node cursor_next = cursor.next;
                cursor_previous.next = cursor_next;
                cursor_next.previous = cursor_previous;
                cursor.next = null;
                cursor.previous = null;
                cursor.value = null;
                cursor = null;
                return;
            }
            // general case

        }
    }

    // Knowing that both lists store their elements in increasing
    // order, both lists can be traversed simultaneously.

    public void merge(OrderedList other) {
        for (int i = 0; i <= other.size() -1; i++) {
            this.add((Comparable) other.get(i));
        }
    }
}