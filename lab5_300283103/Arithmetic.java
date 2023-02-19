
public class Arithmetic extends AbstractSeries {
	private double index;
	double cur_counter;


	public Arithmetic() {
		this.index = 1;
		this.cur_counter = 0;
	}
	
	
	public double next() {
		this.cur_counter += this.index;
		this.index++;
		return this.cur_counter;
	}

}
