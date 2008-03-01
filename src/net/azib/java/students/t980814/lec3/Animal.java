package net.azib.java.students.t980814.lec3;

/**
 * Animal
 *
 * @author dell
 */
public class Animal implements Cloneable {
	protected String name;
	
	Animal(String name) {
		this.name = name;
	}
	
	public boolean equals(Object that) {
		// Üks võimalus, kuid ohtlik.... mitte-Animal-iga võrreldes annab exceptioni
		// return this.name.equals(((Animal)that).name)

		// Nii on korrektne
		if (that instanceof Animal) {
			return this.name.equals(((Animal)that).name);
		}
		else
			return false;
	}
	
	public static void main(String[] args) {
		Animal a = new Animal("Muki");
		Animal b = new Animal("Muki");
		
		System.out.println(a.equals(5));
		System.out.println(a.equals("Muki"));
		System.out.println(a.equals(b));

	
		// Kloonimine viskab exceptioni -> ilma try-catchita ei saa kasutada. Kompiler error

		try {
			Animal c = (Animal)a.clone();
			System.out.println(c);
			System.out.println(a.equals(c));
		}
		catch (CloneNotSupportedException e) {
			System.out.println("Cannot clone!");
			e.printStackTrace();
		}
		catch (NullPointerException e) {
			e.printStackTrace();
		}
		

	}

	// Kasutada Alt+Shift+S override meetodi lisamisel

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		// tagastame nime hashCode()
		return name.hashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// return "Animal named " + name;
		return getClass().getSimpleName() + " named " + name;
	}


	
	
}
