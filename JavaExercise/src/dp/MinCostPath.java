package dp;

public class MinCostPath {
	
	public static int minCost(int[][] map, int w, int h){
		if(w < 0 || h < 0) return 0;
		
		int minCost = 99999;

		minCost = Math.min(map[h][w]+minCost(map, w-1, h), minCost);
		minCost = Math.min(map[h][w]+minCost(map, w-1, h-1), minCost);
		minCost = Math.min(map[h][w]+minCost(map, w, h-1), minCost);

		return minCost;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] map = new int[3][3];
		
		map[0][0] = 1;
		map[0][1] = 2;
		map[0][2] = 3;
		map[1][0] = 4;
		map[1][1] = 8;
		map[1][2] = 2;
		map[2][0] = 1;
		map[2][1] = 5;
		map[2][2] = 3;
		
		System.out.println("min cost :"+minCost(map, 2, 2));
	}

}
