package net.azib.java.lessons.patterns;

import net.azib.java.lessons.basic.Dog;

/**
 * FactoryDemo
 *
 * @author anton
 */
public class FactoryDemo {
	
	public static interface DogFactory {
		Dog newDog();
	}
	
	public static class BullDogFactory implements DogFactory {
		public Dog newDog() {
			return new Dog("BullDog");
		}
	}
	
	public static class DachshundFactory implements DogFactory {
		public Dog newDog() {
			return new Dog("Dachshund");
		}
	}

	public static void main(String[] args) {
		genericCode(new BullDogFactory());
		genericCode(new DachshundFactory());
	}

	private static void genericCode(DogFactory factory) {
		Dog d = factory.newDog();
		System.out.println(d);
	}
	
}
