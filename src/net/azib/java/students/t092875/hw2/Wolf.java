package net.azib.java.students.t092875.hw2;

/**
 * Wolf
 *
 * @author Mihhail
 */
public class Wolf extends Animal {
	private int rabbitsEaten;
	private boolean rabbitCought;
	
	public Wolf(int age, int weight){
		super(age,weight);
	}
	/**
	 * makes a wolf cath a rabbit if he hasn't got one
	 */
	public void cathARabbit(){
		if(this.rabbitCought){
			System.out.println("I already got one!");
		}else{
			System.out.println("Cought a rabbit!");
			this.rabbitCought = true;
		}
	}
	/**
	 * makes wolf eat a rabbit if he has one
	 */
	public void eatARabbit(){
		if(this.rabbitCought){
			System.out.println("MMMM, rabbit! YUMMY!");
			this.rabbitCought = false;
			this.rabbitsEaten++;
		}else{
			System.out.println("I don't have a rabbit to eat!");
		}
	}
	
	@Override
	public String makeSound() {
		return "Howl";
	}
	
	@Override
	public String toString(){
		String extra = "";
		if(this.rabbitsEaten>0){
			extra = "Poor rabbits.";
		}
		return super.toString()+"It ate "+this.rabbitsEaten+" rabbits. "+extra;
	}

}
