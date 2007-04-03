package net.azib.java.students.t030632;

import net.azib.java.students.t030632.DuplicateRemovalImpl;

/**
 * DuplicateRemovalMain
 *
 * @author Toni
 */
public class DuplicateRemovalMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String [] strings = new String[]{"a","x","y","z","a","b"};
		strings = new DuplicateRemovalImpl().removeDuplicateStrings(strings);
		for(String s:strings){
			System.out.println(s);
		}
	}

}
