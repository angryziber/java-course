package net.azib.java.students.t060397.homework;


import org.apache.log4j.Logger;
/**
 * Configuration contains common configuration for SumoApp
 *
 * @author Margus Ernits
 */
public class Configuration {
	
	private String pictureLocation = new String();
	//private int width;
	
	private static final Logger LOG = Logger.getLogger(Configuration.class);
	
	/**
	 * @return the pictureLocation
	 */
	public String getPictureLocation() {
		return pictureLocation;
	}

	/**
	 * @param pictureLocation the pictureLocation to set
	 */
	public void setPictureLocation(String pictureLocation) {
		this.pictureLocation = pictureLocation;
	}

	/**
	 * @return the lOG
	 */
	public static Logger getLOG() {
		return LOG;
	}
	
	

}
