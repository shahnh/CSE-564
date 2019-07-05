import java.util.Arrays;
import java.util.Random;

import edu.princeton.cs.algs4.BinarySearch;


public class Homework02 {
	public static void main(String[] args) {
		int[] n = new int[64000];
		Random rand = new Random();
		int max = 5000;
		int min = -5000;
		for(int i = 0; i < n.length; i++) {
			n[i] = rand.nextInt((max - min) + 1) + min;
		}
		long startTime = System.nanoTime();
		for(int i = 0; i<100; i++) {
			TwoSumFast.count(n);
		}
		long endTime = System.nanoTime();
		double total_time = ((endTime - startTime) / 1000000000.0)/100;
		System.out.println(total_time);
	}



	private static class ThreeSum {
		public static int count(int[] a) { // Count triples that sum to 0.
			int N = a.length;
			int cnt = 0;
			for (int i = 0; i < N; i++)
				for (int j = i+1; j < N; j++)
					for (int k = j+1; k < N; k++)
						if (a[i] + a[j] + a[k] == 0)
							cnt++;
			return cnt;
		}
	}

	private static class TwoSum {
		public static int count(int[] a) { // Count triples that sum to 0.
			int N = a.length;
			int cnt = 0;
			for (int i = 0; i < N; i++)
				for (int j = i+1; j < N; j++)
					if (a[i] + a[j] == 0)
						cnt++;
			return cnt;
		}
	}

	private static class ThreeSumFast {
		public static int count(int[] a) { // Count triples that sum to 0.
			Arrays.sort(a);
			int N = a.length;
			int cnt = 0;
			for (int i = 0; i < N; i++)
				for (int j = i+1; j < N; j++)
					if (BinarySearch.rank(-a[i]-a[j], a) > j)
						cnt++;
			return cnt;
		}
	}
	/**
	 * 
	 * @author https://searchcode.com/codesearch/view/49391673/
	 *
	 */
	private static class TwoSumFast {
		public static int count(int[] a) {
			Arrays.sort(a);
			int N = a.length;
			int cnt = 0;
			for(int i = 0; i < N; i++)
				if(BinarySearch.rank(-a[i], a) > i)
					cnt++;
			return cnt;
		}
	}
}
