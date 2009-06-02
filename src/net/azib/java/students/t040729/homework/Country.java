package net.azib.java.students.t040729.homework;

/**
 * Country
 *
 * @author ValleTon
 */
public class Country {
	private String isoCode;

	public Country(){
		
	}
	
	/**
	 * @param isoCode ISO country code string
	 * @throws Exception If provided country code is not ISO compliant
	 */
	public Country(String isoCode) throws Exception {
		if (isoCode.length()!=2 || !isoCode.equals(isoCode.toUpperCase())){
			throw new IllegalArgumentException("Illegal ISO Country Code.");
		}
		this.isoCode = isoCode;
	}
	
	/**
	 * @return ISO country code
	 */
	public String getCountryCode(){
		return isoCode;
	}

	@Override
	public String toString() {
		return getCountryCode();
	}
	
}
