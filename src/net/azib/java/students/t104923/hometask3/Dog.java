package net.azib.java.students.t104923.hometask3;

public class Dog extends Pet {

	public Dog(String name, int age, int weight, String color)
	{
		setName(name);
		setAge(age);
		setWeight(weight);
		setColor(color);
	}

	public String makeSound() {
		return "Bark!";
	}

	public String toString() {
		return "A " + (getAge() > 1 ? getAge() + " years" : getAge() + " year") + " old " + getColor() + " dog named " + getName() + " weights " + getWeight() + " kg.";
	}
}