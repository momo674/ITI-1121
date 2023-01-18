class MyInteger {
    private int value;
    public MyInteger(int v){
        this.value = v;
    }
    public int getValue() { //getters return values
        return this.value;
    }
    public void setValue(int val){ //setters set values but return nothing.
        this.value = val;
    }
}