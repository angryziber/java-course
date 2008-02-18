package net.azib.java.students.t001370.lectures.lec2;

/**
 * Master
 *
 * @author t001370
 */
public class Master {
	public static void main(String[] args) {
		Dog a = new Dog("Tuzik");
		Dog b = new Bulldog("Sharik");
//võib ka nii: Object a = new Dog("Tuzik");
//võib ka nii: Object b = new Bulldog("Sharik");
		
		System.out.println("i have two: \n" + a + " and \n" + b);
	}
}
