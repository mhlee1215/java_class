package interface_with;
public class Lion extends Animal implements Predator {
	//interface Predator Forced to implement it
    public String getName() {
        return this.name;
    }
}