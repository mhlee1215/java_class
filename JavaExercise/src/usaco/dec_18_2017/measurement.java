//package usaco.dec_18_2017;
//package usaco.dec_18_2017;
//package usaco;

/*
ID: mhlee1215
LANG: JAVA
TASK: measurement
*/
import java.io.*;
import java.util.*;

class measurement {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
    
    String[] part1 = f.readLine().split(" ");
    int n = Integer.parseInt(part1[0]);
    
    int[] date = new int[n];
    String[] name = new String[n];
    int[] measure = new int[n];
    
    //int[] shuffle = new int[n];
    int maxN = 0;
    for(int i = 0 ; i < n ; i++) {
    		String[] part2 = f.readLine().split(" ");
    		date[i] = Integer.parseInt(part2[0]);
    		if(date[i] > maxN) maxN = date[i];
    		name[i] = (part2[1]);
    		measure[i] = Integer.parseInt(part2[2]);
    }
    
    String[] nameSet = new String[maxN];
    int[] measureSet = new int[maxN];
    
    for(int i = 0 ; i < n ; i++) {
    		nameSet[date[i]-1] = name[i];
    		measureSet[date[i]-1] = measure[i];
    }
    
    int[] init = new int[3];
    init[0] = 7;
    init[1] = 7;
    init[2] = 7;
    
    HashMap<String, Integer> nameMap = new HashMap<String, Integer>();
    nameMap.put("Mildred", 0);
    nameMap.put("Elsie", 1);
    nameMap.put("Bessie", 2);
    
    int output = 0;
    
    int best = 0;
    for(int i = 0 ; i < maxN ; i++) {
    		//System.out.println(measureSet[i]);
    		if(measureSet[i] != 0) {
    			//System.out.println(nameSet[i]);
    			
    			init[nameMap.get(nameSet[i])] += measureSet[i];
    			init[nameMap.get(nameSet[i])] = Math.max(init[nameMap.get(nameSet[i])], 0);
    			init[nameMap.get(nameSet[i])] = Math.min(init[nameMap.get(nameSet[i])], 1000);
    			
    			int curMax = 0;
    			int curBest = 0;
    			
    			for(int j = 0 ; j < 3 ; j++) {
    				
    				if(curMax <= init[j]) {
    					if(curMax < init[j])
    						curBest = 0;
    					
    					int op = 1;
    					op <<= j;
    					//System.out.println(op);
    					curBest = curBest | op;
    					
    					curMax = init[j];
    					
    					
    				}
    			}
    			//System.out.println("aa"+curBest);
    			
    			if(curBest != best) {
    				output++;
    				best = curBest;
    			}
    		}
    }
    
    	out.println(output);                           // output result
    out.close();                                  // close the output file
  }
}