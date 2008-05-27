package net.azib.java.students.t011861.homework;

import java.io.File;
import java.util.List;

/**
 * DecathlonCalculator
 * Main Class
 * @author 011861
 */

public class DecathlonCalculator {
	//Create point calculator
	static CalculatePoints calculatedResults = new CalculatePoints();
	//Create object which is responsible for making final data
	static ProcessedData finalData = new ProcessedData();
	/**
	 * Main function needs parameters and input parameters must me before output parameters!
	 * Input methods:
	 * –console <no parameters>
	 * –csv <csv filename (location: Eclipse projects root directory of the workspace)>
	 * –db <id of competition (depends on database)>
	 * Output methods:
	 * –console <no parameters>
	 * –csv <csv filename (generated automatically to Eclipse projects root directory of the workspace)>
	 * –xml <xml filename (generated automatically to Eclipse projects root directory of the workspace)>
	 * –html <html filename (generated automatically to Eclipse projects root directory of the workspace)>
	 * @param args
	 */
	public static void main(String[] args) {	
		try {
			if (args[0].equals("-console"))
			{
				DataFromConsole consoleInput = new DataFromConsole();
				List<String[]> consoleData = consoleInput.getData();
				List<Double[]> calculatedPoints = calculatedResults.processResults(consoleData);
				List<String[]> finalResultsList = finalData.getFinalData(consoleData, calculatedPoints);
				if (args[1].equals("-console"))
				{
					OutDataToScreen printscreen = new OutDataToScreen();
					printscreen.printToConsole(finalResultsList);
				}
				else if (args[1].equals("-csv"))
				{
					File csvData = new File(args[2]);
					OutDataToCsv printCsv = new OutDataToCsv();
					printCsv.showInCsvFile(csvData, finalResultsList);
				}
				else if (args[1].equals("-xml"))
				{
					File xmlData = new File(args[2]);
					OutDataToXml printXml = new OutDataToXml();
					printXml.showInXmlFile(xmlData, finalResultsList);
				}
				else if (args[1].equals("-html"))
				{
					File htmlData = new File(args[2]);
					OutDataToHtml printHtml = new OutDataToHtml();
					printHtml.showInHtmlFile(htmlData, finalResultsList);
				}
			}
			else if (args[0].equals("-csv"))
			{
				File csvData = new File(args[1]);
				DataFromCsv csvInput = new DataFromCsv(csvData);
				List<String[]> consoleData = csvInput.getData();
				List<Double[]> calculatedPoints = calculatedResults.processResults(consoleData);
				List<String[]> finalResultsList = finalData.getFinalData(consoleData, calculatedPoints);
				if (args[2].equals("-console"))
				{
					OutDataToScreen printscreen = new OutDataToScreen();
					printscreen.printToConsole(finalResultsList);
				}
				else if (args[2].equals("-csv"))
				{
					File csvResult = new File(args[3]);
					OutDataToCsv printCsv = new OutDataToCsv();
					printCsv.showInCsvFile(csvResult, finalResultsList);
				}
				else if (args[2].equals("-xml"))
				{
					File xmlData = new File(args[3]);
					OutDataToXml printXml = new OutDataToXml();
					printXml.showInXmlFile(xmlData, finalResultsList);
				}
				else if (args[2].equals("-html"))
				{
					File htmlData = new File(args[3]);
					OutDataToHtml printHtml = new OutDataToHtml();
					printHtml.showInHtmlFile(htmlData, finalResultsList);
				}
			}
			else if (args[0].equals("-db"))
			{
				String competition = String.valueOf(args[1]);
				DataFromMySQL sqlInput = new DataFromMySQL(competition);
				List<String[]> sqlData = sqlInput.getData();
				List<Double[]> calculatedPoints = calculatedResults.processResults(sqlData);
				List<String[]> finalResultsList = finalData.getFinalData(sqlData, calculatedPoints);
				if (args[2].equals("-console"))
				{
					OutDataToScreen printscreen = new OutDataToScreen();
					printscreen.printToConsole(finalResultsList);
				}
				else if (args[2].equals("-csv"))
				{
					File csvResult = new File(args[3]);
					OutDataToCsv printCsv = new OutDataToCsv();
					printCsv.showInCsvFile(csvResult, finalResultsList);
				}
				else if (args[2].equals("-xml"))
				{
					File xmlData = new File(args[3]);
					OutDataToXml printXml = new OutDataToXml();
					printXml.showInXmlFile(xmlData, finalResultsList);
				}
				else if (args[2].equals("-html"))
				{
					File htmlData = new File(args[3]);
					OutDataToHtml printHtml = new OutDataToHtml();
					printHtml.showInHtmlFile(htmlData, finalResultsList);
				} 
			}
		
		}
		catch (Exception e) 
		{
			System.out.println("Check parameters!");
			e.printStackTrace();
		}
	}
}