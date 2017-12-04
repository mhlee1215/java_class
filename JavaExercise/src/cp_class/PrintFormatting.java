package cp_class;

public class PrintFormatting {
	public static void main(String[] args) {
		int a = 10;
		double b = 123.456789;
		String str = "hello";
		
		//Print and return to next line
		System.out.println(a+str);  
		System.out.println(str+":"+a);
		System.out.println(str+":"+b);
		
		//just print so we need to use \n for next line
		System.out.printf("%d\n", a);  	//%d for decimal 
		System.out.printf("%s\n", str); //%s for string
		System.out.printf("%f\n", b);	//%f for float/double
		System.out.printf("%05d\n", a); //05 for zero padding
		System.out.printf("%07d\n", a); //05 for zero padding
		System.out.printf("%.2f\n", b);	//.2 for print accuracy 
		System.out.printf("%.5f\n", b);	//.2 for print accuracy (rounded)
	}
}
