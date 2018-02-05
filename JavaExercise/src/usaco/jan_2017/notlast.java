//package usaco.jan_2017;
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



class notlast {
	public static void main (String [] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("notlast.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));
		
		int n = Integer.parseInt(f.readLine());
		HashMap<String, Integer> milkMap = new HashMap<String, Integer>();
		Vector<MilkProduction> milkList = new Vector<MilkProduction>();
		
		milkMap.put("Bessie", 0);
		milkMap.put("Elsie", 0);
		milkMap.put("Daisy", 0);
		milkMap.put("Gertie", 0);
		milkMap.put("Annabelle", 0);
		milkMap.put("Maggie", 0);
		milkMap.put("Henrietta", 0);
		
		for(int i = 0 ; i < n ; i++) {
			String[] p1 = f.readLine().trim().split(" ");
			String name = p1[0];
			int amount = Integer.parseInt(p1[1]);
			if(milkMap.get(name) == null) milkMap.put(name, 0);
			milkMap.put(name, milkMap.get(name)+amount);
			//milkList.add(new MilkProduction(name, amount));
		}
		
		for(String name : milkMap.keySet()) {
			milkList.add(new MilkProduction(name, milkMap.get(name)));
		}
		
		Collections.sort(milkList, amountComparator);
		System.out.println(milkList);
		
		int minNum = 999999;
		int secondMinNum = -1;
		String secondSmallestName = "";
		for(int i = 0 ; i < milkList.size() ; i++) {
			if(i==0) minNum = milkList.get(i).amount;
			else if(minNum != milkList.get(i).amount && secondMinNum < 0) {
				secondSmallestName = milkList.get(i).name;
				secondMinNum = milkList.get(i).amount;
				//break;
			}else if(secondMinNum > 0) {
				if(milkList.get(i).amount == secondMinNum) {
					secondSmallestName = "Tie";
					break;
				}else {
					break;
				}
			}
		}
		if(secondSmallestName == "")
			secondSmallestName = "Tie";
		
		out.println(secondSmallestName);
		// output result
		out.close();                                  // close the output file
	}

	public static class MilkProduction{
		String name;
		int amount;

		public MilkProduction(String name, int amount) {
			this.name = name;
			this.amount = amount;
		}
		public String toString() {
			return name+" "+amount;
		}
	}

	//Anonymous class.
	public static Comparator<MilkProduction> amountComparator 
	= new Comparator<MilkProduction>() {
		//This is class body!
		public int compare(MilkProduction std1, MilkProduction std2) {
			//ascending order
			return std1.amount - std2.amount;
		}
	};
}