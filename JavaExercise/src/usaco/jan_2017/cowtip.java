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



class cowtip {
	public static void main (String [] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("cowtip.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowtip.out")));
		
		
		int n = Integer.parseInt(f.readLine());
		int[][] board = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			String p = f.readLine().trim();
			for(int j = 0 ; j < p.length() ; j++) {
				board[i][j] = p.charAt(j)-'0';	
			}	
		}
		
		int cnt = 0;
		for(int i=n-1 ; i >= 0 ; i--) {
			
			if(board[i][i] == 1) {
				cnt++;
				board = flip(board, i, i);
			}
			
			//Horizontal board[i][i-1 ... 0]
			for(int j=i-1 ; j >= 0 ; j--) {
				if(board[i][j] == 1) {
					cnt++;
					board = flip(board, i, j);
				}
			}
			
			//Horizontal board[i-1 ... 0][i]
			for(int j=i-1 ; j >= 0 ; j--) {
				if(board[j][i] == 1) {
					cnt++;
					board = flip(board, j, i);
				}
			}
		}
		
		out.println(cnt);
		// output result
		out.close();                                  // close the output file
	}
	
	public static void printBoard(int[][] b) {
		for(int i = 0 ; i < b.length ; i++) {
			for(int j = 0 ; j < b[i].length ; j++) {
				System.out.print(b[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static int countOne(int[][] b) {
		int cnt=0;
		for(int i = 0 ; i < b.length ; i++) {
			for(int j = 0 ; j < b[i].length ; j++) {
				cnt+=b[i][j];
			}
		}
		return cnt;
	}
	
	public static int[][] flip(int[][] b, int x, int y){
		int[][] b2 = new int[b.length][b[0].length];
		for(int i = 0 ; i < b.length ; i++) {
			for(int j = 0 ; j < b[i].length ; j++) {
				if(i <= x && j <= y) {
					b2[i][j] = 1-b[i][j];
				}else {
					b2[i][j] = b[i][j];
				}
			}
		}
		return b2;
	}

}