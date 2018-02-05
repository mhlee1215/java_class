package sort;

import java.util.Collections;
import java.util.Vector;

public class SortPractice {

	public static void main(String[] args) {
		//Generate random array
		int n = 10;
		Vector<Integer> v = new Vector<Integer>();
		for(int i = 0 ; i < n ; i++) {
			v.add((int)(Math.random()*100));
		}
		//Make before/after array using in-built sort method
		Integer[] before = v.toArray(new Integer[v.size()]);
		Collections.sort(v);
		Integer[] after = v.toArray(new Integer[v.size()]);
		System.out.println("Is bubble sort work? "+isSimilarArr(after, bubbleSort(before)));
		System.out.println("Is insertion sort work? "+isSimilarArr(after, insertionSort(before)));
		System.out.println("Is selection sort work? "+isSimilarArr(after, selectionSort(before)));
	}
	
	public static boolean isSimilarArr(Integer[] a, Integer[] b) {
		if(a.length != b.length) return false;
		for(int i = 0 ; i < a.length ; i++) {
			if(a[i] != b[i]) return false;
		}
		return true;
	}
	
	public static Integer[] bubbleSort(Integer[] arr){
		Integer[] sorted = new Integer[arr.length];
		//Please complete here!
		return sorted;
	}
	
	public static Integer[] insertionSort(Integer[] arr){
		Integer[] sorted = new Integer[arr.length];
		//Please complete here!
		return sorted;
	}
	
	public static Integer[] selectionSort(Integer[] arr){
		Integer[] sorted = new Integer[arr.length];
		//Please complete here!
		return sorted;
	}

}
