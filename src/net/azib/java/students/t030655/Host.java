package net.azib.java.students.t030655;

/**
 * Host
 *
 * @author qtrines
 */
public class Host {
	private Host() {
		name="Juku";
	}
	private static Host instance = new Host();
	private static Host getInstance() {
		if (instance == null){
			synchronized (Host.class){
				if (instance == null){
					instance = new Host();
				}
			}
		}
		return instance;
	}
	
	private String name;
	public String getName() {
		return name;
	}
	

}
