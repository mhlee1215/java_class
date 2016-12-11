package sort;

import java.util.Arrays;

public class MyQuickSort {
	
	public static int[] split(int[] array){
		int[] sorted = null;
		if(array == null || array.length == 0) return null;
		else{
			sorted = Arrays.copyOf(array, array.length);
			
			int pivotIdx = 0;
			int swapIdx = 1;
			
			int pivotValue = array[pivotIdx];
			for(int i = 2; i < array.length ; i++){
				if(sorted[i] <= pivotValue){
					sorted = swap(sorted, swapIdx, i);
					swapIdx++;
				}
			}
			//If there was nothing to swap like [3, 1, 1, 2];
			if(swapIdx == 1){
				if(pivotValue > sorted[Math.min(sorted.length-1, swapIdx)]){
					sorted = swap(sorted, pivotIdx, swapIdx);
					pivotIdx = swapIdx;
				}
			}
			else{
				//if the last one is less than pivot,
				if(pivotValue > sorted[swapIdx]){
					sorted = swap(sorted, pivotIdx, swapIdx);
					pivotIdx = swapIdx;
				}
				//if the last one is larger than pivot 
				else{
					sorted = swap(sorted, pivotIdx, swapIdx-1);
					pivotIdx = swapIdx-1;
				}
			}
			
			//Split 
			//a = 0 - pivot-1, 
			//b = pivot,
			//c = pivot+1 - end
			int[] a = null;
			int b = sorted[pivotIdx];
			int[] c = null;
			
			a = new int[pivotIdx];
			for(int i = 0 ; i < a.length ; i++){
				a[i] = sorted[i];
			}
			c = new int[Math.max(0, array.length - pivotIdx -1)];
			for(int i = 0 ; i < c.length ; i++){
				c[i] = sorted[i+a.length+1];
			}
			
			//Recursive call
			return merge(split(a), b, split(c));
		}
	}
	
	
	public static int[] swap(int[] a, int idx1, int idx2){
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
		return a;
	}
	
	public static int[] merge(int[] a, int b , int[] c){
		int len = 1;
		int aLen = 0;
		int cLen = 0;
		if(a != null) aLen = a.length;
		if(c != null) cLen = c.length;
		
		len += aLen;
		len += cLen;
		int[] mArr = new int[len];
		//If a and c are empty
		if(len == 1){
			mArr[0] = b;
			return mArr;
		}
		
		//Otherwise, merge them into one
		for(int i = 0 ; i < aLen ; i++){
			mArr[i] = a[i];
		}
		mArr[aLen] = b;
		for(int i = aLen+1 ; i < len ; i++){
			mArr[i] = c[i-aLen-1];
		}
		return mArr;
	}
	
	//Get Random array
	public static int[] getRandomArray(int n){
		int[] arr = new int[n];
		for(int i = 0 ; i < arr.length ; i++){
			arr[i] = (int)(Math.random()*100);
		}
		return arr;
	}
	
	public static int[] sort(int[] arr){
		return split(arr);
	}
	
	public static String toString(int[] a){
		String b = "[";
		if(a != null){
			for(int i = 0 ; i < a.length ; i++){
				b += a[i]+" ";
			}	
		}
		
		b += "]";
		return b;
	}
	
	public static void main(String[] args){
		//Assign random values
		//int[] arr = getRandomArray(10);
		int[] arr = { 4, 5, 7, 9, 10, 11, 3, 5, 2, 1};
		int[] sorted = sort(arr);
		System.out.println("in: "+toString(arr));
		System.out.println("out: "+toString(sorted));
	}

}
