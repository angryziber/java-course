package net.azib.java.students.t030656.homework;

import java.util.Scanner;

/**
 * reader
 *
 * @author sprot
 */
public class Reader {
	/**
	 * constructor
	 */
	public Reader() {
	}
	
	static Competition readFromScreen(){
		Competition comp = new Competition();
		Scanner kbdIn = new Scanner(System.in);
		System.out.print("Enter the competition name: ");  
		comp.setName(kbdIn.nextLine());
		
		String pName;
		
		return comp;
	}
}
