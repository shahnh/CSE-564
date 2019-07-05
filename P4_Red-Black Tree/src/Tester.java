import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

public class Tester {
	
	static int inputSize = 10000; 
	static int numIteration = 1000; 
	static double height[] = new double[inputSize];
	static double rotations[] = new double[inputSize];
	static double length[] = new double[inputSize];
	public static void main(String[] args) throws IOException {
		
		createTrees();
		
		// Print 
		System.out.println("Height: " + Arrays.toString(height));
		System.out.println("Rotations: " + Arrays.toString(rotations));
		System.out.println("Length: " + Arrays.toString(length));
		
		
		// Write to File for average height and average rotations
        // and average length
        // The file for all the lenghts in printed inside the create
        // trees method
		FileWriter out = new FileWriter("output.txt"); 
		out.write(Arrays.toString(height));
		out.write("\r\n");
		out.write(Arrays.toString(rotations));
		out.write("\r\n");
		out.write(Arrays.toString(length));
	    out.close();
	} // End main


	// Method to create trees 1000 times from size 1 to 10000;
	public static void createTrees() throws IOException {
		FileWriter out = new FileWriter("lengths.txt"); 
		
		for (int size = 1; size <= inputSize; size++) {
			double heightTemp = 0;
			double rotationTemp = 0;
			double lengthTemp = 0; 
			double lengthForOneSize [] = new double[numIteration]; 
			for (int count = 0; count < numIteration; count++) {
				// Reset the rbbst
				RedBlackBST1<Integer, Integer> rbbst = new RedBlackBST1<>();
				rbbst.setRotations(0);
				rbbst.setLength(0);
				
				// Add new data to rbbst and get the values
				rbbst = insertData(size, rbbst);
				heightTemp += rbbst.height();
				rotationTemp += rbbst.getRotations();
				lengthTemp += 1 + (rbbst.getLength()/size);
				
				// Add the length from one iteration to array 
				lengthForOneSize[count] = 1 + (rbbst.getLength()/size);  
			}
			
			// Write data from all iterations of one size into lenghts
            // This is what writes the data for calculating the standard deviation
			out.write(Arrays.toString(lengthForOneSize));
			out.write("\r\n");
			
			// Average values 
			height[size-1] = heightTemp / numIteration;
			rotations[size-1] = rotationTemp / numIteration;
			length[size-1] = lengthTemp / numIteration;
		}
		out.close();

	} // End create trees data method

	// Method to insert a specified size of input data
	// into the RedBlack BST. Repeats the process 1000 times.
	public static RedBlackBST1 insertData(int inputSize, RedBlackBST1 rbbst) {
		for (int i = 0; i < inputSize; i++) {
			rbbst.put(StdRandom.uniform(1000000), StdRandom.uniform(1000000));
		}
		return rbbst;
	} // End insert data method

}
