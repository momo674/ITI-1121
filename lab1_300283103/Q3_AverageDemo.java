public class Q3_AverageDemo{
	public static void main(String[] args){
		double[] valuesArray;
		valuesArray = new double[]{100.0,34.0,72.0,56.0,82.0,67.0,94.0};
		System.out.println("The average is: " + calculateAverage(valuesArray));
	}

	//method that calculates the average of the numbers in an array
	public static double calculateAverage(double[] values){
		double result = 0;
		double temp = 0;
        int j = 0;
        for(int i = 0; i<values.length; i++){
            temp += values[i];
            j++;
        }
        result = temp / j;
		return result;
	}
}