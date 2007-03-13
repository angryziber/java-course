package net.azib.java.lessons.jdbc.activerecord;

/**
 * Application
 *
 * @author ant
 */
public class Application {

	public void runApplication(){
		ActiveRecord ar = ActiveRecord.create();
		ar.setId("blah");
		ar.save();
	}
	
	public static void main(String[] args) {
		Application a = new Application();
		a.runApplication();
	}
	
}
