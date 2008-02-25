package net.azib.java.students.t030611.homework;

/**
 * Animal
 *
 * @author 030611
 */
public abstract class Animal  {
	private String  name;
	private int  age;
	
	Animal(String name, int age){
		this.name=name;
		this.age=age;
	}
	/** returns animals's name */
	String getName() {
		final String newName = name;
		return newName;
	}
	
	int getAge(){
		final int newAge=age;
		return newAge;
	}
	
	abstract String getVoice();

	@Override
	public boolean equals(Object that) {
		if(that instanceof Animal)
			return name.equals(((Animal)that).name);
		else 
			return false;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}
	

	
	
}
