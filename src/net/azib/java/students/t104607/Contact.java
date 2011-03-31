package net.azib.java.students.t104607;
// @author 104607 IASM

import java.text.ParseException;
import java.util.Date;
import java.text.DateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {
	private String name, birthday, email, phone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		Pattern pattern = Pattern.compile("[A-Z][a-z]+\\s[A-Z][a-z]+");
		Matcher matcher = pattern.matcher(name);
		if (matcher.matches())
			this.name = name;
		else
			this.name = null;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		try {
			Date date = dateFormat.parse(birthday);
			this.birthday = DateFormat.getDateInstance(DateFormat.SHORT).format(date);
			if (!this.birthday.equals(birthday)) this.birthday = null;
		} catch (ParseException e) {
			this.birthday = null;
		}
	}

	public String getEmail() {

		return email;
	}

	public void setEmail(String email) {
		Pattern pattern = Pattern.compile("^([a-z0-9._%+-])+@[a-z0-9.-]+\\.(?:[a-z]{2}|com|org|net|edu|gov|mil|biz|vsnl|yahoo|gmail|info|mobi|name|aero|asia|jobs|museum)$");
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches())
			this.email = email;
		else
			this.email = null;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		Pattern pattern = Pattern.compile("[0-9]{3}-[0-9]{3}-[0-9]{4}");
		Matcher matcher = pattern.matcher(phone);
		if (matcher.matches())
			this.phone = phone;
		else
			this.phone = null;
	}
}
