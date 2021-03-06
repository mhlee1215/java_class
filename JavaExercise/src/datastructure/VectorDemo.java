package datastructure;
import java.util.*;

public class VectorDemo {

	public static void main(String args[]) {
		// initial capacity is 3, increment is 2
		Vector<Integer> v = new Vector<Integer>(3, 2);
		System.out.println("Initial size: " + v.size());
		System.out.println("Initial capacity: " +
				v.capacity());
		v.add(new Integer(1));
		v.addElement(new Integer(2));
		v.addElement(new Integer(3));
		v.addElement(new Integer(4));
		System.out.println("Capacity after four additions: " +
				v.capacity());

		v.add(new Integer(5));
		System.out.println("Current capacity: " +
				v.capacity());
		v.add(new Integer(6));
		v.add(new Integer(7));
		System.out.println("Current capacity: " +
				v.capacity());
		v.add(new Integer(9));
		v.add(new Integer(10));
		System.out.println("Current capacity: " +
				v.capacity());
		v.add(new Integer(11));
		v.add(new Integer(12));
		System.out.println("First element: " +
				(Integer)v.firstElement());
		System.out.println("Last element: " +
				(Integer)v.lastElement());
		if(v.contains(new Integer(3)))
			System.out.println("Vector contains 3.");
		
		// enumerate the elements in the vector.
		Enumeration vEnum = v.elements();
		System.out.println("\nElements in vector:");
		while(vEnum.hasMoreElements())
			System.out.print(vEnum.nextElement() + " ");
		System.out.println();
		
		List a = new Vector();
	}
}