package net.azib.java.students.t104923.hometask3;

public class Cat extends Pet {

	public Cat(String name, int age, int weight, String color){
		setName(name);
		setAge(age);
		setWeight(weight);
		setColor(color);
	}

	public String makeSound(){
		return "Meow!";
	}

	public String toString(){
		return "A " + (getAge() > 1 ? getAge() + " years" : getAge() + " year") + " old " + getColor() + " cat named " + getName() + " weights " + getWeight() + " kg.";
	}
}
