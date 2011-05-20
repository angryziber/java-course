package net.azib.java.students.t107675.homework;


import java.awt.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

/**
 * Student Name: Samet ERAP
 * Date: 15.05.2011
 * Time: 15:27
 *
 * All the methods and parameters are initialized in this class. All the reading and printing tasks are done in this class.
 * You need to go into the code and read what other private classes are doing. There is just one public class here,it is DecathlonCalculator.
 */
 public class DecathlonCalculator {

	public static ArrayList<Athlete> athletes = new ArrayList<Athlete>();

	public static Athletes competitors = new Athletes();

	public static Connection connection = null;

	public static void main(String[] args) throws IOException, JAXBException {


		/**
		 * All the methods and parameters are initialized here.
		 */
		String inputMethod = args[0];
		String inputParameters = "";
		String outputMethod;
		String outputParameters = "";

		/**
		 * This part is to read parameters.Basically, if input method and output method are -console, it is not allowed
		 * to enter input parameter or output parameter. It is restricted to enter them. It is allowed to enter this kind of parameters:
		 * -console -console
		 * -inputmethod inputparameter -outputmethod outputparameter
		 * For example:
		 * -csv athletes.csv -html output.html
		 */
		if (inputMethod.equals("-console")) {
			outputMethod = args[1];
			 if (args.length > 2){
				System.out.println(" You entered an unwanted Input or Output Parameter.You can not enter an Input or Output Parameter if you chose -console input or output method." +
						"Correct your arguments and try again."); System.exit(1);}
			if (!outputMethod.equals("-console")) {
				outputParameters = args[2];
			}   else if (args.length > 2){
				System.out.println(" You entered an unwanted Input or Output Parameter.You can not enter an Input or Output Parameter if you chose -console input or output method." +
						"Correct your arguments and try again."); System.exit(1);}


		} else {
			inputParameters = args[1];
			outputMethod = args[2];
			if (!outputMethod.equals("-console")) {
				outputParameters = args[3];
			}   else if (args.length > 3){
				System.out.println("You entered an unwanted Output Parameter.You can not enter an Output Parameter if you chose -console output method."+
						"Correct your arguments and try again."); System.exit(1);}
		}


		/**
		 * Input methods are chosen here according to parameters.
		 * Input methods can be -csv,-db,-console.
		 * Then, the task for that input method is executed.
 		 */

		if (inputMethod.equals("-csv")) {
			readCSV(inputParameters);
		}else if(inputMethod.equals("-db")){
			readDB(inputParameters);
		}else if(inputMethod.equals("-console")){
             readConsole();
  }

		sortAthletes();

		addPlacement();


		/**
		 * Output methods are chosen here according to parameters.
		 * Out methods can be -csv,-xml,-console or -html
		 * Then, the task for that output method is executed.
 		 */
		if (outputMethod.equals("-console")) {
			printConsole();
		} else if (outputMethod.equals("-csv")) {
			printCsv(outputParameters);
		}else if (outputMethod.equals("-xml")) {
			printXml(outputParameters);
		}else if (outputMethod.equals("-html")) {
			printHTML(outputParameters);
		}

	}


	/**
	 * readConsole() is to read all the assignments such as name,birthday,nationality,
	 * results for each sport for an Athlete from Console. To exit from console application, it is needed to press -1.
	 * BufferedReader and InputStreamReader are used to get these stuffs from console.
	 */
        private static void readConsole() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(" - Welcome to interactive mode -");
            System.out.println();
			  System.out.println("Note: Please enter -1 to exit this mode ");
			  String line = "";

			  String name;
			  String dateOfBirth;
			  String nationality;
			  String hundredMSprint;
			  String longJump;
			  String shotPut;
			  String highJump;
			  String fourHundredMSprint;
			  String hundredTenMHurdles;
			  String discusThrow;
			  String poleVault;
			  String javelinThrow;
			  String thousandFiveHundredMRace;

			  while (!line.equals("-1")) {

				   System.out.println("Enter name of the athlete:");
				   name = br.readLine();

				   System.out.println("Enter date of birth of the athlete:");
				   dateOfBirth = br.readLine();

				   System.out.println("Enter nationality of the athlete:");
				   nationality = br.readLine();

				   System.out.println("Enter 100M result of the athlete:");
				   hundredMSprint = br.readLine();

				   System.out.println("Enter Long Jump result of the athlete:");
				   longJump = br.readLine();

				   System.out.println("Enter Shot Put result of the athlete:");
				   shotPut = br.readLine();

				   System.out.println("Enter High Jump result of the athlete:");
				   highJump = br.readLine();

				   System.out.println("Enter 400M result of the athlete:");
				   fourHundredMSprint = br.readLine();

				   System.out.println("Enter 110M Hurdles result of the athlete:");
				   hundredTenMHurdles = br.readLine();

				   System.out.println("Enter Discus Throw result of the athlete:");
				   discusThrow = br.readLine();

				   System.out.println("Enter Pole Vault result of the athlete:");
				   poleVault = br.readLine();

				   System.out.println("Enter Javelin Throw result of the athlete:");
				   javelinThrow = br.readLine();

				   System.out.println("Enter 1500M result of the athlete:");
				   thousandFiveHundredMRace = br.readLine();

				   Athlete athlete = new Athlete();
				   athlete.setName(name);
				   athlete.setDateOfBirth(dateOfBirth);
				   athlete.setNationality(nationality);
				   athlete.setHundredMSprint(Double.parseDouble(hundredMSprint));
				   athlete.setLongJump(Double.parseDouble(longJump));
				   athlete.setShotPut(Double.parseDouble(shotPut));
				   athlete.setHighJump(Double.parseDouble(highJump));
				   athlete.setFourHundredMSprint(Double.parseDouble(fourHundredMSprint));
				   athlete.setHundredTenMHurdles(Double.parseDouble(hundredTenMHurdles));
				   athlete.setDiscusThrow(Double.parseDouble(discusThrow));
				   athlete.setPoleVault(Double.parseDouble(poleVault));
				   athlete.setJavelinThrow(Double.parseDouble(javelinThrow));
				   athlete.setThousandFiveHundredMRace(Double.parseDouble(thousandFiveHundredMRace));
				   athlete.calculateTotalScore();
				   athletes.add(athlete);
				   competitors.addAthlete(athlete);

				   System.out.println("Athlete added, please enter -1 to exit, any other key to continue");
				   line = br.readLine();

				  }

                 System.out.println("Enter of athletes finished!");

              }


	/**
	 * This part is to read all the requirements from database. Firstly, it calls connectToDB() to connect to Database.
	 * It takes the url of database,username and password and if these are correct,it connects.After connection,
	 * it selects the athletes table and results table( according to id number) and join them as one table.How does it get the properties for an Athlete?
	 * It gets these properties due to column number with for example: RS.getString(2) or RS.getDouble(8).It will get the name from the 2nd column and
	 * it will get the 100M Sprint result from the 8th column.After all, it disconnects from Database.
	 */

	private static void readDB(String competitonName) {

		try {
			connectToDB();
		} catch (Exception e) {
			System.out.println("Error while connecting to DB!");
		}


		try {

			Statement Stmt = connection.createStatement();

			ResultSet RS = Stmt.executeQuery("SELECT a.*,r.* FROM athletes a, results r WHERE a.id = r.athlete_id AND r.competition_id = "+competitonName);

			while (RS.next()) {

				Athlete athlete = new Athlete();
				athlete.setName(RS.getString(2));
				athlete.setDateOfBirth(RS.getString(3));
				athlete.setNationality(RS.getString(4));
				athlete.setHundredMSprint(RS.getDouble(8));
				athlete.setLongJump(RS.getDouble(9));
				athlete.setShotPut(RS.getDouble(10));
				athlete.setHighJump(RS.getDouble(11));
				athlete.setFourHundredMSprint(RS.getDouble(12));
				athlete.setHundredTenMHurdles(RS.getDouble(13));
				athlete.setDiscusThrow(RS.getDouble(14));
				athlete.setPoleVault(RS.getDouble(15));
				athlete.setJavelinThrow(RS.getDouble(16));
				athlete.setThousandFiveHundredMRace(RS.getDouble(17));
				athlete.calculateTotalScore();
				athletes.add(athlete);
				competitors.addAthlete(athlete);

			}
			connection.close();
			RS.close();
			Stmt.close();
		} catch (SQLException E) {
			System.out.println("SQLException: " + E.getMessage());
			System.out.println("SQLState:     " + E.getSQLState());
			System.out.println("VendorError:  " + E.getErrorCode());
		}

	}

	/**
	 * This part is to make connection
	 */

	private static void connectToDB() {
		  try {
	            connection = DriverManager.getConnection("jdbc:mysql://java.azib.net/decathlon", "java", "java");
	        } catch (SQLException ex) {
	           System.out.println("Error while creating DB connection");
	           ex.printStackTrace();
	        }

	}

	/**
	 * This part creates HTML file. To create it, an xml file should be created at the begining. printXML() function is
	 * to create xml file which I passed temp.xml name.After creating the xml file,code will check for the XSL file.
	 * XSL file is manually created by us here by looking at the original XML file.After this XML and XSL match,output HTML file that you
	 * will write on arguments window in IDEA will be created with the name you give.
	 *
	 * @param fileName is the output file name that you will write on arguments window.For example; output.html or results.html
	 */

	private static void printHTML(String fileName) {
		try {


			printXml("temp.xml");
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer(new javax.xml.transform.stream.StreamSource("athletes.xsl"));
			transformer.transform(new javax.xml.transform.stream.StreamSource("temp.xml"), new javax.xml.transform.stream.StreamResult(
					new FileOutputStream(fileName)));
		} catch (Exception e) {
			System.out.println("Error while writing HTML file");
			System.exit(1);
		}
	}


	/**
	 *This part is to create an XML file as an output file.It gets the athlete properties from Athletes class and Athlete class and brings here.
	 * After all, you define the output name on arguments window (for example; output.xml),then this task does it's duty.
	 * @param fileName is the output file name that you will write on arguments window.For example; output.xml or results.xml
	 */

	private static void printXml(String fileName) throws JAXBException, FileNotFoundException {


		FileOutputStream outputStream = new FileOutputStream(fileName);

		JAXBContext contextObj = JAXBContext.newInstance(Athletes.class);

		Marshaller marshallerObj = contextObj.createMarshaller();
		marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshallerObj.marshal(competitors, outputStream);

	}


	/**
	 * This part prints the sorted athlete properties on CSV. All the athletes are iterated and the results for each athlete
	 * will be brought from toCSV() function and will be printed as you write the name in arguments window.For example; output.csv
	 * @param fileName is the output file name that you will write on arguments window.For example; output.csv or results.csv
	 */
	private static void printCsv(String fileName) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName));

			Iterator<Athlete> it = athletes.iterator();
			while (it.hasNext()) {
				Athlete athlete = it.next();
				out.write(athlete.toCSV());
			}
			out.close();
		} catch (IOException e) {
			System.out.println("There is an error while writing csv file.");
			System.exit(1);
		}

	}

	/**
	 *   This part iterates the Athletes according to athlete numbers and prints the results from print() function.
	 */
	private static void printConsole() {
		Iterator<Athlete> it = athletes.iterator();
		while (it.hasNext()) {
			Athlete athlete = it.next();
			athlete.print();
		}
	}

	/**
	 * Athletes are sorted here from higher total score to lower total score according to their Total Score.
	 */
	private static void sortAthletes() {
		Collections.sort(athletes, new Comparator<Athlete>() {

			public int compare(Athlete o1, Athlete o2) {
				Athlete p1 = (Athlete) o1;
				Athlete p2 = (Athlete) o2;
				return (p1.getTotalScore() < p2.getTotalScore() ? 1 : 0);
			}

		});

		competitors.sortAthletes();
	}

	/**
	 *  This part adds placement of each athlete after athletes are sorted.
	 */
	private static void addPlacement() {
		//
		Iterator<Athlete> it = athletes.iterator();
		int place = 1;
		while (it.hasNext()) {
			Athlete athlete = it.next();
			athlete.setPlace(place);
			place++;

		}
	}

	/**
	 * This part is to read the datas from a CSV file. FileReader is used here for this purpose.To read from CSV,
	 * parseLine() is used here. The purpose of this function will be told in parseLine explanation.
	 * @param inputParameters is the file name or path name of the file that you want to make it be read. For example; athletes.csv
	 */
	private static void readCSV(String inputParameters) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(inputParameters));
			String str;
			while ((str = in.readLine()) != null) {
				parseLine(str);
			}
			in.close();
		} catch (IOException e) {
			System.out.println("Exception while reading from file!");
			System.exit(1);
		}

	}


	/**
	 * This part is to parse the line in CSV file according to ",".
	 * We do parsing by tokenizer. When we read the datas, we set that property to related property of Athlete.
	 *
	 */
	private static void parseLine(String line) {
		StringTokenizer tokenizer = new StringTokenizer(line, ",");
		Athlete athlete = new Athlete();
		athlete.setName(tokenizer.nextToken());
		athlete.setDateOfBirth(tokenizer.nextToken());
		athlete.setNationality(tokenizer.nextToken());
		athlete.setHundredMSprint(Double.parseDouble(tokenizer.nextToken()));
		athlete.setLongJump(Double.parseDouble(tokenizer.nextToken()));
		athlete.setShotPut(Double.parseDouble(tokenizer.nextToken()));
		athlete.setHighJump(Double.parseDouble(tokenizer.nextToken()));
		athlete.setFourHundredMSprint(minutesToSeconds(tokenizer.nextToken()));
		athlete.setHundredTenMHurdles(Double.parseDouble(tokenizer.nextToken()));
		athlete.setDiscusThrow(Double.parseDouble(tokenizer.nextToken()));
		athlete.setPoleVault(Double.parseDouble(tokenizer.nextToken()));
		athlete.setJavelinThrow(Double.parseDouble(tokenizer.nextToken()));
		athlete.setThousandFiveHundredMRace(minutesToSeconds(tokenizer.nextToken()));
		athlete.calculateTotalScore();
		athletes.add(athlete);
		competitors.addAthlete(athlete);
	}


	/**
	 * This function is to convert minutes to seconds.This transformation is needed for calculation.
	 * How do we do that? Tokenizer is used here one more time for ":".If the result is in this format " min:sec",
	 * we transform it to just seconds. if it is not in this format "min:sec", we do not do anything, because it is already in seconds format.
	 */
	private static double minutesToSeconds(String inputString) {
		StringTokenizer tokenizer = new StringTokenizer(inputString, ":");
		int noOfTokens = tokenizer.countTokens();
		if (noOfTokens == 2) {
			int minutes = Integer.parseInt(tokenizer.nextToken());
			double seconds = Double.parseDouble(tokenizer.nextToken());
			return minutes * 60 + seconds;
		} else {
			double seconds = Double.parseDouble(tokenizer.nextToken());
			return seconds;
		}

	}

}

