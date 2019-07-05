import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.StdOut;

// There are different kinds of graphs that we need to test Kruskal's, Lazy Prim and Eager Prim
// The first consideration is different sizes of graphs
// The second consideration is for sparse vs dense graphs

// Proposed sizes : 500, 1000, 2000, 8000
// Proposed densities : V and V^2 - 2
// * According to http://cseweb.ucsd.edu/~kube/cls/100/Lectures/lec11/lec11-6.html, 
//   a dense graph has close to V^2 edges and a sparse graph has close to V edges

public class Tester {

	// We need

	public static void main(String[] args) throws IOException {
		
		// For vertices = 6000, dense edges
		long[] times0 = new long[6];
		for ( int i = 0; i < 10; i ++) {
		long[] timesTemp = timeEstimate(6000, true);
			for ( int j = 0; j < 6; j++)
				times0[j] += timesTemp[j]; 
		}
		
		// For vertices = 6000, sparse edges
		long[] times1 = new long[6];
		for ( int i = 0; i < 10; i ++) {
		long[] timesTemp = timeEstimate(6000, false);
			for ( int j = 0; j < 6; j++)
				times1[j] += timesTemp[j]; 
		}
		
		// For vertices = 8000, dense edges
		long[] times2 = new long[6];
		for ( int i = 0; i < 10; i ++) {
		long[] timesTemp = timeEstimate(8000, true);
			for ( int j = 0; j < 6; j++)
				times2[j] += timesTemp[j]; 
		}
		
		// For vertices = 8000, sparse edges
		long[] times3 = new long[6];
		for ( int i = 0; i < 10; i ++) {
		long[] timesTemp = timeEstimate(8000, false);
			for ( int j = 0; j < 6; j++)
				times3[j] += timesTemp[j]; 
		}
		
		// For vertices = 10000, dense edges
		long[] times4 = new long[6];
		for ( int i = 0; i < 10; i ++) {
		long[] timesTemp = timeEstimate(10000, true);
			for ( int j = 0; j < 6; j++)
				times4[j] += timesTemp[j]; 
		}
		
		// For vertices = 10000, sparse edges
		long[] times5 = new long[6];
		for ( int i = 0; i < 10; i ++) {
		long[] timesTemp = timeEstimate(10000, false);
			for ( int j = 0; j < 6; j++)
				times5[j] += timesTemp[j]; 
		}
		
		FileWriter out = new FileWriter("output2.txt"); 
		out.write(Arrays.toString(times0));
		out.write("\r\n");
		out.write(Arrays.toString(times1));
		out.write("\r\n");
		out.write(Arrays.toString(times2));
		out.write("\r\n");
		out.write(Arrays.toString(times3));
		out.write("\r\n");
		out.write(Arrays.toString(times4));
		out.write("\r\n");
		out.write(Arrays.toString(times5));
		
		out.close();
//		System.out.println(Arrays.toString(times0));
//		System.out.println(Arrays.toString(times1));

//		
	}

	public static long[] timeEstimate(int numVertices, boolean dense) {
		long[] timeTaken = new long[6];
		int E = (int) (dense ? Math.pow(numVertices, 1.95) - 2 : numVertices);
		int V = numVertices;

		EdgeWeightedGraph graphUniform = new EdgeWeightedGraph(V, E, true);
		EdgeWeightedGraph graphGaussian = new EdgeWeightedGraph(V, E, false);

		////
		// Kruskal
		////

		// Uniform
		long startTime = System.nanoTime();
		KruskalMST Umst = new KruskalMST(graphUniform);
		long endTime = System.nanoTime(); // End Time
		timeTaken[0] = endTime - startTime;

		// Gaussian
		startTime = System.nanoTime();
		KruskalMST Gmst = new KruskalMST(graphGaussian);
		endTime = System.nanoTime(); // End Time
		timeTaken[1] = endTime - startTime;

		////
		// Kruskal
		////

		// Uniform
		 startTime = System.nanoTime();
		LazyPrimMST Umst1 = new LazyPrimMST(graphUniform);
		 endTime = System.nanoTime(); // End Time
		timeTaken[2] = endTime - startTime;

		// Gaussian
		startTime = System.nanoTime();
		LazyPrimMST Gmst1 = new LazyPrimMST(graphGaussian);
		endTime = System.nanoTime(); // End Time
		timeTaken[3] = endTime - startTime;

		////
		// Kruskal
		////

		// Uniform
		 startTime = System.nanoTime();
		PrimMST Umst2 = new PrimMST(graphUniform);
		 endTime = System.nanoTime(); // End Time
		timeTaken[4] = endTime - startTime;

		// Gaussian
		startTime = System.nanoTime();
		PrimMST Gmst2 = new PrimMST(graphGaussian);
		endTime = System.nanoTime(); // End Time
		timeTaken[5] = endTime - startTime;
		return timeTaken;
	}

}

// System.out.println("Uniform before: \n" + graphUniform.toString() + "\n\n");
// System.out.println("Gaussian before: \n" + graphGaussian.toString() + "\n\n");
//System.out.println("Uniform after: \n" + graphUniform.toString() + "\n\n");
//System.out.println("Gaussian after: \n" + graphGaussian.toString() + "\n\n");	