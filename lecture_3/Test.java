class Test {
    public static void increment ( MyInteger a) {
       a.setValue(a.getValue() + 1) ; //since method returns void, we must use a setter method and use a getter method as parameter + 1
       //if it were to return int, the value would still be the same value when we call it's getter.
    }
    public static void main(String[] args){
        MyInteger a = new MyInteger (5);
        System.out.println("Before: " + a.getValue());
        increment(a);
        System.out.println("After: " + a.getValue());
    }
}


