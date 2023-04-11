public class ITIStringBuffer {
    private SinglyLinkedList<String> data;
    private int counter = 0;
    public ITIStringBuffer() {
        this.data = new SinglyLinkedList<>();
        this.counter = 0;
    }

    public ITIStringBuffer(String  firstString){
        
        this.data = new SinglyLinkedList<>();
        this.append(firstString);
        this.counter = firstString.length();
    }

    public void append(String nextString){
        this.counter+= nextString.length();
        this.data.add(nextString);
        
    }

    public String toString(){
        char[] result_array = new char[counter];
        int i = 0;
        for (String x: this.data) {
            char[] temp = x.toCharArray();
            System.arraycopy(temp,0,result_array,i,temp.length);
            i += temp.length;
        }
        String result = new String(result_array);
        return result;
    }

}
