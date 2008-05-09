package net.azib.java.students.t011861.homework;

import java.io.File;
import java.util.List;
/**
 * Decathlon
 *
 * @author 011861
 */
public class Decathlon {

	public static void main(String[] args) {	
		System.out.println("Choose a number to insert data:");
		System.out.println("1 - Keyboard");
		System.out.println("2 - CSV file");
		System.out.println("3 - Database (MySQL)");
		System.out.println("4 - QUIT");
		try {
			DataFromMySQL mySqlData = new DataFromMySQL();
			List<String[]> sqlData = mySqlData.getData();
			
			CalculatePoints competitionResults = new CalculatePoints();
			List<Double[]> allresults = competitionResults.processResults(sqlData);
			
			ProcessedData finalData = new ProcessedData();
			List<String[]> finalResultsList = finalData.getFinalData(sqlData, allresults);
			
			OutDataToScreen printscreen = new OutDataToScreen();
			printscreen.printToConsole(finalResultsList);
			
			File xml = new File("athletes.xml");
			OutDataToXml writeXml = new OutDataToXml();
			writeXml.showInXmlFile(xml, finalResultsList);
			
			File html = new File("athletes.html");
			File xsl = new File("athletes.xsl");
			OutDataToHtml writeHtml = new OutDataToHtml();
			writeHtml.showInHtmlFile(html, xsl, finalResultsList);
			
			File csv = new File("athletes.csv");
			OutDataToCsv writeCsv = new OutDataToCsv();
			writeCsv.showInCsvFile(csv, finalResultsList);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean check = false;
		do {
			String input = DataFromConsole.readOperation("Please insert the number of the command!");
			switch (Integer.valueOf(input)) 
			{
				case 1: 
					{	/**
						System.out.println(input);
						OutDataToCsv testima = new OutDataToCsv();
						try {
							
							//testima.createFile();
						}
						catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}**/
					break;
					}
				case 2: 
					{
						System.out.println(input);
					break;
					}
				case 3: 
					{
						System.out.println(input);
					break;
					}
					case 4:
					return;
				default:
				System.out.println("Insert correct number");
				check = true;
				break;
			}
		   } while (check);
	}

}
