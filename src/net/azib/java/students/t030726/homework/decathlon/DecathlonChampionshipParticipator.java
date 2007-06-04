package decathlon;

/**
 * Describes the participator properties.
 * @author Deniss Nikiforov
 *
 */
public class DecathlonChampionshipParticipator {
	private String participatorName = null;
	private String participatorCountryCode = null;
	private String dateOfBirth = null;
	
	public DecathlonChampionshipParticipator(String participatorName, String participatorCountryCode, String dateOfBirth) {
		this.participatorName = participatorName;
		this.participatorCountryCode = participatorCountryCode;
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getDateOfBirth() {
		return this.dateOfBirth;
	}
	
	/**
	 * A getter for the participator name
	 * @return
	 */
	public String getParticipatorName() {
		return this.participatorName;
	}
	
	/**
	 * A getter for the participator country code
	 * @return
	 */
	public String getParticipatorCountryCode() {
		return this.participatorCountryCode;
	}

}
