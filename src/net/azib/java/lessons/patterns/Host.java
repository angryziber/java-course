package net.azib.java.lessons.patterns;

import net.azib.java.lessons.misc.Dog;

/**
 * Host
 *
 * @author anton
 */
public class Host {
	private static Host instance;
	
	public static Host getInstance() {
		if (instance == null) {
			synchronized (Host.class) {
				if (instance == null) {
					instance = new Host();
				}
			}
		}
		return instance;
	}
	
	private String name;
	private int lastDogId;

	private Host() {
		name = "Juku";
	}
	
	public String getName() {
		return name;
	}
	
	public Dog acquireDog() {
		lastDogId++;
		return new Dog(name + "'s Koer " + lastDogId);
	}
	
}
