package cp_class;

public class ReversePractice {
	public static void main(String[] args) { 
		int[] arr = {1, 2, 4, 6, 10, 12};
		int[] rArr = reverseArray(arr);
		//Check it is correct
		boolean isReverse = true;
		for(int i = 0 ; i < arr.length ; i++)
			if(arr[i] != rArr[arr.length-i-1]) isReverse = false;
		System.out.println("Is it a reverse array? : "+isReverse);
			
		String str = "Hello world";
		String rStr = reverseString(str);
		//Check it is correct
		boolean isReverseString = true;
		for(int i = 0 ; i < str.length() ; i++)
			if(str.charAt(i) != rStr.charAt(str.length()-i-1)) isReverseString = false;
		System.out.println("Is it a reverse string? : "+isReverseString);
	}
	
	static int[] reverseArray(int[] arr){
		int[] rArray = new int[arr.length];
		// *** Code here ***
		return rArray;
	}
	
	static String reverseString(String str){
		String rStr = "";
		// *** Code here ***
		return rStr;
	}
}
