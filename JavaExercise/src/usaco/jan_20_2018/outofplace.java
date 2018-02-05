package usaco.jan_20_2018;
//package usaco.dec_18_2017;
//package usaco;

/*
ID: mhlee1215
LANG: JAVA
TASK: billboard
*/
import java.io.*;
import java.util.*;

class outofplace {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("outofplace.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("outofplace.out")));
    
    int n = Integer.parseInt(f.readLine());
    Vector<Integer> a = new Vector<Integer>();
    Vector<Integer> b = new Vector<Integer>();
    Vector<Integer> sorted = new Vector<Integer>();
    for(int i = 0 ; i < n ; i++) {
    		int num = Integer.parseInt(f.readLine());
    		a.add(num);
    		b.add(num);
    }
    
    Collections.sort(a);
    
    System.out.println(a);
    System.out.println(b);
    
    	
    for(int i = 0 ; i < a.size(); i++) {
		if(a.get(i) != b.get(i)) {
			sorted.add(0);
		}else {
			sorted.add(1);
		}
    }
    
    
    Map<Integer, Vector<Integer>> sortedTo = new HashMap<Integer, Vector<Integer>>();
    for(int i = 0 ; i < a.size(); i++) {
    		if(sortedTo.get(a.get(i)) == null){
    			sortedTo.put(a.get(i), new Vector<Integer>());
    		}
    		sortedTo.get(a.get(i)).add(i);
    }
    
    //System.out.println(sortedTo.get(7));
    
//    int diffNum = 0;
//    
//    for(int i = 0 ; i < a.size(); i++) {
//    		if(a.get(i) != b.get(i)) {
//    			diffNum++;
//    		}
//    }
//    
//    out.println(diffNum-1);                           // output result
    out.close();                                  // close the output file
  }
}