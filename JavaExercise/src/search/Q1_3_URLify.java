package search;

public class Q1_3_URLify{
	public static void main(String[] args){
		String input = "Mr John Smith    ";
		int len = 13;
		

		System.out.println(urlify(input, len));

	}

	public static String urlify(String input, int len){
		String result = "";
		for(int i = 0 ; i < len ; i++){
			char c = input.charAt(i);
			if(c == ' ') result += "%20";
			else result += c;
		}
		return result;
	}	

	
}