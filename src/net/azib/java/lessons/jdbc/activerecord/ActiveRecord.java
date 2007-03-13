package net.azib.java.lessons.jdbc.activerecord;

/**
 * ActiveRecord
 *
 * @author ant
 */
public class ActiveRecord {

	private String id;
	/**
	 * @return
	 */
	public static ActiveRecord create() {
		// either creates a new object or retrieves it from database
		return new ActiveRecord();
	}
	
	public void save(){
		//saves the object to database
		System.out.println("save(" +this+ ")");
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	
	
}
