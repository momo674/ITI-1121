public class Geometric extends AbstractSeries {
	private double index;
	double cur_counter;

	public Geometric() {
		this.index = 1;
		this.cur_counter = 0;
	}
    public double next() {
		this.cur_counter += (1/ Math.pow(2, index-1));
		this.index++;
		return this.cur_counter;
        

    }
}