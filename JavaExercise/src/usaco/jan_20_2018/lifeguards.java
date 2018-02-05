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



class lifeguards {
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

		Collections.sort(timeSpanList, TimeComparator);
		
		int total_coverage = 0;
		int min_reduce = 999999999;
		int cur_start = 0;
		int cur_end = 0;
		for(int i = 0 ; i < timeSpanList.size(); i++) {
			if(i == 0){
				cur_start = timeSpanList.get(i).start;
				cur_end = timeSpanList.get(i).end;
			}else {
				if(timeSpanList.get(i).start > cur_end) {
					total_coverage += cur_end-cur_start;
					cur_start = timeSpanList.get(i).start;
					cur_end = timeSpanList.get(i).end;
				}else {
					if(timeSpanList.get(i).end > cur_end) {
						cur_end = timeSpanList.get(i).end;
					}
				}
			}
			//For the last
			int overlap = 0;
			if(i == timeSpanList.size()-1) {
				total_coverage += cur_end-cur_start;
			}
			
			//Find overlap comparing to prev and next
			//First case = only compare to next
			if(i == 0) {
				//Single size input
				if(n == 1) {
					overlap = 0;
				}else {
					if(timeSpanList.get(i+1).start < timeSpanList.get(i).end) {
						overlap = Math.min(timeSpanList.get(i).end,timeSpanList.get(i+1).end) - 
								timeSpanList.get(i+1).start; 
					}
				}
			}
			//Last case = only compare to prev
			else if(i == timeSpanList.size()-1) {
				if(timeSpanList.get(i-1).end > timeSpanList.get(i).start) {
					overlap = timeSpanList.get(i-1).end - 
							Math.max(timeSpanList.get(i).start, timeSpanList.get(i-1).start); 
				}
			}
			//Otherwise = compare to prev and next
			else {
				//Prev
				if(timeSpanList.get(i-1).end > timeSpanList.get(i).start) {
					overlap += timeSpanList.get(i-1).end - 
							Math.max(timeSpanList.get(i).start, timeSpanList.get(i-1).start); 
				}
				//Next
				if(timeSpanList.get(i+1).start < timeSpanList.get(i).end) {
					overlap += Math.min(timeSpanList.get(i).end,timeSpanList.get(i+1).end)
							- timeSpanList.get(i+1).start; 
				}
			}
			//System.out.println(overlap);
			int reduced_day = timeSpanList.get(i).end - timeSpanList.get(i).start - overlap;
			if(min_reduce > reduced_day)
				min_reduce = reduced_day;
			
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