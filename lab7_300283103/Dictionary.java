import java.util.NoSuchElementException;

public class Dictionary implements Map<String, Integer> {

    private final static int INITIAL_CAPACITY = 10;
    private final static int INCREMENT = 5;
    private int count;

    private Pair[] elems;

    public int getCount() {
      return count;
    }

    public int getCapacity() {
      return elems.length;
    }

    public Dictionary() {
        this.elems = new Pair[INITIAL_CAPACITY];
        this.count = 0;
    }

    @Override
    public void put(String key, Integer value) {
        if (key == null || value == null) {	throw new NullPointerException("key or value is null");}
        else{
            if (this.count == this.elems.length) {this.increaseCapacity();}
            this.elems[this.count] = new Pair(key,value);
            this.count++;
        }
    }

    private void increaseCapacity() {
        Pair[] new_elems = new Pair[this.elems.length + INCREMENT];
        int new_count = 0;
        for (int i = 0; i < this.elems.length; i++){
            new_elems[i] = this.elems[i];
            new_count++;
        }
        this.elems = new_elems;
        this.count = new_count;
    }

    @Override
    public boolean contains(String key) {
        if (key == null) { throw new NullPointerException("key or value is null");}
        for (int i = 0; i < this.elems.length; i++) {
            if (this.elems[this.elems.length - 1 - i] != null){
                if (this.elems[this.elems.length - 1 - i].getKey().equals(key)) {
                    return true;
                }
            }
            
        }
        return false;  
    }

    @Override
    public Integer get(String key) {
        if (key == null) { throw new NullPointerException("key or value is null");}
        for (int i = 0; i < this.elems.length; i++) {
            if (this.elems[this.elems.length - 1 - i] != null){
                if (this.elems[this.elems.length - 1 - i].getKey().equals(key)) {
                    return (this.elems[this.elems.length - 1 - i].getValue());
                }
                else {
                    throw new NoSuchElementException();
                }
            }
            
        }
        return -1;
    }

    @Override
    public void replace(String key, Integer value) {
        if (key == null) {throw new NullPointerException("key or value is null");}
        for (int i = 0; i < this.elems.length; i++) {
            if (this.elems[this.elems.length - 1 - i] != null){
                if (this.elems[this.elems.length - 1 - i].getKey().equals(key)) {
                    this.elems[this.elems.length - 1 - i].setValue(value);
                }
                else {
                    throw new NoSuchElementException();
                }
            }
            
        }
        return;
    }

    @Override
    public Integer remove(String key) {
        if (key == null) {throw new NullPointerException("key or value is null");}
        for (int i = 0; i < this.elems.length; i++) {
            if (this.elems[this.elems.length - 1 - i] != null){
                if (this.elems[this.elems.length - 1 - i].getKey().equals(key)) {
                    Integer desired= (this.elems[this.elems.length - 1 - i].getValue());
                    this.elems[this.elems.length - 1 - i] = null;
                    this.count--;
                    return desired;
                }
                else {throw new NoSuchElementException();}
            }
            
        }
        return -1;
    }

    @Override
    public String toString() {
      String res;
      res = "Dictionary: {elems = [";
      for (int i = count-1; i >= 0 ; i--) {
          res += elems[i];
          if(i > 0) {
              res += ", ";
          }
      }
      return res +"]}";
    }

}