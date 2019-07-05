import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Random;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.Test;

/**
 *  @author Nishil Shah (shahnh)
 *  @author 
 */

public class JUnitTest {
	private long s = 1234567;
	private Random random = new Random(s);
	@Test
	public void getSeedTest() {
		StdRandom.setSeed(s);
		assertEquals(s, StdRandom.getSeed());
	}

	@Test
	public void uniformTest() {
		double temp = 0;
		for (int i = 0; i < 1000; i++) {
			double std = 	StdRandom.uniform();
					temp += std;
			assertTrue("Error, random is too high", 1 > std);
			assertTrue("Error, random is too low",  0  <= std);
		}
		assertTrue("Error, distribution mean is not coverge to 0.5", temp / 1000 > 0.45 && temp / 1000 < 0.55 ); 
	}

	@Test
	public void uniformIntTest() {
		int inputInt = random.nextInt(1000);
		int result = 0;
		for (int i = 0; i < 1000; i++) {
			result += StdRandom.uniform(inputInt);
		}
		assertTrue("Error", (result/1000) < ((inputInt/2) *1.1) && (result/1000) > ((inputInt/2) *.9));
	}

	@Test
	public void uniformLongTest() {
		long result = 0;
		for (int i = 0; i < 1000; i++) {
			result += StdRandom.uniform(s);
		}
		assertTrue("Error", (result/1000) < ((s/2) *1.1) && (result/1000) > ((s/2) *.9));
	}

	@Test
	public void uniformTwoParaIntTest() {
		int b = Math.abs(random.nextInt(1000));
		int a = Math.abs(random.nextInt(b));
		int result = 0;
		for (int i = 0; i < 1000; i++) {
			result+=StdRandom.uniform(a,b);
		}
		//		System.out.println("A: "+a + ". B" + b);
		assertTrue("Error", (result / 1000) > (((a+b)/2)*.9) && (result / 1000) < (((a+b)/2)*1.1));
	}

	@Test
	public void uniformTwoParaDoubleTest() {
		double b = Math.abs(random.nextDouble());
		double a = Math.abs(random.nextDouble()*b);
		double result = 0;
		for (int i = 0; i < 1000; i++) {
			result+=StdRandom.uniform(a,b);
		}
		assertTrue("Error", (result / 1000) > (((a+b)/2)*.9) && (result / 1000) < (((a+b)/2)*1.1));
	}

	@Test
	public void bernoulliDoubleTest() {
		double results = 0;
		double temp = random.nextDouble();
		for (int i = 0; i < 1000; i++) {
			results += (StdRandom.bernoulli(temp) == true ? 1 : 0);
		}
		assertTrue("Error", results / 1000 > temp*.9 && results / 1000 < temp*1.1);
	}
	
	/**
	 * 
	 */
	@Test
	public void bernoulliTest() {
		double temp = 0;
		for (int i = 0; i < 1000; i++) {
			temp += (StdRandom.bernoulli() == true ? 1 : 0);
		}
		assertTrue("Error", temp / 1000 > 0.45 && temp / 1000 < 0.55); 
	}
	
	/**
	 * Testing the shuffle(Object[] a) method in StdRandom
	 * Check after shuffling the array should not be same
	 */
	@Test
	public void shuffleTest() {
		Double[] putIn = {3.56, 9.99, 5.8888, 6.0001, 3.222221};
		Double[] checkIn = {3.56, 9.99, 5.8888, 6.0001, 3.222221};
		StdRandom.shuffle(putIn);
		assertTrue(!Arrays.equals(putIn, checkIn));		
	}
	
	/**
	 * Testing the shuffle(double[] a) method in StdRandom
	 * Check after shuffling the array should not be same
	 */
	@Test
	public void shuffleDoubleTest() {
		double[] putIn = {3.98898, 12.12, 1.234, 10.987, 6.54};
		double[] checkIn = {3.98898, 12.12, 1.234, 10.987, 6.54};
		StdRandom.shuffle(putIn);
		assertTrue(!Arrays.equals(putIn, checkIn));		
	}
	
	/**
	 * Testing the shuffle(int[] a) method in StdRandom
	 * Check after shuffling the array should not be same
	 */
	@Test
	public void shuffleIntTest() {
		int[] putIn = {5, 8, 77, 45, 68, 99, 10002, 102582};
		int[] checkIn = {5, 8, 77, 45, 68, 99, 10002, 102582};
		StdRandom.shuffle(putIn);
		assertTrue(!Arrays.equals(putIn, checkIn));		
	}
	
	/**
	 * Testing the shuffle(char[] a) method in StdRandom
	 * Check after shuffling the array should not be same
	 */
	@Test
	public void shuffleCharTest() {
		char[] putIn = {'N', 'i', 's', 'h', 'i', 'l'};
		char[] checkIn = {'N', 'i', 's', 'h', 'i', 'l'};
		StdRandom.shuffle(putIn);
		assertTrue(!Arrays.equals(putIn, checkIn));		
	}
	
	/**
	 * Testing the shuffle(Object[] a, int lo, int hi) method in StdRandom
	 * Check after shuffling the array should not be same
	 */
	@Test
	public void shuffleObjIntIntTest() {
		Double[] putIn = {3.56, 9.99, 5.8888, 6.0001, 3.222221};
		Double[] checkIn = {3.56, 9.99, 5.8888, 6.0001, 3.222221};
		StdRandom.shuffle(putIn, 2, 5);
		assertTrue(!Arrays.equals(putIn, checkIn));		
	}
	
	/**
	 * Testing the shuffle(double[] a, int lo, int hi) method in StdRandom
	 * Check after shuffling the array should not be same
	 */
	@Test
	public void shuffleDoubleIntIntTest() {
		double[] putIn = {3.98898, 12.12, 1.234, 10.987, 6.54};
		double[] checkIn = {3.98898, 12.12, 1.234, 10.987, 6.54};
		StdRandom.shuffle(putIn, 1, 3);
		assertTrue(!Arrays.equals(putIn, checkIn));		
	}
	
	/**
	 * Testing the shuffle(int[] a, int lo, int hi) method in StdRandom
	 * Check after shuffling the array should not be same
	 */
	@Test
	public void shuffleIntIntIntTest() {
		int[] putIn = {5, 8, 77, 45, 68, 99, 10002, 99};
		int[] checkIn = {5, 8, 77, 45, 68, 99, 10002, 99};
		StdRandom.shuffle(putIn, 5, 6);
		assertTrue(!Arrays.equals(putIn, checkIn));		
	}

}
