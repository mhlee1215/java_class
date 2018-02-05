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



class rental {
	public static void main (String [] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("rental.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("rental.out")));
		
		List<Integer> milk = new Vector<Integer>();
		List<Integer> rent = new Vector<Integer>();
		List<PriceSpan> priceSpanList = new Vector<PriceSpan>();
		String[] p = f.readLine().split(" ");
		int n = Integer.parseInt(p[0]);
		int m = Integer.parseInt(p[1]);
		int r = Integer.parseInt(p[2]);
		
		for(int i = 0 ; i < n ; i++) {
			String[] p1 = f.readLine().trim().split(" ");
			int a = Integer.parseInt(p1[0]);
			milk.add(a);
		}
		
		for(int i = 0 ; i < m ; i++) {
			String[] p1 = f.readLine().trim().split(" ");
			int a = Integer.parseInt(p1[0]);
			int price = Integer.parseInt(p1[1]);
			priceSpanList.add(new PriceSpan(a, price));
		}
		
		for(int i = 0 ; i < r ; i++) {
			String[] p1 = f.readLine().trim().split(" ");
			int a = Integer.parseInt(p1[0]);
			rent.add(a);
		}

		Collections.sort(milk, Collections.reverseOrder());
		Collections.sort(priceSpanList, PriceComparator);
		Collections.sort(rent, Collections.reverseOrder());
			
		int profit = 0;
		
		while(milk.size() > 0) {
			int amount = milk.get(0);
			int maxSell = getMaxSell(amount, priceSpanList);
			int maxRent = getMaxRent(rent);
			
			int bestIdx = 0;
			if(maxSell > maxRent) {
				bestIdx = 0;
			}else {
				bestIdx = milk.size()-1;
			}
				
			if(maxSell == 0 && maxRent == 0){
				break;
			}else {
				//System.out.println("maxSell:"+maxSell+", maxRent"+maxRent);
				if(maxSell > maxRent) {
					profit += maxSell;
				//	System.out.println("before"+priceSpanList);
					priceSpanList = doSell(amount, priceSpanList);
				//	System.out.println("after"+priceSpanList);
				}else {
					profit += maxRent;
				//	System.out.println("before"+rent);
					rent = doRent(rent);
				//	System.out.println("after"+rent);
				}
			}
			milk.remove(bestIdx);
		}
		
		out.println(profit);
		// output result
		out.close();                                  // close the output file
	}
	
	public static int getMaxSell(int amount, List<PriceSpan> priceSpanList) {
		if(priceSpanList.size() == 0) return 0;
		else {
			int price = 0;
			int remained = amount;
			System.out.println("remain:"+remained);
			for(int i = 0 ; i < priceSpanList.size() ; i++) {
				price += Math.min(remained, priceSpanList.get(i).amount)*priceSpanList.get(i).price;
				remained -= priceSpanList.get(i).amount;
				if(remained < 0) break;
			}
			return price;	
		}	
	}
	
	public static List<PriceSpan> doSell(int amount, List<PriceSpan> priceSpanList){
		int remained = amount;
		for(int i = 0 ; i < priceSpanList.size() ; i++) {
			if(remained > priceSpanList.get(i).amount) {
				remained -= priceSpanList.get(i).amount;
				priceSpanList.get(i).amount = 0;
			}else {
				priceSpanList.get(i).amount -= remained;
				break;
			}
		}
		return priceSpanList;
	}
	
	public static int getMaxRent(List<Integer> rent) {
		if(rent.size() == 0) return 0;
		else return rent.get(0);
	}
	
	
	
	public static List<Integer> doRent(List<Integer> rent){
		rent.remove(0);
		return rent;
	}
	

	public static class PriceSpan{
		int amount;
		int price;

		public PriceSpan(int amount, int price) {
			this.amount = amount;
			this.price = price;
		}
		public String toString() {
			return amount+" "+price;
		}
	}

	//Anonymous class.
	public static Comparator<PriceSpan> PriceComparator 
	= new Comparator<PriceSpan>() {
		//This is class body!
		public int compare(PriceSpan std1, PriceSpan std2) {
			//ascending order
			return - std1.price + std2.price;
		}
	};
	
//	public static class ExpectSpan{
//		int idx;
//		int sell;
//		int rent;
//		int gap;
//
//		public ExpectSpan(int idx, int sell, int rent) {
//			this.idx = idx;
//			this.sell = sell;
//			this.rent = rent;
//			this.gap = Math.abs(sell-rent);
//		}
//		public String toString() {
//			return sell+" "+rent;
//		}
//	}
//	
//	//Anonymous class.
//		public static Comparator<ExpectSpan> ExpectComparator 
//		= new Comparator<ExpectSpan>() {
//			//This is class body!
//			public int compare(ExpectSpan std1, ExpectSpan std2) {
//				//ascending order
//				return - std1.gap + std2.gap;
//			}
//		};


}