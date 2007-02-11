package net.azib.java.students.t020544;

/**
 * SomeStuff
 * 
 * @author Julija Kondratjeva
 */
public class DogStuff {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dog sobaka = new Dog("Deik", (byte) 3, "Doberman", "Sombody");
		System.out.println(sobaka.getName() + " " +sobaka.getAge()+" "+sobaka.getBreed()+" "+sobaka.getOwner());
		for (int i=0; i< 4; i++){
			sobaka.growUp();
		}
		System.out.println(sobaka.getName() + " " +sobaka.getAge()+" "+sobaka.getBreed()+" "+sobaka.getOwner());
	}
}
