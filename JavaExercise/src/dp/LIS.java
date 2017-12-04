package dp;

import org.omg.CORBA.SystemException;

public class LIS {

	public static int LIS(int[] seq, int n){
		
		if(n == 1){
			return 1;
		}
		
		int curMax = 0;
		for(int i = n-2 ; i >= 0 ; i--){
			
			if(seq[i] < seq[n-1]){
				curMax = Math.max(1+LIS(seq, i+1), curMax);
			}else{
				curMax = Math.max(LIS(seq, i+1), curMax);
			}
		}
		
		return Math.max(LIS(seq, n-1), curMax);
	}
	
	public static void main(String[] args) {
		int[] arr = {50, 3, 10, 7, 40, 80};

		System.out.println("LIS: "+(LIS(arr, arr.length)));
		
	}

}
