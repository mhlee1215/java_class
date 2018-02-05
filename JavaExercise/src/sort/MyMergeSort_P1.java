package sort;

public class MyMergeSort_P1 {

	public static void main(String[] args) {
		//From given sorted lists,
		int[] a = {1, 3, 6, 8, 9};
		int[] b = {2, 4, 5, 7, 10, 11, 12, 13};
		int[] c = merge(a, b);
		
		//Below should print
		//1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13
		printArr(c);
	}
	
	public static int[] merge(int[] a, int[] b) {
		int[] merged = new int[a.length + b.length];
		//... Fill Out ...
		return merged;
	}
	
	public static void printArr(int[] a) {
		for(int i = 0 ; i < a.length ; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
}
