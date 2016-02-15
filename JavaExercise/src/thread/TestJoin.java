package thread;

import java.util.ArrayList;

public class TestJoin {
	public static void main(String[] args) {
	    ArrayList<Thread> threads = new ArrayList<Thread>();
	    for(int i=0; i<10; i++) {
	        Thread t = new TestDetail(i);
	        t.start();
	        threads.add(t);
	    }
	
	    for(int i=0; i<threads.size(); i++) {
	        Thread t = threads.get(i);
	        try {
	            t.join();
	        }catch(Exception e) {
	        }
	    }
	    System.out.println("main end.");
	}
}

