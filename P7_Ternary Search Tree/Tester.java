import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.TST;


public class Tester {

	public static String[] words = new String[466547];
	public static int[] index; 
	public static TST<Integer> tst = new TST<Integer>();
	public static BST<String, Integer> bst = new BST<String, Integer>();
	
	public static void main(String[] args) throws FileNotFoundException {

		fileRead();
		
		Pattern p;
		Matcher m;
		for(int i = 0; i < words.length; i++) {
			p = Pattern.compile("[MNmn]{1}[a-z]{4,6}ed");
			m = p.matcher(words[i]);
			while(m.find())
				System.out.println(m.group());
	    }	
	}
	
	/**
	 * Returns time taken to search for 30, 40, 50 and 60 input sizes
	 * @return times
	 */
	public static long[] successSearchBST() {
		long[] successSearchBSTTimes = new long[4];
		long startTime, endTime;

		startTime = System.nanoTime();
		// First 30 
		for (int i = 0; i < 3000000; i++) {
			bst.contains(words[index[i % 300]]); 
		}
		endTime = System.nanoTime(); 
		successSearchBSTTimes[0] = (endTime-startTime); 
		

		startTime = System.nanoTime(); 
		// Next 40 
		for (int i = 0; i < 4000000; i++) {
			bst.contains(words[index[i % 400]]);   
		}
		endTime = System.nanoTime(); 
		successSearchBSTTimes[1] = (endTime-startTime); 
		
 
		startTime = System.nanoTime(); 
		// Next 50 
		for (int i = 0; i < 5000000; i++) {
			bst.contains(words[index[i % 500]]);  
		}
		endTime = System.nanoTime(); 
		successSearchBSTTimes[2] = (endTime-startTime); 
		

		// Next 60 
		startTime = System.nanoTime(); 
		for (int i = 0; i < 6000000; i++) {
			bst.contains(words[index[i % 600]]); 
		}
		endTime = System.nanoTime(); 
		successSearchBSTTimes[3] = (endTime-startTime);  
		
		
		return successSearchBSTTimes; 
	}
	
	/**
	 * Returns time taken to search for 30, 40, 50 and 60 input sizes
	 * @return times
	 */
	public static long[] unsuccessSearchBST() {
		long[] unsuccessSearchBSTTimes = new long[4]; 
		long startTime, endTime;

		startTime = System.nanoTime();
		// First 30 
		for (int i = 0; i < 3000000; i++) {
			bst.contains(words[index[i % 300]] + "1a"); 
		}
		endTime = System.nanoTime(); 
		unsuccessSearchBSTTimes[0] = (endTime-startTime); 
		

		startTime = System.nanoTime(); 
		// Next 40 
		for (int i = 0; i < 4000000; i++) {
			bst.contains(words[index[i % 400]] + "1a");   
		}
		endTime = System.nanoTime(); 
		unsuccessSearchBSTTimes[1] = (endTime-startTime); 
		
 
		startTime = System.nanoTime(); 
		// Next 50 
		for (int i = 0; i < 5000000; i++) {
			bst.contains(words[index[i % 500]] + "1a");  
		}
		endTime = System.nanoTime(); 
		unsuccessSearchBSTTimes[2] = (endTime-startTime); 
		

		// Next 60 
		startTime = System.nanoTime(); 
		for (int i = 0; i < 6000000; i++) {
			bst.contains(words[index[i % 600]] + "1a"); 
		}
		endTime = System.nanoTime(); 
		unsuccessSearchBSTTimes[3] = (endTime-startTime);  
		
		return unsuccessSearchBSTTimes; 
	}
	
	/**
	 * Returns time taken to search for 30, 40, 50 and 60 input sizes
	 * @return times
	 */
	public static long[] successSearchTST() {
		long[] successSearchTSTTimes = new long[4];  
		long startTime, endTime;

		startTime = System.nanoTime();
		// First 30 
		for (int i = 0; i < 3000000; i++) {
			tst.contains(words[index[i % 300]]); 
		}
		endTime = System.nanoTime(); 
		successSearchTSTTimes[0] = (endTime-startTime); 
		

		startTime = System.nanoTime(); 
		// Next 40 
		for (int i = 0; i < 4000000; i++) {
			tst.contains(words[index[i % 400]]);   
		}
		endTime = System.nanoTime(); 
		successSearchTSTTimes[1] = (endTime-startTime); 
		
 
		startTime = System.nanoTime(); 
		// Next 50 
		for (int i = 0; i < 5000000; i++) {
			tst.contains(words[index[i % 500]]);  
		}
		endTime = System.nanoTime(); 
		successSearchTSTTimes[2] = (endTime-startTime); 
		

		// Next 60 
		startTime = System.nanoTime(); 
		for (int i = 0; i < 6000000; i++) {
			tst.contains(words[index[i % 600]]); 
		}
		endTime = System.nanoTime(); 
		successSearchTSTTimes[3] = (endTime-startTime);  
		
		return successSearchTSTTimes; 
	}
	
	/**
	 * Returns time taken to search for 30, 40, 50 and 60 input sizes
	 * @return times
	 */
	public static long[] unsuccessSearchTST() {
		long[] unsuccessSearchTSTTimes = new long[4];  
		long startTime, endTime;

		startTime = System.nanoTime();
		// First 30 
		for (int i = 0; i < 3000000; i++) {
			tst.contains(words[index[i % 300]] + "1a"); 
		}
		endTime = System.nanoTime(); 
		unsuccessSearchTSTTimes[0] = (endTime-startTime); 
		

		startTime = System.nanoTime(); 
		// Next 40 
		for (int i = 0; i < 4000000; i++) {
			tst.contains(words[index[i % 400]] + "1a");   
		}
		endTime = System.nanoTime(); 
		unsuccessSearchTSTTimes[1] = (endTime-startTime); 
		
 
		startTime = System.nanoTime(); 
		// Next 50 
		for (int i = 0; i < 5000000; i++) {
			tst.contains(words[index[i % 500]] + "1a");  
		}
		endTime = System.nanoTime(); 
		unsuccessSearchTSTTimes[2] = (endTime-startTime); 
		

		// Next 60 
		startTime = System.nanoTime(); 
		for (int i = 0; i < 6000000; i++) {
			tst.contains(words[index[i % 600]] + "1a"); 
		}
		endTime = System.nanoTime(); 
		unsuccessSearchTSTTimes[3] = (endTime-startTime);  
		
		
		return unsuccessSearchTSTTimes; 
	}
	
	
	public static void fileRead() throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader("words.txt"));
		for (int i = 0; i < words.length; i++) {
			words[i] = in.nextLine();
		}
		StdRandom.shuffle(words);
		randomSample();
		for (int i = 0; i < words.length; i++) {
			tst.put(words[i], i);
			bst.put(words[i], i);
		}
		

	}

	/**
	 * Populates an array of random indices used for
	 * selecting the expressions to search for 
	 */
	public static void randomSample() {
		index = new int[600];
		Random rnd = new Random() ; 
		int ind;
		for(int i = 0; i < index.length; i++) {
			ind = (int) (rnd.nextDouble() * 466547);
			index[i] = ind;
		}

	}
	
}
