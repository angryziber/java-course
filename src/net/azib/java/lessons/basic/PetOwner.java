package net.azib.java.lessons.basic;

/**
 * PetKeeper
 *
 * @author anton
 */
public class PetOwner {
	public static void main(String[] args) {
		new PetOwner().doSomething();		
	}

	private void doSomething() {
		Pet pets[] = {
			new Dog("Muku", 1),
			new Cat("Kiisu", 2)
		};
		
		for (Pet pet : pets) {
			print(pet);
			if (pet instanceof StickCatcher) {
				StickCatcher petAsCatcher = (StickCatcher)pet; 
				petAsCatcher.catchStick();
			}
		}
				
		System.out.println(pets[0] instanceof Dog ? "First pet is a dog!!!" : "");
	}

	private void print(Pet pet) {
		System.out.println("I have a " + getKind(pet) + " named " + pet.getName() + " and it sounds " + pet.getSound());
	}

	private String getKind(Pet pet) {
		return pet.getClass().getSimpleName().toLowerCase();
	}
}
