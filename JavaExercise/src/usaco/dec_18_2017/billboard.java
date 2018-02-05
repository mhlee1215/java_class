//package usaco.dec_18_2017;
//package usaco;

/*
ID: mhlee1215
LANG: JAVA
TASK: billboard
*/
import java.io.*;
import java.util.*;

class billboard {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("billboard.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
    
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
    
    String[] part3 = f.readLine().split(" ");
    int llx3 = Integer.parseInt(part3[0]);
    int lly3 = Integer.parseInt(part3[1]);
    int urx3 = Integer.parseInt(part3[2]);
    int ury3 = Integer.parseInt(part3[3]);
    
    
    
    int minx = Math.min(llx1, Math.min(llx2, llx3));
    int miny = Math.min(lly1, Math.min(lly2, lly3));
    
    int maxx = Math.max(urx1, Math.max(urx2, urx3));
    int maxy = Math.max(ury1, Math.max(ury2, ury3));
    
    int width = maxx-minx;
    int height = maxy-miny;
    
    int[][] rect = new int[width][height];
    for(int x = llx1-minx ; x < urx1-minx ; x++)
    		for(int y = lly1-miny ; y < ury1-miny ; y++)
    			rect[x][y] = 1;
    
    for(int x = llx2-minx ; x < urx2-minx ; x++)
		for(int y = lly2-miny ; y < ury2-miny ; y++)
			rect[x][y] = 1;
    
    for(int x = llx3-minx ; x < urx3-minx ; x++)
		for(int y = lly3-miny ; y < ury3-miny ; y++)
			rect[x][y] = 0;
//    
    int area = 0;
    for(int x = 0 ; x < width ; x++)
    		for(int y = 0 ; y < height ; y++)
    			area += rect[x][y];
    
    out.println(area);                           // output result
    out.close();                                  // close the output file
  }
}