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
        System.out.println(calculateNumberFailed(grades)+ " students have failed.");
        System.out.println(calculateNumberPassed(grades) + " students have passed.");
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
		int size=notes.length;
        double temp;
        for (int i = 0; i < size; i++){
            for (int j = i + 1; j<size; j++){
                if(notes[i] > notes[j]){
                    temp = notes[i];
                    notes[i] = notes[j];
                    notes[j] = temp;
                }
            }
        }
        int index1 = size/2;
        int index2 = index1 + 1;
        double median = ((notes[index1] + notes[index2])/2);
        return median;
        
	}

	public static int calculateNumberFailed(double[] notes){
		int counter = 0;
        for(int i =0; i<notes.length;i++){
            if (notes[i] < 50.00){
                counter++;
            }
        }
        return counter;
	}

	public static int calculateNumberPassed(double[] notes){
		return (notes.length - calculateNumberFailed(notes));
	}

}
