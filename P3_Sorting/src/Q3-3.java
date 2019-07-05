import java.util.Arrays;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;


public class Q3 {

	public static void main(String[] args) {

		// 10^3
		Comparable[] arr3 = new Comparable[1000]; 
		arr3 = populateArray(arr3);
		double[] time3 = multipleM(arr3);
		
		// 10^4
		Comparable[] arr4 = new Comparable[10000]; 
		arr4 = populateArray(arr4);
		double[] time4 = multipleM(arr4);
		
		// 10^5
		Comparable[] arr5 = new Comparable[100000]; 
		arr5 = populateArray(arr5);
		double[] time5 = multipleM(arr5);
		
		// 10^6
		Comparable[] arr6 = new Comparable[1000000]; 
		arr6 = populateArray(arr6);
		double[] time6 = multipleM(arr6);

		System.out.println(Arrays.toString(multipleM(arr3))); 
		System.out.println(Arrays.toString(multipleM(arr4))); 
		System.out.println(Arrays.toString(multipleM(arr5))); 
		System.out.println(Arrays.toString(multipleM(arr6))); 
	}
	
	// Run quick cut to insertion for multple m values 
	// For a givev value of array size
	static double[] multipleM (Comparable[] arr) {
		double[] timesM = new double[30]; 
		
		for (int m1 = 1; m1 <= 30; m1++) {

			
			double avgTime = 0; 
			for (int i = 0; i < 10; i++) {
				StdRandom.shuffle(arr);
				double startTime = System.nanoTime(); 
				quickCuttoff(arr, m1, 0, arr.length - 1);
				double endTime = System.nanoTime();
				avgTime += (endTime - startTime);
			}
			
			avgTime = avgTime / 10.0;
			timesM[m1-1] = avgTime; 
		}
		
		
		return timesM; 
	}

	
	// Quick Sort with cutoff
	static void quickCuttoff(Comparable[] arr, int cutoff, int low, int hi) {
		if (low + cutoff - 1 >= hi) {
			Insertion.sort(arr, low, hi);
			return;
		}
		int index = partition(arr, low, hi);

		quickCuttoff(arr, cutoff, low, index - 1);
		quickCuttoff(arr, cutoff, index + 1, hi);
		
	}

	// print array
	static void printArr(Comparable[] arr) {
		System.out.println();
		for (Comparable i : arr)
			System.out.print(i + " ");
		System.out.println();
	}
	
	// populate array
	static Comparable[] populateArray (Comparable[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = StdRandom.gaussian(0, 100000); 
		}
		return arr; 
	}


	// Helper Methods
	// Sedgewick & Wayne, (2018) Algs4Jar

	// From : Sedgewick & Wayne, (2018) Algs4Jar
	/**
	 * Rearranges the subarray a[lo..hi) in ascending order, using the natural
	 * order.
	 * 
	 * @param a  the array to be sorted
	 * @param lo left endpoint (inclusive)
	 * @param hi right endpoint (exclusive)
	 */
	public static void insertionSort(Comparable[] a, int lo, int hi) {
		for (int i = lo + 1; i < hi; i++) {
			for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
		}
		assert isSorted(a, lo, hi);
	}

	// From : Sedgewick & Wayne, (2018) Algs4Jar
	// partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
	// and return the index j.
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		Comparable v = a[lo];
		while (true) {

			// find item on lo to swap
			while (less(a[++i], v)) {
				if (i == hi)
					break;
			}

			// find item on hi to swap
			while (less(v, a[--j])) {
				if (j == lo)
					break; // redundant since a[lo] acts as sentinel
			}

			// check if pointers cross
			if (i >= j)
				break;

			exch(a, i, j);
		}

		// put partitioning item v at a[j]
		exch(a, lo, j);

		// now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
		return j;
	}

	/***************************************************************************
	 * Helper sorting functions.
	 ***************************************************************************/
	// From : Sedgewick & Wayne, (2018) Algs4Jar
	// is v < w ?
	private static boolean less(Comparable v, Comparable w) {
		if (v == w)
			return false; // optimization when reference equals
		return v.compareTo(w) < 0;
	}

	// From : Sedgewick & Wayne, (2018) Algs4Jar
	// exchange a[i] and a[j]
	private static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	// From : Sedgewick & Wayne, (2018) Algs4Jar
	// is the array a[lo..hi) sorted
	private static boolean isSorted(Comparable[] a, int lo, int hi) {
		for (int i = lo + 1; i < hi; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

}

