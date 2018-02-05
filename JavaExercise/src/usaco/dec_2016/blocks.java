//package usaco.dec_2016;
//package usaco.dec_18_2017;
//package usaco;

/*
ID: mhlee1215
LANG: JAVA
TASK: measurement
*/
import java.io.*;
import java.util.*;

class blocks {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("blocks.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));
    
    int n = Integer.parseInt(f.readLine());
    
    int[] initArr = new int[26];
    for(int i = 0 ; i < n ; i++) {
    		int[] curArr = new int[26];
    		String[] p = f.readLine().split(" ");
    		int[] a = getAlphaArr(p[0]);
    		curArr = mergeArrMax(curArr, a);
    		int[] b = getAlphaArr(p[1]);
    		curArr = mergeArrMax(curArr, b);
    		
    		initArr = mergeArrAdd(initArr, curArr);
    }
    
    for(int i = 0 ; i < 26 ; i++) {
    		if(i > 0) out.println();
    		out.print(initArr[i]);
    		
    }
                           // output result
    out.close();                                  // close the output file
  }
  
  public static int[] getAlphaArr(String str) {
	  int[] alpha = new int[26];
	  for(int i = 0 ; i < str.length() ; i++)
		  alpha[str.charAt(i)-'a']++;
	  return alpha;
  }
  
  public static int[] mergeArrMax(int[] a, int[] b) {
	  int[] c = new int[a.length];
	  
	  for(int i = 0 ; i < a.length ; i++) {
		  c[i] = Math.max(a[i], b[i]);
	  }
	  
	  return c;
  }
  
  public static int[] mergeArrAdd(int[] a, int[] b) {
	  int[] c = new int[a.length];
	  
	  for(int i = 0 ; i < a.length ; i++) {
		  c[i] = a[i]+b[i];
	  }
	  
	  return c;
  }
  
}