package net.azib.java.students.t030632.homework;

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	public ConsoleHandler(){
		competitorsList= new LinkedList<Competitor>();
	}
	
	/**
	 * prints welcome string, reads input options, reads enetered data 
	 * @param in an input stream
	 */
	public void runProgram(InputStream in){
		scanner = new Scanner(in);
		System.out.println("Decathlon results analyzer!!!");
		printInputOptions();
	}
	
	private void printInputOptions(){
		
		System.out.println("Help, Input options:");
		System.out.println("\t c <results>: results are read from console");
		System.out.println("\t f <filename>: results are in CSV file");
		System.out.println("\t d : results are taken from DB");
		if (!handleInput(scanner.nextLine())){
			printInputOptions();
			handleInput(scanner.nextLine());
		}
	}
	private void printOutputOptions(){
		System.out.println("Help, Output options:");
		System.out.println("\t o : results are printed out to console");
		System.out.println("\t i <filename>: results are saved to CSV file");
		System.out.println("\t x <xml filename>: results are saved in xml file");
		System.out.println("\t h <html filename>: results are saved in html via XSL transformation from XML file");
		if(!handleOutput(scanner.nextLine())){
			printOutputOptions();
			handleOutput(scanner.nextLine());
		}
	}
	private void printExitOptions(){
		System.out.println("Exit options: ");
		System.out.println("\t q : quit");
		System.out.println("\t t : continue with output options");
		if(!handleExit(scanner.nextLine())){
			printExitOptions();
			handleExit(scanner.nextLine());
		}
	}
	
	/**
	 * decides using input parameters where input comes from
	 * @param inputCommand string containing input parametr(s)
	 * @return true - parametr(s) is/are valid, false - parametr(s) is/are invalid
	 */
    boolean handleInput(String inputCommand){
    	if(inputCommand.isEmpty()){
    		return false;
    	}else{
    		String[] inputStrs = inputCommand.split(" ");
    		
    		char key = inputCommand.charAt(0);
    		switch (key) {
    		case 'c':
    			System.out.println("input from console");
    			String dataStr;
    			/*add entered competitors to the existing list*/
    			while(!(dataStr = scanner.nextLine()).isEmpty()){
    				competitorsList.add(new Competitor(dataStr));
    			}
    			printOutputOptions();
    			return true;
    		case 'f':
    			System.out.println("input from file");
    			if(inputStrs.length < 2){
    				System.err.println("No input file specified, read input Options");
    				printInputOptions();
    				return false;
    			}
    			/*add entered competitors to the existing list*/
    			for(Competitor champ: new FileProcessor(new File(inputStrs[1])).getCompetitors()){
    				competitorsList.add(champ);
    			}
    			printOutputOptions();
    			return true;
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
    			return true;
    						
    		default:
    			System.out.println("INVALID OPTION SELECTED...");
    			return false;
    		}
    	}
		
	}
    /**
	 * decides using output parameters where output goes to
	 * @param outputCommand string containing output parametr(s)
	 * @return true - parametr(s) is/are valid, false - parametr(s) is/are invalid
	 */
	boolean handleOutput(String outputCommand){
		if(outputCommand.isEmpty()){
			return false;
		}else{
			String fileName ;
			Map<Integer, String> places = new PlaceCalculator(competitorsList).getPlaces();
			Set <String> sortingCompetitors = new TreeSet<String>();
	        for(Competitor champ:competitorsList){
	        	sortingCompetitors.add(champ.getPoints()+"*"+places.get(champ.getPoints())+"|"+champ.getInitialData());
	        }
	        List <String> sortingCompetitorsArray = new LinkedList<String>();
	        for(String data : sortingCompetitors){
	        	sortingCompetitorsArray.add(data);
	        }
	        List <Competitor> sortedCompetitorsList = new LinkedList<Competitor>();
	        for(int i= sortingCompetitorsArray.size()-1; i>-1; i--){
	        	sortedCompetitorsList.add(new Competitor(sortingCompetitorsArray.get(i).substring(sortingCompetitorsArray.get(i).indexOf("|")+1)));
	        }
	        
			char key = outputCommand.charAt(0);
			switch (key) {
			case 'o':// to the terminal window
				List <String> compsDataToWrite = new LinkedList<String>();
				for(Competitor champ : sortedCompetitorsList){
					compsDataToWrite.add(String.valueOf("("+places.get(champ.getPoints())+") Points: "+champ.getPoints()+" Name: "+champ.getName()));
				}
				System.out.println("Rated results to console: ");					
				for(String data:compsDataToWrite){
					System.out.println(new String(data.toCharArray()));
				}		
				printExitOptions();
				return true;
			case 'i'://to CSV file
				if(!outputCommand.contains(" ")){
					fileName = "outPut.csv";
				}else{
					fileName = outputCommand.substring(outputCommand.indexOf(" ")).trim();
				}
				
				File outputFile;
				if(fileName.contains(".csv")){
					outputFile = new File(fileName);
				}else{
					outputFile = new File(fileName+".csv");
				}
				new OutFileWriter(outputFile, sortedCompetitorsList);
				System.out.println("Rated results to "+outputFile.getAbsolutePath()+" file: ");
				printExitOptions();
				return true;
			case 'x': // to xml file
				if(!outputCommand.contains(" ")){
					fileName = "outPut.xml";
				}else{
					fileName = outputCommand.substring(outputCommand.indexOf(" ")).trim();
				}
				
				if(!fileName.contains(".xml")){
					fileName = String.valueOf(fileName+".xml");
				}	
				File xmlF = new File(fileName);

				new XmlCreator(xmlF,competitorsList);
				System.out.println("Rated results in : "+xmlF.getAbsolutePath()+" file ");
				printExitOptions();
				return true;
			case 'h': // to html file
				if(!outputCommand.contains(" ")){
					fileName = "outPut.html";
				}else{
					fileName = outputCommand.substring(outputCommand.indexOf(" ")).trim();
				}
				
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
				return true;	
			default:
				System.out.println("INVALID OPTION SELECTED...");
				return false;
			}

		}
	}
	
	/**
	 * decides using exit parameter (exit the program or continue with output options)
	 * @param exitCommand string containing exit parametr
	 * @return true - parametr is valid, false - parametr is invalid
	 */
	boolean handleExit(String exitCommand){
		if(exitCommand.isEmpty()){
			return false;
		}else{
			char key = exitCommand.charAt(0);
			switch (key) {
			case 'q':
				System.out.println("Exited successfully!");
				return true;
			case 'u':
				printInputOptions();
				return true;
			case 't':
				printOutputOptions();
				return true;
			default:
				System.out.println("INVALID OPTION SELECTED...");
				return false;
			}
		}
		
	}
	
	/**
	 * connects to the DB and gets the competions list  
	 * @return list of competitions (names)
	 */
    ArrayList<String> getCompetitions() {
		
		ArrayList<String> al = null;
//		try {
		Statement stmt;
		ResultSet rs = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://srv.azib.net:3306/decathlon";	
			con = DriverManager.getConnection(url,"java", "java");	
				  //Get a Statement object
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM competitions");
			al = new ArrayList<String>();
			while (rs.next()) {
				al.add(rs.getString("description"));
			}
			con.close();
		}catch (ClassNotFoundException e) {
			System.err.println("com.mysql.jdbc.Driver driver not found");
		    System.err.println(e);
			}
		catch (SQLException e) {
			System.err.println(e + ": experiencing problem with database transactions");
			
		}finally{
			try {
				con.close();
			}
			catch (SQLException e) {
				System.err.println(e + ": Failed to close connection with database");
			}
		}
		return al;
	}

}
