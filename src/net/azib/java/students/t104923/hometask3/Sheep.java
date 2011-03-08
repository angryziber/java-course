package net.azib.java.students.t104923.hometask3;

public class Sheep extends Pet {

	public Sheep(String name, int age, int weight, String color)
	{
		setName(name);
		setAge(age);
		setWeight(weight);
		setColor(color);
	}

	public String makeSound() {
		return "Bleat!";
	}

	public String toString() {
		return "A " + (getAge() > 1 ? getAge() + " years" : getAge() + " year") + " old " + getColor() + " sheep named " + getName() + " weights " + getWeight() + " kg.";
	}
}