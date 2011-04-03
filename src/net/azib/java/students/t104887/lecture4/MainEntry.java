package net.azib.java.students.t104887.lecture4;

/**
 * Created by IntelliJ IDEA.
 * User: BJU
 * Date: 3.04.11
 * Time: 18:37
 * To change this template use File | Settings | File Templates.
 */
public class MainEntry {
	public static void main(String[] args) {
		DuplicateRemoverImpl collection = new DuplicateRemoverImpl();
		String[] inputValues = new String[]{"one", "one", "two", "one", "three", "two"};
		String[] outputValues = collection.removeDuplicateStrings(inputValues);

		System.out.println("Input values:");
		for(String value: inputValues){
			System.out.println(value);
		}

		System.out.println("Output values:");
		for(String value: outputValues){
			System.out.println(value);
		}
	}
}
