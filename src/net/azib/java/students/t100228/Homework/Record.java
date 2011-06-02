package net.azib.java.students.t100228.Homework;

/**
 * Represents an individual record as a competition result
 * @author Martin
 */
public class Record implements Comparable<Record>{
	String name;
	Integer score;
	String place;
	String birthDate;
	String nationality;
	Float hundredMResult;
	Float longJumpResult;
	Float shotPutResult;
	Float highJumpResult;
	String fourHundredMResult;
	Float oneHundredTenResult;
	Float discusResult;
	Float poleVaultResult;
	Float javelinResult;
	String thousandFiveHundredResult;

	public Record(){
	}

	public Record(String aName, int aScore, String aBirthDate, String aNationality, float aHundredMResult,
					float aLongJumpResult, float aShotPutResult, float aHighJumpResult, String aFourHundredMResult,
					float aOneHundredTenResult, float aDiscusResult, float aPoleVaultResult, float aJavelinResult,
					String aThousandFiveHundredResult){
		name = aName;
		score = aScore;
		birthDate = aBirthDate;
		nationality = aNationality;
		hundredMResult = aHundredMResult;
		longJumpResult = aLongJumpResult;
		shotPutResult = aShotPutResult;
		highJumpResult = aHighJumpResult;
		fourHundredMResult = aFourHundredMResult;
		oneHundredTenResult = aOneHundredTenResult;
		discusResult = aDiscusResult;
		poleVaultResult = aPoleVaultResult;
		javelinResult = aJavelinResult;
		thousandFiveHundredResult = aThousandFiveHundredResult;
	}

	String getName(){
		return name;
	}

	void setName(String aName){
		name = aName;
	}

	Integer getScore(){
		return score;
	}

	void setScore(int aScore){
		score = aScore;
	}

	String getPlace(){
		return place;
	}

	void setPlace(String s){
		place = s;
	}

	String getBirthDate(){
		return birthDate;
	}

	void setBirthDate(String s){
		birthDate = s;
	}

	String getNationality(){
		return nationality;
	}

	void setNationality(String s){
		nationality = s;
	}

	Float getHundredMResult(){
		return hundredMResult;
	}

	void setHundredMResult(float f){
		hundredMResult = f;
	}

	Float getLongJumpResult(){
		return longJumpResult;
	}

	void setLongJumpResult(float f){
		longJumpResult = f;
	}

	Float getShotPutResult(){
		return shotPutResult;
	}

	void setShotPutResult(float f){
		shotPutResult = f;
	}

	Float getHighJumpResult(){
		return highJumpResult;
	}

	void setHighJumpResult(float f)
	{
		highJumpResult = f;
	}

	String getFourHundredMResult(){
		return fourHundredMResult;
	}

	void setFourHundredMResult(String s){
		fourHundredMResult = s;
	}

	Float getOneHundredTenResult(){
		return oneHundredTenResult;
	}

	void setOneHundredTenResult(float f){
		oneHundredTenResult = f;
	}

	Float getDiscusResult(){
		return discusResult;
	}

	void setDiscusResult(float f){
		discusResult = f;
	}

	Float getPoleVaultResult(){
		return poleVaultResult;
	}

	void setPoleVaultResult(float f){
		poleVaultResult = f;
	}

	Float getJavelinResult(){
		return javelinResult;
	}

	void setJavelinResult(float f){
		javelinResult = f;
	}

	String getThousandFiveHundredResult(){
		return thousandFiveHundredResult;
	}

	void setThousandFiveHundredResult(String s){
		thousandFiveHundredResult = s;
	}

	/**
	 * Implements the IComparable interface. Needed to sort records in an array.
	 * @param otherRecord The {@link Record} to compare the current {@link Record} to
	 * @return 1 if the current {@link Record}'s score is less than {@code otherRecord}'s score;
	 * -1 if the current {@link Record}'s score is higher than {@code otherRecord}'s score;
	 * 0 if the scores are equal. Meant to sort an array of {@link Record}s in the descending order of scores.
	 */
	@Override
	public int compareTo(Record otherRecord) {
		int score = this.getScore();
		int otherScore = otherRecord.getScore();
		if(score < otherScore) return 1;
		else if(score > otherScore) return -1;
		else if(score == otherScore) return 0;
		else return 0;
	}
}



