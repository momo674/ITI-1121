public class Counter{
	private int count = 0;
	
	public int getValue(){
		return this.value;
	}
	public void setValue(int new_value){
		this.count = new_value;
	}
	public int incr(){
		return (this.count ++);
		
	}
	public void reset(){
		this.count = 0;
	}
}