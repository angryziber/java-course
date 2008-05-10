package net.azib.java.students.t011861.homework;

import java.io.File;
import java.util.List;
/**
 * Decathlon
 *
 * @author 011861
 */
public class Decathlon {
	//Create point calculator
	static CalculatePoints calculatedResults = new CalculatePoints();
	//Create object which is responsible for making final data
	static ProcessedData finalData = new ProcessedData();
	
	//List<Double[]> allresults = competitionResults.processResults(sqlData);
	public static void main(String[] args) {	
		try 
		{
			
		/**
		for (String procParam: args) {
            System.out.println(procParam);
        	}**/
		
		//if (args[0].equals("-console"))
		{
			DataFromConsole consoleInput = new DataFromConsole();
			List<String[]> consoleData = consoleInput.getData();
			List<Double[]> calculatedPoints = calculatedResults.processResults(consoleData);
			List<String[]> finalResultsList = finalData.getFinalData(consoleData, calculatedPoints);
			if (args[1].equals("-connsole"))
			{
				OutDataToScreen printscreen = new OutDataToScreen();
				printscreen.printToConsole(finalResultsList);
			}
		}
		/**
		String inputMethod = args[0]
		                          
		#  -console - no parameters
		# -csv - input file name or path
		# -db -
		
		#  -conole - no parameters
		# -csv - output file name or path
		# -xml - output file name or path
		# -html - out
		**/
		System.out.println("Choose a number to insert data:");
		System.out.println("1 - Keyboard");
		System.out.println("2 - CSV file");
		System.out.println("3 - Database (MySQL)");
		System.out.println("4 - QUIT");
		
		
			/**
			DataFromMySQL mySqlData = new DataFromMySQL();
			List<String[]> sqlData = mySqlData.getData();
			
			
			
			
			List<String[]> finalResultsList = finalData.getFinalData(sqlData, allresults);
			
			
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
			
			DataFromConsole consoleInput = new DataFromConsole();
			List<String[]> consoleData = consoleInput.getData();
			allresults = competitionResults.processResults(consoleData);
			finalResultsList = finalData.getFinalData(consoleData, allresults);
			printscreen.printToConsole(finalResultsList);
			
			File csvdata = new File("csvdata.csv");
			DataFromCsv csvData = new DataFromCsv(csvdata);
			List<String[]> csvDatas = csvData.getData();
			printscreen.printToConsole(csvDatas);
			CalculatePoints competitionResults2 = new CalculatePoints();
			List<Double[]> allresults2 = competitionResults2.processResults(csvDatas);
			ProcessedData finalData2 = new ProcessedData();
			List<String[]> finalResultsList2 = finalData2.getFinalData(csvDatas, allresults2);
			printscreen.printToConsole(finalResultsList2);
			
			File xml2 = new File("athletes2.xml");
			//OutDataToXml writeXml = new OutDataToXml();
			writeXml.showInXmlFile(xml2, finalResultsList2);
			
			File html2 = new File("athletes2.html");
			//File xsl = new File("athletes.xsl");
			//OutDataToHtml writeHtml = new OutDataToHtml();
			writeHtml.showInHtmlFile(html2, xsl, finalResultsList2);
			
			File csv2 = new File("athletes2.csv");
			//OutDataToCsv writeCsv = new OutDataToCsv();
			writeCsv.showInCsvFile(csv2, finalResultsList2);
		**/
	}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean check = false;
		/**
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
						}
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
		   **/
	
	}
}
