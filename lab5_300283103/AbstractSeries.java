public abstract class AbstractSeries implements Series {

    public double[] take(int k) {
    	double[] list = new double[k];
    	for (int i = 0; i < k; i++) {
    		list[i] = next();
    	}
        return list;
        
    }

}