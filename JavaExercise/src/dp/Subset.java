package dp;

public class Subset {
	
	public static boolean isSubsetSum(int[] set, int n, int sum){
		if(n >= set.length) return false;		
		return set[n] == sum ||isSubsetSum(set, n+1, sum-set[n]) || isSubsetSum(set, n+1, sum);
	}
	
	
	public static void main(String[] argv){
		int set[] = {3, 34, 4, 12, 5, 2};
		int sum = 46;
		
		System.out.println(isSubsetSum(set, 0, sum));
		
	}
}
