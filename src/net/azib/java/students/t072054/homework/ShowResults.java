package net.azib.java.students.t072054.homework;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;

/**
 * ShowResults
 * 
 * @author r_vassiljev
 */

// TODO This class will be rewritten later
public class ShowResults {
	/**
	 * @param results
	 * @param numEvent
	 */
	public static void ShowResultsConsole(Map<Integer, String[]> result_map1, 
			Map<Integer, String[]> result_map2,
			Map<Integer, String[]> result_map3,
			ArrayList<Integer> results, double numEvent) {
		// public static void main(String[] args) {
		//LoadNewResults lnr = new LoadNewResults();

		//Map<Integer, String[]> result_map1 = new LinkedHashMap<Integer, String[]>();
		//Map<Integer, String[]> result_map2 = new LinkedHashMap<Integer, String[]>();
		//Map<Integer, String[]> result_map3 = new LinkedHashMap<Integer, String[]>();

		//lnr.loadResults(result_map1, result_map2, result_map3);

		// double numEvent = 2;
		// ArrayList<Integer> results = SortingID.SortByID(result_map1,
		// result_map2, result_map3, numEvent);

		// Print competitions data
		System.out.println("Competitions data:");
		for (int i = 0; i < result_map2.size(); i++) {
			for (int j = 0; j < 5; j++)
				System.out.println(result_map2.get(i)[j]);
			System.out.println();
		}
		System.out.println();

		// Print athletes data
		System.out.println("Results:");
		System.out.println(" ... "); // TODO Here will be the description of
		// columns
		for (int i = 0; i < results.size(); i++) {

			System.out.print((i + 1) + " ");
			System.out.print(CountAthletResult.CountResultByID(result_map3, (double) results.get(i), numEvent));
			for (int j = 0; j < 4; j++) {
				System.out.print(result_map1.get(results.get(i) - 1)[j] + " ");

			}
			System.out.println();

			// Print athlete data from results table
			for (int k = 0; k < result_map3.size(); k++) {
				if (Double.parseDouble(result_map3.get(k)[1]) == (double) results.get(i)) {
					for (int j = 2; j < 13; j++)
						System.out.print(result_map3.get(k)[j] + " ");

					System.out.println();
				}
			}
			System.out.println();
		}
	}

	/**
	 * @param results
	 * @param numEvent
	 * @param fileName
	 */
	public static void ShowResultsCSV(Map<Integer, String[]> result_map1, 
			Map<Integer, String[]> result_map2,
			Map<Integer, String[]> result_map3,
			ArrayList<Integer> results, double numEvent, String fileName) {
		// public static void main(String[] args) {
		LoadNewResults lnr = new LoadNewResults();

		//Map<Integer, String[]> result_map1 = new LinkedHashMap<Integer, String[]>();
		//Map<Integer, String[]> result_map2 = new LinkedHashMap<Integer, String[]>();
		//Map<Integer, String[]> result_map3 = new LinkedHashMap<Integer, String[]>();

		//lnr.loadResults(result_map1, result_map2, result_map3);

		// double numEvent = 2;
		// ArrayList<Integer> results = SortingID.SortByID(result_map1,
		// result_map2, result_map3, numEvent);

		// Output file name
		File f1 = new File(fileName); // new File("C:\\dest.csv");

		/**
		 * Creating new file for writing
		 */
		try {
			FileWriter fw = new FileWriter(f1);

			// Print competitions data
			fw.write("Competitions data:");
			fw.write("\n");
			for (int i = 0; i < result_map2.size(); i++) {
				for (int j = 0; j < 5; j++)
					fw.write(result_map2.get(i)[j] + ",");
				fw.write("\n");
			}
			fw.write("\n");

			// Print athletes data
			fw.write("Results:" + ",");
			fw.write(" ... "); // TODO Here will be the description
			// of columns
			fw.write("\n");
			for (int i = 0; i < results.size(); i++) {

				fw.write((i + 1) + ",");
				fw.write((int) CountAthletResult.CountResultByID(result_map3, (int) results.get(i), numEvent) + ",");
				for (int j = 0; j < 4; j++) {
					fw.write(result_map1.get(results.get(i) - 1)[j] + ",");

				}
				fw.write("\n");

				// Print athlete data from results table
				for (int k = 0; k < result_map3.size(); k++) {
					if (Double.parseDouble(result_map3.get(k)[1]) == (double) results.get(i)) {
						for (int j = 2; j < 13; j++)
							fw.write(result_map3.get(k)[j] + ",");

						fw.write("\n");
					}
				}
				System.out.println();
			}

			// Close the file
			fw.close();
		}
		catch (Exception e) {
			System.out.println("File exception");
		}

	}

	// public static void ShowResultsXML(ArrayList<Integer> results, double
	// numEvent, String fileName) throws Exception {
	/**
	 * @param args
	 * @throws Exception
	 */
	// TODO http://www.topxml.com/xsltStylesheets/Stylesheets/DataFormatting/EmployeeStringFuncs/Employees.xml
	// May be to try as it is done on link 
	public static void main(String[] args) throws Exception {
		LoadNewResults lnr = new LoadNewResults();

		Map<Integer, String[]> result_map1 = new LinkedHashMap<Integer, String[]>();
		Map<Integer, String[]> result_map2 = new LinkedHashMap<Integer, String[]>();
		Map<Integer, String[]> result_map3 = new LinkedHashMap<Integer, String[]>();

		/*lnr.loadResults(result_map1, result_map2, result_map3);*/ //TEMPORARY TODO

		double numEvent = 2;
		ArrayList<Integer> results = SortingID.SortByID(result_map1, result_map2, result_map3, numEvent);

		// TODO DELETE THIS !
		// File f1 = new File("C:\\dest.csv");

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.newDocument();
		String root = "Decathlon";
		Element rootElement = document.createElement(root);
		document.appendChild(rootElement);

		/**
		 * Creating new file for writing
		 */
		try {
			// FileWriter fw = new FileWriter(f1);

			// Print competitions data
			Element comp_data = document.createElement("competitions_data");
			rootElement.appendChild(comp_data);
			// fw.write("Competitions data:");
			// fw.write("\n");
			Element[] el_c = new Element[10000];
			for (int i = 0; i < result_map2.size(); i++) {
				for (int j = 0; j < 5; j++) {
					switch (j) {
					case 0:
						el_c[5 * i + j] = document.createElement("competition");
						el_c[5 * i + j].setAttribute("id", String.valueOf(i + 1));
						break;
					case 1:
						el_c[5 * i + j] = document.createElement("country_code");
						break;
					case 2:
						el_c[5 * i + j] = document.createElement("date");
						break;
					case 3:
						el_c[5 * i + j] = document.createElement("name");
						break;
					case 4:
						el_c[5 * i + j] = document.createElement("location");
						break;
					}
					if (j != 0) {
						el_c[5 * i + j].appendChild(document.createTextNode(result_map2.get(i)[j]));
						el_c[5 * i].appendChild(el_c[5 * i + j]);
					}
				}
				// el_c[5 *
				// i].appendChild(document.createTextNode(result_map2.get(i)[0]));
				comp_data.appendChild(el_c[5 * i]);
				// fw.write(result_map2.get(i)[j] + ",");
				// fw.write("\n");
			}
			// fw.write("\n");

			// Print athletes data
			Element athletes_data = document.createElement("athletes_data");
			rootElement.appendChild(athletes_data);
			// fw.write("Results:" + ",");
			// fw.write(" ... "); // TODO Here will be the description
			// of columns
			// fw.write("\n");
			Element[] el_a = new Element[10000];
			int el_a_counter = 0;
			for (int i = 0; i < results.size(); i++) {

				el_a[6 * i] = document.createElement("athlet");
				el_a[6 * i].setAttribute("place", String.valueOf(i + 1));
				athletes_data.appendChild(el_a[6 * i]);

				// fw.write((i + 1) + ",");
				el_a[6 * i + 1] = document.createElement("score");
				el_a[6 * i + 1].appendChild(document.createTextNode(Double.toString(CountAthletResult.CountResultByID(
						result_map3, (int) results.get(i), numEvent))));
				el_a[6 * i].appendChild(el_a[6 * i + 1]);
				// fw.write((int) CountAthletResult.CountResultByID(result_map3,
				// (int) results.get(i), numEvent) + ",");
				for (int j = 0; j < 4; j++) {
					switch (j) {
					case 0:
						el_a[6 * i + j + 2] = document.createElement("id");
						break;
					case 1:
						el_a[6 * i + j + 2] = document.createElement("name");
						break;
					case 2:
						el_a[6 * i + j + 2] = document.createElement("dob");
						break;
					case 3:
						el_a[6 * i + j + 2] = document.createElement("country_code");
						break;
					}

					el_a[6 * i + j + 2].appendChild(document.createTextNode(result_map1.get(results.get(i) - 1)[j]));
					el_a[6 * i].appendChild(el_a[6 * i + j + 2]);
					// fw.write(result_map1.get(results.get(i) - 1)[j] +
					// ",");

				}
				// fw.write("\n");

				// Print athlete data from results table
				Element results_data = document.createElement("results_data");
				el_a[6 * i].appendChild(results_data);

				Element[] el_r = new Element[10000];
				for (int k = 0; k < result_map3.size(); k++) {
					if (Double.parseDouble(result_map3.get(k)[1]) == (double) results.get(i)) {
						for (int j = 2; j < 13; j++) {
							switch (j) {
							case 2:
								el_r[13 * k + j - 2] = document.createElement("competition_id");
								break;
							case 3:
								el_r[13 * k + j - 2] = document.createElement("race_100m");
								break;
							case 4:
								el_r[13 * k + j - 2] = document.createElement("long_jump");
								break;
							case 5:
								el_r[13 * k + j - 2] = document.createElement("shot_put");
								break;
							case 6:
								el_r[13 * k + j - 2] = document.createElement("high_jump");
								break;
							case 7:
								el_r[13 * k + j - 2] = document.createElement("race_400m");
								break;
							case 8:
								el_r[13 * k + j - 2] = document.createElement("hurdles_110m");
								break;
							case 9:
								el_r[13 * k + j - 2] = document.createElement("discus_throw");
								break;
							case 10:
								el_r[13 * k + j - 2] = document.createElement("pole_vault");
								break;
							case 11:
								el_r[13 * k + j - 2] = document.createElement("javelin_throw");
								break;
							case 12:
								el_r[13 * k + j - 2] = document.createElement("race_1500m");
								break;
							}
							el_r[13 * k + j - 2].appendChild(document.createTextNode(result_map3.get(k)[j]));
							results_data.appendChild(el_r[13 * k + j - 2]);
						}
						// fw.write(result_map3.get(k)[j] + ",");

						// fw.write("\n");
					}
				}
				System.out.println();

				el_a_counter++;
			}

			// Close the file
			// fw.close();
		}
		catch (Exception e) {
			System.out.println("Exception");
		}

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult("c:\\results.xml"); // System.out
		transformer.transform(source, result);

	}

/*	public void transformUsingStylesheet()

	{

		try {

			File sourceFile = new File("c:\\results.xml");

			File resultFile = new File("c:\\results.htm");

			StreamResult result = new StreamResult(resultFile);

			StreamSource source = new StreamSource(sourceFile);

			Templates template = tFactory.newTemplates(new StreamSource(stylesheetURI));

			transformer = template.newTransformer();

			transformer.setParameter("heading", "This is A Parameter Heading");

			transformer.transform(source, result);

		}
		catch (TransformerConfigurationException tce)

		{

			tce.printStackTrace();

		}
		catch (TransformerException te)

		{

			te.printStackTrace();

		}

	}*/
}
