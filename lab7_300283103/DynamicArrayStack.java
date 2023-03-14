import java.util.EmptyStackException;

public class DynamicArrayStack<E> implements Stack<E> {

    // Instance variables

    private E[] elems;  // Used to store the elements of this ArrayStack
    private int top;    // Designates the first free cell
    private static final int DEFAULT_INC = 25;   //Used to store default increment / decrement

    @SuppressWarnings( "unchecked" )

    // Constructor
    public DynamicArrayStack( int capacity ) {
        if (capacity < DEFAULT_INC) {capacity = DEFAULT_INC; }
        this.elems = (E[]) new Object[capacity];
        this.top = 0;
    }

    // Gets current capacity of the array
    public int getCapacity() {
        return elems.length;
    }

    // Returns true if this DynamicArrayStack is empty
    public boolean isEmpty() {
        return ( top == 0 );
    }

    // Returns the top element of this ArrayStack without removing it
    public E peek() {
        if (top == 0) {throw new EmptyStackException();}
        return elems[ top-1 ];
    }

    @SuppressWarnings( "unchecked" )

    // Removes and returns the top element of this stack
    public E pop() {
        if (this.top == 0) {
            throw new EmptyStackException();
        }
        if (this.top <= this.getCapacity() && this.getCapacity() > DEFAULT_INC){
            E[] new_elems = (E[]) new Object[this.elems.length - DEFAULT_INC];
            int new_top = 0;
            for (int i = 0; i < new_elems.length; i ++){
                new_elems[i] = this.elems[i];
               new_top++;
            }
            this.elems = new_elems;
            this.top = new_top;
        }
        E value = this.elems[top-1];
        this.elems[top-1] = null;
        top--;
        return value;
    }


    @SuppressWarnings( "unchecked" )

    // Puts the element onto the top of this stack.
    public void push( E element ) {
        if (this.top == 0) {
            throw new EmptyStackException();
        }
        if (this.top == this.elems.length) {
            E[] next = (E[]) new Object[this.elems.length + DEFAULT_INC];
            for (int i = 0; i < this.elems.length ; i++){
                next[i] = this.elems[i];
            }
            this.elems = next;
        }

        this.elems[this.top] = element;
        this.top++;
    }

    @SuppressWarnings( "unchecked" )

    public void clear() {
        this.elems = (E[]) new Object[DEFAULT_INC];
        this.top = 0;
    }

}