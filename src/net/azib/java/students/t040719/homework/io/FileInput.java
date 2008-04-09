package net.azib.java.students.t040719.homework.io;

import net.azib.java.students.t040719.homework.Athlete;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * FileInput - a class for obtaining decathlon results from a CVS file
 *
 * @version 0.0
 * @author Romi Agar
 */
public class FileInput implements DataInput {

	public static final String INSTRUCTIONS_TEXT = "Please enter path to the CSV file:";
	public static final String ERROR_NO_FILE_TEXT = " cannot be found.";
	public static final String INVALID_DATA_TEXT = " contains data in invalid format.";
	public static final String INVALID_FILENAME_TEXT = " is not valid file name.";
	private final Scanner input;
	private final PrintStream out;
	private File dataSource;

	/**
	 * @param input
	 * @param printStream
	 */
	public FileInput(){
		this(new Scanner(System.in), System.out);
	}
	
	FileInput(Scanner input, PrintStream out) {
		this.input = input;
		this.out = out;
	}
	
	boolean initiateFile(){
		out.println(INSTRUCTIONS_TEXT);
		String fileName = "";
		if (input.hasNext())
			 fileName = input.next();
		/*while(!input.hasNext("[!\\.a-zA-Z_0-9:\\\\]+")){
			out.println("'" + input.next() + "'" + INVALID_FILENAME_TEXT) ;
			out.println(INSTRUCTIONS_TEXT);
		}*/

		dataSource = new File(fileName);
		if (!dataSource.exists()){
			out.println("'" + dataSource + "'" + ERROR_NO_FILE_TEXT);
			return false;
		}
		return true;
	}
	
	public List<Athlete> getResults() throws IOException {
		if (!initiateFile())
			return null;
		String line = "";
		String name = "";
		String countryCode = "";
		Date birthday = null;
		String[] elements = null;
		float[] results = null;
		BufferedReader br = null;
		//PrintStream ps = null;
		//BufferedWriter ou = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("D:\\out.txt")),"UTF8"));
		//ps = new PrintStream(System.out, true, "UTF-8");
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(dataSource), "UTF-8"));
			while ((line = br.readLine()) != null) {
				elements = line.split(",");
				if (elements.length == 13){
					name = InputParser.parseName(elements[0]);
					birthday = InputParser.parseDateString(elements[1]);
					countryCode = InputParser.parseCountryCode(elements[2]);
					results = InputParser.parseEventResults(Arrays.copyOfRange(elements, 3, 13));
				}
			}
			System.out.println("done");
		}
		finally{
			br.close();
		}
			//throw new IOException();
		return null;
	}
	
	public static void main(String[] args) throws IOException {
		FileInput fi = new FileInput();
		fi.getResults();
	}

}
