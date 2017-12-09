//package usaco;

/*
ID: mhlee1215
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

class ride {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("ride.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
            
    String comet = f.readLine();//st.nextToken();
    String group = f.readLine();//st.nextToken();
    
    int sum1 = 1;
    for(int i = 0 ; i < comet.length() ; i++)
    	sum1 *= (comet.charAt(i)-'A'+1);
    
    int sum2 = 1;
    for(int i = 0 ; i < group.length() ; i++)
    	sum2 *= (group.charAt(i)-'A'+1);
    
    if(sum1 % 47 == sum2 % 47)
    	out.println("GO");
    else
    	out.println("STAY");
    //out.println(i1+i2);                           // output result
    out.close();                                  // close the output file
  }
}