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
        this.elems = new Pair[10];
		this.count = 0;
    }

    @Override
    public void put(String key, Integer value) {
        if (key != null && value != null){
			if (this.count > this.elems.length -1 ) {this.increaseCapacity();}
			this.elems[this.count] = new Pair(key, value);
			this.count++;
		}
    }

    private void increaseCapacity() {
		Pair[] larger_elems = new Pair[this.elems.length + INCREMENT];
			for (int i = 0; i < this.elems.length; i ++) {
				larger_elems[i] = this.elems[i];
			}
			this.elems = larger_elems;
        /* Your code here.  Use this in put() where necessary. */
    }

    @Override
    public boolean contains(String key) {
        if (key == null) {return false;}
		for (int i = 0; i < this.elems.length; i++) {
			if (this.elems[i].getKey().equals(key)) {return true;}
		}
		return false;
    }

    @Override
    public Integer get(String key) {
		if (!this.contains(key)) {return null;}
		for (int i = this.count; i >= 0; i--) {
			if (this.elems[i].getKey().equals(key)) {return this.elems[i].getValue();}
		}
		return null;
		
        /* Your code here. */
    }

    @Override
    public void replace(String key, Integer value) {
        for (int i = this.count; i >= 0; i--) {
			if (this.elems[i].getKey().equals(key)) {this.elems[i].setValue(value);}
		}
    }

    @Override
    public Integer remove(String key) {
      for (int i = this.count; i >= 0; i--){
        if (this.elems[i].getKey().equals(key)) {
			    Integer value = this.elems[i].getValue();
			    this.elems[this.count] = null;
			    this.count --;
          return value;
			  }
      }
			return null;
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