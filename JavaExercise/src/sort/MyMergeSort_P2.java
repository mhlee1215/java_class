package sort;

public class MyMergeSort_P2 {

	public static void main(String[] args) {
		//From given partially sorted lists,
		int[] sumOfLocalSortedList = {1, 3, 6, 8, 9, 2, 4, 5, 7, 10};
		
		//Divide into two pieces which have equal length
		//a should be {1, 3, 6, 8, 9} from 0 ... 4
		//b should be {2, 4, 5, 7, 10} from 5 ... 9
		int[] a = null; 
		int[] b = null;
		////////////////////
		//Need to be completed.
		//a = ...
		//b = ...
		////////////////////
		
		int[] c = merge(a, b);
		
		//Below should print
		//1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13
		printArr(c);
	}
	
	public static int[] merge(int[] a, int[] b) {
		int[] merged = new int[a.length + b.length];
		//Complete this part
		return merged;
	}
	
	public static void printArr(int[] a) {
		for(int i = 0 ; i < a.length ; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}

}
