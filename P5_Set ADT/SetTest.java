import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

class SetTest {

	@Test
	void testAdd() {
		Set<Double> set = new Set<Double>();
		set.add(14.25);
		set.add(14.5);
		set.add(1.5);
		set.add(14.5);
		set.add(null);
		assertEquals(true, set.contains(14.25));
	}

	@Test
	void testContains() {
		Set<Double> set = new Set<Double>();
		set.add(1.5);
		assertEquals(true, set.contains(1.5));
	}

	@Test // (expected = Exception.class)
	void testRemove() throws Exception {
		Set<Double> set = new Set<Double>();
		set.add(1.5);
		assertEquals(true, set.contains(1.5));
		set.remove(1.5);
		set.remove(null);
		assertEquals(false, set.contains(1.5));
		// assertThrows("Object Not Found", set.remove(0.5));
	}

	@Test
	void testSize() {
		Set<Double> set = new Set<Double>();
		set.add(14.25);
		set.add(14.5);
		set.add(1.5);
		set.add(14.5);
		assertEquals(3, set.size());
	}

	@Test
	void testToString() throws Exception {
		Set<Double> smallSet = new Set<Double>(3);
		smallSet.add(5.0);
		smallSet.add(14.25);
		smallSet.add(1.111111);
		smallSet.add(1.0);
		smallSet.add(1.0);
		smallSet.add(5.0);
		smallSet.add(1.111111);
		smallSet.add(1.0);
		//System.out.println(smallSet.toString());
		assertEquals(false, smallSet.contains(1.5));
		assertEquals("[0]: 5.0, 1.111111, 1.0\n[1]: \n[2]: 14.25\n", smallSet.toString());
	}
	
	@Test
	void testEquals() {
		Set<Double> smallSet = new Set<Double>(3);
		smallSet.add(5.0);
		smallSet.add(14.25);
		smallSet.add(1.111111);
		smallSet.add(1.0);
		Set<Double> largeSet = new Set<Double>(5);
		assertEquals(false, smallSet.equals(largeSet));
		largeSet.add(1.0);
		largeSet.add(1.111111);
		largeSet.add(14.25);
		largeSet.add(5.0);
		assertEquals(true, smallSet.equals(largeSet));
	}

	@Test
	void testIsEmpty() {
		Set<Double> emptySet = new Set<Double>();
		assertEquals(true, emptySet.isEmpty());
	}
	
	@Test
	void testUnionDifferenceIntersection() throws Exception {
		Set<Double> smallSet = new Set<Double>(3);
		Set<Double> largeSet = new Set<Double>(5);
		Set<Double> nullSet = new Set<Double>(5);
		Set<Double> unionSet = new Set<Double>(5);
		Set<Double> differenceSet = new Set<Double>();
		Set<Double> intersectionSet = new Set<Double>();
		
		smallSet.add(5.0);
		smallSet.add(8.0);
		smallSet.add(9.999999);
		
		
		largeSet.add(5.0);
		largeSet.add(8.888);
		largeSet.add(8888.55225);
		largeSet.add(585.52);
		
		unionSet.add(5.0);
		unionSet.add(8.0);
		unionSet.add(9.999999);
		unionSet.add(8.888);
		unionSet.add(8888.55225);
		unionSet.add(585.52);
		
		differenceSet.add(8.0);
		differenceSet.add(9.999999);

		intersectionSet.add(5.0);
		
		
		
//		System.out.println(smallSet.union(largeSet));
//		System.out.println(unionSet);
		
		assertEquals(true, smallSet.equals(smallSet.union(nullSet)));
		assertEquals(false, largeSet.equals(smallSet.union(nullSet)));
		assertEquals(true, unionSet.equals(smallSet.union(largeSet)));
		
		
		System.out.println("UnionSet\n" + unionSet);
		System.out.println(smallSet.union(largeSet));
		System.out.println(unionSet.hashCode());
		System.out.println(smallSet.union(largeSet).hashCode());
		
		
		
		assertEquals(true, unionSet.hashCode() == smallSet.union(largeSet).hashCode());
		
		assertEquals(false, nullSet.equals(smallSet.difference(nullSet)));
		assertEquals(false, largeSet.equals(smallSet.difference(nullSet)));
		assertEquals(true, differenceSet.equals(smallSet.difference(largeSet)));
		
//		System.out.println(smallSet.intersection(nullSet));
//		System.out.println(nullSet);
		assertEquals(true, nullSet.equals(smallSet.intersection(nullSet)));
		assertEquals(false, largeSet.equals(smallSet.intersection(nullSet)));
		assertEquals(true, intersectionSet.equals(smallSet.intersection(largeSet)));
		assertEquals(true, intersectionSet.equals(largeSet.intersection(smallSet)));
	}
	
	@Test
	void testResizeAdd() {
		Set<Double> reSizeSet = new Set<Double>(1);
		reSizeSet.add(5.0);
		reSizeSet.add(8.0);
		reSizeSet.add(9.999999);
		reSizeSet.add(8.888);
		reSizeSet.add(8888.55225);
		reSizeSet.add(585.52);
	}
	
}
