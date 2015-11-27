
public class BigNumberCalculator {
	public static void main(String[] args){
		String a = "123";
		String b = "99";
		String sum = bigAdd(a, b);
		System.out.println(sum);
		//System.out.println(reverse(a));
	}
	
	public static String reverseOrder(String a){
		String r_string = "";
		for(int i = a.length()-1 ; i >= 0  ; i--){
			r_string+= a.charAt(i)+"";
		}
		return r_string;
	}
	
	public static String char2String(char a){
		return a+"";
	}
	
	public static int char2Int(char a){
		return a-48;
	}
	
	
	public static String bigAdd(String a, String b){
		String result = "";
		String long_num , short_num;
		if(a.length() > b.length()){
			long_num = a;
			short_num = b;
		}else{
			long_num = b;
			short_num = a;
		}
		//12345 -> 54321
		long_num = reverseOrder(long_num);
		short_num = reverseOrder(short_num);
		
		int carry = 0;
		for(int i = 0 ; i < long_num.length() ; i++){
			int digit_long = char2Int(long_num.charAt(i));
			int digit_short = 0;
			int digit_sum = 0;
			if (i < short_num.length()){
				digit_short = char2Int(short_num.charAt(i));
			}
			
			digit_sum = digit_long + digit_short + carry;
			carry = 0;
			if(digit_sum > 9){
				digit_sum -= 10;
				carry = 1;
			}
			result += Integer.toString(digit_sum);
		}
		
		result = reverseOrder(result);
		return result;
	}
}
