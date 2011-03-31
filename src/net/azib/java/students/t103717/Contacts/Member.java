package net.azib.java.students.t103717.Contacts;

import java.util.Date;

/**
 * User: ruzard
 * Malyshev Konstantin 103717IAPB28
 * Date: 31.03.11
 */
interface IntMember {
	void setName(String name);

	void setEmail(String email);
}

public class Member implements IntMember {
	String name;
	String phone;
	Date birthday;
	String email;
	String fruit;
	String gname;
	int gweight;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getFruit() {
		return fruit;
	}

	public void setFruit(String fruit) {
		this.fruit = fruit;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public int getGweight() {
		return gweight;
	}

	public void setGweight(int gweight) {
		this.gweight = gweight;
	}

}
