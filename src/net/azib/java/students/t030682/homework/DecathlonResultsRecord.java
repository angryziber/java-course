package net.azib.java.students.t030682.homework;

import sun.misc.Regexp;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;

public class DecathlonResultsRecord {

	String name;
	String dateOfBirth;
	String country;
	double resultOf100mSprint;
	double resultOfLongJump;
	double resultOfShotPut;
	double resultOfHighJump;
	double resultOf400mSprint;
	double resultOf110mHurdles;
	double resultOfDiscusThrow;
	double resultOfPoleVault;
	double resultOfJavelinThrow;
	double resultOf1500Race;
	int totalScore;

	public DecathlonResultsRecord() {
	};

	public DecathlonResultsRecord(String name, String dateOfBirth, String country, double resultOf100mSprint,
			double resultOfLongJump, double resultOfShotPut, double resultOfHighJump, double resultOf400mSprint,
			double resultOf110mHurdles, double resultOfDiscusThrow, double resultOfPoleVault, double resultOfJavelinThrow,
			double resultOf1500Race) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.country = country;
		this.resultOf100mSprint = resultOf100mSprint;
		this.resultOfLongJump = resultOfLongJump;
		this.resultOfShotPut = resultOfShotPut;
		this.resultOfHighJump = resultOfHighJump;
		this.resultOf400mSprint = resultOf400mSprint;
		this.resultOf110mHurdles = resultOf110mHurdles;
		this.resultOfDiscusThrow = resultOfDiscusThrow;
		this.resultOfPoleVault = resultOfPoleVault;
		this.resultOfJavelinThrow = resultOfJavelinThrow;
		this.resultOf1500Race = resultOf1500Race;
		this.totalScore = Math.round((float) Math.floor(25.4347 * (Math.pow((18.00 - resultOf100mSprint), 1.81)))
				+ (float) Math.floor(0.14354 * (Math.pow((resultOfLongJump * 100 - 220.00), 1.40)))
				+ (float) Math.floor(51.39 * (Math.pow((resultOfShotPut - 1.5), 1.05)))
				+ (float) Math.floor(0.8465 * (Math.pow((resultOfHighJump * 100 - 75.00), 1.42)))
				+ (float) Math.floor(1.53775 * (Math.pow((82.00 - resultOf400mSprint), 1.81)))
				+ (float) Math.floor(5.74352 * (Math.pow((28.50 - resultOf110mHurdles), 1.92)))
				+ (float) Math.floor(12.91 * (Math.pow((resultOfDiscusThrow - 4.0), 1.10)))
				+ (float) Math.floor(0.2797 * (Math.pow((resultOfPoleVault * 100 - 100.00), 1.35)))
				+ (float) Math.floor(10.14 * (Math.pow((resultOfJavelinThrow - 7.0), 1.08)))
				+ (float) Math.floor(0.03768 * (Math.pow((480.0 - resultOf1500Race), 1.85))));
	}

	public String toString() {
		return name + " born " + dateOfBirth + " from " + country + " get " + totalScore + " points.";

	}

	public static DecathlonResultsRecord stringToRecord(String rawResults) {

		String[] splitResults = rawResults.split(",");
		
		
		DecathlonResultsRecord newRecord = new DecathlonResultsRecord(splitResults[0], splitResults[1], splitResults[2], Double
				.parseDouble(splitResults[3]), Double.parseDouble(splitResults[4]), Double.parseDouble(splitResults[5]), Double
				.parseDouble(splitResults[6]), Double.parseDouble(splitResults[7]), Double.parseDouble(splitResults[8]), Double
				.parseDouble(splitResults[9]), Double.parseDouble(splitResults[10]), Double.parseDouble(splitResults[11]), Double
				.parseDouble(splitResults[12]));

		return newRecord;
	}
	
	public static void main(String[] args) {
		// DecathlonResultsRecord tmpRecord = new DecathlonResultsRecord(
		// "Siim Susi","01.01.1976","EE",12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,325.72);
		String tmp = "Siim Susi,01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,325.72";
		String tmp2 = "Beata Kana,29.02.1982,ZA,13.04,4.53,7.79,1.55,64.72,18.74,24.20,2.40,28.20,410.76";
		DecathlonResultsRecord tmpRecord = new DecathlonResultsRecord();
		tmpRecord = DecathlonResultsRecord.stringToRecord(tmp2);

		System.out.println(tmpRecord);

	}

}
