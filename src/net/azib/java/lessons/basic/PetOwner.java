package net.azib.java.lessons.basic;

import java.util.ArrayList;
import java.util.List;

public class PetOwner {
	private List<Pet> pets = new ArrayList<Pet>();

	public int getPetCount() {
		return pets.size();
	}

	public void buy(Pet pet) {
		pets.add(pet);
	}

	public void buy(Pet pet, String name) {
		Pet renamedPet = pet.rename(name);
		buy(renamedPet);
	}

	public Pet getPet(int indexOneBased) {
		return pets.get(indexOneBased - 1);
	}

	public static void main(String[] args) {
		Bulldog dog = new Bulldog("Sharky");
		System.out.println(dog.toString());

		System.out.println(new Bulldog("a") instanceof Animal);
		System.out.println(new Dog("a") instanceof Animal);
	}
}
