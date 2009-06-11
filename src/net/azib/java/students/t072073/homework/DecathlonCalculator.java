package net.azib.java.students.t072073.homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.zip.DataFormatException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.output.DOMOutputter;
import org.jdom.output.XMLOutputter;
import org.xml.sax.SAXException;

/**
 * DecathlonCalculator
 *
 * @author janika
 */
public class DecathlonCalculator {
	private static final String propertiesFile = "db.properties";
	private static final String SQL_SELECT = "select athletes.name, athletes.dob, athletes.country_code, results.race_100m, " 
		+"results.long_jump, results.shot_put, results.high_jump, results.race_400m, "
		+ "results.hurdles_110m, results.discus_throw, results.pole_vault, results.javelin_throw, results.race_1500m "
		+ "from athletes " 
		+ "join results on athletes.id = results.athlete_id " 
		+ "join competitions on results.competition_id = competitions.id ";

	static Decathlon competition = new Decathlon();
	
	public static void main(String [] args){
		try {
			UserArguments userInput = new UserArguments(new ArgumentValidator(args));
			System.out.println("Your selected import method: " + userInput.getInputMethod());	

			importData(userInput);
	
			System.out.println("Your selected output method: " + userInput.getOutputMethod());

			exportData(userInput);

		}
		catch (DataFormatException e) {
			System.out.println(e.getMessage());
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	/**
	 * 
	 * @param userArgs - parsed and validated program arguments from the user
	 * @throws Exception
	 * @description - data import management
	 */
	public static void importData(UserArguments userArgs) throws Exception{
		System.out.println("Starting data import");
		if(userArgs.consoleInput()){
			try {
				getConsoleData();
			}
			catch (IOException e) {

				System.out.println(e.getMessage());
			}
		}
		else if(userArgs.csvInput()){
			getCsvData(new FileInputStream(userArgs.getInputParams()));

		}
		else if(userArgs.databseInput()){
			getDbData(userArgs.getInputParams());

		}
	}
	
	/**
	 * 
	 * @param userArgs - parsed and validated program arguments from the user
	 * @throws IOException
	 * @throws TransformerException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws JDOMException
	 * @description data export management
	 */
	
	public static void exportData(UserArguments userArgs) throws IOException, TransformerException, SAXException, ParserConfigurationException, JDOMException{
		System.out.println("Starting data export.");
		if(userArgs.consoleOutput()){
			competition.printToConsole();
		}
		else if(userArgs.csvOutput()){
			System.out.println("Data will be in file: " + userArgs.getOutputParams());
			try {
				exportToCsv(new FileWriter(userArgs.getOutputParams(),false));
			}
			catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
		else if(userArgs.htmlOutput()){
			Document myDocument = competition.toXml();
			DOMOutputter outputter = new DOMOutputter();
			org.w3c.dom.Document domDocument = outputter.output(myDocument);
			Transformer serializer = TransformerFactory.newInstance().newTransformer(new StreamSource(DecathlonCalculator.class.getResource("decathlon.xsl").toString()));
			serializer.transform(new DOMSource(domDocument), new StreamResult(new File(userArgs.getOutputParams())));
			System.out.println("The result is in file: " + userArgs.getOutputParams());

		}
		else if(userArgs.xmlOutput()){
			try {
			    XMLOutputter outputter = new XMLOutputter();
			    FileWriter writer = new FileWriter(userArgs.getOutputParams());
			    outputter.output(competition.toXml(), writer);
			    writer.close();
			    System.out.println("The result is in file: " + userArgs.getOutputParams());
			} 
			catch (java.io.IOException e) {
			    e.getStackTrace();
			}

		}
	}
	
	/**
	 * 
	 * @param fstream - filestream which outputs the data to a file
	 * @throws IOException
	 * @description data export to csv file
	 */
	public static void exportToCsv(FileWriter fstream) throws IOException{
        BufferedWriter out = new BufferedWriter(fstream);
        for(Athlete athlete : competition.getAthletes()){
        	out.write(athlete.toString() + '\n');
        }
       	out.close();
	}
	
	/**
	 * 
	 * @param dbParameter - user given database parameter (competition id or name)
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 * @description connecting to database, retrieving data and adding athletes to competition
	 */
	public static void getDbData(String dbParameter) throws ClassNotFoundException, SQLException, IOException{
		System.out.println("Creating database connection"); 
		Properties props = new Properties();
		InputStream in = DecathlonCalculator.class.getResourceAsStream(propertiesFile);
		props.load(in);  
		in.close();  
		
		String drivers = props.getProperty("jdbc.drivers");

		System.setProperty("jdbc.drivers", drivers);
        String url = props.getProperty("jdbc.url");  
	    String username = props.getProperty("jdbc.username");  
	    String password = props.getProperty("jdbc.password");
		Connection connection = DriverManager.getConnection(url, username, password);
		Statement stmt = connection.createStatement();
		String dbIdParam = dbParameter.matches("^[0-9]*$") ? dbParameter : null;
		String sql = SQL_SELECT + "where competitions.id = " + dbIdParam + " or competitions.name = '" + dbParameter + "'";
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			competition.add(new Athlete(new AthleteParser(rs)));
		}
		connection.close();
	}

	/**
	 * 
	 * @throws IOException
	 * @description console input data management
	 */
	public static void getConsoleData() throws IOException{
		System.out.println(DecathlonConstants.CONSOLE_INPUT_INSTRUCTIONS);
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader input = new BufferedReader(isr);
        String line;
        while ((line = input.readLine()) != null) {   
            if (line.compareTo("exit")==0){
            	break;
            }
			try {
				AthleteParser parsedAthlete = new AthleteParser(line);
	            Athlete athlete = new Athlete(parsedAthlete);
	            competition.add(athlete);
			}
			catch (DataFormatException e) {
				System.out.println(e.getMessage());
			}
        }
        System.out.println("töö lõpetatud");
	}
	
	/**
	 * 
	 * @param fstream - user given csv file stream
	 * @throws DataFormatException
	 * @throws IOException
	 * @description collecting athletes from a csv file.
	 */
	public static void getCsvData(FileInputStream fstream) throws DataFormatException, IOException{
	    DataInputStream in = new DataInputStream(fstream);
	    BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    String line;
	    while ((line = br.readLine()) != null){
			AthleteParser parsedAthlete = new AthleteParser(line);
		    Athlete athlete = new Athlete(parsedAthlete);
		    competition.add(athlete);
	    }
	    in.close();
	}

}
