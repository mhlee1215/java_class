package cp_class;

public class RandomArray {
	public static void main(String[] args) {
		 int width = 10;
		 int height = 5;
		 int[] rand1DArray = gen1DRandomArray(width);
		 printArray(rand1DArray);
		 int[][] rand2DArray = gen2DRandomArray(width, height);
		 printArray(rand2DArray);
	}
	
	static int[] gen1DRandomArray(int width){
		int[] randArray = new int[width];
		//*** Code here ***
		return randArray;
	}
	
	static void printArray(int[] arr){
		//*** Code here ***
	}
	
	static int[][] gen2DRandomArray(int width, int height){
		int[][] rand2DArray = new int[height][width];
		//Code here
		return rand2DArray;
	}
	
	static void printArray(int[][] arr){
		//*** Code here ***
	}
}
