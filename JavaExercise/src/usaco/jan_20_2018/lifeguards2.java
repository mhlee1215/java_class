//package usaco.jan_20_2018;
//package usaco.jan_20_2018;
//package usaco.dec_18_2017;
//package usaco;

/*
ID: mhlee1215
LANG: JAVA
TASK: measurement
 */
import java.io.*;
import java.util.*;



class lifeguards2 {
	public static void main (String [] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("lifeguards.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
		
		List<TimeSpan> timeSpanList = new Vector<TimeSpan>();
		int n = Integer.parseInt(f.readLine().trim());
		for(int i = 0 ; i < n ; i++) {
			String[] p = f.readLine().trim().split(" ");
			int s = Integer.parseInt(p[0]);
			int e = Integer.parseInt(p[1]);
			TimeSpan m = new TimeSpan(s, e);
			timeSpanList.add(m);
		}
		
		int[] timeMap = new int[1000];
		for(int i = 0 ; i < timeSpanList.size() ; i++) {
			for(int j = timeSpanList.get(i).start ; j < timeSpanList.get(i).end ; j++) {
				timeMap[j] += 1;
			}
		}
		
		int total_coverage = 0;
		for(int i = 0 ; i < timeMap.length ; i++) {
			if(timeMap[i] > 0) total_coverage++;
		}
		
		int min_reduce = 9999999;
		for(int i = 0 ; i < timeSpanList.size() ; i++) {
			int reduce = 0;
			for(int j = timeSpanList.get(i).start ; j < timeSpanList.get(i).end ; j++) {
				if(timeMap[j] == 1) reduce++;
			}
			if(min_reduce > reduce) {
				min_reduce = reduce;
			}
		}
		
		

		
		//System.out.println(total_coverage-min_reduce);
		out.println(total_coverage-min_reduce);
		// output result
		out.close();                                  // close the output file
	}

	public static class TimeSpan{
		int start;
		int end;

		public TimeSpan(int start, int end) {
			this.start = start;
			this.end = end;
		}
		public String toString() {
			return start+" "+end;
		}
	}

	//Anonymous class.
	public static Comparator<TimeSpan> TimeComparator 
	= new Comparator<TimeSpan>() {
		//This is class body!
		public int compare(TimeSpan std1, TimeSpan std2) {
			//ascending order
			return std1.start - std2.start;
		}
	};


}