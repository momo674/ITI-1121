/**
 * COPYRIGHTED MATERIAL -- DO NOT DISTRIBUTE
 *
 * @author Guy-Vincent Jourdan
 * @author Mehrdad Sabetzadeh 
 */

public class UniquifiableArrayStack<E> extends ArrayStack<E> {

	public Stack<E> uniquify() {
	  Stack<E> reversed_final = new ArrayStack<E>();
	  Stack<E> reversed_original = new ArrayStack<E>();
	  
	  //creating reversed stacks first
	  while (!this.isEmpty()) {
		  E highlighted_element = this.pop();
		  if (reversed_final.isEmpty()){
			  reversed_final.push(highlighted_element);
			  reversed_original.push(highlighted_element);
		  }
		  else{
			  if (!highlighted_element.equals(reversed_final.peek())) {
				  reversed_final.push(highlighted_element);
			  }
			  reversed_original.push(highlighted_element);
			  }
	  }
	  Stack<E> last_final = new ArrayStack<E>();
	  while (!reversed_final.isEmpty()) {
		  last_final.push(reversed_final.pop());
	  }
	  
	  while (!reversed_original.isEmpty()) {
		  this.push(reversed_original.pop());
	  }
	  return last_final;
	}

}