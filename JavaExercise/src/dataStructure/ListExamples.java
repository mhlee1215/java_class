package dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> a = new ArrayList<Integer>();
		a.add(10);
		a.add(20);
		a.add(30);
		
		List<Integer> b = new ArrayList<Integer>(a.size());
		//b.addAll(a);
		
		
		System.out.println(b.size()+" "+a.size());
		
		Collections.copy(b, a);
		
		System.out.println("a: "+a);
		System.out.println("b: "+b);
		
		int[][][] aa = new int[10][10][10];
		Arrays.fill(aa, -1);
	}

}
