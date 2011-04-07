package net.azib.java.students.t104540.hometask4;

public class DuplicateRemoverDemo {
	public static void main(String[] args) {
		String[] arr = {"one", "two", "three", "two", "four", "one"};
		System.out.print("Inital values:");
		for (String s : arr) {
			System.out.print(s + ", ");
		}
		DuplicateRemoverImpl remover = new DuplicateRemoverImpl();
		String[] arr2 = remover.removeDuplicateStrings(arr);
		System.out.print("\nValues after removing duplicates:");
		for (String s : arr2) {
			System.out.print(s + ", ");
		}
		System.out.print("\n");
	}
}
