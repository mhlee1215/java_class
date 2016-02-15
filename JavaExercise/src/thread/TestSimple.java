package thread;
public class TestSimple extends Thread {
	int idx;
	public TestSimple(int idx){
		this.idx = idx;
	}
    public void run() {
        System.out.println("thread run. #:"+idx);
    }

    public static void main(String[] args) {
        TestSimple test = new TestSimple(1);
        test.start();
        TestSimple test2 = new TestSimple(2);
        test2.start();
    }
}