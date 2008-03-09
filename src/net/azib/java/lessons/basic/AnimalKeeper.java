package net.azib.java.lessons.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * Master - the keeper of {@link AbstractAnimal}s.
 *
 * @author anton
 */
public class AnimalKeeper {
	
	private Collection<Animal> animals = new HashSet<Animal>(); 
	
	public void obtainAnimal(Animal a) {
		animals.add(a);
	}
	
	public void obtainAnimals(Collection<? extends Animal> newAnimals) {
		animals.addAll(newAnimals);
	}
	
	public void giveAnimal(Collection<? super Animal> whereToPut) {
		whereToPut.add(animals.iterator().next());
	}
	
	public boolean hasAnimal(Animal a) {
		return animals.contains(a);
	}
	
	public String toString() {
		String s = "I have " + animals.size() + " animals:";
		for (Animal a : animals) {
			s += "\n" + a;
		}
		return s;
	}
	
	public static void main(String[] args) {
		Animal a1 = new Dog("Sharik");
		Animal a2 = new Cat("Murzik");
		
		a1.growUp();
		
		AnimalKeeper keeper = new AnimalKeeper();
		keeper.obtainAnimal(a1);
		keeper.obtainAnimal(a2);
		
		Collection<Dog> dogs = Arrays.asList(new Dog("Dog2"), new Dog("Dog2"));
		keeper.obtainAnimals(dogs);
		
		keeper.giveAnimal(new ArrayList<Animal>());
		
		System.out.println(keeper);
		
		a1.makeSound();
		a2.makeSound();
				
		Animal a3 = (Animal) a1.clone();
		System.out.println(a3);
		System.out.println(a3.equals(a1));
	}
}
