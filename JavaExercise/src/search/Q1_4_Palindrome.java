package search;

public class Q1_4_Palindrome{
	public static void main(String[] args){
		//String input = "Tact coha";
		String input = "Rats live on no evil star";
		

		System.out.println(isPalindrome(input));

	}

	public static boolean isPalindrome(String input){

		int[] map = new int[128];

		input = input.toLowerCase().replace(" ", "");

		for(int i = 0 ; i < input.length() ; i++){

			int idx = input.charAt(i) - 'a';
			map[idx]++;
		}

		int oddNum = 0;
		for(int i = 0 ; i < map.length ; i++){
			if(map[i]%2 == 1) oddNum++;
		}

		if(oddNum <= 1) return true;
		else return false;

	}	

	
}