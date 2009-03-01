package net.azib.java.students.t000522;

import java.util.Date;

/**
 * Cat
 *
 * @author jurrassic
 */
public class Cat extends Animal {
	
	private Date takenon = new Date();
	
	public Cat(String name, int weigth, Date birthdate, Date takenon) {
		super(name, weigth, birthdate);
		this.takenon = takenon;
	}

	@Override
	public void makeNoise() {
		System.out.println("Meow");
	}
	
	@Override
	public String toString() {
		return super.toString() + "; taken on " + takenon;
	}
}
