import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

import edu.princeton.cs.algs4.BoyerMoore;
import edu.princeton.cs.algs4.KMP;
import edu.princeton.cs.algs4.RabinKarp;

public class P8 {
	
	public static long[] smallBruteForce, smallBoyerMoore, smallRabinKarp,
						 largeBruteForce, largeBoyerMoore, largeRabinKarp,
						 smallKnuthMoririsPratt, largeKnuthMoririsPratt,
						 longBruteForce, longBoyerMoore, longRabinKarp,
						 longKnuthMoririsPratt;

	public static void main(String[] args) throws FileNotFoundException {
		String fileName = "tale.txt";
		inputReadIn(fileName);
		printOutput();
	}
	
	public static void inputReadIn (String fileName) throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader(fileName));
		String str = "";
		while (in.hasNextLine()) {
			str = str + "" + in.nextLine() + " ";
		}
		smallLine(str);
		largeLine(str);
		longLines(str);
	}

	public static void printOutput() {
		System.out.println("smallBruteForce\nsmallKnuthMoririsPratt\nsmallBoyerMoore\nsmallRabinKarp");
		System.out.println("largeBruteForce\nlargeKnuthMoririsPratt\nlargeBoyerMoore\nlargeRabinKarp");
		System.out.println("longBruteForce\nlongKnuthMoririsPratt\nlongBoyerMoore\nlongRabinKarp");
		
		System.out.println(Arrays.toString(smallBruteForce));
		System.out.println(Arrays.toString(smallKnuthMoririsPratt));
		System.out.println(Arrays.toString(smallBoyerMoore));
		System.out.println(Arrays.toString(smallRabinKarp));
		System.out.println(Arrays.toString(largeBruteForce));
		System.out.println(Arrays.toString(largeKnuthMoririsPratt));
		System.out.println(Arrays.toString(largeBoyerMoore));
		System.out.println(Arrays.toString(largeRabinKarp));
		System.out.println(Arrays.toString(longBruteForce));
		System.out.println(Arrays.toString(longKnuthMoririsPratt));
		System.out.println(Arrays.toString(longBoyerMoore));
		System.out.println(Arrays.toString(longRabinKarp));	
	}	
	
	public static void longLines (String str) {
		
		String longLines1 = "less horrible sentencehad there been a chance of any one of its "+ 
				"savage details being sparedby just so much would he have lost in " + 
				"his fascination  the form that was to be doomed to be so shamefully " + 
				"mangled was the sight the immortal creature that was to be so " + 
				"butchered and torn asunder yielded the sensation  whatever gloss";
		String longLines2 = "i think he whispered to miss pross after anxious consideration " + 
				"i think we had best not speak to him just now or at all disturb him " + 
				"i must look in at tellsons so i will go there at once and come back " + 
				"presently  then we will take him a ride into the country and dine " + 
				"there and all will be well";
		String longLines3 = "light of his  i see the blots i threw upon it faded away  i see " + 
				"him foremost of just judges and honoured men bringing a boy of my " + 
				"name with a forehead that i know and golden hair to this place " + 
				"then fair to look upon with not a trace of this days disfigurement " + 
				"and i hear him tell the child my story with a tender and a faltering";
		
		longBruteForce = bruteForce(str, longLines1, longLines2, longLines3);
		longBoyerMoore = boyerMoore(str, longLines1, longLines2, longLines3);
		longRabinKarp = rabinKarp(str, longLines1, longLines2, longLines3);
		longKnuthMoririsPratt = knuthMoririsPratt(str, longLines1, longLines2, longLines3);
	}
	
	private static void largeLine (String str) {
		
		String largeLine1 = "it is a far far better thing that i do than i have ever done";
		String largeLine2 = "to take care of him  there were no other passengers that night but";
		String largeLine3 = "we have been to your residence said the first and not being so";
		
		largeBruteForce = bruteForce(str, largeLine1, largeLine2, largeLine3); 
		largeKnuthMoririsPratt = knuthMoririsPratt(str, largeLine1, largeLine2, largeLine3);
		largeBoyerMoore  = boyerMoore(str, largeLine1, largeLine2, largeLine3);
		largeRabinKarp = rabinKarp(str, largeLine1, largeLine2, largeLine3);
		
	}
	
	private static void smallLine (String str) {
		
		String smallLine1 = "it was the dover";
		String smallLine2 = "i am doubtful said";
		String smallLine3 = "nishil is nice person";
		
		smallBruteForce = bruteForce(str, smallLine1, smallLine2, smallLine3); 
		smallKnuthMoririsPratt = knuthMoririsPratt(str, smallLine1, smallLine2, smallLine3);
		smallBoyerMoore  = boyerMoore(str, smallLine1, smallLine2, smallLine3);
		smallRabinKarp = rabinKarp(str, smallLine1, smallLine2, smallLine3);
		
	}
	
	private static long[] bruteForce(String str, String line1, String line2, String line3) {
		long[] timeArray = new long[3];
		long startTime, endTime;
		
		startTime = System.nanoTime();
		for (int i = 0; i < 5000; i++)
			Brute.search1(str, line1);
		endTime = System.nanoTime(); 
		timeArray[0] = (endTime-startTime)/5000;
		
		startTime = System.nanoTime();
		for (int i = 0; i < 5000; i++)
			Brute.search1(str, line2);
		endTime = System.nanoTime(); 
		timeArray[1] = (endTime-startTime)/5000;
		
		startTime = System.nanoTime();
		for (int i = 0; i < 5000; i++)
			Brute.search1(str, line3);
		endTime = System.nanoTime(); 
		timeArray[2] = (endTime-startTime)/5000;
		
		
		return timeArray;
	}
	
	private static long[] knuthMoririsPratt(String str, String line1, String line2, String line3) {
		long[] timeArray = new long[3];
		KMP kmp1 = new KMP(str);
		
		long startTime, endTime;
		
		startTime = System.nanoTime();
		for (int i = 0; i < 5000; i++)
			kmp1.search(line1);
		endTime = System.nanoTime(); 
		timeArray[0] = (endTime-startTime)/5000;
		
		startTime = System.nanoTime();
		for (int i = 0; i < 5000; i++)
			kmp1.search(line2);
		endTime = System.nanoTime(); 
		timeArray[1] = (endTime-startTime)/5000;
		
		startTime = System.nanoTime();
		for (int i = 0; i < 5000; i++)
			kmp1.search(line3);
		endTime = System.nanoTime(); 
		timeArray[2] = (endTime-startTime)/5000;
		
		
		return timeArray;
	}
	
	private static long[] boyerMoore(String str, String line1, String line2, String line3) {
		long[] timeArray = new long[3];
		BoyerMoore boyermoore = new BoyerMoore(str);
		long startTime, endTime;
		
		startTime = System.nanoTime();
		for (int i = 0; i < 5000; i++)
			boyermoore.search(line1);
		endTime = System.nanoTime(); 
		timeArray[0] = (endTime-startTime)/5000;
		
		startTime = System.nanoTime();
		for (int i = 0; i < 5000; i++)
			boyermoore.search(line2);
		endTime = System.nanoTime(); 
		timeArray[1] = (endTime-startTime)/5000;
		
		startTime = System.nanoTime();
		for (int i = 0; i < 5000; i++)
			boyermoore.search(line3);
		endTime = System.nanoTime(); 
		timeArray[2] = (endTime-startTime)/5000;
		
		
		return timeArray;
	}
	
	private static long[] rabinKarp(String str, String line1, String line2, String line3) {
		long[] timeArray = new long[3];
		RabinKarp searcher = new RabinKarp(str);
		long startTime, endTime;
		
		startTime = System.nanoTime();
		for (int i = 0; i < 5000; i++)
			searcher.search(line1);
		endTime = System.nanoTime(); 
		timeArray[0] = (endTime-startTime)/5000;
		
		startTime = System.nanoTime();
		for (int i = 0; i < 5000; i++)
			searcher.search(line2);
		endTime = System.nanoTime(); 
		timeArray[1] = (endTime-startTime)/5000;
		
		startTime = System.nanoTime();
		for (int i = 0; i < 5000; i++)
			searcher.search(line3);
		endTime = System.nanoTime(); 
		timeArray[2] = (endTime-startTime)/5000;
		
		return timeArray;
	}
	
}
