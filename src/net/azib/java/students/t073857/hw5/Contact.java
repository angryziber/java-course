package net.azib.java.students.t073857.hw5;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Contact
 *
 * @author Joonas Vali
 */
public class Contact {
	static public SimpleDateFormat format = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.MEDIUM);
	private Name name;
	private Date birthday;
	private Email email;
	private long phone;	
	
	public Contact(Name name, Date birthday, Email email, long phone){
		this.name = name;
		this.birthday = birthday;
		this.email = email;
		this.phone = phone;
	}
	
	public String toString(){
		return name+" | "+format.format(birthday)+" | "+email+" | "+phone;
	}
}
