package net.azib.java.students.t000522;

import java.util.Calendar;
import java.util.Date;

/**
 * Animal
 *
 * @author jurrassic
 */
public abstract class Animal implements Cloneable {

	private String name;
	private int weigth;
	private Date birthdate;
	
	
	public Animal(String name, int weigth, Date birthdate) {
		this.name = name;
		this.weigth = weigth;
		this.birthdate = birthdate;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " named " + name + 
		" ; birthdate: " + birthdate + " (age " + getAge(birthdate) + "); weigth: " + weigth;
	}
	
	public int getAge(Date birthdate) {
		Calendar dateofbirth = Calendar.getInstance();
		dateofbirth.setTime(birthdate);
		Calendar currentday = Calendar.getInstance();
		int age = currentday.get(Calendar.YEAR) - dateofbirth.get(Calendar.YEAR);
		if (currentday.get(Calendar.DAY_OF_YEAR) <= dateofbirth.get(Calendar.DAY_OF_YEAR)) {
			age--;
		}
		return age;
	}
	
	public abstract void makeNoise(); {
		
	}	

	@Override
	public boolean equals(Object o) {
		if (o instanceof Animal) {
			Animal that = (Animal)o;
			return that.name.equals(this.name)
				&& that.weigth == this.weigth;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return name.hashCode() + weigth * 37;
	}

	@Override
	public Animal clone() throws CloneNotSupportedException {
		Animal clone = (Animal) super.clone();
		clone.weigth = 1;
		clone.birthdate.setTime(732312321332L);
		return clone;
		
	}	
}
