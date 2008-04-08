package net.azib.java.lessons.patterns;

import net.azib.java.lessons.basic.Cat;
import net.azib.java.lessons.basic.Dog;

/**
 * FactoryDemo
 *
 * @author anton
 */
public class AbstractFactoryDemo {
	
	public static interface AnimalFactory {
		Cat newCat();
		Dog newDog();
	}
	
	public static class RedAnimalFactory implements AnimalFactory {
		
		public Dog newDog() {
			return new Dog("RedDog");
		}

		public Cat newCat() {
			return new Cat("RedCat");
		}
	}
	
	public static class GreenAnimalFactory implements AnimalFactory {
		public Dog newDog() {
			return new Dog("GreenDog");
		}

		public Cat newCat() {
			return new Cat("GreenCat");
		}
	}

	public static void main(String[] args) {
		genericCode(new RedAnimalFactory());
		genericCode(new GreenAnimalFactory());
	}

	private static void genericCode(AnimalFactory factory) {
		System.out.println("I have created: " + factory.newDog() + " and " + factory.newCat());
	}
	
}
