package interface_with;
public class ZooKeeper {    
	//Note that lion and tiger can be called as predator
    public void feed(Predator predator) {
        System.out.println("feed "+predator.getName());
    }

    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        tiger.setName("tiger");

        Lion lion = new Lion();
        lion.setName("lion");
        
        ZooKeeper zooKeeper = new ZooKeeper();
        zooKeeper.feed(tiger);
        zooKeeper.feed(lion);
        
        //They also can be called as predator
        Predator p1 = tiger;
        Predator p2 = lion;
    }
}