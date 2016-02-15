package interface_with_class;
public class ZooKeeper {    
    public void feed(Animal animal) {
        System.out.println("feed "+animal.getName());
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