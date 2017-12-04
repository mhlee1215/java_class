package dp;
//http://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/
public class BuyingSellingShareK {

	public static int getMaxProfit(int[] share, int e, int K){
		if(K == 0 || e > share.length || e < 0) return 0;
		int curMax = 0;
		for(int i = 0 ; i < e ; i++){
			curMax = Math.max(share[e-1]-share[i] + getMaxProfit(share, i, K-1), curMax);
		}
		return Math.max(curMax, getMaxProfit(share, e-1, K));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] share = {10, 22, 5, 75, 65, 80};
		//int[] share = {2, 30, 15, 16, 8, 25, 80};
		int[] share = {1, 1, 1, 100, 100, 100};
		
		int K = 2;
		System.out.println("Max Profit from at most "+K+" transactions is "+getMaxProfit(share, share.length, K));
	}

}
