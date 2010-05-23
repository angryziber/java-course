package net.azib.java.students.t073862.homework.util;

import net.azib.java.students.t073862.homework.Main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

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
	 * Will return a float from the user, forcefully.
	 * @param text text to present to the user
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
	/**
	 * Points = INT(A*(B-P)^C) for track events
	 * @return
	 */
	private static int calcTrack(float A, float B, float C, float P) {
		return (int)(A*Math.pow((B-P),C));
	}
	/**
	 * @return  INT(A*(P-B)^C) for field events
	 */
	private static int calcField(float A, float B, float C, float P) {
		return (int)(A*Math.pow((P-B),C));
	}	
	private static Float[] A = { 25.4347F,
		0.14354F, 
		51.39F, 
		0.8465F, 
		1.53775F, 
		5.74352F, 
		12.91F, 
		0.2797F, 
		10.14F, 
		0.03768F 
		};
	private static Float[] B = { 18F, 220F, 1.5F, 75F, 82F, 28.5F, 4F, 100F, 7F, 480F  };
	private static Float[] C = { 1.81F, 1.4F, 1.05F, 1.42F, 1.81F, 1.92F, 1.1F, 1.35F, 1.08F, 1.85F };
	private static boolean[] trackEvent = { 
		true, //race_100m
		false, //long_jump
		false, //shot_put
		false, //high_jump 
		true, //race_400m
		true, //hurdles_110m
		false, //discus_throw
		false, //pole_vault
		false, //javelin_throw
		true //race_1500m
	};
	
	/**
	 * Calculates the score for the given athlete
	 * @return
	 */
	public static int calculateScores(Float[] scores) {
		int points = 0;
		
		for(int i = 0; i < trackEvent.length; i++) {
			if(trackEvent[i]) {
				
				int newPoints = calcTrack(A[i], B[i], C[i], scores[i]);
				//System.out.println("races: " + races[i] + " scored: "+ newPoints + " ("+A[i] +"|"+B[i]+"|"+C[i] +")");
				points += newPoints;
			}
			else {
				int newPoints = -1;
				
				if(i == 1 || i == 3 || i == 7) {
					newPoints = calcField(A[i], B[i], C[i], (scores[i]*100));
				}
				else {
					newPoints = calcField(A[i], B[i], C[i], scores[i]);
				}
				//System.out.println("races: " + races[i] + " scored: "+ newPoints + " ("+A[i] +"|"+B[i]+"|"+C[i]+"|"+scores[i] +")");
				points += newPoints;
			}
		}
		return points;
	}
	/**
	 * Writes data to a file.
	 * @param f
	 * @param data
	 */
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
	/**
	 * Output file getter based on the file path. If filePath is a valid absolute path, then it is used. Otherwise Main.class.getResource is used
	 * @param filePath
	 * @return
	 */
	public static File getOutputFile(String filePath) {
		File f = new File(filePath); 
		if(!f.isAbsolute()) {
			URL uri = Main.class.getResource(filePath);
			if(uri != null) 
				f = new File(uri.getFile().replace("%20", " "));
			
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
	/**
	 * Loads a DOM Document from a XML file
	 * @param string
	 * @return
	 */
	public static Document loadDocument(String string) throws Exception {
		InputStream stream = Main.class.getResourceAsStream(string);
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		return builder.parse(stream);
		
	}
}
