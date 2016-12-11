package thread;
class YourRunnable implements Runnable {
    private Object mPauseLock;
    private boolean mPaused;
    private boolean mFinished;
    int idx;
	int count;

	
    public YourRunnable(int idx) {
    	this.idx = idx;
        mPauseLock = new Object();
        mPaused = false;
        mFinished = false;
    }

    public void run() {
        while (!mFinished) {
            // Do stuff.
        	count++;
    		try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		System.out.println("thread run. #:"+idx+", count:"+count);

            synchronized (mPauseLock) {
                while (mPaused) {
                    try {
                        mPauseLock.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }

    /**
     * Call this on pause.
     */
    public void onPause() {
        synchronized (mPauseLock) {
            mPaused = true;
        }
    }

    /**
     * Call this on resume.
     */
    public void onResume() {
        synchronized (mPauseLock) {
            mPaused = false;
            mPauseLock.notifyAll();
        }
    }
    
    public static void main(String[] args){ 
    	System.out.println("Runnable pause and resume example");
    	YourRunnable test1 = new YourRunnable(1);
    	YourRunnable test2 = new YourRunnable(2);
    	Thread t1 = new Thread(test1);
        t1.start();
        Thread t2 = new Thread(test2);
        t2.start();
        
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
    }

}