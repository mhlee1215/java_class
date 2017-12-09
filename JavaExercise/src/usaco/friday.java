//package usaco;

/*
ID: mhlee1215
LANG: JAVA
TASK: friday
*/
import java.io.*;
import java.util.*;

class friday {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("friday.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    StringTokenizer st = new StringTokenizer(f.readLine());
						  // Get line, break into tokens
    int N = Integer.parseInt(st.nextToken());    // first integer
    //int i2 = Integer.parseInt(st.nextToken());    // second integer
    
    Vector<Integer> frequency = new Vector<Integer>();
    //Mon:0, ... Sun:6
    for(int i = 0 ; i < 7 ; i++)
    	frequency.add(0);
    
    int curDate = 2; //1900, Jan 1 is Monday
    
    for(int year = 0 ; year < N ; year++){
    	for(int month = 1 ; month <= 12 ; month++){
    		int curDay = getDateOfMonth(month, year+1900);
    		
    		int dateOf13Th = (curDate + 12)%7;
    		frequency.set(dateOf13Th, frequency.get(dateOf13Th)+1);
    		
    		curDate = (curDate+curDay) % 7;
    		
    	}
    }
    
    for(int i = 0 ; i < frequency.size() ; i++){
    	if(i > 0) out.print(" ");
    	out.print(frequency.get(i));                           // output result	
    }
    out.println("");
    
    
    out.close();                                  // close the output file
  }
  
  public static int getDateOfMonth(int month, int year){
	  if(month == 2){
		  if(year % 400 == 0) return 29;
		  else if(year % 100 == 0) return 28;
		  else if(year % 4 == 0) return 29;
		  else return 28;
	  }
	  else if(month == 4 || month == 6 || month == 9 || month == 11 ) return 30;
	  else return 31;
  }
}