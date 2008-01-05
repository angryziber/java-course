package net.azib.java.lessons.jdbc.activerecord;

/**
 * Application
 *
 * @author ant
 */
public class Application {

	public void runApplication(){
        // assume we retrieve the object from db here
		ActiveRecord ar = ActiveRecord.create(); 
		// update the object 
		ar.setId("blah");
		// update row in database
		ar.save();
	}
	
	public static void main(String[] args) {
		Application a = new Application();
		a.runApplication();
	}
	
}
