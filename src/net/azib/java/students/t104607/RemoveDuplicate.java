package net.azib.java.students.t104607;
// @author 104607 IASM

import java.util.Properties;

public class RemoveDuplicate {
	public static void main(String[] args) {
		String[] stringArray = {"dog","cat","frog","dog"};

		System.out.println("original array");
		for (String line:stringArray) {
			System.out.println("* "+line);
		}

		System.out.println("after removing duplicates");
		DuplicateRemoverImpl remover = new DuplicateRemoverImpl();
		String[] result = remover.removeDuplicateStrings(stringArray);
		for (String line:result) {
			System.out.println("* " + line);
		}

		Properties properties = System.getProperties();
		System.out.println("\nP.S. Operating system name - " + properties.getProperty("os.name"));
	}
}
