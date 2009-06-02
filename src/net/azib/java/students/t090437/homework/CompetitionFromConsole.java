package net.azib.java.students.t090437.homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * CompetitionFromConsole
 * 
 * Class what implements functionality to allow for the user to insert 
 * data about competitors and their results into the console. 
 *
 * @author Ronald
 */
public class CompetitionFromConsole implements CompetitionDataLoader {
	private SortedSet<Competitor> competitors;
	
	public CompetitionFromConsole() {
		competitors = new TreeSet<Competitor>();
	}
	
	/**
	 * Returns SortedSet<Competitor> containing the inserted data or empty set
	 * when no data was inserted.
	 */
	@Override
	public SortedSet<Competitor> getResults() {
		return competitors;
	}

	/**
	 * Asks data from the user about the competitors. If any of the data inserted 
	 * is invalid, the same thing is asked once more. If nothing is entered to any 
	 * kind of parameter, the process of inserting data ends and only the previous
	 * competitors are stored.
	 */
	public void loadData() throws MyException {
		Competitor competitor;
		Scanner in = new Scanner(System.in);
		String line;
		
		while(true) {
			System.out.println("Enter the competitor data what is asked. " +
					"To quit entering competitors, enter blank line for any competitor parameter");
			System.out.println("");
			
			System.out.print("Competitor name : ");
			line = in.nextLine();			
			if(line.equals("")) {
				break;
			}
			
			competitor = new Competitor();			
			competitor.setName(line);
			
			if(askCountry(competitor, in)) {
				break;
			}
			
			if(askBirthday(competitor, in)) {
				break;
			}
			
			if(askSprint100m(competitor, in)) {
				break;
			}
			
			if(askLongJump(competitor, in)) {
				break;
			}
			
			if(askShotPut(competitor, in)) {
				break;
			}
			
			if(askHighJump(competitor, in)) {
				break;
			}
			
			if(askSprint400m(competitor, in)) {
				break;
			}
			
			if(askHurdles(competitor, in)) {
				break;
			}
			
			if(askDiscus(competitor, in)) {
				break;
			}
			
			if(askPoleVault(competitor, in)) {
				break;
			}
			
			if(askJavelinThrow(competitor, in)) {
				break;
			}
			
			if(askRace1500m(competitor, in)) {
				break;
			}
			
			competitor.calcScore();
			competitors.add(competitor);
		}		
	}

	private boolean askRace1500m(Competitor competitor, Scanner in) {
		String line;
		while(true) {
			System.out.print("1500m race time in min:sec : ");
			line = in.nextLine();
			
			if(line.equals("")) {
				return true;
			}
			
			try {
				competitor.setRace_1500m_m_s(MyTime.createObj(line));
			} catch(BadDataFormatException e) {
				System.out.println("Bad format. Insert again or press enter to quit.");
				continue;
			}
			return false;
		}
	}
	private boolean askJavelinThrow(Competitor competitor, Scanner in) {
		String line;
		while(true) {
			System.out.print("Javelin throw distance in m : ");
			line = in.nextLine();
			
			if(line.equals("")) {
				return true;
			}
			
			try {
				competitor.setJavelin_throw(MyDouble.parseDouble(line));
			} catch(BadDataFormatException e) {
				System.out.println("Bad format. Insert again or press enter to quit.");
				continue;
			}
			return false;
		}
	}
	private boolean askPoleVault(Competitor competitor, Scanner in) {
		String line;
		while(true) {
			System.out.print("Pole vault distance in m : ");
			line = in.nextLine();
			
			if(line.equals("")) {
				return true;
			}
			
			try {
				competitor.setPole_vault(MyDouble.parseDouble(line));
			} catch(BadDataFormatException e) {
				System.out.println("Bad format. Insert again or press enter to quit.");
				continue;
			}
			return false;
		}
	}
	private boolean askDiscus(Competitor competitor, Scanner in) {
		String line;
		while(true) {
			System.out.print("Discus distance in m : ");
			line = in.nextLine();
			
			if(line.equals("")) {
				return true;
			}
			
			try {
				competitor.setDiscus(MyDouble.parseDouble(line));
			} catch(BadDataFormatException e) {
				System.out.println("Bad format. Insert again or press enter to quit.");
				continue;
			}
			return false;
		}
	}
	private boolean askHurdles(Competitor competitor, Scanner in) {
		String line;
		while(true) {
			System.out.print("Hurdles time in sec : ");
			line = in.nextLine();
			
			if(line.equals("")) {
				return true;
			}
			
			try {
				competitor.setHurdles_s(MyTime.createObj(line));
			} catch(BadDataFormatException e) {
				System.out.println("Bad format. Insert again or press enter to quit.");
				continue;
			}
			return false;
		}
	}
	private boolean askSprint400m(Competitor competitor, Scanner in) {
		String line;
		while(true) {
			System.out.print("400m sprint time in sec or min:sec : ");
			line = in.nextLine();
			
			if(line.equals("")) {
				return true;
			}
			
			try {
				competitor.setSprint_400m_m_s(MyTime.createObj(line));
			} catch(BadDataFormatException e) {
				System.out.println("Bad format. Insert again or press enter to quit.");
				continue;
			}
			return false;
		}
	}
	private boolean askHighJump(Competitor competitor, Scanner in) {
		String line;
		while(true) {
			System.out.print("High jump height in m : ");
			line = in.nextLine();
			
			if(line.equals("")) {
				return true;
			}
			
			try {
				competitor.setHigh_jump_m(MyDouble.parseDouble(line));
			} catch(BadDataFormatException e) {
				System.out.println("Bad format. Insert again or press enter to quit.");
				continue;
			}
			return false;
		}
	}
	private boolean askShotPut(Competitor competitor, Scanner in) {
		String line;
		while(true) {
			System.out.print("Shot put distance in m ");
			line = in.nextLine();
			
			if(line.equals("")) {
				return true;
			}
			
			try {
				competitor.setShot_put_m(MyDouble.parseDouble(line));
			} catch(BadDataFormatException e) {
				System.out.println("Bad format. Insert again or press enter to quit.");
				continue;
			}
			return false;
		}
	}
	private boolean askLongJump(Competitor competitor, Scanner in) {
		String line;
		while(true) {
			System.out.print("Long jump distance in m : ");
			line = in.nextLine();
			
			if(line.equals("")) {
				return true;
			}
			
			try {
				competitor.setLong_jump_m(MyDouble.parseDouble(line));
			} catch(BadDataFormatException e) {
				System.out.println("Bad format. Insert again or press enter to quit.");
				continue;
			}
			return false;
		}
	}
	private boolean askSprint100m(Competitor competitor, Scanner in) {
		String line;
		while(true) {
			System.out.print("100m sprint time in sec : ");
			line = in.nextLine();
			
			if(line.equals("")) {
				return true;
			}
			
			try {
				competitor.setSprint_100m_s(MyTime.createObj(line));
			} catch(BadDataFormatException e) {
				System.out.println("Bad format. Insert again or press enter to quit.");
				continue;
			}
			return false;
		}
	}
	private boolean askBirthday(Competitor competitor, Scanner in) {
		String line;
		while(true) {
			System.out.print("Birthday in form DD.MM.YYYY : ");
			line = in.nextLine();
			
			if(line.equals("")) {
				return true;
			}
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
			
			try {
				competitor.setBirthday(sdf.parse(line));
			} catch(ParseException e) {
				System.out.println("Bad format. Insert again or press enter to quit.");
				continue;
			}
			return false;
		}
	}
	private boolean askCountry(Competitor competitor, Scanner in) {
		String line;
		while(true) {
			System.out.print("Competitor country code in format XX : ");
			line = in.nextLine();
			
			if(line.equals("")) {
				return true;
			}
			
			try {
				competitor.setCountry(line);
			} catch(BadDataFormatException e) {
				System.out.println("Bad format. Insert again or press enter to quit.");
				continue;
			}
			return false;
		}
	}
}
