package net.azib.java.students.t050209.homework;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * HandleDecathlonIO
 *
 * @author Kaupo Laan
 */
public class HandleDecathlonIO {
	
	/**
	 * Gets user inserted string and converts it to double 
	 */
	public static double getUserInsertedValue() throws Exception, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		double value = Double.parseDouble(in.readLine());
		return value;
	}
	
	/**
	 * Gets user inserted string 
	 */
	public static String getUserInsertedString() throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));		
		String value = (String)in.readLine();
		return value;		
	}
	
	/**
	 * Gets user inserted string and checks if the file exists.
	 * If file doesn't exist, creates it.
	 */
	public static String insertFilePath() throws IOException{
		Boolean validData      = false;
		String pathTempString;
		
		do{	
			System.out.print("Insert the location of the file: ");
			pathTempString = getUserInsertedString();

			Reader reader = null;
			try {
				reader = new InputStreamReader(new BufferedInputStream(new FileInputStream(pathTempString)), "UTF-8");
				reader.close();	        
		        validData = true;
			}
			catch (IOException e) {
			    createFile(pathTempString);
			    System.out.println("File created successfully.");
				validData = true;
			}
			catch (NullPointerException e){
				System.out.println("NullPointerException in insertFilePath");
				validData = false;
			}
		}while(validData == false);
		
		return pathTempString;
	}
	
	/**
	 * Creates file 
	 */
	public static void createFile(String filePath) throws IOException{	
		Reader reader = null;
		try {
			reader = new InputStreamReader(new BufferedInputStream(new FileInputStream(filePath)), "UTF-8");
			reader.close();	        
	        System.out.println("File " + filePath + " already exists!");
		}
		catch (IOException e) {
			FileWriter fstream = new FileWriter(filePath);
		    BufferedWriter out = new BufferedWriter(fstream);
		    out.write("");
		    out.close();
		    System.out.println("File " + filePath + " created successfully.");
		}
		catch (NullPointerException e){
			System.out.println("NullPointerException in insertFilePath");
		}
	}
	
	/**
	 * Lets the user choose data input method 
	 */
	public static byte selectDataInputType() throws Exception{
		byte result = 0;
		boolean value = false;
		System.out.println("What do you want to do?");
		System.out.println("- 1 Insert values manually through console");
		System.out.println("- 2 Insert values from CSV file");
		System.out.println("- 3 Get values from Database");
		
		while(value == false){
			try{
				result = (byte)getUserInsertedValue();
				value = true;
			}
			catch(Error e) {
				System.out.println("Insert number 1, 2 or 3!");
				value = false;
			}
		}
		return result;
	}
	
	/**
	 * Lets the user choose data output method 
	 */
	public static byte selectDataOutputType() throws Exception{
		byte result = 0;
		boolean value = false;
		System.out.println("Where do you want to see results?");
		System.out.println("- 1 Console");
		System.out.println("- 2 CSV file");
		System.out.println("- 3 XML file");
		System.out.println("- 4 HTML file");
		
		while(value == false){
			try{
				result = (byte)getUserInsertedValue();
				value = true;
			}
			catch(Error e) {
				value = false;
				System.out.println("Insert number 1, 2, 3 or 4!");
			}
		}
		return result;
	}
}
