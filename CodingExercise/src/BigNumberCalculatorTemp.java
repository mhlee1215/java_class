
public class BigNumberCalculatorTemp {
	public static void main(String[] args){
		String a = "123";
		String b = "99";
		String sum = bigAdd(a, b);
		System.out.println(sum);
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
		
		//Fill this part so that compute a + b
		
		return result;
	}
}
