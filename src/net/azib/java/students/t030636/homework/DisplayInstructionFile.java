package net.azib.java.students.t030636.homework;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * DisplayInstructionFile
 *
 * @author Martin
 */
public class DisplayInstructionFile {
	
	public void display(String filename) {
			Reader reader = null;
		try {
			reader = new InputStreamReader(new BufferedInputStream(this.getClass().getResourceAsStream(filename)), "UTF-8");
			int c;
			while ((c = reader.read()) != -1) 
				System.out.print((char)c);
			System.out.println();
		}
		catch (IOException e) {
			System.out.println("Unable to read data");
		}
		finally {
			try {
				reader.close();
			}
			catch (IOException e) {
				// this should not happen
			}
		}
	}

}
