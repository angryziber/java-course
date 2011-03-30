/**
 * 
 */
package net.azib.java.students.t092861.lecture7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Stanislav / 092861
 * 
 */
public class Friend {
	String name;
	Date birthday;
	String email;
	String phoneNmber;
	String facebook;

	public Friend() { // default constructor
		// TODO Auto-generated constructor stub
	}

	public Friend(String name, String birthday, String email,
			String phoneNmber, String facebook) {
		this.name = name;
		setBirthday(birthday);
		this.email = email;
		this.phoneNmber = phoneNmber;
		this.facebook = facebook;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		try {
			this.birthday = format.parse(birthday);
		} catch (ParseException e) {
			System.out
					.println("Error has been reached unexpectedly while parsing the data!");
			e.printStackTrace();
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNmber() {
		return phoneNmber;
	}

	public void setPhoneNmber(String phoneNmber) {
		this.phoneNmber = phoneNmber;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
}
