package net.azib.java.students.t654321.hometasks;

/**
 * AnimalCreator
 *
 * @author karl
 */
public class AnimalCreator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int arrayLenght = Integer.parseInt(args[0]);
		Animal[] animal = new Animal[arrayLenght];
		System.out.println("Array lenght is: " + arrayLenght);
		for (int i = 0; i < arrayLenght; i++){
			int selector = (int)(3.0 * Math.random() + 1);
			System.out.println("Index i before is" + i);
			System.out.println("Selector is " + selector);
			switch (selector) {
            case 1:  animal[i] = new Turtle("Jass","brown",100); break;
            case 2:  animal[i] = new Snake("Uss","brown",100); break;
            case 3:  animal[i] = new Goose("Jasper","brown",100); break;
			}
			System.out.println("Index i is" + i);
			System.out.println("");
		}
		
		for(Animal a: animal)
			System.out.println(a.toString());
	}
}
