package components;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, String> a = new HashMap<Integer, String>();
		a.put(10, "aa");
		a.put(12, "bb");
		a.put(13, "cc");
		for(Integer k : a.keySet()){
			System.out.println(k+" "+a.get(k));
		}
	
	}

}
