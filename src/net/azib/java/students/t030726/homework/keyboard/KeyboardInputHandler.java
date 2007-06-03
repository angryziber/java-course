package keyboard;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import decathlon.*;

/**
 * The main class for handling keyboard input. It acquires all input automatically and creates an arraylist of DecathlonChampionship objects 
 * @author Deniss Nikiforov
 *
 */
public class KeyboardInputHandler {
	//storage of the final result to allow multiple queries without recalculation
	private ArrayList finalResults = null;

	public KeyboardInputHandler(BufferedReader br) throws IOException {
		this.inputWizard(br);
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
		participator = new DecathlonChampionshipParticipator(participatorName, participatorCountryCode);
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
	
	/**
	 * A basic input wizard asking the user whether to continue entering participator details or abort. It also handles exceptions triggered
	 * by invalid user input. 
	 * When the user is done entering, it compiles an arraylist of DecathlonChampionship objects.
	 * @param br
	 * @throws IOException
	 */
	private void inputWizard(BufferedReader br) throws IOException {
		String inputLine = null;
		ArrayList list = new ArrayList();
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
	 * Forwards the results produced by the inputWizard to the upper levels.
	 * @return
	 */
	public ArrayList getAllResults() {
		return this.finalResults;
	}
}
