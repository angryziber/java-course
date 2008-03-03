package net.azib.java.students.t040750.lesson2;

/**
 * Dog
 *
 * @author t040750
 */
public class Dog {

	protected String name; 		//Main1: ei saa teha staailiseks, kuna muidu iga Dog tüüpi objekti
						// muutuja name kirjutatakse ühte ja samasse mäluauku, st iga objekti puhul
						// omab name seda väärtust, mis viimane objekt talle andis
	
	/**
	 * @param string
	 */
	public Dog(String name) {
		this.name = name;
	}


	public String getName() {
		
		final String newName = "Mega" + name;
		return newName;
		
		//return name;
	}
	/* Main1 
	public static void main(String[] args) {
		Dog a = new Dog();
		Dog b = new Dog();
		
		a.name = "Sharik";
		b.name = "Tuzik";
		
		System.out.println("I have 2 dogs: " + a.getName() + " and " + b.getName());
	}
	*/
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Bulldog: " + getName();
	}
	
	public static void main(String[] args) {
		Dog a = new Dog("Sharik");
		Dog b = new Dog("Tuzik");
		
		System.out.println("I have 2 dogs: " + a.getName() + ", " + b.getName());
	}
}
