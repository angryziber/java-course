package net.azib.java.students.t030726.homework.decathlon;

import net.azib.java.lessons.logging.JavaUtilLogging;

import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Describes the participator properties.
 * @author Deniss Nikiforov
 *
 */
public class DecathlonChampionshipParticipator {
	private String participatorName = null;
	private String participatorCountryCode = null;
	private String dateOfBirth = null;
	private Logger log = null;
	
	public DecathlonChampionshipParticipator(String participatorName, String participatorCountryCode, String dateOfBirth) throws Exception {

		this.log = Logger.getLogger(JavaUtilLogging.class.getName());
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy"); 

		
		try{
			df.parse(dateOfBirth);
		} catch (Exception ex) {
			this.log.log(Level.SEVERE, "Date has an invalid format", ex);
			throw ex;
		}
		

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
