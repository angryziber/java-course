package net.azib.java.students.t103784.homework;

import net.azib.java.lessons.db.PersonException;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

public class Main {
	static String inputMethod = null, inputParameter = null, outputMethod = null, outputParameter = null;

	public static void main(String[] args) throws IOException {

		for (String s: args) {
			if (s.contains("-")) {
				if (inputMethod == null) {
					inputMethod = s;
				}
				else {
					outputMethod = s;
				}
			}
			else {
				if (inputParameter == null && outputParameter != null) {
					inputParameter = s;
				}
				else {
					outputParameter = s;
				}
			}
		}

		List<Athlete> contestants = null;
		BufferedReader reader;
		Input input = new Input();
		Output output = new Output();
		
		if (inputMethod != null && inputMethod.equals("-console")) {
			try {
				contestants = input.readAthleteFromConsole();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} 
		else if (inputMethod != null && inputMethod.equals("-csv")){
				try {
					File file;
					if (inputParameter != null) {
						file = new File(inputParameter);
					}
					else {
						file = new File("src\\net\\azib\\java\\students\\t103784\\homework\\tmp\\sample.csv");
					}
					reader = new BufferedReader(new FileReader(file));
					contestants = input.readAthleteFromCSV(reader);
				}
				catch (Exception e) {
					System.out.println("You have specified CSV input, but no CSV file found");
					return;
				}
		}
		else if (inputMethod != null && inputMethod.equals("-db")){
			try {
				contestants = input.readAthleteFromDB();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (PersonException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("No input selected");
			return;
		}

		if (outputMethod != null && outputMethod.equals("-console")){
			output.outputToConsole(contestants);
		}
		else if (outputMethod != null && outputMethod.equals("-csv")){
			output.outputToCSV(contestants);
		}
		else if (outputMethod != null && outputMethod.equals("-xml")){
			try {
				output.outputToXML(contestants);
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (TransformerException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			}
		}
		else if	(outputMethod != null && outputMethod.equals("-html")){
			try {
				output.outputToHTML(contestants);
			} catch (TransformerConfigurationException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (TransformerException e) {
				e.printStackTrace();
			}
		}
		else {System.out.println("No output selected");
		}

	}
}
