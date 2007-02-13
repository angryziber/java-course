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
		
		Dog dobermanDeik = new Dog("Deik", (byte) 3, "Doberman", "Somebody");
		
		System.out.println("Name:" +dobermanDeik.getName() + ";  Age:" +dobermanDeik.getAge()+";  Breed:"+dobermanDeik.getBreed()+";  Owner:"+dobermanDeik.getOwner());
		
		for (int i=0; i< 4; i++){
			dobermanDeik.growUp();
		}
		System.out.println(dobermanDeik.getName() + " " +dobermanDeik.getAge()+" "+dobermanDeik.getBreed()+" "+dobermanDeik.getOwner());

		Dog dobermanRex = new Dog("Rex", (byte) 0, "Doberman", "Somebody");
		
		System.out.println(dobermanRex.getName() + " " +dobermanRex.getAge()+" "+dobermanRex.getBreed()+" "+dobermanRex.getOwner());
		
		for (int i=0; i< 4; i++){
			dobermanRex.growUp();
		}
		System.out.println(dobermanRex.getName() + " " +dobermanRex.getAge()+" "+dobermanRex.getBreed()+" "+dobermanRex.getOwner());
	
	}
}
