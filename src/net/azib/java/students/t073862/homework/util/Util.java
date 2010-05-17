package net.azib.java.students.t073862.homework.util;

import net.azib.java.students.t073862.homework.Main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

/**
 * Utilities class, random calculations etc
 *
 * @author Pets
 */
public class Util {
	/**
	 * Loads database properties from the .properties file
	 * @return null on failure, otherwise properties
	 */
	public static Properties loadDBProperties() {
		Properties db = new Properties();
		URL url = Main.class.getResource("db.properties");
		File f = new File(url.getFile().replace("%20", " "));
		try {
			FileInputStream stream = new FileInputStream(f.getAbsoluteFile());
			db.load(stream);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return db;
	}
	/**
	 * 
	 * @param scanner
	 * @param regex
	 * @return
	 */
	public static float getFloat(String text) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(text);
		float returnval = 0L;
		try {
			returnval = scanner.nextFloat();
		}
		catch(InputMismatchException e) {
			returnval = getFloat(text);
		}
		return returnval;
	}
	
	private static int calcTrack(float A, float B, float C, float P) {
		return (int)(A*Math.pow((B-P),C));
	}
	private static int calcField(float A, float B, float C, float P) {
		return (int)(A*Math.pow((P-B),C));
	}	
	private static Float[] A = { 25.4347F, 0.14354F, 51.39F, 0.8465F, 1.53775F, 5.74352F, 12.91F, 0.2797F, 10.14F, 0.03768F };
	private static Float[] B = { 18F, 220F, 1.5F, 75F, 82F, 28.5F, 4F, 100F, 7F, 480F  };
	private static Float[] C = { 1.81F, 1.4F, 1.05F, 1.42F, 1.81F, 1.92F, 1.1F, 1.35F, 1.08F, 1.85F };
	
	private static boolean[] trackEvent = { true, true, false, true, true, false, false, true, false, true };
	
	
	/**
	 * Calculates the score for the given athlete
	 * @return
	 */
	public static int calculateScores(Float[] scores) {
		int points = 0;
		
		for(int i = 0; i < trackEvent.length; i++) {
			if(trackEvent[i]) {
				points += calcTrack(A[i], B[i], C[i], scores[i]);
			}
			else {
				points += calcField(A[i], B[i], C[i], scores[i]);
			}
		}
		return points;
	}
	
	public static void writeToFile(File f, String data) {
		Writer outputWriter = null;
		try {
			outputWriter = new BufferedWriter(new FileWriter(f));
		    outputWriter.write(data);
		    outputWriter.close();
		}
		catch (IOException e) {
			System.out.println("Output file writing failed.");
			e.printStackTrace();
			System.exit(1);
		}
		finally {
			try {
				outputWriter.close();
			}
			catch (IOException e) {
				System.out.println("Output file writing failed.");
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
	
	public static File getOutputFile(String filePath) {
		File f = new File(filePath); 
		if(!f.isAbsolute()) {
			f = new File(Main.class.getResource(filePath).getFile().replace("%20", " "));
		}
		if(!f.isFile()) {
			try {
				f.createNewFile();
			}
			catch (IOException e) {
				System.out.println("Output file creation failed.");
				e.printStackTrace();
				System.exit(1);
			}
		}
		return f;
	}
}
