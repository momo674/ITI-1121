import java.util.Stack;
public class StacksRFun{
	//Stacks are linear data structure like arrays but insertions and deletions are only allowed at the END (aka the top of a stack)
	//we think of a stack as a vetical stack, where the top of the stack is the end (stack of books)
	//we can only add add to the top of stack
	public static void main(String[] args){
		// Stack <String> games = new Stack<String>();
		
		// games.add("Call of Duty");
		// games.add("Guitar Hero");
		// games.add("Super Monkey Ball");
		// // System.out.println(games.pop());
		// // System.out.println(games.pop()); //pop returns the top of a stack and removes it from the stack

		// System.out.println(games.peek());  //peek returns the top of a stack
		// System.out.println(games);


		//We want to turn this stack of coloured legos into an actaul stack
		// Y
		// B
		// R
		Stack <Character> tower = new Stack<Character>();
		tower.add('R');
		tower.add('B');
		tower.add('Y');
		
		System.out.println(tower.peek()); //returns Y
		System.out.println(tower.pop()); //returns and removes Y
		System.out.println(tower); //returns stack (Y not in Stack)
		System.out.println(tower.contains('P')); //returns false
		System.out.println(tower.contains('B')); //returns true
		System.out.println(tower.empty()); //returns false
		System.out.println(tower.get(1)); //returns B
		System.out.println(tower.get(0)); //returns R
		//IMPORTANT!!!! Indexes go from bottom to top, so when you peek at a stack your only viewing the top of a stack.
		System.out.println(tower.set(0,'O')); //stack at index 0 wil be O for orange.
		System.out.println(tower); //returns stack (O for bottom of stack)
		System.out.println(tower.size()); //returns size (length) of stack
	}
}