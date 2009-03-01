package net.azib.java.students.t000522;

import java.util.Date;

/**
 * Frog
 *
 * @author jurrassic
 */
public class Frog extends Animal{
	
	private int thonglength;

	public Frog(String name, int weigth, Date birthdate, int thonglength) {
		super(name, weigth, birthdate);
		this.thonglength = thonglength;
	}
	
	@Override
	public void makeNoise() {
		System.out.println("Kva");
	}
	
	@Override
	public String toString() {
		return super.toString() + "; thonglength " + thonglength;
	}

}
