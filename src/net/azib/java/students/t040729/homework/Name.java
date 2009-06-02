package net.azib.java.students.t040729.homework;

/**
 * Stores person's name.
 *
 * @author ValleTon
 */
public class Name {
	private String firstName;
	private String lastName;
	private String name;
	
	public Name(){
		
	}
	
	/**
	 * @param name The name that is given for person.
	 * @throws Exception If name was not given
	 */
	public Name(String name) throws Exception {
		if ("".equals(name)){
			throw new IllegalArgumentException("Name is compulsory but was not set.");
		}
		this.name = name;
	}

	/**
	 * @param firstName Person's first name
	 * @param lastName Person's last name
	 */
	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		if (name==null){
			return firstName + " " + lastName;
		}else{
			return name;
		}
	}
}
