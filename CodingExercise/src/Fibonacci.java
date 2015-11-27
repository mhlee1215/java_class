
public class Fibonacci {

	public static void main(String[] args) {
		for(int i = 0 ; i < 10 ; i++){
			System.out.println(Fibo(i));
		}
	}
	
	public static int Fibo(int curPosition){
		if (curPosition == 0) return 0;
		else if(curPosition == 1) return 1;
		else return Fibo(curPosition-1)+Fibo(curPosition-2);
	}
}
