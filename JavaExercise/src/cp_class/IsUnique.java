package cp_class;

public class IsUnique {
	public static void main(String[] args) {
		int height = 5;
		int width = 10;
        int[][] rand2DArray = new int[height][width];
        
        for(int i = 0 ; i < height ; i++){
        	for(int j = 0 ; j < width ; j++){
        		System.out.print(rand2DArray[i][j]+" ");
        	}
        	System.out.println();
        }
		
        String s = "abcdeffff";
		int[] a = new int[s.length()];
		System.out.println(a.length);
		
		
		System.out.println("String "+s+" is "+isUniqueString(s));
	}
	
	static boolean isUniqueString(String s){
		boolean isUnique = true;
		// *** Code here ***
		return isUnique;
	}
}
