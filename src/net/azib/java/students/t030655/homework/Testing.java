package net.azib.java.students.t030655.homework;

//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.util.PriorityQueue;

/**
 * Testing
 *
 * @author Triin Nestor
 */
public class Testing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*DecathlonPoints katsetus*/
//		DecathlonPoints one = new DecathlonPoints();
//		one.setSprint100m(12.61);
////		System.out.println((int)one.getSprint100m());
//		one.setLongJump(5.00);
//		one.setShotPut(9.22);
//		one.setHighJump(1.50);
//		one.setSprint400m(59.39);
//		one.setHurdles110m(16.43);
//		one.setDiscusThrow(21.60);
//		one.setPoleVault(2.60);
//		one.setJavelinThrow(35.81);
//		one.setRace1500m(325.72);
//		System.out.println(one.totalPoints());
		
		/*Competitori katsetus*/
//		Competitor comp1 = new Competitor();
//		comp1.setCompetitor("Siim Susi,01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72");
//		System.out.println("Name: " + comp1.getName());
//		System.out.println("Date of Birth: " + comp1.getDateOfBirth());
//		System.out.println("Country: " + comp1.getCountry());
//		for (int i=0; i<10; i++){
//			System.out.println((i+1) + ". event: " + comp1.getResults(i));
//		}
//		System.out.println("Score: " + comp1.getTotalPoints());

		/*File'ist lugemise katsetus*/
//		FileInputStream input = null;
//		try {
//			 input = new FileInputStream("C:\\Documents and Settings\\qtrines.EEMEA\\My Documents\\Kool\\Java\\java\\src\\net\\azib\\java\\students\\t030655\\homework\\decathlon.txt");
//		}
//		catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("File not found!");
//		}
//		DecathlonInputReader inputReader = new DecathlonInputReader();
//		PriorityQueue<Competitor> competitorsQueue =  inputReader.readInputStream(input);
//		PriorityQueue<Competitor> compQ = new PriorityQueue<Competitor>(competitorsQueue);
//		Competitor comp = null;
//		int i=0;
//		while ((comp=compQ.poll())!= null){
//			System.out.println(comp.getString());
//			i++;
		
		/*DatabaseReaderi katsetus*/
//		DecathlonDatabaseReader databaseReader = new DecathlonDatabaseReader();
//		databaseReader.setConnection("jdbc:mysql://srv.azib.net/decathlon", "java", "java");
//		databaseReader.displayCompetitions();
//		databaseReader.setCompetitionId(2);
//		System.out.println("\nCompetition 2 selected, results are following:");
//		PriorityQueue<Competitor> competitorsQueue =  databaseReader.readDatabase();
//		PriorityQueue<Competitor> compQ = new PriorityQueue<Competitor>(competitorsQueue);
//		Competitor comp = null;
//		int i=0;
//		while ((comp=compQ.poll())!= null){
//			System.out.println(comp.getString());
//			i++;
//		}
//		databaseReader.closeConnection();
		
		/*competitionResults katsetus*/
//		DecathlonDatabaseReader databaseReader = new DecathlonDatabaseReader();
//		databaseReader.setConnection("jdbc:mysql://srv.azib.net/decathlon", "java", "java");
//		databaseReader.displayCompetitions();
//		databaseReader.setCompetitionId(2);
//		System.out.println("\nCompetition 2 selected, results are following:");
//		PriorityQueue<Competitor> competitorsQueue =  databaseReader.readDatabase();
//		DecathlonOutputWriter obj = new DecathlonOutputWriter();
//		PriorityQueue<Competitor> pq = obj.competitionResults(competitorsQueue);
//		PriorityQueue<Competitor> compQ = new PriorityQueue<Competitor>(pq);
//		Competitor comp = null;
//		int i=0;
//		while ((comp=compQ.poll())!= null){
//			System.out.println(comp.getString());
//			i++;
//		}
//		databaseReader.closeConnection();
		
		/*writeToConsole katsetus*/
//		DecathlonDatabaseReader databaseReader = new DecathlonDatabaseReader();
//		databaseReader.setConnection("jdbc:mysql://srv.azib.net/decathlon", "java", "java");
//		databaseReader.displayCompetitions();
//		databaseReader.setCompetitionId(2);
//		System.out.println("\nCompetition 2 selected, results are following:");
//		PriorityQueue<Competitor> competitorsQueue =  databaseReader.readDatabase();
//		DecathlonOutputWriter writer = new DecathlonOutputWriter();
//		writer.writeToConsole(competitorsQueue);
//		databaseReader.closeConnection();
		
		/*writeToFile katsetus*/
		DecathlonDatabaseReader databaseReader = new DecathlonDatabaseReader();
		databaseReader.setConnection("jdbc:mysql://srv.azib.net/decathlon", "java", "java");
		databaseReader.displayCompetitions();
		databaseReader.setCompetitionId(2);
		System.out.println("\nCompetition 2 selected, results are following:");
		PriorityQueue<Competitor> competitorsQueue =  databaseReader.readDatabase();
		DecathlonOutputWriter writer = new DecathlonOutputWriter();
		writer.writeToFile("C:\\Documents and Settings\\qtrines.EEMEA\\My Documents\\Kool\\Java\\java\\src\\net\\azib\\java\\students\\t030655\\homework\\decathlonResults.txt", competitorsQueue);
		databaseReader.closeConnection();
	}

}
