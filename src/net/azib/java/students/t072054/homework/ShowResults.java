package net.azib.java.students.t072054.homework;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Map;

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

public class ShowResults implements ResultShower {
	/**
	 * Prints results to console
	 * 
	 * @param resultMap1
	 * @param resultMap2
	 * @param resultMap3
	 * @param results
	 * @param numEvent
	 */
	public String showResultsConsole(Map<Integer, String[]> resultMap1, Map<Integer, String[]> resultMap2,
			Map<Integer, String[]> resultMap3, ArrayList<Integer> results, double numEvent) {

		String returnString = "Test string: ";

		WriteCorrectPlace wcp = new WriteCorrectPlace(11);

		for (int i = 0; i < results.size(); i++) {
			wcp.addScore(i, CountAthletResult.countResultByID(resultMap3, i + 1, numEvent));
		}

		// Print competitions data
		System.out.println("Competitions data:");
		for (int i = 0; i < resultMap2.size(); i++) {
			for (int j = 0; j < 5; j++) {
				System.out.println(resultMap2.get(i)[j]);

				returnString = returnString + resultMap2.get(i)[j];
			}
			System.out.println();
		}
		System.out.println();

		// Print athletes data
		System.out.println("Results:");
		System.out.println("(place score name birthdate country)");
		System.out.println("(competition_index results[])");
		// columns
		for (int i = 0; i < results.size(); i++) {
			// Printing place
			System.out.print(wcp.returnPlace(CountAthletResult.countResultByID(resultMap3, (double) results.get(i), numEvent)));
			returnString = returnString
					+ wcp.returnPlace(CountAthletResult.countResultByID(resultMap3, (double) results.get(i), numEvent));
			System.out.print(" ");

			System.out.print(CountAthletResult.countResultByID(resultMap3, (double) results.get(i), numEvent));
			for (int j = 0; j < 4; j++) {
				System.out.print(resultMap1.get(results.get(i) - 1)[j] + " ");
				returnString = returnString + resultMap1.get(results.get(i) - 1)[j];
			}
			System.out.println();

			// Print athlete data from results table
			for (int k = 0; k < resultMap3.size(); k++) {
				if (Double.parseDouble(resultMap3.get(k)[1]) == (double) results.get(i)) {
					for (int j = 2; j < 13; j++) {
						System.out.print(resultMap3.get(k)[j] + " ");
						returnString = returnString + resultMap3.get(k)[j];
					}

					System.out.println();
				}
			}
			System.out.println();
		}

		return returnString;
	}

	/**
	 * Prints results to CSV file
	 * 
	 * @param resultMap1
	 * @param resultMap2
	 * @param resultMap3
	 * @param results
	 * @param numEvent
	 * @param fileName
	 */
	public String showResultsCSV(Map<Integer, String[]> resultMap1, Map<Integer, String[]> resultMap2,
			Map<Integer, String[]> resultMap3, ArrayList<Integer> results, double numEvent, String fileName) {

		String returnString = "Test string: ";

		WriteCorrectPlace wcp = new WriteCorrectPlace(11);

		for (int i = 0; i < results.size(); i++) {
			wcp.addScore(i, CountAthletResult.countResultByID(resultMap3, i + 1, numEvent));
		}

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
			for (int i = 0; i < resultMap2.size(); i++) {
				for (int j = 0; j < 5; j++) {
					fw.write(resultMap2.get(i)[j] + ",");
					returnString = returnString + resultMap2.get(i)[j];
				}
				fw.write("\n");
			}
			fw.write("\n");

			// Print athletes data
			fw.write("Results:" + ",");
			// of columns
			fw.write("\n");
			for (int i = 0; i < results.size(); i++) {

				fw.write(wcp.returnPlace(CountAthletResult.countResultByID(resultMap3, (double) results.get(i), numEvent))
								+ ",");
				returnString = returnString
						+ wcp.returnPlace(CountAthletResult.countResultByID(resultMap3, (double) results.get(i), numEvent));
				fw.write((int) CountAthletResult.countResultByID(resultMap3, (int) results.get(i), numEvent) + ",");
				for (int j = 0; j < 4; j++) {
					fw.write(resultMap1.get(results.get(i) - 1)[j] + ",");
					returnString = returnString + resultMap1.get(results.get(i) - 1)[j];
				}
				fw.write("\n");

				// Print athlete data from results table
				for (int k = 0; k < resultMap3.size(); k++) {
					if (Double.parseDouble(resultMap3.get(k)[1]) == (double) results.get(i)) {
						for (int j = 2; j < 13; j++) {
							fw.write(resultMap3.get(k)[j] + ",");
							returnString = returnString + resultMap3.get(k)[j];
						}
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

		return returnString;
	}

	/**
	 * Prints results to XML file
	 * 
	 * @param resultMap1
	 * @param resultMap2
	 * @param resultMap3
	 * @param results
	 * @param numEvent
	 * @param fileName
	 * @throws Exception
	 */
	public void showResultsXML(Map<Integer, String[]> resultMap1, Map<Integer, String[]> resultMap2,
			Map<Integer, String[]> resultMap3, ArrayList<Integer> results, double numEvent, String fileName) throws Exception {
		WriteCorrectPlace wcp = new WriteCorrectPlace(11);

		for (int i = 0; i < results.size(); i++) {
			wcp.addScore(i, CountAthletResult.countResultByID(resultMap3, i + 1, numEvent));
		}

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

			// Print competitions data
			Element compData = document.createElement("competitions_data");
			rootElement.appendChild(compData);
			Element[] elC = new Element[10000];
			for (int i = 0; i < resultMap2.size(); i++) {
				for (int j = 0; j < 5; j++) {
					switch (j) {
					case 0:
						elC[5 * i + j] = document.createElement("competition");
						elC[5 * i + j].setAttribute("id", String.valueOf(i + 1));
						break;
					case 1:
						elC[5 * i + j] = document.createElement("country_code");
						break;
					case 2:
						elC[5 * i + j] = document.createElement("date");
						break;
					case 3:
						elC[5 * i + j] = document.createElement("name");
						break;
					case 4:
						elC[5 * i + j] = document.createElement("location");
						break;
					}
					if (j != 0) {
						elC[5 * i + j].appendChild(document.createTextNode(resultMap2.get(i)[j]));
						elC[5 * i].appendChild(elC[5 * i + j]);
					}
				}
				compData.appendChild(elC[5 * i]);
			}

			// Print athletes data
			Element athletesData = document.createElement("athletesData");
			rootElement.appendChild(athletesData);

			Element[] elA = new Element[10000];
			int elACounter = 0;
			for (int i = 0; i < results.size(); i++) {

				elA[6 * i] = document.createElement("athlet");
				elA[6 * i].setAttribute("place", String.valueOf(wcp.returnPlace(CountAthletResult.countResultByID(resultMap3,
						(double) results.get(i), numEvent))));
				athletesData.appendChild(elA[6 * i]);

				elA[6 * i + 1] = document.createElement("score");
				elA[6 * i + 1].appendChild(document.createTextNode(Double.toString(CountAthletResult.countResultByID(
						resultMap3, (int) results.get(i), numEvent))));
				elA[6 * i].appendChild(elA[6 * i + 1]);
				for (int j = 0; j < 4; j++) {
					switch (j) {
					case 0:
						elA[6 * i + j + 2] = document.createElement("id");
						break;
					case 1:
						elA[6 * i + j + 2] = document.createElement("name");
						break;
					case 2:
						elA[6 * i + j + 2] = document.createElement("dob");
						break;
					case 3:
						elA[6 * i + j + 2] = document.createElement("country_code");
						break;
					}

					elA[6 * i + j + 2].appendChild(document.createTextNode(resultMap1.get(results.get(i) - 1)[j]));
					elA[6 * i].appendChild(elA[6 * i + j + 2]);

				}
				Element resultsData = document.createElement("resultsData");
				elA[6 * i].appendChild(resultsData);

				Element[] elR = new Element[10000];
				for (int k = 0; k < resultMap3.size(); k++) {
					if (Double.parseDouble(resultMap3.get(k)[1]) == (double) results.get(i)) {
						for (int j = 2; j < 13; j++) {
							switch (j) {
							case 2:
								elR[13 * k + j - 2] = document.createElement("competition");
								elR[13 * k + j - 2].setAttribute("id", resultMap3.get(k)[j]);
								break;
							case 3:
								elR[13 * k + j - 2] = document.createElement("race_100m");
								break;
							case 4:
								elR[13 * k + j - 2] = document.createElement("long_jump");
								break;
							case 5:
								elR[13 * k + j - 2] = document.createElement("shot_put");
								break;
							case 6:
								elR[13 * k + j - 2] = document.createElement("high_jump");
								break;
							case 7:
								elR[13 * k + j - 2] = document.createElement("race_400m");
								break;
							case 8:
								elR[13 * k + j - 2] = document.createElement("hurdles_110m");
								break;
							case 9:
								elR[13 * k + j - 2] = document.createElement("discus_throw");
								break;
							case 10:
								elR[13 * k + j - 2] = document.createElement("pole_vault");
								break;
							case 11:
								elR[13 * k + j - 2] = document.createElement("javelin_throw");
								break;
							case 12:
								elR[13 * k + j - 2] = document.createElement("race_1500m");
								break;
							}
							if (j != 2)
								elR[13 * k + j - 2].appendChild(document.createTextNode(resultMap3.get(k)[j]));
							if (j == 2) {
								resultsData.appendChild(elR[13 * k + j - 2]);
							}
							else {
								elR[13 * k].appendChild(elR[13 * k + j - 2]);
							}
						}
					}
				}
				System.out.println();

				elACounter++;
			}

		}
		catch (Exception e) {
			System.out.println("XML Exception");
		}

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(fileName);
		transformer.transform(source, result);

	}
}
