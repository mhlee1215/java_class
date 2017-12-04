package bit_operation;

public class BOTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int val = 3;
		System.out.println("Binary of "+val);
		printBitElements(val);
		val = val << 1;
		System.out.println("Binary of "+val);
		printBitElements(val);
		val = val << 3;
		System.out.println("Binary of "+val);
		printBitElements(val);
		int val2 = 23;
		System.out.println("Binary of "+val2);
		printBitElements(val2);
		System.out.println("OR of "+val+" and "+val2);
		printBitElements(val | val2);
		System.out.println("AND of "+val+" and "+val2);
		printBitElements(val & val2);
		System.out.println("XOR of "+val+" and "+val2);
		printBitElements(val ^ val2);
	}
	
	static void printBitElements(int val){
		//Why 32? 
		for(int i = 0 ; i < 32 ; i++){
			//Meaning?
			int v = 1 & (val >> 32-i-1);
			System.out.print(v);
		}
		System.out.println();
	}
}

