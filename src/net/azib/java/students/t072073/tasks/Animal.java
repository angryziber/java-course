package net.azib.java.students.t072073.tasks;

/**
 * Animal
 *
 * @author t072073
 */
public abstract class Animal {
	private String name;
	private int age;
	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected int getAge() {
		return age;
	}

	protected void setAge(int age) {
		this.age = age;
	}
	
	
	abstract void makeSound();
	
	abstract String animalClass();
	
	public String toString(){
		String animalString = animalClass() + "'s name is " + name;
		return animalString;
		
	}

	public static void main(String[] args) {
		Cat cat1 = new Cat("Miu");
		cat1.setAge(5);
		
		Cat cat2 = new Cat("Saluut");
		cat2.coat("yellow");
		
		GoldFish fish1 = new GoldFish();
		fish1.origin("Jamaica");
		
		GoldFish fish2 = new GoldFish();
		fish2.setName("Saphire");
		fish2.makeSound();

		Animal [] myPets = new Animal []{cat1, fish1, cat2, fish2 };
		for (Animal a : myPets){
			System.out.println(a);
		}
		
	}
}
