package search;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

class MyPair{
	public String job;
	public String dependent;
	public MyPair(String job, String dependent){
		this.job = job;
		this.dependent = dependent;
	}
}

public class Q4_7_build_order{


	public static void main(String[] args){
		
		String a = "abcdefg";
		String b = "cde";
		
		System.out.println(a.indexOf(b));
		System.out.println("abcdefg".substring(3));
		
//		String[] list = {"a", "b", "c", "d", "e", "f"};
//		List<MyPair> dep = new ArrayList<MyPair>();
//		dep.add(new MyPair("a", "d"));
//		dep.add(new MyPair("f", "b"));
//		dep.add(new MyPair("b", "d"));
//		dep.add(new MyPair("f", "a"));
//		dep.add(new MyPair("d", "c"));
//		System.out.println(buildOrder(list, dep));
	}

	public static List<String> buildOrder(String[] jobs, List<MyPair> dep){
		List<String> remaining = new ArrayList<String>();
		List<String> order = new ArrayList<String>();
		HashMap<String, String> depMap = new HashMap<String, String>();

		for(int i = 0 ; i < jobs.length ; i++){
			remaining.add(jobs[i]);
		}

		for(int i = 0 ; i < dep.size() ; i++){
			depMap.put(dep.get(i).dependent, dep.get(i).job);
		}


		while(remaining.size() > 0){
			//Find top job
			String curTop = remaining.get(0);

			while(depMap.get(curTop) != null){
				curTop = depMap.get(curTop);
			}
			System.out.println(curTop);
			order.add(curTop);
			System.out.println("before"+remaining);
			remaining.remove(curTop);
			System.out.println("after"+remaining);
		}

		return order;

	}
}