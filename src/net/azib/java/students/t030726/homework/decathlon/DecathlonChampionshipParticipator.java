package decathlon;

/**
 * Describes the participator properties.
 * @author Deniss Nikiforov
 *
 */
public class DecathlonChampionshipParticipator {
	private String participatorName = null;
	private String participatorCountryCode = null;
	
	public DecathlonChampionshipParticipator(String participatorName, String participatorCountryCode) {
		this.participatorName = participatorName;
		this.participatorCountryCode = participatorCountryCode;
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
