package net.azib.java.students.t050545.homework.sportman;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Person
 *
 * @author libricon
 */
public class Person {
	
	public Person(String name, String country, GregorianCalendar birthDay) {
		this.name = name;
		this.country = country;
		this.birthDay = (GregorianCalendar)birthDay.clone();
	}
	
	@Override
	public String toString(){
		SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return (name+"\nBirthday is: " + df.format(birthDay.getTime()) + "\nfrom "+country+"\n");
	}
	
	@Override
	public boolean equals(Object other){
		if (this == other)
			return true;
		if (other == null)
			return false;
		if (getClass() != other.getClass())
			return false;
		Person p = (Person) other;
		return this.name.equals(p.getName()) && this.country.equals(p.getCountry()) && this.birthDay.equals(p.getBirthDay());
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the birthDay
	 */
	public GregorianCalendar getBirthDay() {
		return birthDay;
	}

	
	private String name;
	private String country;
	private GregorianCalendar birthDay;
	
	public static void main(String[] args) {
		Person person = new Person("Kirill","RU",new GregorianCalendar(1987, 4, 29));
		System.out.println(person);
	}
}