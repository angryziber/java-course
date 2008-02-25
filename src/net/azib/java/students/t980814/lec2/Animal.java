package net.azib.java.students.t980814.lec2;

import java.util.Date;

/**
 * Animal
 *
 * @author allan
 */
public abstract class Animal {

	protected String name;
	protected Date birthDay;
	protected boolean canJump;

	Animal() {
		this.name = "Unknown";
		this.birthDay = new Date();
		this.canJump = false;
	}
	
	Animal(String name, Date birthDay, boolean canJump) {
		this.name = name;
		this.canJump = canJump;
		this.birthDay = birthDay;
	}

	public void setBirthday(Date birthDay) {
		this.birthDay = birthDay;
	}
	
	public String getName() {
		return name;
	}

	@SuppressWarnings("deprecation")
	public int getAge() {
		Date rightNow = new Date(); // või new Date();
		int age = 0;
		
		if (birthDay.compareTo(rightNow) < 0) {
			age = rightNow.getYear() - birthDay.getYear();
		}
		
		return age;
	}
	
	public boolean iCanJump() {
		return canJump;
	}

	abstract void makeSound();

	public String toString() {
		return (name + "(" + getAge() + ")");
	}
}
