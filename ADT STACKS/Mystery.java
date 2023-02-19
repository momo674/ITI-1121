public class Mystery {
    public static void main (String[] args){
        Stack <String> stack = new StackImplementation <String>();
        for (int i = 0; i <args.length(); i++){
            stack.push(args[i]);
        }

        while (! stack.empty()){
            System.out.print(stack.pop())
        }
    }
}