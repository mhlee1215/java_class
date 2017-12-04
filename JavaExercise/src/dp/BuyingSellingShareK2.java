package dp;
//http://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/
public class BuyingSellingShareK2 {

	public static int getMaxProfit(int[] share, int n, int K){
		if(K == 0 || n > share.length || n < 0) return 0;
		
		int curMax = 0;
		for(int i = 0 ; i < n - 1 ; i++){
			curMax = Math.max(share[n-1]-share[i] + getMaxProfit(share, i, K-1), curMax);
		}
		return Math.max(getMaxProfit(share, n+1, K), curMax);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] share = {10, 22, 5, 75, 65, 80};
		//int[] share = {1, 1, 1, 100, 100, 100};
		int K = 2;
		
		System.out.println("Max Profit from at most "+K+" transactions is "+getMaxProfit(share, 0, K));
	}

}
