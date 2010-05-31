package net.azib.java.students.t073862.homework.util;

import net.azib.java.students.t073862.homework.Main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Utilities class, random calculations etc
 *
 * @author Pets
 */
public class Util {
	
	private static final Log logger = LogFactory.getLog(Util.class); 
	
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
			logger.error("DB properties file not found", e);
			return null;
		}
		catch (IOException e) {
			logger.error("DB properties file io exception", e);
			return null;
		}
		return db;
	}
	/**
	 * Will return a double from the user, forcefully.
	 * @param text text to present to the user
	 * @return
	 */
	public static Double getDouble(String text) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(text);
		Double returnval = 0D;
		try {
			returnval = scanner.nextDouble();
		}
		catch(InputMismatchException e) {
			returnval = getDouble(text);
		}
		return returnval;
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
			logger.fatal("Output file writing failed.", e);
		}
		finally {
			try {
				outputWriter.close();
			}
			catch (IOException e) {
				logger.fatal("Output file writing failed.", e);
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
				logger.fatal("Output file creation failed.", e);
			}
		}
		return f;
	}

}
