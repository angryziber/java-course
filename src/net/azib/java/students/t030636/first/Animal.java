package net.azib.java.students.t030636.first;

/**
 * Animal
 *
 * @author t030636
 */
public abstract class Animal {
	private String name ;
	private byte age;

	public byte getAge() {
		return age;
	}
	
	public void growUp() {
		age++ ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public Animal(String name, byte age) {
		this.name = name;
		this.age = age;
	}


	public abstract String getType();
	
	@Override
	public String toString() {
		return "I'm "+ getType()+ ", my name is " + name + " and i'm " + age + " years old.";
	}
		
}
