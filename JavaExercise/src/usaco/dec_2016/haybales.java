//package usaco.dec_2016;
//package usaco.dec_18_2017;
//package usaco;

/*
ID: mhlee1215
LANG: JAVA
TASK: haybales
 */
import java.io.*;
import java.util.*;

class haybales {
	public static void main (String [] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("haybales.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));

		String[] nq = f.readLine().split(" ");
		int n = Integer.parseInt(nq[0]);
		int q = Integer.parseInt(nq[1]);

		Vector<Integer> occVector = new Vector<Integer>();
		String[] occu = f.readLine().split(" ");
		for(int i = 0 ; i < n ; i++)
			occVector.add(Integer.parseInt(occu[i]));
		Collections.sort(occVector);

		for(int i = 0 ; i < q ; i++) {
			if(i > 0 ) out.println();

			String[] query = f.readLine().split(" ");
			int start = Integer.parseInt(query[0]);
			int end = Integer.parseInt(query[1]);
			out.print(getOccuNum(occVector, start, end));
		}
		out.close();                                  // close the output file
	}

	public static int getOccuNum(Vector<Integer> occuVector, int start, int end) {
		int startIdx = getSearchIdx(occuVector, start);
		int endIdx = getSearchIdx(occuVector, end);
		
		if(occuVector.get(startIdx) < start)
			startIdx++;
		
		return endIdx-startIdx+1;
	}

	public static int getSearchIdx(Vector<Integer> occuVector, int query) {
		int startIdx = 0;
		int endIdx = occuVector.size()-1;
		int mid = (startIdx+endIdx)/2;
		while(startIdx <= endIdx) {
			if(occuVector.get(mid) > query) {
				endIdx = mid-1;
			}else if(occuVector.get(mid) < query) {
				startIdx = mid+1;
			}else {
				return mid;
			}
			mid = (startIdx+endIdx)/2;
		}
		return mid;
	}

}