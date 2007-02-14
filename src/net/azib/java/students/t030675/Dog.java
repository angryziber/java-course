package net.azib.java.students.t030675;



public class Dog extends Animal implements Comparable<Dog>{

	public Dog(String name) {
		super(name);
	}
	
	public Dog(String name, byte age) {
		super(name, age);
	}



	public String getName() {
		return "Pjos" + super.getName();
	}
	
	public String getType(){
		return "Dog";
	}


	public int compareTo(Dog o) {

		return getName().compareTo(o.getName());
	}
	
}