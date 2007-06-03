package decathlon;

/**
 * 
 * @author NTAdmin
 *
 */
public class DecathlonChampionshipParticipator {
	private String participatorName = null;
	private String participatorCountryCode = null;
	
	public DecathlonChampionshipParticipator(String participatorName, String participatorCountryCode) {
		this.participatorName = participatorName;
		this.participatorCountryCode = participatorCountryCode;
	}
	
	public String getParticipatorName() {
		return this.participatorName;
	}
	
	public String getParticipatorCountryCode() {
		return this.participatorCountryCode;
	}
	
}
