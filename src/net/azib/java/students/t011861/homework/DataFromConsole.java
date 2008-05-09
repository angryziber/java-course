package net.azib.java.students.t011861.homework;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * DataInputModule
 *
 * @author 011861
 */
public class DataFromConsole {
	 /**
	 * Ask data from human
	 * @param String order - command to human
	 * @return String commandNumber - inserted symbol 
	 */
	static public String readOperation(String order) {
		BufferedReader fromConsole = new BufferedReader(new InputStreamReader(System.in));
		String commandNumber = null;
		System.out.println(order);
		try {
		         commandNumber = fromConsole.readLine();
		      } catch (IOException ioe) {
		         System.out.println("IO error trying to read the number of the command!");
		         System.exit(1);
		      }
		return commandNumber;
	}
}