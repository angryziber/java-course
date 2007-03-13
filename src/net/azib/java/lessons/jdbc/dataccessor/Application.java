package net.azib.java.lessons.jdbc.dataccessor;

/**
 * Application
 *
 * @author ant
 */
public class Application {
	private DataAccessor dataAccessor;
	
	public Application(DataAccessor dataAccessor){
		this.dataAccessor = dataAccessor;
	}
	
	public void runApplication(){
		Object object = dataAccessor.getData();
		//do something with object
		dataAccessor.save(object);
	}
	
	public static void main(String[] args) {
		Application a = new Application(new ConcreteDataAccessor());
		a.runApplication();
	}
	
}
