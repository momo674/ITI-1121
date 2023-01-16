import java.util.*;
import java.util.Scanner;
public class Q6{
	public static void main(String[] args){
        double[] grades = new double[10];
        int i = 0;
        while (i<10){
            Scanner prompt = new Scanner(System.in);
			System.out.print("Please enter a grade. " + (i) + "/10 grades enetered. " );
            double grade_enter = prompt.nextDouble();
            grades[i] = grade_enter;
            i++;
			if(i==10){
				prompt.close();
			}
        }
		
        
        for(int j = 0; j <grades.length; j++){
            System.out.println(grades[j]);
        }
		System.out.println("The class average is: " + calculateAverage(grades));
		System.out.println("The class median is: " + calculateMedian(grades));

		

	}

	public static double calculateAverage(double[] notes){
		double tmp = 0;
		for (int i = 0; i<notes.length;i++){
			tmp = tmp + notes[i];
		}
		return (tmp/(notes.length));
	}

	public static double calculateMedian(double[] notes){
		int i, j, argMin; 
		double tmp;
		for (i=0; i <notes.length -1; i++) {
			argMin = i;
			for(j = i+ 1; j<notes.length; j++){
				if (notes[j] < notes[argmin]){
					argMin= j;
				}
			}
			tmp = notes[argMin];
			notes[argMin] = notes[i];
			notes[i] = tmp;
		}
		
		double answer = notes[((notes.length) /2)];
		return answer;
		
		
	}

	public static int calculateNumberFailed(double[] notes){
		//your code here
	}

	public static int calculateNumberPassed(double[] notes){
		//your code here
	}

}
