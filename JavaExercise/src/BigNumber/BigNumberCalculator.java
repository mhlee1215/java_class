package BigNumber;

public class BigNumberCalculator {
	
	public static void main(String[] args){
		String a = "12345";
		System.out.println(getNumber(a, 0));
		System.out.println(getNumber(a, 1));
		System.out.println(getNumber(a, 2));
		System.out.println(getNumber(a, 3));
		System.out.println(getNumber(a, 4));
	}
	
	public static int getNumber(String a, int index){
		return a.charAt(index)- 48;
	}

}
