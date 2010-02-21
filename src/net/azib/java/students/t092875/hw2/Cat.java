package net.azib.java.students.t092875.hw2;

/**
 * Cat
 *
 * @author Mihhail
 */
public class Cat extends Pet {
	private int numberOfLives;
	
	Cat(String name, int age, int weight){
		super(name,age,weight);
		this.numberOfLives = 9;
	}
	/**
	 * Overload constructor with life settings.
	 * @param name
	 * @param age
	 * @param weight
	 * @param numberOfLives
	 */
	Cat(String name, int age, int weight, int numberOfLives){
		super(name,age,weight);
		if(numberOfLives<=0){
			this.numberOfLives = 0;
		}else{
			this.numberOfLives = numberOfLives;
		}
	}
	/**
	 * Hits the cat with a bus if it has any lives left. Reduces the live count by one.
	 */
	public void getHitByABus(){
		if(this.numberOfLives>0){
			System.out.println("MeooooooooooooooW!");
			this.numberOfLives--;
		}else{
			System.out.println("The cat is dead, you sadist!");
		}
	}
	/**
	 * @return The number of lives the cat has left.
	 */
	public int getNumberOfLives(){
		return this.numberOfLives;
	}
	
	@Override
	public String makeSound() {
		// TODO Auto-generated method stub
		if(this.numberOfLives>0){
			return "Meow";
		}else{
			return "Dead cats don't make sounds";
		}
	}
	
	@Override
	public String toString(){
		String finalOutput = super.toString();
		if(this.numberOfLives>0){
			finalOutput+="It has "+this.numberOfLives+" lives left.";
		}else{
			finalOutput+="The cat is dead. Go bury it.";
		}
		return finalOutput;
	}

}
