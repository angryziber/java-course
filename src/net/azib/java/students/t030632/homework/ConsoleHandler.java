package net.azib.java.students.t030632.homework;

import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * ConsoleHandler <br>
 * Displays input/output options to console, handles data from console.
 *
 * @author Toni
 */
public class ConsoleHandler {
	private Scanner scanner;
	private List<Competitor> competitorsList;
	public ConsoleHandler(InputStream in){
		competitorsList= new LinkedList<Competitor>();
		scanner = new Scanner(in);
		System.out.println("Decathlon results analyzer!!!");
		printInputOptions();
		String inputCommand = scanner.nextLine();
		handleInput(inputCommand);
		
	}
	private void printInputOptions(){
		
		System.out.println("Help, Input options:");
		System.out.println("\t c <results>: results are read from console");
		System.out.println("\t f <filename>: results are in CSV file");
		System.out.println("\t d <username:password>: results are taken from DB");
	}
	private void printOutputOptions(){
		System.out.println("Help, Output options:");
		System.out.println("\t o : results are printed out to console");
		System.out.println("\t i <filename>: results are saved to CSV file");
		System.out.println("\t x <xml filename>: results are saved in xml file");
		System.out.println("\t h <html filename>: results are saved in html via XSL transformation from XML file");
	}
	private void printExitOptions(){
		System.out.println("Exit options: ");
		System.out.println("\t q : quit");
//		System.out.println("\t u : continue with input options");
		System.out.println("\t t : continue with output options");
	}
	private void handleInput(String inputCommand){
		String[] inputStrs = inputCommand.split(" ");
		
		char key = inputCommand.charAt(0);
		switch (key) {
		case 'c':
			System.out.println("input from console");
			String dataStr;
			/*add entered competitors to the existing list*/
			while(!(dataStr = scanner.nextLine()).equals("")){
				competitorsList.add(new Competitor(dataStr));
			}
			
			printOutputOptions();
			handleOutput(scanner.nextLine());
			break;
		case 'f':
			System.out.println("input from file");
			/*add entered competitors to the existing list*/
			for(Competitor champ: new FileProcessor(new File(inputStrs[1])).getCompetitors()){
				competitorsList.add(champ);
			}
			printOutputOptions();
			handleOutput(scanner.nextLine());
			break;
		case 'd':
			List<String> competitions = getCompetitions();
			int i=1;
			System.out.println("input from database...");
			System.out.println("Choose competition no. :");
			for(String competition: competitions){
				System.out.println(i+". "+ competition );
				i++;
			}
			String chosenCompetition = competitions.get(Integer.parseInt(scanner.nextLine())-1);
			System.out.println("Chosen: "+ chosenCompetition);
			SqlQuery sqlQuery = new SqlQuery(chosenCompetition);
			for(String str: sqlQuery.getData()){
				competitorsList.add(new Competitor(str));
			}
			printOutputOptions();
			handleOutput(scanner.nextLine());
			break;			
		default:
			System.out.println("INVALID OPTION SELECTED...");
			printInputOptions();
			handleInput(scanner.nextLine());
			break;
		}
	}
	private void handleOutput(String outputCommand){
		String fileName ;
		Map<Integer, String> places = new PlaceCalculator(competitorsList).getPlaces();
		char key = outputCommand.charAt(0);
		switch (key) {
		case 'o':// to the terminal window
			Set <String> compsDataToWrite = new TreeSet<String>();
			for(Competitor champ : competitorsList){
				compsDataToWrite.add(String.valueOf("("+places.get(champ.getPoints())+") "+champ));
			}
			System.out.println("Rated results to console: ");
			try {
					PrintStream out = new PrintStream(System.out, true, "UTF8");
					for(String data:compsDataToWrite){
						out.println(data);
					}
				}
				catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			printExitOptions();
			handleExit(scanner.nextLine());
			break;
		case 'i'://to CSV file
			fileName= outputCommand.substring(outputCommand.indexOf(" ")).trim();
			
			File outputFile;
			if(fileName.contains(".csv")){
				outputFile = new File(fileName);
			}else{
				outputFile = new File(fileName+".csv");
			}
			new outFileWriter(outputFile, competitorsList);
			System.out.println("Rated results to "+outputFile.getAbsolutePath()+" file: ");
			printExitOptions();
			handleExit(scanner.nextLine());
			break;
		case 'x': // to xml file
			fileName = outputCommand.substring(outputCommand.indexOf(" ")).trim();
			
			if(!fileName.contains(".xml")){
				fileName = String.valueOf(fileName+".xml");
			}	
			File xmlF = new File(fileName);

			new XmlCreator(xmlF,competitorsList);
			System.out.println("Rated results in : "+xmlF.getAbsolutePath()+" file ");
			printExitOptions();
			handleExit(scanner.nextLine());
			break;
		case 'h': // to html file
			fileName = outputCommand.substring(outputCommand.indexOf(" ")).trim();
			
			if(!fileName.contains(".html")){
				if(fileName.contains(".htm")){
					fileName = String.valueOf(fileName+"l");
				}else{
					fileName = String.valueOf(fileName+".html");					
				}
			}
			File htmlFile = new File(fileName);
			File xmlFile = new File(fileName.substring(0,fileName.indexOf(".html"))+".xml");
			String fs = File.separator;
			File xsltFile = new File(".."+fs+"java"+fs+"src"+fs+"net"+fs+"azib"+fs+"java"+fs+"students"+fs+"t030632"+fs+"homework"+fs+"competition.xsl");
			XmlCreator xmlCreator = new XmlCreator(xmlFile,competitorsList);
			xmlCreator.CreateHTML(xmlFile, xsltFile , htmlFile);
			System.out.println("Rated results in : "+htmlFile.getAbsolutePath()+" file ");
			printExitOptions();
			handleExit(scanner.nextLine());
			break;			
		default:
			System.out.println("INVALID OPTION SELECTED...");
			printOutputOptions();
			handleOutput(scanner.nextLine());
			break;
		}
	}
	private void handleExit(String exitcommand){
		char key = exitcommand.charAt(0);
		switch (key) {
		case 'q':
			//scanner.nextLine();
			System.out.println("Exited successfully!");
			break;
		case 'u':
			printInputOptions();
			handleInput(scanner.nextLine());
			
			break;
		case 't':
			printOutputOptions();
			handleOutput(scanner.nextLine());
			break;
		default:
			System.out.println("INVALID OPTION SELECTED...");
			printExitOptions();
			handleExit(scanner.nextLine());
			break;
		}
	}
	private ArrayList<String> getCompetitions() {
		
		ArrayList<String> al = null;
		try {
			Statement stmt;
			  ResultSet rs = null;
			  Class.forName("com.mysql.jdbc.Driver");
			
			  String url = "jdbc:mysql://srv.azib.net:3306/decathlon";
			
			  Connection con = DriverManager.getConnection(url,"java", "java");
			
			  //Get a Statement object
			  stmt = con.createStatement();
			  rs = stmt.executeQuery("SELECT * FROM competitions");
			  al = new ArrayList<String>();
			  while (rs.next()) {
				  al.add(rs.getString("description"));
			  }
			  con.close();
		}catch( Exception e ) {
	      e.printStackTrace();
	    }
		
		return al;
	}

}
