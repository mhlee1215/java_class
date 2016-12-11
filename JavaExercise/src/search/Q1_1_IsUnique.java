package search;

public class Q1_1_IsUnique{
	public static void main(String[] args){
		String input = "abcdefgg";

		System.out.println(isUnique(input));
		System.out.println(isUnique2(input));
		System.out.println(isUnique3(input));
	
	}

	public static boolean isUnique(String a){
		for(int i = 0 ; i < a.length() ; i++){
			for(int j = 0 ; j < a.length() ; j++){
				if(i == j)
					continue;

				char aa = a.charAt(i);
				char bb = a.charAt(j);
				if(aa == bb) return false;
			}
		}
		return true;
	}
	
	public static boolean isUnique2(String a){
		boolean[] map = new boolean[128];
		for(int i = 0 ; i < map.length ; i++){
			map[i] = false;
		}
		for(int i = 0 ; i < a.length() ; i++){
			int idx = a.charAt(i) - 'a';
			if(map[idx] == true) return false;
			else map[idx] = true;
		}
		return true;
	}
	
	public static boolean isUnique3(String a){
		int bitMap = 0;
		for(int i = 0 ; i < a.length() ; i++){
			int val = a.charAt(i) - 'a';
			if((bitMap & (1 << val)) > 0) return false;
			else bitMap |= (1 << val);
		}
		return true;
	}
}