package net.azib.java.students.t110013.hometask6;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Vadim
 */
public class Person {
	private String name;
	private Date birthday;
	private String phone;
	private String email;

	public void setName(String name) {this.name = name;}
	public void setBirthday(Date birthday) {this.birthday = birthday;}
	public void setPhone(String phone) {this.phone = phone;}
	public void setEmail(String email) {this.email = email;}

	public String getName() {return name;}
	public Date getBirthday() {return birthday;}
	public String getPhone() {return phone;}
	public String getEmail() {return email;}

	@Override
	public String toString() {
		return "Name:\t\t" + name + "\n" +
				"Birthday:\t" + new SimpleDateFormat().getDateInstance(DateFormat.MEDIUM).format(birthday) + "\n" +
				"Phone:\t\t" + phone + "\n" +
				"Email:\t\t" + email + "\n";
	}
}
