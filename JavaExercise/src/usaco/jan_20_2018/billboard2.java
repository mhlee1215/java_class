//package usaco.jan_20_2018;
//package usaco.dec_18_2017;
//package usaco;

/*
ID: mhlee1215
LANG: JAVA
TASK: billboard
*/
import java.io.*;
import java.util.*;

class billboard2 {
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
    
    
    
    
//    int llxMin = Math.min(llx1, llx2);
//    int llyMin = Math.min(lly1, lly2);
//    int urxMax = Math.max(urx1, urx2);
//    int uryMax = Math.max(ury1, ury2);
//    
//    llx1-=llxMin;
//    lly1-=llyMin;
//    urx1-=llxMin;
//    ury1-=llyMin;
//    
//    llx2-=llxMin;
//    lly2-=llyMin;
//    urx2-=llxMin;
//    ury2-=llyMin;
//    
//    int width = urxMax-llxMin;
//    int height = uryMax-llyMin;
//    
//    
//    int[][] map = new int[uryMax-llyMin][urxMax-llxMin];
//    
//    for(int i = llx1 ; i < urx1 ; i++ ) {
//    		for(int j = lly1 ; j < ury1 ; j++ ) {
//    			map[j][i] = 1;
//        }
//    }
//    
//    for(int i = llx2 ; i < urx2 ; i++ ) {
//		for(int j = lly2 ; j < ury2 ; j++ ) {
//			map[j][i] *= 0;
//		}
//    }
//    
//    int maxWidth = 0;
//    int maxHeight = 0;
//    
//    int[] map_x = new int[width];
//    int[] map_y = new int[height];
//    for(int i = 0 ; i < height ; i++) {
//    		for(int j = 0 ; j < width ; j++) {
//    			map_y[i]+=map[i][j];
//        }
//    }
//    
//	for(int j = 0 ; j < width ; j++) {
//		for(int i = 0 ; i < height ; i++) {
//			map_x[j]+=map[i][j];
//		}
//	}
//	
//	for(int j = 0 ; j < width ; j++) {
//		if(map_x[j] > 0) maxWidth++;
//	}
//	
//	for(int i = 0 ; i < height ; i++) {
//		if(map_y[i] > 0) maxHeight++;
//	}
	
	
    
    int width = urx1-llx1;
    int height = ury1-lly1;
    
    //Horizontally cover all
    if(llx1 >= llx2 && urx1 <= urx2) {
    		if(lly1 <= ury2 && ury2 <= ury1 && lly1 <= lly2 && lly2 <= ury1) {
    			
    		}
    		else if(lly1 <= ury2 && ury2 <= ury1) {
    			height = ury1 - ury2;
    		}else if(lly1 <= lly2 && lly2 <= ury1) {
    			height = lly2 - lly1;
    		}
    }
    //Vertically cover all
    if(lly1 >= lly2 && ury1 <= ury2) {
    		if(llx1 <= urx2 && urx2 <= urx1 && llx1 <= llx2 && llx2 <= urx1) {
    			
    		}
    		else if(llx1 <= urx2 && urx2 <= urx1) {
    			width = urx1 - urx2;
		}else if(llx1 <= llx2 && llx2 <= urx1) {
			width = llx2 - llx1;
		}
    }
    
    out.println(width*height);                           // output result
    out.close();                                  // close the output file
  }
}