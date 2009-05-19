package net.azib.java.students.t050545.homework.sportman;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Person
 *
 * @author libricon
 */
public class Person {
	
	/** 
	 * @param name person's name
	 * @param country country, where is from
	 * @param birthDay BirthDay
	 */
	public Person(String name, String country, GregorianCalendar birthDay) {
		this.name = name;
		this.country = country;
		this.birthDay = (GregorianCalendar)birthDay.clone();
	}
	
	/** This function returns String, with information about the Person
	 * 
	 * @return Return name, country and birthday in readable form
	 */
	@Override
	public String toString(){
		SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return (name+"\nBirthday is: " + df.format(birthDay.getTime()) + "\nfrom "+country+"\n");
	}
	
	/**
	 * This Method compare 2 objects, if all field are equal, returns true
	 * 
	 * @param other The second object to compare
	 * @return return true, if equals
	 */
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
	 * @return cloned object
	 */
	public GregorianCalendar getBirthDay() {
		return (GregorianCalendar)birthDay.clone();
	}

	
	/** name */
	private String name;
	/** country */
	private String country;
	/** birthDay */
	private GregorianCalendar birthDay;
	
	/**
	 * @param args command line arguments, not used
	 */
	public static void main(String[] args) {
		Person person = new Person("Kirill","RU",new GregorianCalendar(1987, 4, 29));
		System.out.println(person);
	}
}