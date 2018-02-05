package usaco.dec_18_2017;
//package usaco.dec_18_2017;
//package usaco;

/*
ID: mhlee1215
LANG: JAVA
TASK: measurement
*/
import java.io.*;
import java.util.*;

class shuffle {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("shuffle.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
    
    String[] part1 = f.readLine().split(" ");
    int n = Integer.parseInt(part1[0]);
    
    
    String[] part2 = f.readLine().split(" ");
    int[] shuffle = new int[n];
    for(int i = 0 ; i < n ; i++)
    		shuffle[i] = Integer.parseInt(part2[i]);
    
    String[] ids = f.readLine().split(" ");
    
    ids = reverse_shuffle(ids, shuffle);
    ids = reverse_shuffle(ids, shuffle);
    ids = reverse_shuffle(ids, shuffle);
    
    for(int i = 0 ; i < n ; i++)
    		out.println(ids[i]);                           // output result
    out.close();                                  // close the output file
  }
  
  public static String[] reverse_shuffle(String[] ids, int[] shuffle) {
	  String[] before = new String[ids.length];
	  for(int i = 0 ; i < ids.length ; i++)
		  before[i] = ids[shuffle[i]-1];
	  return before;
  }
}