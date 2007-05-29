package net.azib.java.students.t030630;

/**
 * Host
 * 
 * @author Kasutaja
 */
public class Host {
	private Host() {
		name = "Juku";
	}

	// private static Host uniqueInstance = new Host();
	//	
	// public static Host getInstance(){
	// return uniqueInstance;
	// }
	public static Host instance;

	public static Host getInstance() {
		if (instance == null) {
			synchronized (instance) {
				instance = new Host();
			}
		}
		return instance;
	}

	private String name;
	
	private int lastDogID;

	public String getName() {
		return name;
	}
	public Dog acquireDog(){
		lastDogID++;
		return new Dog(name + "'s dog " + lastDogID);
	}
}
