package net.azib.java.students.t092875.hw2;

/**
 * Cow
 *
 * @author Mihhail
 */
public class Cow extends Pet {
	private int milkGiven;
	
	public Cow(String name, int age, int weight){
		super(name,age,weight);
	}
	/**
	 * Adds one galon of milk to the produced sum for this cow.
	 */
	public void giveMilk(){
		this.milkGiven ++;
	}
	/**
	 * @return The number of galons of milk, that the cow has produced.
	 */
	public int getmilkGiven(){
		return this.milkGiven;
	}
	@Override
	public String makeSound() {
		return "MOOOO";
	}
	
	public String toString(){
		return super.toString()+"It gave "+this.milkGiven+" galons of milk. ";
	}

}
