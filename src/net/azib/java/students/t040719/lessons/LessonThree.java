package net.azib.java.students.t040719.lessons;

/**
 * LessonThree
 *
 * @author Administrator
 */
public class LessonThree {
	public static void main(String[] args) {
		DuplicateRemoverImpl test = new DuplicateRemoverImpl();
		String[] arr = new String[] {"asd","asd","afsfd","akllkk","asd","kala"};
		System.out.println("Enne:");
		for(String str : arr){
			System.out.println(str);
		}
		System.out.println("\nPärast:");
		arr = test.removeDuplicateStrings(arr);
		for(String str : arr){
			System.out.println(str);
		}
	}
}
