package net.azib.java.students.t020544;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * CopyProgram
 * 
 * @author Julija
 */
public class CopyProgram {

	protected String file;
	protected String copyfile;
	String encod;

	public CopyProgram(String file, String copyfile) {
		this.file = file;
		this.copyfile = copyfile;

	}

	public void copying() {

		long startTime = System.currentTimeMillis();

		FileReader reader = null;
		FileWriter writer = null;

		try {

			reader = new FileReader(file);
			writer = new FileWriter(copyfile);

			int c;
			while ((c = reader.read()) != -1)
				writer.write((char) c);

		}
		catch (IOException e) {
			System.out.println("Unable to read data");
		}
		finally {
			try {
				reader.close();
				writer.close();
			}
			catch (IOException e) {
				// this should not happen
			}

		}
		System.out.println("Time: " + (System.currentTimeMillis() - startTime));

	}

	public void bufferedCopying() {

		long startTime = System.currentTimeMillis();

		BufferedReader reader = null;
		// PrintWriter writer = null;
		BufferedWriter writer = null;
		try {

			reader = new BufferedReader(new FileReader(file));
//			writer = new PrintWriter(new FileWriter(copyfile));
			writer = new BufferedWriter(new FileWriter(copyfile));

//			 int c;
//			 while ((c = reader.read()) != -1)
//			 writer.write((char) c);

			String line;

			while ((line = reader.readLine()) != null) {
				writer.write(line);

			}

		}
		catch (IOException e) {
			System.out.println("Unable to read data");
		}
		finally {
			try {
				reader.close();
				writer.close();
			}
			catch (IOException e) {
				// this should not happen
			}

		}
		System.out.println("Time: " + (System.currentTimeMillis() - startTime));

	}
}