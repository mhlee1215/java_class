//package usaco;

/*
ID: mhlee1215
LANG: JAVA
TASK: beads
*/
import java.io.*;
import java.util.*;

class beads {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("beads.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    StringTokenizer st = new StringTokenizer(f.readLine());
						  // Get line, break into tokens
    int N = Integer.parseInt(st.nextToken());    // first integer
    String s = f.readLine();
    
    
    int max = 0;
    for(int i = 0 ; i < s.length() ; i++){
    	int curMax = 0;
    	
    	//0:right, 1:left
    	for(int j = 0 ; j < 2 ; j++){
    		int curIdx = i;
    		if(j == 1) curIdx = i-1;
    		
        	char curColor = 'w';
        	while(true){
        		char cur = getBead(curIdx, s);
        		if(cur != 'w') curColor = cur;
        		
        		int nextIdx = 0;
        		
        		if(j==0){
        			nextIdx = curIdx+1;
        		}
        		else if(j==1){
        			nextIdx = curIdx-1;
        		}
        		
        		char next = getBead(nextIdx, s);
        		
        		if(j==0){
        			curIdx++;
            		curIdx = curIdx % s.length();
        		}else if(j==1){
        			curIdx--;
        			if(curIdx < 0) 
        				curIdx = s.length() + curIdx;
        		}
        		
        		if(curIdx == i) break;
        		
        		curMax++;
        		if(curColor != 'w' && (next != 'w' && curColor != next)){
        			break;
        		}
        	}
    	}	
    	if(curMax > max) max = curMax;
    }
    
    out.println(Math.min(max, s.length()));                           // output result
    out.close();                                  // close the output file
  }
  
  public static char getBead(int index, String beads){
	  if(index < 0) index = beads.length() + index;
	  if(index >= beads.length()) index = index % (beads.length());
	  
	  return beads.charAt(index);
  }
}