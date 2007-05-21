package net.azib.java.students.t030656.homework;

import java.io.InputStream;

/**
 * reader
 *
 * @author sprot
 */
public class Reader {
	InputStream inStream;
	/**
	 * constructor
	 */
	public Reader(InputStream inStream) {
		this.inStream = inStream;
	}
	
	public void readFromScreen(){
		System.out.println("Insert values");
	}
}
