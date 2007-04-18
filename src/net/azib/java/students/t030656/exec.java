package net.azib.java.students.t030656;

/**
 * exec
 *
 * @author t030656
 */
public class exec {

	public static void main(String[] args) {
		Host h = Host.getInstance();
		System.out.print("Koeral on alati ");
		System.out.println(h.getName());
			
		System.out.println(h.createRndmDog().getName());
		System.out.println(h.createRndmDog().getName());
		System.out.println(h.createRndmDog().getName());
		System.out.println(h.createRndmDog().getName());

	}
}
