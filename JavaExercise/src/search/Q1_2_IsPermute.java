package search;

public class Q1_2_IsPermute{
	public static void main(String[] args){
		String input1 = "abcdefg";
		String input2 = "abfcdeg";

		System.out.println(isPermute(input1, input2));
		System.out.println(isPermute2(input1, input2));

	}

	public static boolean isPermute(String a, String b){
		char[] ac = a.toCharArray();
		char[] bc = b.toCharArray();

		java.util.Arrays.sort(ac);
		java.util.Arrays.sort(bc);

		String acs = new String(ac);
		String bcs = new String(bc);

		if(acs.equals(bcs)) return true;
		return false;
	}
	
	public static boolean isPermute2(String a, String b){
		if(a.length() != b.length()) return false;

		int[] map = new int[128];
		for(int i = 0 ; i < a.length() ; i++){
			int idx = a.charAt(i)-'a';
			map[idx]++;
		}

		for(int i = 0 ; i < b.length() ; i++){
			int idx = b.charAt(i)-'a';
			map[idx]--;	
			if(map[idx] < 0) return false;
		}


		return true;
	}
}