//package usaco.jan_2017;
//package usaco.jan_20_2018;
//package usaco.jan_20_2018;
//package usaco.dec_18_2017;
//package usaco;

/*
ID: mhlee1215
LANG: JAVA
TASK: measurement
 */
import java.io.*;
import java.util.*;



class hps {
	public static void main (String [] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("hps.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
		
		//int won = 0;
		int n = Integer.parseInt(f.readLine());
		int[][] games = new int[n][2];
		
		int[][] rule = new int[4][4];
		//Rock, Paper, Scissors
		rule[1][3] = 1;
		rule[2][1] = 1;
		rule[3][2] = 1;
		
		int[][] cases = new int[6][4];
		cases[0][1] = 1;
		cases[0][2] = 2;
		cases[0][3] = 3;
		cases[1][1] = 1;
		cases[1][2] = 3;
		cases[1][3] = 2;
		cases[2][1] = 2;
		cases[2][2] = 1;
		cases[2][3] = 3;
		cases[3][1] = 2;
		cases[3][2] = 3;
		cases[3][3] = 1;
		cases[4][1] = 3;
		cases[4][2] = 1;
		cases[4][3] = 2;
		cases[5][1] = 3;
		cases[5][2] = 2;
		cases[5][3] = 1;
		
		for(int i = 0 ; i < n ; i++) {
			String[] p1 = f.readLine().trim().split(" ");
			int a = Integer.parseInt(p1[0]);
			int b = Integer.parseInt(p1[1]);
			games[i][0] = a;
			games[i][1] = b;
		}
		
		int maxWon = 0;
		for(int j = 0 ; j < cases.length ; j++) {
			int won = 0;
			for(int i = 0 ; i < n ; i++) {
				won+=rule[cases[j][games[i][0]]][cases[j][games[i][1]]];
			}
			if(maxWon < won) maxWon = won;
		}
		
		
		out.println(maxWon);
		// output result
		out.close();                                  // close the output file
	}

}