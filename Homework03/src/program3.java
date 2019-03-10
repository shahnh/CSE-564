import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.Shell;
import edu.princeton.cs.algs4.StdRandom;

public class program3 {
	public static void main(String[] args) throws IOException {
		// System.out.println(Arrays.toString(a));
		char[] vars = { 'I', 'S', 'H' };
		for(char var: vars) {
			double[] sortSize = {1000, 2000, 4000, 8000, 16000};
			double[] sortTime = new double[5];

			for(int i = 0; i < sortSize.length; i++) {
				double totalTime = 0;
				for(int j = 0; j<10; j++) {
					totalTime += time(randomGen(sortSize[i]), var);
				}
				sortTime[i] = totalTime/10;
			}
			//System.out.println("Size is " + Arrays.toString(sortSize));
			//System.out.println("Time is " + Arrays.toString(sortTime));
			printModel(sortSize, sortTime);
		}
	}
	private static double time(Integer[] a, char s) {
		long startTime = 0;
		long endTime = 0;
		if(s == 'I') {
			startTime = System.nanoTime();
			Insertion.sort(a);
			endTime = System.nanoTime();
		}
		if(s == 'S') {
			startTime = System.nanoTime();
			Selection.sort(a);
			endTime = System.nanoTime();
		}
		if(s == 'H') {
			startTime = System.nanoTime();
			Shell.sort(a);
			endTime = System.nanoTime();
		}
		double total_time = ((endTime - startTime) / 1000000000.0)/100;
		//System.out.println(total_time);
		//System.out.println("Size of a is " + a.length);
		return total_time;
	}

	private static Integer[] randomGen(double size) {
		Integer[] a = new Integer[(int)size];
		for (int j = 0; j < size; j++) {
			a[j] = StdRandom.uniform(50000);
		}
		return a;
	}

	// Method to print all info about model we create
	// Model we are creating is:
	// T(N) = a * N ^ b
	// Technique used is doubling
	public static void printModel(double[] sizes, double[] times) {

		// array to store rations of times
		double[] ratios = new double[(times.length - 1)];
		// array to store log of ratios
		double[] lratios = new double[(times.length - 1)];
		// average value of b
		double b = 0;
		// average value of a
		double a = 0;

		// Method to calculate ratios
		for (int i = 0; i < ratios.length; i++) {
			ratios[i] = times[i + 1] / times[i];
		}

		// Calc log base 2 of ratios
		for (int i = 0; i < ratios.length; i++) {
			lratios[i] = Math.log(ratios[i]) / Math.log(2);
		}

		// Average value of b
		double tempSum = 0;
		for (int i = 0; i < lratios.length; i++) {
			tempSum += lratios[i];
		}
		b = tempSum / lratios.length;

		// Average value of a
		double [] aArray = new double[ratios.length];
		for (int i = 0; i < aArray.length; i++) { 
			aArray[i] = times[i] / Math.pow(sizes[i], lratios[i]) ; 
		}
		tempSum = 0; 
		for (int i = 0; i < aArray.length; i++) { 
			tempSum += aArray[i]; 
		}
		a = tempSum / aArray.length; 
		// Prediction According to model
		double[] predict = new double[sizes.length]; 
		for (int i = 0; i < predict.length; i++) { 
			predict[i] = a * Math.pow(sizes[i], b) ; 
		}
		System.out.println("a: " + a);
		System.out.println("b: " + b);
//		for(int i = 0; i < 5; i++) {
//			System.out.printf("Input size = %f | Actual runtime = %.6f |"
//					+ " Predited runtime = %.6f |",sizes[i], times[i], predict[i]);
//		}
	}

	public static void printArr( double [] o ) {

		for (int i = 0; i < o.length; i++){
			System.out.println(o[i]); 
		}

	}
}
