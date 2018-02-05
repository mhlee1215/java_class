package sort;

public class MyMergeSort_Complete {

	public static void main(String[] args) {
		//From given partially sorted lists,
		int[] unsorted = {1, 0, 11, 100, 123, 3, 6, 8, 9, 2, 4, 5};
		int[] sorted = mergeSort(unsorted);
		
		//Below should print
		//1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13
		long startTime = System.nanoTime();        
		printArr(sorted);
		double estimatedTime = (System.nanoTime() - startTime)*(1e-9);
		System.out.println("After Sort, time used:"+estimatedTime);
	}
	
	public static void printArr(int[] a) {
		for(int i = 0 ; i < a.length ; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	public static int[] mergeSort(int[] unsorted) {
		if(unsorted.length == 1) return unsorted;
		
		//Divide into two
		int[] a = new int[unsorted.length/2];
		int[] b = new int[unsorted.length - a.length];
		
		for(int i = 0 ; i < b.length ; i++) {
			if(i < a.length)
				a[i] = unsorted[i];
			b[i] = unsorted[i+a.length];
		}
			
		//Merge from two
		int[] merged = merge(mergeSort(a), mergeSort(b));
		return merged;
	}
	
	public static int[] merge(int[] a, int[] b) {
		//System.out.println(">>>"+a.length+" "+b.length);
		int[] merged = new int[a.length + b.length];
		
		int ai = 0;
		int bi = 0;
		for(int i = 0 ; i < merged.length ; i++) {
			if(ai < a.length && (bi >= b.length || a[ai] < b[bi])) {
				merged[i] = a[ai];
				ai++;
			}else {
				merged[i] = b[bi];
				bi++;
			}
		}
		//Complete this part
		return merged;
	}

}
