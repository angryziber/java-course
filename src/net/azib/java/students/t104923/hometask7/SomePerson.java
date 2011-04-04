package net.azib.java.students.t104923.hometask7;

import java.util.Date;

public class SomePerson {

	private String name;
	private String birthDay;
	private String phoneNumber;
	private String email;

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

	@Override
	public String toString() {
		return "SomePerson{" +
				"name='" + name + '\'' +
				", birthDay='" + birthDay + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
