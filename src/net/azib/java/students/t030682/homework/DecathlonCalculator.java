package net.azib.java.students.t030682.homework;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

/**
 * DecathlonCalculator Main Application
 * 
 * @author aplotn
 */
public class DecathlonCalculator {

	public static void main(String[] args) throws IOException, TransformerException, SAXException, ParserConfigurationException,
			SQLException {

		DataInputClass tmpInput = new DataInputClass();
		String[] tmpArray = new String[0];
		String inputSource = null, inputArg = null, outputDest = null, outputArg = null;

		// depending on input arguments define input and output methods and
		// locations
		if (args.length != 0) {
			inputSource = args[0];
			if (inputSource.equals("-console")) {
				outputDest = args[1];
				if (!outputDest.equals("-console")) {
					outputArg = args[2];
				}
			}
			else {
				inputArg = args[1];
				outputDest = args[2];
				if (!outputDest.equals("-console")) {
					outputArg = args[3];
				}
			}

			// input data from console,CSV file or mySQL database defined by
			// arguments
			if (inputSource.equals("-console")) {
				tmpArray = tmpInput.consoleReader();
			}
			else if (inputSource.equals("-csv")) {
				tmpArray = tmpInput.csvReader(inputArg);

			}
			else if (inputSource.equals("-db")) {
				tmpArray = tmpInput.mysqlReader(inputArg);

			}
			else {
				System.out
						.println("Wrong input arguments\nUsage:\nDecathlonCalculator -console|-csv filename|-db dbname -console|-csv filename|-xml filename|-html filename");
				System.exit(-1);
			}
		}
		// if wrong input arguments were typed, show error message adn quit the
		// program
		else {
			System.out.println("Error: No arguments!!");
			System.exit(-1);
		}

		// from athletes data form a collection and sort it
		List<DecathlonResultsRecord> competitionRecords = new ArrayList<DecathlonResultsRecord>();
		for (String s : tmpArray) {
			competitionRecords.add(DecathlonResultsRecord.stringToRecord(s));
		}
		System.out.println("Sorting results...");
		Collections.sort(competitionRecords);

		// output data to console, csv file, xml file or html file depending on
		// arguments
		DataOutputClass out = new DataOutputClass();
		if (outputDest.equals("-console")) {
			out.consoleWriter(competitionRecords);
		}

		else if (outputDest.equals("-csv")) {
			out.csvWriter(competitionRecords, outputArg);
		}
		else if (outputDest.equals("-html")) {
			//create DOM object, validate it and in case of valid XML transform to HTML file
			if (out.validateXML(out.buildDocument(competitionRecords))) {
				out.htmlWriter(out.buildDocument(competitionRecords), outputArg);
			}

		}
		else if (outputDest.equals("-xml")) {
			//create DOM object, validate it and in case of valid XML write to XML file
			if (out.validateXML(out.buildDocument(competitionRecords))) {
				out.xmlWriter(out.buildDocument(competitionRecords), outputArg);
			}
		}
		else {
			System.out
					.println("Wrong output arguments\nUsage:\nDecathlonCalculator -console|-csv filename|-db dbname -console|-csv filename|-xml filename|-html filename");
			System.exit(-1);
		}
	}

}
