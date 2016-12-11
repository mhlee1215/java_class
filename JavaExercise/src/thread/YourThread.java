package thread;
class YourThread extends ThreadController {
    int idx;
	int count;

	
    public YourThread(int idx) {
    	super();
    	this.idx = idx;
    }

    public void run() {
        while (!isFinished()) {
            // Do stuff.
        	count++;
    		try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		System.out.println("thread run. #:"+idx+", count:"+count);

            synchronized (getLock()) {
                while (isPaused()) {
                    try {
                        getLock().wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }
  
    public static void main(String[] args){ 
    	System.out.println("Runnable pause and resume example");
    	YourThread test1 = new YourThread(1);
    	YourThread test2 = new YourThread(2);
//    	Thread t1 = new Thread(test1);
//        t1.start();
//        Thread t2 = new Thread(test2);
//        t2.start();
    	test1.start();
    	test2.start();
        
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("thread 2 stopped");
        try {
			test2.onPause();
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
        test2.onResume();
        
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("thread finished");
        test1.onStop();
        test2.onStop();
    }

}