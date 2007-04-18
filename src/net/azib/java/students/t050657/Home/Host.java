package net.azib.java.students.t050657.Home;

import net.azib.java.students.t050657.Class.Dog;

/**
 * Host
 *
 * @author t050657
 */
public class Host {
	
	private static Host hostInstance;
	private String name;
	private static int number;
	
	private Host() {
		name = "Jack";
	}
	
	public static Host getInstance() {
		if(hostInstance == null) {
			hostInstance = new Host();
		}
		return hostInstance;
	}
	
	public String getName() {
		return name;
	}
	
	public Dog acqureDog() {
		number++;
		return new Dog(name + "'s Dog " + number);
	}
}
