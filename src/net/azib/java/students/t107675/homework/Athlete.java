package net.azib.java.students.t107675.homework;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement

	/**
	 * Each athlete is created here and each athlete's properties such as name, birthday,
	 * nationality, results of sports, total score and placement are defined in this Athlete class.
	 */
	public class Athlete {

	private String name;
	public String dateOfBirth;
	private String nationality;

	private double hundredMSprint;
	private double longJump;
	private double shotPut;
	private double highJump;
	private double fourHundredMSprint;
	private double hundredTenMHurdles;
	private double discusThrow;
	private double poleVault;
	private double javelinThrow;
	private double thousandFiveHundredMRace;

	public int totalScore;
	private int place;


	public static String newline = System.getProperty("line.separator");


	/**
	 *
	 * @return Returns the Name of Athlete
	 */
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Returns the Birthday of Athlete
	 */
	private String getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return Returns the Nationality of Athlete
	 */
	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * @return Returns the 100 M Sprint result of Athlete
	 */
	public double getHundredMSprint() {
		return hundredMSprint;
	}


	public void setHundredMSprint(double hundredMSprint) {
		this.hundredMSprint = hundredMSprint;
	}

	/**
	 * @return Returns the Long Jump result of Athlete
	 */
	public double getLongJump() {
		return longJump;
	}


	public void setLongJump(double longJump) {
		this.longJump = longJump;
	}

	/**
	 * @return Returns the Shot Put result of Athlete
	 */
	public double getShotPut() {
		return shotPut;
	}


	public void setShotPut(double shotPut) {
		this.shotPut = shotPut;
	}

	/**
	 * @return Returns the High Jump result of Athlete
	 */
	public double getHighJump() {
		return highJump;
	}


	public void setHighJump(double highJump) {
		this.highJump = highJump;
	}

	/**
	 * @return Returns the 400 M Sprint result of Athlete
	 */
	public double getFourHundredMSprint() {
		return fourHundredMSprint;
	}


	public void setFourHundredMSprint(double fourHundredMSprint) {
		this.fourHundredMSprint = fourHundredMSprint;
	}

	/**
	 * @return Returns the 110 M Hurdles result of Athlete
	 */
	public double getHundredTenMHurdles() {
		return hundredTenMHurdles;
	}


	public void setHundredTenMHurdles(double hundredTenMHurdles) {
		this.hundredTenMHurdles = hundredTenMHurdles;
	}

	/**
	 * @return Returns the Discus Throw result of Athlete
	 */
	public double getDiscusThrow() {
		return discusThrow;
	}


	public void setDiscusThrow(double discusThrow) {
		this.discusThrow = discusThrow;
	}

	/**
	 * @return Returns the Pole Vault result of Athlete
	 */
	public double getPoleVault() {
		return poleVault;
	}


	public void setPoleVault(double poleVault) {
		this.poleVault = poleVault;
	}

	/**
	 * @return Returns the Javelin Throw result of Athlete
     */
	public double getJavelinThrow() {
		return javelinThrow;
	}


	public void setJavelinThrow(double javelinThrow) {
		this.javelinThrow = javelinThrow;
	}

	/**
	 @return Returns the 1500 M Race result of Athlete
     */
	public double getThousandFiveHundredMRace() {
		return thousandFiveHundredMRace;
	}


	public void setThousandFiveHundredMRace(double thousandFiveHundredMRace) {
		this.thousandFiveHundredMRace = thousandFiveHundredMRace;
	}

	/**
	 * @return Returns the Total Score of Athlete
	 */
	public int getTotalScore() {
		return totalScore;
	}


	public void setTotalScore(double totalScore) {
		this.totalScore = (int)totalScore;
	}

	/**
	 * @return Returns the placement of Athlete like 1st,2nd or 3rd...
	 */
	public int getPlace() {
		return place;
	}


	public void setPlace(int place) {
		this.place = place;
	}


	/**
	 * Total Score is calculated here. All the results are taken from related sport class,performance of the athlete is
	 * taken from input and put here.
	 * After that, all the scores are calculated according to their related formula which are Track Formula and Jump/Throw Formula.
	 */
	public void calculateTotalScore() {

		setTotalScore(
				calculateHundredMSprint(getHundredMSprint())+calculateLongJump(getLongJump())+calculateShotPut(getShotPut())+calculateHighJump(getHighJump())
				+calculateFourHundredMSprint(getFourHundredMSprint())
				+calculateHundredTenMHurdles(getHundredTenMHurdles())
				+calculateDiscusThrow(getDiscusThrow())
				+calculatePoleVault(getPoleVault())+calculateJavelinThrow(getJavelinThrow())+calculateThousandFiveHundredMRace(getThousandFiveHundredMRace())
				);
	}


	private double calculateThousandFiveHundredMRace(double performance) {
		return trackFormula(ThousandFiveHundredMRace.getA(), ThousandFiveHundredMRace.getB(), ThousandFiveHundredMRace.getC(), performance);
	}

	private double calculateJavelinThrow(double performance) {
		return jumpOrThrowFormula(JavelinThrow.getA(), JavelinThrow.getB(), JavelinThrow.getC(), performance);
	}

	private double calculateHundredTenMHurdles(double performance) {
		return trackFormula(HundredTenMHurdles.getA(), HundredTenMHurdles.getB(), HundredTenMHurdles.getC(), performance);
	}

	private double calculateDiscusThrow(double performance) {
		return jumpOrThrowFormula(DiscusThrow.getA(), DiscusThrow.getB(), DiscusThrow.getC(), performance);
	}

	private double calculatePoleVault(double performance) {
		return jumpOrThrowFormula(PoleVault.getA(), PoleVault.getB(), PoleVault.getC(), performance*100);
	}

	private double calculateFourHundredMSprint(double performance) {
		return trackFormula(FourHundredMSprint.getA(), FourHundredMSprint.getB(), FourHundredMSprint.getC(), performance);
	}

	private double calculateLongJump(double performance) {
		return jumpOrThrowFormula(LongJump.getA(), LongJump.getB(), LongJump.getC(), performance*100);
	}

	private double calculateShotPut(double performance) {
		return jumpOrThrowFormula(ShotPut.getA(), ShotPut.getB(), ShotPut.getC(), performance);
	}

	private double calculateHighJump(double performance) {
		return jumpOrThrowFormula(HighJump.getA(),HighJump.getB(),HighJump.getC(),performance*100);

	}

	private double calculateHundredMSprint(double performance) {
		return trackFormula(HundredMSprint.getA(),HundredMSprint.getB(),HundredMSprint.getC(),performance);
	}



	private double trackFormula(double a, double b, double c, double performance) {
		//Points = INT(A*(B-P)C)
		return a*(Math.pow((b-performance),c));
	}

	private double jumpOrThrowFormula(double a, double b, double c, double performance) {
		// Points = INT(A*(P-B)C)
		return a*(Math.pow((performance-b),c));
	}


	/**
	 * print() makes the athlete properties ready to be printed to console when print()function is called from printConsole().
	 */
	public void print() {
		System.out.print(this.getPlace()+",");
		System.out.print(this.getTotalScore()+",");
		System.out.print(this.getName()+",");
		System.out.print(this.getDateOfBirth()+",");
		System.out.print(this.getNationality()+",");
		System.out.print(this.getHundredMSprint()+",");
		System.out.print(this.getLongJump()+",");
		System.out.print(this.getShotPut()+",");
		System.out.print(this.getHighJump()+",");
		System.out.print(this.getFourHundredMSprint()+",");
		System.out.print(this.getHundredTenMHurdles()+",");
		System.out.print(this.getDiscusThrow()+",");
		System.out.print(this.getPoleVault()+",");
		System.out.print(this.getJavelinThrow()+",");
		System.out.println(this.getThousandFiveHundredMRace());

	}

	/**
	 * This part's duty is to get all the assigned items to Athlete and to convert everything to string and to be printed as a string into a CSV file.
	 * This class will be called from printCSV class.
	 * "newline" code is to go to the next line.
	 * It is used as a system property line separator, because this programme can be run in different operating systems.
	 */

	public String toCSV(){
		return this.getPlace()+","+this.getName()+","+this.getDateOfBirth()+","+this.getNationality()+","+
			this.getHundredMSprint()+","+this.getLongJump()+","+this.getShotPut()+","+
			this.getHighJump()+","+this.getFourHundredMSprint()+","+
			this.getHundredTenMHurdles()+","+this.getDiscusThrow()+","+
			this.getPoleVault()+","+this.getJavelinThrow()+","+
			this.getThousandFiveHundredMRace()+","+this.getTotalScore()+newline;
	}





}
