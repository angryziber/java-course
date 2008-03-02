package net.azib.java.lessons.basic;

/**
 * Animal interface - each Animal should provide the following methods.
 *
 * @author anton
 */
public interface Animal extends Comparable<Animal>, Cloneable{

	public String getName();

	public void growUp();

	public byte getAge();

	public void makeSound();

	public int compareTo(Animal that);

	public String toString();
	
	public Animal clone();
}
