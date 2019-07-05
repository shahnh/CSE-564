/**
 * @author Vikramaditya Pandey, Nishil Shah
 * Class : CSE 564 C
 * Proffessor : Dr. Kiper 
 * Date : 02/05/2019
 * PROGRAM 1
 */

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.Test;

public class JUnitTest {
	private long s = 12345678;
	private Random random = new Random(s);

	/**
	 * Testing that seed is set to specified value
	 */
	@Test
	public void getSeedTest() {
		StdRandom.setSeed(s);
		assertEquals(s, StdRandom.getSeed());
	}

	/**
	 * Testing uniform distribution Testing values are between 0 and 1 TEsting mean
	 * is close to 0.5
	 */
	@Test
	public void uniformTest() {
		double temp = 0;
		for (int i = 0; i < 1000; i++) {
			double std = StdRandom.uniform();
			temp += std;
			assertTrue("Error, random is too high", 1 > std);
			assertTrue("Error, random is too low", 0 <= std);
		}
		assertTrue("Error, distribution mean is not coverge to 0.5", temp / 1000 > 0.45 && temp / 1000 < 0.55);
	}

	/**
	 * Testing uniform distribution Testing mean is of distribution close to (0 +
	 * InputIn)/2
	 */
	@Test
	public void uniformIntTest() {
		int inputInt = random.nextInt(1000);
		int result = 0;
		for (int i = 0; i < 1000; i++) {
			result += StdRandom.uniform(inputInt);
		}
		assertTrue("Error", (result / 1000) < ((inputInt / 2) * 1.1) && (result / 1000) > ((inputInt / 2) * .9));
	}

	/**
	 * Testing uniform distribution Testing mean is close to (0 + s)/2 here s =
	 * 123456
	 */
	@Test
	public void uniformLongTest() {
		long result = 0;
		for (int i = 0; i < 1000; i++) {
			result += StdRandom.uniform(s);
		}
		assertTrue("Error", (result / 1000) < ((s / 2) * 1.1) && (result / 1000) > ((s / 2) * .9));
	}

	/**
	 * Testing uniform distribution Testing mean is close to (b+a)/2
	 */
	@Test
	public void uniformTwoParaIntTest() {
		int b = Math.abs(random.nextInt(1000));
		int a = Math.abs(random.nextInt(b));
		int result = 0;
		for (int i = 0; i < 1000; i++) {
			result += StdRandom.uniform(a, b);
		}
		// System.out.println("A: "+a + ". B" + b);
		assertTrue("Error", (result / 1000) > (((a + b) / 2) * .9) && (result / 1000) < (((a + b) / 2) * 1.1));
	}

	/**
	 * Testing uniform distribution Testing mean is close to (b+a)/2
	 */
	@Test
	public void uniformTwoParaDoubleTest() {
		double b = Math.abs(random.nextDouble());
		double a = Math.abs(random.nextDouble() * b);
		double result = 0;
		for (int i = 0; i < 1000; i++) {
			result += StdRandom.uniform(a, b);
		}
		assertTrue("Error", (result / 1000) > (((a + b) / 2) * .9) && (result / 1000) < (((a + b) / 2) * 1.1));
	}

	/**
	 * Testing bernouli distribution Testing mean is close to the random value used
	 * as p before
	 */
	@Test
	public void bernoulliDoubleTest() {
		double results = 0;
		double temp = random.nextDouble();
		for (int i = 0; i < 1000; i++) {
			results += (StdRandom.bernoulli(temp) == true ? 1 : 0);
		}
		assertTrue("Error", results / 1000 > temp * .9 && results / 1000 < temp * 1.1);
	}

	/**
	 * Testing bernouli distribution Testing mean is close to 0.5
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
	 * Testing the shuffle(Object[] a) method in StdRandom Check after shuffling the
	 * array should not be same
	 */
	@Test
	public void shuffleTest() {
		Double[] putIn = { 3.56, 9.99, 5.8888, 6.0001, 3.222221 };
		Double[] checkIn = { 3.56, 9.99, 5.8888, 6.0001, 3.222221 };
		StdRandom.shuffle(putIn);
		assertTrue(!Arrays.equals(putIn, checkIn));
	}

	/**
	 * Testing the shuffle(double[] a) method in StdRandom Check after shuffling the
	 * array should not be same
	 */
	@Test
	public void shuffleDoubleTest() {
		double[] putIn = { 3.98898, 12.12, 1.234, 10.987, 6.54 };
		double[] checkIn = { 3.98898, 12.12, 1.234, 10.987, 6.54 };
		StdRandom.shuffle(putIn);
		assertTrue(!Arrays.equals(putIn, checkIn));
	}

	/**
	 * Testing the shuffle(int[] a) method in StdRandom Check after shuffling the
	 * array should not be same
	 */
	@Test
	public void shuffleIntTest() {
		int[] putIn = { 5, 8, 77, 45, 68, 99, 10002, 102582 };
		int[] checkIn = { 5, 8, 77, 45, 68, 99, 10002, 102582 };
		StdRandom.shuffle(putIn);
		assertTrue(!Arrays.equals(putIn, checkIn));
	}

	/**
	 * Testing the shuffle(char[] a) method in StdRandom Check after shuffling the
	 * array should not be same
	 */
	@Test
	public void shuffleCharTest() {
		char[] putIn = { 'N', 'i', 's', 'h', 'i', 'l' };
		char[] checkIn = { 'N', 'i', 's', 'h', 'i', 'l' };
		StdRandom.shuffle(putIn);
		assertTrue(!Arrays.equals(putIn, checkIn));
	}

	/**
	 * Testing the shuffle(Object[] a, int lo, int hi) method in StdRandom Check
	 * after shuffling the array should not be same
	 */
	@Test
	public void shuffleObjIntIntTest() {
		Double[] putIn = { 3.56, 9.99, 5.8888, 6.0001, 3.222221 };
		Double[] checkIn = { 3.56, 9.99, 5.8888, 6.0001, 3.222221 };
		StdRandom.shuffle(putIn, 2, 5);
		assertTrue(!Arrays.equals(putIn, checkIn));
	}

	/**
	 * Testing the shuffle(double[] a, int lo, int hi) method in StdRandom Check
	 * after shuffling the array should not be same
	 */
	@Test
	public void shuffleDoubleIntIntTest() {
		double[] putIn = { 3.98898, 12.12, 1.234, 10.987, 6.54, 3.56, 9.99, 5.8888, 6.0001, 3.222221 };
		double[] checkIn = { 3.98898, 12.12, 1.234, 10.987, 6.54, 3.56, 9.99, 5.8888, 6.0001, 3.222221 };
		StdRandom.shuffle(putIn, 3, 10);
		assertTrue(!Arrays.equals(putIn, checkIn));
	}

	/**
	 * Testing the shuffle(int[] a, int lo, int hi) method in StdRandom Check after
	 * shuffling the array should not be same
	 */
	@Test
	public void shuffleIntIntIntTest() {
		int[] putIn = { 5, 8, 77, 45, 68, 99, 10002, 102582, 1, 3, 1000, 876143, 10927 };
		int[] checkIn = { 5, 8, 77, 45, 68, 99, 10002, 102582, 1, 3, 1000, 876143, 10927 };
		StdRandom.shuffle(putIn, 4, 12);
		assertTrue(!Arrays.equals(putIn, checkIn));
	}

	/**
	 * Testing the standard normal distribution. Check whether the mean is close to
	 * zero Check whether approx 68% of observations are close to 1
	 */
	@Test
	public void stdNormalTest() {

		double mean = 0;
		double prob = 0;
		for (int i = 0; i < 1000; i++) {
			double temp = StdRandom.gaussian();
			mean += temp;
			prob += (temp <= 1 && temp >= -1 ? 1 : 0);
		}

		assertTrue("Mean of standard gaussian distribution doesnt converge to 0",
				mean / 1000 > -0.1 && mean / 1000 < 0.1);
		assertTrue("Standard Deviation of standard gaussian distribution doesnt converge to 1",
				prob / 1000 > 0.612 && prob / 1000 < 0.748);
	}

	/**
	 * Testing the normal distribution. Check whether the mean is close to given mu
	 * Check whether the z-score of approx 68% of observations are between 1 and -1
	 */
	@Test
	public void normalTest() {

		double mu = random.nextInt(1000) * random.nextDouble();
		double sigma = random.nextInt(100) * random.nextDouble();
		double mean = 0;
		double prob = 0;

		for (int i = 0; i < 1000; i++) {
			double temp = StdRandom.gaussian(mu, sigma);
			mean += temp;
			double zScore = (temp - mu) / sigma;
			prob += (zScore >= -1 && zScore <= 1 ? 1 : 0);
		}

		assertTrue("Mean of standard gaussian distribution doesnt converge to mu",
				mean / 1000 > -0.9 * mu && mean / 1000 < 1.1 * mu);
		assertTrue("Standard Deviation of standard gaussian distribution doesnt converge to 1",
				prob / 1000 > 0.612 && prob / 1000 < 0.748);
	}

	/**
	 * Testing the geometric distribution. Using the fact that the values in
	 * geometric distributions are positive
	 */
	@Test
	public void geometricTest() {
		for (int i = 0; i < 1000; i++) {
			double ran = random.nextDouble();
			double geom = StdRandom.geometric(ran);
			assertTrue("Geometric: Output cannot be negative", geom >= 0);
		}
	}

	/**
	 * Testing the poisson distribution. Using the fact that both the expected value
	 * and variance of the distribution should roughly equal to lambda
	 */
	@Test
	public void poissonTest() {
		double ran = random.nextDouble();
		double sum = 0;
		for (int i = 0; i < 10000; i++) {
			sum += (double) StdRandom.poisson(ran);
		}
		assertTrue("Poisson: Mean doesnt converge to expected value",
				sum / 10000 >= 0.9 * ran && sum / 10000 <= 1.1 * ran);

	}

	/**
	 * Testing the pareto distribution. Using the fact that both the values in
	 * pareto distributions are positive
	 */
	@Test
	public void stdParetoTest() {
		for (int i = 0; i < 10000; i++) {
			assertTrue("Pareto values cannot be negative", StdRandom.pareto() > 0);
		}
	}

	/**
	 * Testing the pareto distribution. Using the fact that both the values in
	 * pareto distributions are positive
	 */
	@Test
	public void paretoTest() {
		for (int i = 0; i < 10000; i++) {
			assertTrue("Pareto values cannot be negative", StdRandom.pareto(random.nextDouble()) > 0);
		}
	}

	/**
	 * Testing cauchy distribution
	 * Testing that 1 million numbers in cauchy distribution have a median of zero
	 */
	@Test
	public void cauchyTest() {
		ArrayList<Double> xyz = new ArrayList<>();
		for (int i = 0; i < 100000; i++) {
			xyz.add(StdRandom.cauchy()); 
		}
		Collections.sort(xyz);
		assertTrue("Median is not zero for caucy distribution",xyz.get(50000) < 0.01 && xyz.get(50000) > -0.01);
	}

	/**
	 * Testing for the exponential function Relying on the fact that mean of an
	 * exponential function should be approximately equal to (1/lambda)
	 */
	@Test
	public void expTest() {
		double lambda = random.nextDouble();
		double sum = 0;
		for (int i = 0; i < 1000; i++) {
			sum += StdRandom.exp(lambda);
		}

		assertTrue("Exponential: mean doesnt converge to true mean",
				sum / 1000 < 1.1 / lambda && sum / 1000 > 0.9 / lambda);
	}

	/**
	 * Testing discreet probability function. Making sure returned index is within
	 * bounds of the input array
	 */
	@Test
	public void discreetTestFreq() {
		// Case 1
		int[] xyz = new int[] { 3, 0, 1 };
		assertTrue("Discreet Prob: error ", StdRandom.discrete(xyz) <= 2);

		// Case 2
		xyz = new int[] { 3, 0, 1, 102, 183, 17, 10, 19, 10, 73, 46, 1, 1, 3 };
		assertTrue("Discreet Prob: error ", StdRandom.discrete(xyz) <= xyz.length);
	}

	/**
	 * Testing discreet probability function. Making sure returned index is within
	 * bounds of the input array
	 */
	@Test
	public void discreetTestProb() {
		// Case 1
		double rand = random.nextDouble();
		double[] xyz = new double[] { rand / 2, rand / 3, 1 - rand * 5 / 6 };
		assertTrue("Discreet Prob: error ", StdRandom.discrete(xyz) <= 2);

		// Case 2
		rand = random.nextDouble();
		xyz = new double[] { rand / 4, rand / 4, rand / 3, 1 - rand * 5 / 6 };
		assertTrue("Discreet Prob: error ", StdRandom.discrete(xyz) <= 3);
	}

	/**
	 * Testing permutation method. Making sure the output is of the right length
	 */
	@Test
	public void testPermutationN() {
		for (int i = 0; i <= 5; i++) {
			int temp = random.nextInt(500);
			int[] arr = StdRandom.permutation(temp);
			assertTrue("Array of permutation is not of specified length", arr.length == temp);
		}
	}

	/**
	 * Testing permutation method. Making sure the output is of the right length
	 */
	@Test
	public void testPermutationNK() {
		for (int i = 0; i <= 5; i++) {
			int tempN = random.nextInt(500);
			int tempK = random.nextInt(tempN);
			int[] arr = StdRandom.permutation(tempN, tempK);
			assertTrue("Array of permutation is not of specified length", arr.length == tempK);
		}
	}

}
