package net.azib.java.students.t000522;

import java.util.Date;

public class Dog extends Animal {
	
	private int taillength;
	
	public Dog(String name, int weigth, Date birthdate, int taillength) {
		super(name, weigth, birthdate);
		this.taillength = taillength;
	}

	@Override
	public void makeNoise() {
		System.out.println("Gav");
	}
	
	@Override
	public String toString() {
		return super.toString() + "; taillength " + taillength;	
	}
}
