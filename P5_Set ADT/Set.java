import java.lang.Exception;
import java.util.HashSet;
import java.util.Iterator;

public class Set<Item> {

	private final int DEFAULT_ARR_SIZE = 10;
	private int objectCount;
	public Node[] arr;

	// Default Constructor initializes set with size 100
	public Set() {
		this.arr = new Node[DEFAULT_ARR_SIZE];
		this.objectCount = 0;
	}

	// Custom Size Constructor initializes set with input size
	public Set(int size) {
		this.arr = new Node[size];
		this.objectCount = 0;
	}

	// Add Method
	@SuppressWarnings("unchecked")
	public void add(Item item) {
		if (item == null)
			return;

		resizeAdd();

		int index = Math.abs(item.hashCode()) % arr.length;

		// Temp node to traverse the link list
		Node temp = arr[index];

		// If no node at that index, insert node and increment object count
		if (temp == null) {
			arr[index] = new Node(item);
			objectCount++;
			return;
		}

		// Item at node is equal to what we are trying to add
		if (temp.item.equals(item)) {
			return;
		}

		// Traverse node to get to end, but return if an Equal item already in list
		while (temp.next != null) {
			if (temp.item.equals(item) || temp.next.item.equals(item)) {
				return;
			}
			temp = temp.next;
		}

		// Insert node at end of list and increase object count
		temp.next = new Node(item);
		objectCount++;
	}

	// Remove Method
	public void remove(Item item) throws Exception {
		if (item == null)
			return;

		resizeRemove();

		int index = Math.abs(item.hashCode()) % arr.length;

		// Temp node to traverse the link list
		Node temp = arr[index];

		// If no node at that index
		if (temp == null) {
			throw new Exception("Object Not Found");
		}

		if (temp.item.equals(item)) {
			arr[index] = temp.next;
			objectCount--;
			return;
		}

		while (temp.next != null) {
			if (temp.next.item.equals(item)) {
				temp.next = temp.next.next;
				objectCount--;
				return;
			}
			temp = temp.next;
		}

		throw new Exception("Object Not Found");
	}

	// Contains Method
	public boolean contains(Item item) {
		int index = Math.abs(item.hashCode()) % arr.length;

		Node temp = arr[index];
		while (temp != null) {
			if (temp.item.equals(item))
				return true;
			temp = temp.next;
		}

		return false;
	}

	// To String
	public String toString() {
		String s = "";

		for (int i = 0; i < arr.length; i++) {
			Node temp = arr[i];
			s += "[" + i + "]: ";
			while (temp != null) {
				s += temp.item.toString();
				if (temp.next != null)
					s += ", ";
				temp = temp.next;
			}
			s += "\n";
		}
		return s;
	}

	// size
	public int size() {
		return objectCount;
	}

	// isEmpty
	public boolean isEmpty() {
		return objectCount == 0;
	}

	public boolean equals(Object o) {

		// If not instance of Set, return flase
		if (!(o instanceof Set<?>))
			return false;

		// Cast to Set type
		Set obj = (Set<Item>) o;

		// If different object size, return false
		if (obj.size() != this.size())
			return false;

		// if both are empty, return true
		if (this.size() == obj.size() && this.size() == 0)
			return true;

		// Get iterators and hashSets for these two sets
		// We use hash sets to avoid using the
		java.util.Iterator<Item> it = this.iterator();
		HashSet<Item> aList = new HashSet();

		java.util.Iterator<Item> it1 = obj.iterator();
		HashSet<Item> aList1 = new HashSet();

		// Add all elements to the arrays
		while (it.hasNext()) {
			Item temp = it.next();
			if (temp != null)
				aList.add(temp);
		}
		while (it1.hasNext()) {
			Item temp = it1.next();
			if (temp != null)
				aList1.add(temp);
		}

		// Check if arraylists are equal
		return aList.equals(aList1);
	}

	// Iterator
	public Iterator<Item> iterator() {
		if (objectCount <= 0)
			return null;
		Iterator<Item> it = new Iterator<Item>() {
			private int arrIndex = 0;
			private Node nodeIndex = arr[0];

			@Override
			public boolean hasNext() {

				// Case : array index is greater than length of array
				if (arrIndex > arr.length - 1) {
					return false;
				}

				// Case : last index of array but at last node of linked list
				if (arrIndex == arr.length - 1) {
					if (nodeIndex == null)
						return false;
				}

				return true;
			}

			@Override
			public Item next() {
				Node ret = new Node();
				if (nodeIndex != null) {
					ret = (Node) nodeIndex;
				} else if (arrIndex < arr.length - 1) {
					while (nodeIndex == null) {
						arrIndex = arrIndex + 1;
						if (arrIndex == arr.length)
							break;
						nodeIndex = (Node) arr[arrIndex];
					}
					ret = (Node) nodeIndex;
				}
				nodeIndex = (nodeIndex == null ? null : (nodeIndex.next == null ? null : nodeIndex.next));
				return (ret == null ? null : (Item) ret.item);
			}

		};
		return it;
	}

	// Union
	public Set<Item> union(Set<Item> thatSet) {
		// If thatset is null
		if (thatSet.size() == 0 || thatSet == null)
			return this;
		if (this.size() == 0 || this == null)
			return thatSet;

		// New iterators for both Sets
		Iterator<Item> thatIterator = thatSet.iterator();
		Iterator<Item> thisIterator = this.iterator();

		// Create a new set with twice the length (to allow for adding new elements)
		Set<Item> newSet = new Set();

		// Add elements from both sets
		while (thatIterator.hasNext())
			newSet.add(thatIterator.next());
		while (thisIterator.hasNext())
			newSet.add(thisIterator.next());

		return newSet;
	}

	// Union
	public Set<Item> difference(Set<Item> thatSet) {

		// If thatSet is null
		if (thatSet.size() == 0)
			return this;

		// New iterators for both Sets
		Iterator<Item> thatIterator = thatSet.iterator();
		Iterator<Item> thisIterator = this.iterator();

		// Create a new set with twice the length (to allow for adding new elements)
		Set<Item> newSet = new Set((int) (this.arr.length));

		// Add elements from both sets
		while (thisIterator.hasNext())
			newSet.add(thisIterator.next());

		while (thatIterator.hasNext())
			try {
				newSet.remove(thatIterator.next());
			} catch (Exception e) {
			}

		return newSet;
	}

	// Intersection
	public Set<Item> intersection(Set<Item> thatSet) {
		Set<Item> intersectionSet = new Set<Item>();

		// If either set is empty, the intersection will be an empty set
		if (thatSet.size() == 0 || this.size() == 0)
			return intersectionSet;

		// Which set is smaller? We will iterate over that one.
		boolean thisSetSmaller = false;
		thisSetSmaller = this.size() < thatSet.size();

		Iterator it;

		if (thisSetSmaller)
			it = this.iterator();
		else
			it = thatSet.iterator();

		// Add items to the the return set if both thisSet and thatSet have that item
		// In this case, thisSet is smaller, so we iterate over this set and check
		// if that set has the items
		if (thisSetSmaller)
			while (it.hasNext()) {
				Item temp = (Item) it.next();
				if (thatSet.contains(temp))
					intersectionSet.add(temp);
			}
		// Add items to the the return set if both thisSet and thatSet have that item
		// In this case, thatSet is smaller, so we iterate over thatSet and check
		// if thisSet has the items
		else
			while (it.hasNext()) {
				Item temp = (Item) it.next();
				if (this.contains(temp))
					intersectionSet.add(temp);
			}

		return intersectionSet;

	}

	// HashCode
	public int hashCode() {
		if (objectCount == 0)
			return -1;

		Iterator it = this.iterator();
		int hashCode = 0;
		int x = 0;
		while (it.hasNext()) {
			Item temp = (Item) it.next();
			if (temp !=  null)
				x = temp.hashCode();
			hashCode += x;
		}
		return hashCode;
	}

	private void resizeAdd() {
		if (objectCount < arr.length * 5)
			return;

		Node[] temp = arr;
		Set<Item> tempSet = new Set<Item>(arr.length * 3);

		Iterator it = this.iterator();
		while (it.hasNext())
			tempSet.add((Item) it.next());

		this.arr = tempSet.arr;

	}

	private void resizeRemove() {
		if (objectCount > arr.length || objectCount == 0)
			return;

		Node[] temp = arr;
		Set<Item> tempSet = new Set<Item>(arr.length / 2);

		Iterator it = this.iterator();
		while (it.hasNext())
			tempSet.add((Item) it.next());

		this.arr = tempSet.arr;

	}
}
