//package usaco.dec_2016;
//package usaco.dec_18_2017;
//package usaco;

/*
ID: mhlee1215
LANG: JAVA
TASK: billboard
*/
import java.io.*;
import java.util.*;

class cowsignal {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("cowsignal.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));
    
    String[] part1 = f.readLine().split(" ");
    int M = Integer.parseInt(part1[0]);
    int N = Integer.parseInt(part1[1]);
    int K = Integer.parseInt(part1[2]);
    
    for(int m = 0 ; m < M ; m++) {
    		if(m > 0) out.println();
    		String line = f.readLine();
    		for(int k = 0 ; k < K ; k++) {
    			if(k > 0) out.println();
        		for(int n = 0 ; n < N ; n++) {
        			for(int k2 = 0 ; k2 < K ; k2++)
        				out.print(line.charAt(n));
        		}    			
    		}
    }
    out.close();                                  // close the output file
  }
}