package net.azib.java.students.t073639.homework;

/**
 * <p>
 * Athlete Instance of Athlete class represents real athlete with its name,
 * birthday, country, total points, place and ten results of decathlon. <br>
 * All fields are strings, except "totalPoints" - integer.
 * <p>
 * Examples of correct results: 12.58, 12, 12.3, 1:05:20, 300, 5. <br>
 * Correct country should have two letters country code. <br>
 * Example of places: 1, 4, 3-7, 4-5.
 * <p>
 * In this class NO check for inputed data.
 * 
 * @author t073639
 */
public class Athlete {
	private String name;
	private String birthdate;
	private String country;
	private String m100Result;
	private String longJumpResult;
	private String shotPutResult;
	private String highJumpResult;
	private String m400Result;
	private String m110HurdlesResult;
	private String discusThrowResult;
	private String poleVaultResult;
	private String javelinThrowResult;
	private String m1500Result;
	private int totalPoints;
	private String place;

	/**
	 * Get athlete's name.
	 * 
	 * @return Athlete's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * <p>Get athlete's birthday. <br>
	 * Example: "07.07.1988".
	 * 
	 * @return Athlete's Birthday.
	 */
	public String getBirthdate() {
		return birthdate;
	}

	/**
	 * <p>Get athlete's country code. <br>
	 * Example: "EE".
	 * 
	 * @return Athlete's country code.
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * <p>Get athlete's 100m result.
	 * 
	 * @return 100m result.
	 */
	public String getM100Result() {
		return m100Result;
	}

	/**
	 * <p>Get athlete's long jump result.
	 * 
	 * @return Long jump result.
	 */
	public String getLongJumpResult() {
		return longJumpResult;
	}

	/**
	 * <p>Get athlete's shot put result.
	 * 
	 * @return Shot put result.
	 */
	public String getShotPutResult() {
		return shotPutResult;
	}

	/**
	 * <p>Get athlete's high jump result.
	 * 
	 * @return High jump result.
	 */
	public String getHighJumpResult() {
		return highJumpResult;
	}

	/**
	 * <p>Get athlete's 400m result.
	 * 
	 * @return 400m result.
	 */
	public String getM400Result() {
		return m400Result;
	}

	/**
	 * <p>Get athlete's 110m hurdles result.
	 * 
	 * @return 110m hurdles result.
	 */
	public String getM110HurdlesResult() {
		return m110HurdlesResult;
	}

	/**
	 * <p>Get athlete's discus throw result.
	 * 
	 * @return Discus throw result.
	 */
	public String getDiscusThrowResult() {
		return discusThrowResult;
	}

	/**
	 * <p>Get athlete's pole vault result.
	 * 
	 * @return Pole vault result.
	 */
	public String getPoleVaultResult() {
		return poleVaultResult;
	}

	/**
	 * <p>Get athlete's javelin throw result.
	 * 
	 * @return Javelin throw result.
	 */
	public String getJavelinThrowResult() {
		return javelinThrowResult;
	}

	/**
	 * <p>Get athlete's 1500m result.
	 * 
	 * @return 1500m result.
	 */
	public String getM1500Result() {
		return m1500Result;
	}

	/**
	 * <p>Get athlete's total point.
	 * 
	 * @return Total points.
	 */
	public int getTotalPoints() {
		return totalPoints;
	}

	/**
	 * <p>Get athlete's place.
	 * 
	 * @return Place.
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * <p>Set athlete's place.
	 * 
	 * @param place
	 *            - place of athlete in group of athletes
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * <p>Create a new athlete, using string.<br>
	 * This class uses {@link StringConverter} and {@link DecathlonCalculator}
	 * to initialise fields, except field "place".<br>
	 * Field "place" is NULL.
	 * 
	 * @param string
	 *            - string, which contains name, birthday, country and ten
	 *            results of decathlon separated by comma.
	 * @see {@link StringConverter}, {@link DecathlonCalculator}
	 */
	public Athlete(String string) {
		StringConverter sc = new StringConverter(string);
		this.name = sc.getList().get(0);
		this.birthdate = sc.getList().get(1);
		this.country = sc.getList().get(2);
		this.m100Result = sc.getList().get(3);
		this.longJumpResult = sc.getList().get(4);
		this.shotPutResult = sc.getList().get(5);
		this.highJumpResult = sc.getList().get(6);
		this.m400Result = sc.getList().get(7);
		this.m110HurdlesResult = sc.getList().get(8);
		this.discusThrowResult = sc.getList().get(9);
		this.poleVaultResult = sc.getList().get(10);
		this.javelinThrowResult = sc.getList().get(11);
		this.m1500Result = sc.getList().get(12);
		this.totalPoints = DecathlonCalculator.getTotalPoints(sc.getList().subList(3, sc.getList().size()));
	}

	/**
	 * @return Formated string, which contains name, birthday, country and ten
	 *         results of decathlon separated by comma.
	 */
	@Override
	public String toString() {
		return name + "," + birthdate + "," + country + "," + m100Result + "," + longJumpResult + "," + shotPutResult + ","
				+ highJumpResult + "," + m400Result + "," + m110HurdlesResult + "," + discusThrowResult + "," + poleVaultResult
				+ "," + javelinThrowResult + "," + m1500Result;
	}

	/**
	 * @return Formated string, which contains place,total points, name,
	 *         birthday, country and ten results of decathlon separated by
	 *         comma.
	 */
	public String toStringWithFinal() {
		return place + "," + totalPoints + "," + name + "," + birthdate + "," + country + "," + m100Result + "," + longJumpResult
				+ "," + shotPutResult + "," + highJumpResult + "," + m400Result + "," + m110HurdlesResult + ","
				+ discusThrowResult + "," + poleVaultResult + "," + javelinThrowResult + "," + m1500Result;
	}
}
