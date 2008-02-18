package net.azib.java.students.t040750;

/**
 * Master
 *
 * @author t040750
 */
public class Master {
	public static void main(String[] args) {
		Dog a = new Dog("Sharik");
		Dog b = new Bulldog("Tuzik");
		//Dog c = new Dog();
		
	/*	No access to name
		a.name = "888"; 
	*/
		
		System.out.println("Mul on 2 koera: " + a.getName() + " ja " + b.getName());
		System.out.println("Mul on 2 koera: " + a + " ja " + b); 	//nii tohib, kuna StringBuilder 
																	//kutsutakse automaatselt välja (java.Object.toString)
																	//polümorfism (Javas ei ole mittepolümorfismilisi meetodeid)
																	//polümorfism = virtual (C++)
	}
}
