public class Test2{
    public static void display(int a) { //a is a parameter here
        System.out.println ("a = " + a);
    }
    // old display method had no parameter, resulting in error
    public static void main( String[] args){
        int a;
        a = 9;
        if (a< 10){
            a++;
        }
        display(a);
        System.out.println("Scream if you see this line in terminal");
    }
}