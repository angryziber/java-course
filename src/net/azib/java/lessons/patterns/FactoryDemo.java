package net.azib.java.lessons.patterns;

import net.azib.java.lessons.basic.Animal;
import net.azib.java.lessons.basic.Cat;
import net.azib.java.lessons.basic.Dog;

/**
 * FactoryDemo
 *
 * @author anton
 */
public class FactoryDemo {
	
	static class AnimalFactory {
		
		static enum Factory {
			DOG(Dog.class),
			CAT(Cat.class);

			private final Class<? extends Animal> clazz;

			private Factory(Class<? extends Animal> clazz) {
				this.clazz = clazz;
			}
		}
		
		Class<? extends Animal> animalClass;
		
		private AnimalFactory(Factory currentClass) {
			this.animalClass = currentClass.clazz;
		}

		public Animal createAnimal() {
			try {
				return animalClass.newInstance();
			}
			catch (Exception e) {
				throw new RuntimeException("Failed to create " + animalClass, e);
			}
		}
		
		static AnimalFactory newInstance(String animalName) {
			Factory f = Factory.valueOf(Factory.class, animalName.toUpperCase());
			return new AnimalFactory(f);
		}
	}
	
	public static void main(String[] args) {
		Animal a = AnimalFactory.newInstance("dog").createAnimal();
	}
}
