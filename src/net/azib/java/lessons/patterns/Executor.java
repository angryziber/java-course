package net.azib.java.lessons.patterns;


/**
 * Executor
 *
 * @author anton
 */
public class Executor {
	public static void main(String[] args) {
		Host host = Host.getInstance();
		System.out.println(host.acquireDog().getName());
		System.out.println(host.acquireDog().getName());
		System.out.println(host.acquireDog().getName());
	}
}
