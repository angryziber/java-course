package decathlon;

import java.lang.InstantiationException;

/**
 * The main DTO object for the program. Contains all necessary information to produce output for a single participant.
 * Used in conjunction with arraylist.
 * A championship by my definition here is a series of all decathlon events
 * @author NTAdmin
 *
 */
public class DecathlonChampionship  implements Comparable {
	private final int totalEvents = 10; 
	private HundredMeterSprint hundredSprint = null;
	private LongJumpEvent longJump = null;
	private ShotPutEvent shotPut = null;
	private HighJumpEvent highJump = null;
	private FourHundredMeterSprint fourHundredSprint = null;
	private HundredAndTenMeterHurdlesEvent hurdlesEvent = null;
	private DiscusThrowEvent discusThrow = null;
	private PoleVaultEvent poleVault = null;
	private JavelinThrowEvent javelinThrow = null;
	private FifteenHundredMeterRunEvent longRun = null;
	private String position = null;
	
	//Initialized event counter. Used to check whether everything is initialized prior to point computation
	private int eventsInitialized = 0;
	private DecathlonChampionshipParticipator participator = null;
	
	public String getHundredMeterSprintRawResult() throws InstantiationException {
		if(this.hundredSprint == null) {
			throw new InstantiationException();
		}
		return this.hundredSprint.getRawResult();
	}
	
	public String getLongJumpRawResult() throws InstantiationException {
		if(this.longJump == null) {
			throw new InstantiationException();
		}
		return this.longJump.getRawResult();
	}
	
	public String getShotPutRawResult() throws InstantiationException {
		if(this.shotPut == null) {
			throw new InstantiationException();
		}
		return this.shotPut.getRawResult();
	}
	
	public String getHighJumpRawResult() throws InstantiationException {
		if(this.highJump == null) {
			throw new InstantiationException();
		}
		return this.highJump.getRawResult();
	}
	
	public String getFourHundredMeterSprintRawResult() throws InstantiationException {
		if(this.fourHundredSprint == null) {
			throw new InstantiationException();
		}
		return this.fourHundredSprint.getRawResult();
	}
	
	public String getHurdlesRawResult() throws InstantiationException {
		if(this.hurdlesEvent == null) {
			throw new InstantiationException();
		}
		return this.hurdlesEvent.getRawResult();
	}
	
	public String getDiscusThrowRawResult() throws InstantiationException {
		if(this.discusThrow == null) {
			throw new InstantiationException();
		}
		return this.discusThrow.getRawResult();
	}
	
	public String getPoleVaultRawResult() throws InstantiationException {
		if(this.poleVault == null) {
			throw new InstantiationException();
		}
		return this.poleVault.getRawResult();
	}
	
	public String getJavelinThrowRawResult() throws InstantiationException {
		if(this.javelinThrow == null) {
			throw new InstantiationException();
		}
		return this.javelinThrow.getRawResult();
	}
	
	public String getLongRunRawResult() throws InstantiationException {
		if(this.longRun == null) {
			throw new InstantiationException();
		};
		return this.longRun.getRawResult();
	}
	
	
	public DecathlonChampionship (DecathlonChampionshipParticipator participator) {
		this.participator = participator;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getPosition() throws Exception {
		if(this.position == null) {
			throw new Exception();
		}
		return this.position;
	}
	
	/**
	 * Setter for the HundredMeterSprint
	 * @param eventData
	 * @throws InstantiationException if already set
	 */
	public void setHundredMeterSprintData(HundredMeterSprint eventData) throws InstantiationException {
		if(this.hundredSprint != null) {
			throw new InstantiationException();
		}
		this.hundredSprint = eventData;
		this.eventsInitialized++;
	}
	
	/**
	 * Setter for the LongJumpEvent
	 * @param eventData
	 * @throws InstantiationException if already set
	 */
	public void setLongJumpEventData(LongJumpEvent eventData) throws InstantiationException {
		if(this.longJump != null) {
			throw new InstantiationException();
		}
		this.longJump = eventData;
		this.eventsInitialized++;
	}
	
	/**
	 * Setter for the ShotPutEvent
	 * @param eventData
	 * @throws InstantiationException if already set
	 */
	public void setShotPutEventData(ShotPutEvent eventData) throws InstantiationException {
		if(this.shotPut != null) {
			throw new InstantiationException();
		}
		this.shotPut = eventData;
		this.eventsInitialized++;
	}
	
	/**
	 * Setter for the HighJumpEvent
	 * @param eventData
	 * @throws InstantiationException if already set
	 */
	public void setHighJumpEventData(HighJumpEvent eventData) throws InstantiationException {
		if(this.highJump != null) {
			throw new InstantiationException();
		}
		this.highJump = eventData;
		this.eventsInitialized++;
	}
	
	/**
	 * Setter for the FourHundredMeterSprintEvent
	 * @param eventData
	 * @throws InstantiationException if already set
	 */
	public void setFourHundredMeterSprintEventData(FourHundredMeterSprint eventData) throws InstantiationException {
		if(this.fourHundredSprint != null) {
			throw new InstantiationException();
		}
		this.fourHundredSprint = eventData;
		this.eventsInitialized++;
	}
	
	/**
	 * Setter for the HundredAndTenMeterHurdlesEvent
	 * @param eventData
	 * @throws InstantiationException if already set
	 */
	public void setHundredAndTenMeterHurdlesEventData(HundredAndTenMeterHurdlesEvent eventData) throws InstantiationException {
		if(this.hurdlesEvent != null) {
			throw new InstantiationException();
		}
		this.hurdlesEvent = eventData;
		this.eventsInitialized++;
	}
	
	/**
	 * Setter for the DiscusThrowEvent
	 * @param eventData
	 * @throws InstantiationException if already set
	 */
	public void setDiscusThrowEventData(DiscusThrowEvent eventData) throws InstantiationException {
		if(this.discusThrow != null) {
			throw new InstantiationException();
		}
		this.discusThrow = eventData;
		this.eventsInitialized++;
	}
	
	/**
	 * Setter for the PoleVaultEvent
	 * @param eventData
	 * @throws InstantiationException if already set
	 */
	public void setPoleVaultEventData(PoleVaultEvent eventData) throws InstantiationException {
		if(this.poleVault != null) {
			throw new InstantiationException();
		}
		this.poleVault = eventData;
		this.eventsInitialized++;
	}
	
	/**
	 * Setter for the JavelinThrowEvent
	 * @param eventData
	 * @throws InstantiationException if already set
	 */
	public void setJavelinThrowEventData(JavelinThrowEvent eventData) throws InstantiationException {
		if(this.javelinThrow != null) {
			throw new InstantiationException();
		}
		this.javelinThrow = eventData;
		this.eventsInitialized++;
	}
	
	/**
	 * Setter for the FifteenHundredMeterRunEvent
	 * @param eventData
	 * @throws InstantiationException if already set
	 */
	public void setFifteenHundredMeterRunEventData(FifteenHundredMeterRunEvent eventData) throws InstantiationException {
		if(this.longRun != null) {
			throw new InstantiationException();
		}
		this.longRun = eventData;
		this.eventsInitialized++;
	}

	/**
	 * The getter for ta participator. Participator is set in the constructor
	 * @return
	 */
	public DecathlonChampionshipParticipator getParticipator() {
		return this.participator;
	}
	
	/**
	 * Computes the total points of the participator. Basically sums the points for all the events.
	 * @return
	 */
	private int computeTotalPoints() {
		int points = 0;
		points += this.hundredSprint.getPoints();
		points += this.longJump.getPoints();
		points += this.shotPut.getPoints();
		points += this.highJump.getPoints();
		points += this.fourHundredSprint.getPoints();
		points += this.hurdlesEvent.getPoints();
		points += this.discusThrow.getPoints();
		points += this.poleVault.getPoints();
		points += this.javelinThrow.getPoints();
		points += this.longRun.getPoints();
		
		
		return points;
	}
	
	/**
	 * An abstraction for higher levels. Executes computeTotalPoints, but first validates whether all events have been initialized.
	 * @return
	 * @throws Exception
	 */
	public int getPoints() throws Exception {
		if(this.eventsInitialized != this.totalEvents) {
			throw new Exception("Not all events were initialized");
		}
		
		return this.computeTotalPoints();
	}

	public int compareTo(Object arg0)  {
		if(!(arg0 instanceof DecathlonChampionship)) {
			 throw new ClassCastException("A DecathlonChampionship Object is Expected");
		}
		int otherResult = 0;
		try {
			otherResult = ((DecathlonChampionship) arg0).getPoints();
		} catch (Exception ex) {
			//Ok, we don't do anything here! Let it crash.
		}
		int myPoints = 0;
		try {
			myPoints = this.getPoints();
		} catch (Exception ex) {
			//Same as above, we ignore this
		}
		
		return (myPoints - otherResult);
	}
}
