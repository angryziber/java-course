package net.azib.java.students.t020281.hometasks;

import java.util.Properties;

/**
 * PropertiesTest
 *
 * @author Trial
 */
public class PropertiesTest {
		
	public static void main(String[] args) {
		Properties myProperties = System.getProperties();
		System.out.println(myProperties);
		System.out.println("User variant: " + myProperties.get("user.variant"));
		myProperties.put("user.variant", "t020281");
		System.out.println("User variant: " + myProperties.get("user.variant"));
		myProperties.put("user.variant", "");
		System.out.println("User variant: " + myProperties.get("user.variant"));
		
	}
	
		
}
