//package usaco;

/*
ID: mhlee1215
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;

class gift1 {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    
    StringTokenizer st = new StringTokenizer(f.readLine());
						  // Get line, break into tokens
    int np = Integer.parseInt(st.nextToken());    // first integer
    
    Vector<String> namesKey = new Vector<String>();
    Map<String, Integer> names = new HashMap<String, Integer>();
    for(int i = 0 ; i < np ; i++){
    	String name = f.readLine();
    	names.put(name, 0);
    	namesKey.add(name);
    }
    
    String next = f.readLine();
    //System.out.println(next);
    while(next != null){
    	String giver = next;
    	//System.out.println(giver);
    	st = new StringTokenizer(f.readLine());
    	int amount = Integer.parseInt(st.nextToken());
    	
    	
    	
    	int divideNum = Integer.parseInt(st.nextToken());
    	//System.out.println(amount+" "+divideNum);
    	
    	int divideMoney = 0;
    	if(divideNum > 0)
    		divideMoney = amount / divideNum;
    	
    	names.put(giver, names.get(giver) - divideMoney*divideNum);
    	for(int i = 0 ; i < divideNum ; i++){
    		String receiver = f.readLine();
    		//System.out.println(receiver);
    		names.put(receiver, names.get(receiver) + divideMoney);
    	}
    	next = f.readLine();
    }
    
    
    for(int i = 0 ; i < namesKey.size(); i++)
    	out.println(namesKey.get(i)+" "+names.get(namesKey.get(i)));
    
    out.close();                                  // close the output file
  }
}