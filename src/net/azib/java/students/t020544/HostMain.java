package net.azib.java.students.t020544;

/**
 * Main
 * 
 * @author Julija
 */
public class HostMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(Host.getInstance().acquireDog());

		System.out.println(Host.getInstance().acquireDog().getName());
		System.out.println(Host.getInstance().acquireDog().getName());
		System.out.println(Host.getInstance().acquireDog().getName());

	}

}
