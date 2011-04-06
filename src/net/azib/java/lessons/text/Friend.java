/**
 * 
 */
package net.azib.java.lessons.text;

import java.util.Date;

/**
 * Copied from t092861 to serve as an example of refactoring.
 *
 * @author Stanislav / 092861
 */
public class Friend {
	String name;
	Date birthday;
	String email;
	String phoneNmber;
	String facebook;

	public Friend() { // default constructor
	}

	public Friend(String name, Date birthday, String email,
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

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
