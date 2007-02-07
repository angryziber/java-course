package net.azib.java.students.t030675;

/**
 * Dog
 *
 * @author t030675
 */
public class Dog {
	private String name;
	private int age;

	/**
	 * @return the vanus
	 */
	public int getVanus() {
		return age;
	}

	/**
	 * @param vanus the vanus to set
	 */
	public void setVanus(int vanus) {
		this.age = vanus;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 */
	public Dog(String name) {
		this.name = name;
	}
	
	public void growUp(){
		this.age++;
	}
	
	/**
	 * 
	 */
	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
}
