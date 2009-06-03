package net.azib.java.students.t040750.homework.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The {@link DecathlonProperties} class provides a method
 * for accessing a properties file and reading the required
 * value from it.
 * 
 * @author Karpz
 *
 */
public class DecathlonProperties {
	Properties props;
	
	/**
	 * Creates a new {@link DecathlonProperties} object and loads the
	 * properties file from the provided location.
	 * 
	 * @param in - property file stream
	 * @throws IOException - in case of error accessing/closing the 
	 * properties file
	 */
	public DecathlonProperties(InputStream in) throws IOException {
		this.props = new Properties();
		props.load(in);
		in.close();
	}
	
	/**
	 * Returns the value of the specified property
	 * 
	 * @param name - name of the property
	 * @return value of the property
	 */
	public String getProperty(String name) {
		return props.getProperty(name);
     }
}
