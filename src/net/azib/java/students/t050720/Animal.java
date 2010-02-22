package net.azib.java.students.t050720;

import com.sun.org.apache.bcel.internal.classfile.JavaClass;

/**
 * Animal
 *
 * @author Marek
 */
public abstract class Animal {
	int age;
	int weight;
	
	abstract void makeSound();

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
}
