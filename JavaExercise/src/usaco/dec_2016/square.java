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

class square {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("square.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));
    
    String[] part1 = f.readLine().split(" ");
    int llx1 = Integer.parseInt(part1[0]);
    int lly1 = Integer.parseInt(part1[1]);
    int urx1 = Integer.parseInt(part1[2]);
    int ury1 = Integer.parseInt(part1[3]);
    
    String[] part2 = f.readLine().split(" ");
    int llx2 = Integer.parseInt(part2[0]);
    int lly2 = Integer.parseInt(part2[1]);
    int urx2 = Integer.parseInt(part2[2]);
    int ury2 = Integer.parseInt(part2[3]);
    
    
    int minx = Math.min(llx1, llx2);
    int miny = Math.min(lly1, lly2);
    
    int maxx = Math.max(urx1, urx2);
    int maxy = Math.max(ury1, ury2);
    
    int maxSide = Math.max(maxx-minx, maxy-miny);
    
    out.println(maxSide*maxSide);                           // output result
    out.close();                                  // close the output file
  }
}