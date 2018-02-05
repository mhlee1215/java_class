package sort;

import java.util.*;

public class VectorSort {

	public static void main(String[] args) {
		int n = 10;
		Vector<Integer> v = new Vector<Integer>();
		for(int i = 0 ; i < n ; i++) {
			v.add((int)(Math.random()*100));
		}

		System.out.println("Before Sort");
		System.out.println(v);
		
		long startTime = System.nanoTime();        
		Collections.sort(v);
		double estimatedTime = (System.nanoTime() - startTime)*(1e-9);
		System.out.println("After Sort (Asc), time used:"+estimatedTime);
		System.out.println(v);
		
		startTime = System.nanoTime();
		Collections.reverse(v);
		estimatedTime = (System.nanoTime() - startTime)*(1e-9);
		System.out.println("After Sort (Desc), time used:"+estimatedTime);
		System.out.println(v);
	}
}
