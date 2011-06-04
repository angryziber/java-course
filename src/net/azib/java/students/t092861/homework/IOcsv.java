package net.azib.java.students.t092861.homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author Stanislav / 092861
 * 
 */
public class IOcsv extends AbstractIO {
	
	/**
	 * File name or the path to the file.
	 */
	public String param = "";

	/**
	 * Default constructor.
	 * 
	 * @param param
	 *            - parameters of the input/output
	 * @param ctrl
	 *            - controller
	 */
	public IOcsv(String param, Controller ctrl) {
		super(ctrl);
		this.param = param;
	}

	@Override
	ArrayList<Athlete> input() {
		ArrayList<Athlete> athletes = new ArrayList<Athlete>();
		FileInputStream streamIn = null;
		InputStreamReader readerIn;
		BufferedReader bufReader = null;
		int lineNumber = 0;
		try {
			streamIn = new FileInputStream(Const.USER_DIR + getParameters());
			// trying to read as utf-8
			readerIn = new InputStreamReader(streamIn, "UTF8");
			bufReader = new BufferedReader(readerIn);

			// current line
			String curLine = null;
			// Read input file line by line
			while ((curLine = bufReader.readLine()) != null) {
				// converting string array to array list
				inputData = new ArrayList<String>(Arrays.asList(curLine.split(",")));
				athletes.add(ctrl.readData(inputData));
				lineNumber++;
			}
			out.println("\nSuccessful input from " + "\"" + getParameters()+ "\"" + " file!\n");
			
		} catch (FileNotFoundException en) {
			out.println("\nError " + en.getMessage()
					+ ". \nPlease check the file " + getParameters()
					+ " location!");
		} catch (UnsupportedEncodingException e) {
			out.println("\nError! Couldn't read file as UTF8");
			// therefore reading it as non-UTF-8 encoding
			readerIn = new InputStreamReader(streamIn);
			
		} catch (ArrayIndexOutOfBoundsException e) {
			out.println("\nError! File " + getParameters()+ " structure in line " + lineNumber + " is incorrect\n");

		} catch (IOException e) {
			out.println("\nError! I/O error occured");
			e.printStackTrace();

		} finally {
			if (bufReader != null) {
				try {
					bufReader.close();
				} catch (IOException e) {
					out.println("\nError! Cannot close the file!");
					e.printStackTrace();
				}
			}
		}
		return athletes;
	}

	@Override
	File output(ArrayList<Athlete> athletes) {
		if(athletes.size() == 0){
			return null;
		}
		Writer writer = null;
		ArrayList<Athlete> results = ctrl.arrangeInOrder(athletes);
		Iterator<Athlete> itr = results.iterator();		
		File file = getOutputFile(getParameters());
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF8"));
			while (itr.hasNext()) {
				Athlete item = itr.next();
				writer.write(item.getPlace() + ","
						+ item.getScore()  + ","
						+ ctrl.indertQuotes(item.getName()) + ","
						+ this.convertDateDMY(item.getBirthday()) + ","
						+ item.getCountry() + ","
						+ item.getSprint100() + ","
						+ item.getLongJump() + ","
						+ item.getShortPut() + ","
						+ item.getHighJump() + ","
						+ this.convertTimeToString(item.getSprint400()) + ","
						+ item.getHurdles() + ","
						+ item.getDiscusThrow() + ","
						+ item.getPoleVault() + ","
						+ item.getJavelinThrow() + ","
						+ this.convertTimeToString(item.getSprint1500()) + ",");
						((BufferedWriter) writer).newLine();
			}
			
			// forces any buffered output bytes to be written out
			writer.flush(); 
			out.println("Successful CSV output to " + getParameters() + " file!");
			
		} catch (FileNotFoundException en) {
			try {
				out.println("\nERROR! The file " + file.getCanonicalPath() + " was not found " + en.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			out.println("\nERROR! I/O eror of some sort has occurred! "  + e.toString());
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				out.println("\nERROR! Cannot close the file! "  + e.toString());
			}
		}
		return file;
	}

	@Override
	public String getParameters() {
		return param;
	}
}
