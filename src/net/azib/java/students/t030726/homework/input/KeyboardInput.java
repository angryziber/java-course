package net.azib.java.students.t030726.homework.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

import net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship;
import net.azib.java.students.t030726.homework.decathlon.DecathlonChampionshipParticipator;
import net.azib.java.students.t030726.homework.decathlon.DiscusThrowEvent;
import net.azib.java.students.t030726.homework.decathlon.FifteenHundredMeterRunEvent;
import net.azib.java.students.t030726.homework.decathlon.FourHundredMeterSprint;
import net.azib.java.students.t030726.homework.decathlon.HighJumpEvent;
import net.azib.java.students.t030726.homework.decathlon.HundredAndTenMeterHurdlesEvent;
import net.azib.java.students.t030726.homework.decathlon.HundredMeterSprint;
import net.azib.java.students.t030726.homework.decathlon.InvalidDataFormatException;
import net.azib.java.students.t030726.homework.decathlon.JavelinThrowEvent;
import net.azib.java.students.t030726.homework.decathlon.LongJumpEvent;
import net.azib.java.students.t030726.homework.decathlon.PoleVaultEvent;
import net.azib.java.students.t030726.homework.decathlon.ShotPutEvent;

/**
 * Class is responsible for keyboard input and abstraction for the input controller
 * @author Deniss Nikiforov
 *
 */
public class KeyboardInput implements IInput {
	private ArrayList finalResults = null;
	private Iterator mainIterator = null;
	
	/**
	 * The parameter is here for unit tests. So we can pass something else and test the class independently from what the user enters
	 * @param br
	 * @throws IOException
	 */
	public KeyboardInput(BufferedReader br) throws IOException {
		this.inputWizard(br);
		this.mainIterator = this.finalResults.iterator();
	}

	/**
	 * Attemps to parse the string date with a standard java function and checks if it fails
	 * Germany is set here, as the time representation of dots and month/date position is also correct
	 * @param dateOfBirth
	 * @return
	 */
	private boolean isDateValid(String dateOfBirth) {
		DateFormat df = DateFormat.getDateInstance(DateFormat.DATE_FIELD, Locale.GERMANY); //Germany is set to accept date formats like we have
		
		try{
			df.parse(dateOfBirth);
		} catch (Exception ex) {
			return false;
		}
		return true;

	}
	
	
	/**
	 * Gets the next element from the iterator
	 */
	public DecathlonChampionship getNext() throws InstantiationException, Exception {
		DecathlonChampionship temp = (DecathlonChampionship)this.mainIterator.next();
		return temp;
	}

	/**
	 * Returns true if there is something else to read
	 */
	public boolean hasNext() {
		return this.mainIterator.hasNext();
	}
	
	/**
	 * A basic input wizard asking the user whether to continue entering participator details or abort. It also handles exceptions triggered
	 * by invalid user input. 
	 * When the user is done entering, it compiles an arraylist of DecathlonChampionship objects.
	 * @param br
	 * @throws IOException
	 */
	private void inputWizard(BufferedReader br) throws IOException {
		String inputLine = null;
		ArrayList<DecathlonChampionship> list = new ArrayList<DecathlonChampionship>();
		while(true) {
			try {
				System.out.print("Would you like to enter details about a participator: (1 - yes, 2 - no): ");
				inputLine = br.readLine();
				try {
					if(Integer.parseInt(inputLine) == 2) {
						break;
					}
				} catch (Exception ex) {
					System.out.println("You need to enter either 1 for yes and 2 for no.");
					continue;
				}
				
				try {
					list.add(this.singleParticipatorInput(br));
				} catch (Exception e) {
					//Something obviously broke here. We assume it is caused by invalid data entry, so we tell that to the user.
					System.out.println("An error occured in processing your data entry, please start over");
				}
				
				
			} catch (IOException e) {
				throw e;
			}
		}
		this.finalResults = list;
		
	}
	
	/**
	 * Asks the user for data to create a single DecathlonChampionship object. It asks for all information.
	 * The code here is long and not optimal, but this is the price of handling keyboard input - the intermidiate variables are here for 
	 * readability sake
	 * @param BufferedReader br
	 * @return DecathlonChampionship
	 * @throws Exception
	 */
	private DecathlonChampionship singleParticipatorInput(BufferedReader br) throws Exception {
		String participatorName = null;
		String participatorDateOfBirth = null;
		String participatorCountryCode = null;
		HundredMeterSprint hundredSprint = null;
		LongJumpEvent longJump = null;
		ShotPutEvent shotPut = null;
		HighJumpEvent highJump = null;
		FourHundredMeterSprint fourHundredSprint = null;
		HundredAndTenMeterHurdlesEvent hurdles = null;
		DiscusThrowEvent discusThrow = null;
		PoleVaultEvent poleVault = null;
		JavelinThrowEvent javelinThrow = null;
		FifteenHundredMeterRunEvent longRun = null;
		DecathlonChampionship championship = null;
		DecathlonChampionshipParticipator participator = null;
		
		
		//General participator information
		System.out.print("What is the name: ");
		participatorName = br.readLine();
		System.out.print("What is your birth date (dd.mm.yyyy):");
		participatorDateOfBirth = br.readLine();
		if(!this.isDateValid(participatorDateOfBirth)) {
			throw new InvalidDataFormatException();
		}
		System.out.print("What is the country code: ");
		participatorCountryCode = br.readLine();
		if(participatorCountryCode.length() != 2) {
			throw new InvalidDataFormatException();
		}
		
		//Event specific information
		System.out.print("What is the time for 100 meter spring (s): ");
		hundredSprint = new HundredMeterSprint(br.readLine());
		
		System.out.print("What is the long jump achievement (m): ");
		longJump = new LongJumpEvent(Double.parseDouble(br.readLine()));
		
		System.out.print("What is the shot put event achievement(m): ");
		shotPut = new ShotPutEvent(Double.parseDouble(br.readLine()));
		
		System.out.print("What is the high jump achievement(m): ");
		highJump = new HighJumpEvent(Double.parseDouble(br.readLine()));
		
		System.out.print("What is the 400m spring achievement(min:sec): ");
		fourHundredSprint = new FourHundredMeterSprint(br.readLine());
		
		System.out.print("What is the 110m with hurles achievement(min:sec): ");
		hurdles = new HundredAndTenMeterHurdlesEvent(br.readLine());
		
		System.out.print("What is the discus throw achievement(m): ");
		discusThrow = new DiscusThrowEvent(Double.parseDouble(br.readLine()));
		
		System.out.print("What is the pole vault achievement(m): ");
		poleVault = new PoleVaultEvent(Double.parseDouble(br.readLine()));
		
		System.out.print("What is the javeling throw achievement(m): ");
		javelinThrow = new JavelinThrowEvent(Double.parseDouble(br.readLine()));
		
		System.out.print("What is the 1500m run achievement(min:sec): ");
		longRun = new FifteenHundredMeterRunEvent(br.readLine());
		
		//Ok, if we are here, that means there have been no problems with the input, we can construct objects now
		participator = new DecathlonChampionshipParticipator(participatorName, participatorCountryCode, participatorDateOfBirth);
		championship = new DecathlonChampionship(participator);
		
		championship.setHundredMeterSprintData(hundredSprint);
		championship.setLongJumpEventData(longJump);
		championship.setShotPutEventData(shotPut);
		championship.setHighJumpEventData(highJump);
		championship.setFourHundredMeterSprintEventData(fourHundredSprint);
		championship.setHundredAndTenMeterHurdlesEventData(hurdles);
		championship.setDiscusThrowEventData(discusThrow);
		championship.setPoleVaultEventData(poleVault);
		championship.setJavelinThrowEventData(javelinThrow);
		championship.setFifteenHundredMeterRunEventData(longRun);
		
		return championship;
	}

}
