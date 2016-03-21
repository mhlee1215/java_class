package thread;

public class ThreadStartAndStop extends Thread {
	int idx;
	int count;
	public ThreadStartAndStop(int idx){
		this.idx = idx;
	}
    public void run() {
    	count = 0;
    	while(true){
    		count++;
    		try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		System.out.println("thread run. #:"+idx+", count:"+count);
    	}
    }

    public static void main(String[] args) {
    	ThreadStartAndStop test = new ThreadStartAndStop(1);
        test.start();
        ThreadStartAndStop test2 = new ThreadStartAndStop(2);
        test2.start();
        
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("thread 2 stopped");
        try {
			test2.wait();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("thread 2 restarted");
        test2.resume();
    }
}