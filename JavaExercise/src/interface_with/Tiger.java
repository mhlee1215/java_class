package interface_with;
public class Tiger extends Animal implements Predator {
	//interface Predator Forced to implement it
    public String getName() {
        return this.name;
    }
}