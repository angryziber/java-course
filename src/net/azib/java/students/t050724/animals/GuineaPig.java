package net.azib.java.students.t050724.animals;

/**
 * GuineaPig
 *
 * @author xom
 */
public class GuineaPig extends Pet implements NestBuilder {

	protected boolean isCoward;
	
	/**
	 * @param age
	 * @param weight
	 */
	public GuineaPig(int age, int weight) {
		super(age, weight);
		// TODO Auto-generated constructor stub
	}

	@Override
	void makeSound() {
		System.out.println("squeak, squeak, squeak");

	}

	@Override
	public void buildNest() {
		System.out.println("Look mom, i'm building a nest!");
		
	}

	/**
	 * @return the isCoward
	 */
	public boolean isCoward() {
		return isCoward;
	}

	/**
	 * @param isCoward the isCoward to set
	 */
	public void setCoward(boolean isCoward) {
		this.isCoward = isCoward;
	}
	
}
