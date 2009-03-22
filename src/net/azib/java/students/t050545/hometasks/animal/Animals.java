package net.azib.java.students.t050545.hometasks.animal;

/**
 * Animals
 * 
 * @author libricon
 */
public class Animals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Animal[] pets = new Animal[] { new Dog("Urbi", 3), new Dog("Pesik", 5),
				new Cat("Masja",6), new Cat("4ernqsh", 1)};
		   for(Animal a: pets) {
			   System.out.println(a);
		   } 
		}

	}

