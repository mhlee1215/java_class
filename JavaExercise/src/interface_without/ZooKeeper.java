package interface_without;
public class ZooKeeper {    
	//Zookeeper has to make their own feed method.
	//If we have another type like bear,
	//then we need to make another one. 
	public void feed(Tiger tiger) {
	    System.out.println("feed tiger");
	}

	public void feed(Lion lion) {
	    System.out.println("feed lion");
	}

    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        tiger.setName("tiger");

        Lion lion = new Lion();
        lion.setName("lion");

        ZooKeeper zooKeeper = new ZooKeeper();
        zooKeeper.feed(tiger);
        zooKeeper.feed(lion);
    }
}