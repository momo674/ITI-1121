public class ArrayStack<T> implements Stack <T> {
	
	private T[] elems;
	private int top; // designates the first **free** cell
	
	//constructor class
	@SuppressWarnings("unchecked") //our way of telling java to stfu
	public ArrayStack(int capacity){
		this.elems = (T[]) new Object[capacity];
		this.top = 0;
	}
	
	//tells if its empty if top is at 0 index
	public boolean isEmpty(){
		return (top == 0);
	}
	//adds to top of stack
	public void push(T o){
		// pre-condition is that the stack is not full.
		elems[top] = o;
		top++;
	}
	//removes and returns the top of a stack
	public T pop() {
		//pre-condition is that the object is not empty
		top = top - 1;
		T saved = elems[top];
		elems[top] = null;
		return saved;
	}
	//returns the top of a stack
	public T peek() {
		//pre-condition is that the object is not empty
		return elems[top-1];
	}
	
}