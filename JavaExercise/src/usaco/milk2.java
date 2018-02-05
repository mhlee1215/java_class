//package usaco;

/*
ID: mhlee1215
LANG: JAVA
TASK: milk2
 */
import java.io.*;
import java.util.*;

class milk2 {
	public static void main (String [] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster

		List<MilkSpan> milkSpanList = new Vector<MilkSpan>();
		int n = Integer.parseInt(f.readLine().trim());
		for(int i = 0 ; i < n ; i++) {
			String[] p = f.readLine().trim().split(" ");
			int s = Integer.parseInt(p[0]);
			int e = Integer.parseInt(p[1]);
			MilkSpan m = new MilkSpan(s, e);
			milkSpanList.add(m);
		}

		Collections.sort(milkSpanList, MilkComparator);

		int maxContTime = 0;
		int maxIdleTime = 0;

		int curContStart = 0;
		int curContEnd = 0;

		for(int i = 0 ; i < milkSpanList.size() ; i++) {
			int s = milkSpanList.get(i).start;
			int e = milkSpanList.get(i).end;
			if(i == 0) {
				curContStart = s;
				curContEnd = e;
			}else {
				//Overlap
				if(s <= curContEnd) {
					//Do nothing
				}else {
					int curContTime = curContEnd-curContStart;
					if(curContTime > maxContTime) {
						maxContTime = curContTime;
					}
					curContStart = s;
					int curIdleTime = s-curContEnd;
					if(curIdleTime > maxIdleTime) {
						maxIdleTime = curIdleTime;
					}
				}
				if(curContEnd < e) curContEnd = e;
			}

			//Handle the last element
			if(i == milkSpanList.size()-1) {
				int curContTime = curContEnd-curContStart;
				if(curContTime > maxContTime) {
					maxContTime = curContTime;
				}
			}
		}

		out.println(maxContTime+" "+maxIdleTime);
		out.close();                                  // close the output file
	}

	public static class MilkSpan{
		int start;
		int end;

		public MilkSpan(int start, int end) {
			this.start = start;
			this.end = end;
		}
		public String toString() {
			return start+" "+end;
		}
	}

	//Anonymous class.
	public static Comparator<MilkSpan> MilkComparator 
	= new Comparator<MilkSpan>() {
		//This is class body!
		public int compare(MilkSpan std1, MilkSpan std2) {
			//ascending order
			return std1.start - std2.start;
		}
	};
}