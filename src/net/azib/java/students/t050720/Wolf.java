package net.azib.java.students.t050720;

/**
 * Wolf
 *
 * @author Marek
 */
public class Wolf extends Animal {
	
	Boolean isPackLeader;

	/**
	 * @return the isPackLeader
	 */
	public Boolean getIsPackLeader() {
		return isPackLeader;
	}

	/**
	 * @param isPackLeader the isPackLeader to set
	 */
	public void setIsPackLeader(Boolean isPackLeader) {
		this.isPackLeader = isPackLeader;
	}

	void makeSound() {
		System.out.println("howl!");
	}
	
	public String toString()
	{
		return new String("Hi! I'm a wolf!");
	}

}
