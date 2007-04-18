package net.azib.java.students.t020544;

import net.azib.java.lessons.misc.Dog;

;

/**
 * Host
 * 
 * @author Julija
 */
public class Host {

	private static Host instance;
	private static int dogID;
	private String name;

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

	private Host() {
		name = "Juku";
	}

	public String getName() {
		return name;
	}

	public Dog acquireDog() {
		dogID++;
		return new Dog(name + "'s Koer " + dogID);
	}

}
