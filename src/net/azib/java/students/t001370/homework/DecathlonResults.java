package net.azib.java.students.t001370.homework;

/**
 * DecathlonResults
 * Class for holding decathlon competitor results and calculating total score
 * @author maksim
 */
public class DecathlonResults {
	
	private float result100mRace;
	private float resultLongJump;
	private float resultShotPut;
	private float resultHighJump;
	private float result400mSprint;
	private float result110mHurdles;
	private float resultDiscusThrow;
	private float resultPoleVault;
	private float resultJavelinThrow; 
	private float result1500mRace;
	
	/**
	 * Calculate total score for given results
	 * @return int - total score
	 */
	public int getTotalScore(){
		int totalResult = 0;
		
		if (this.result100mRace != 0){
			totalResult += DecathlonFormulaArguments.
							RUNNING_EVENT_100M_IN_SEC.
								getRunningEventResult(this.result100mRace);
		}
		if (resultLongJump != 0){
			totalResult += DecathlonFormulaArguments.
							FIELD_EVENT_LONG_JUMP_IN_M.
								getFieldEventResult(this.resultLongJump);
		}
		if (resultShotPut != 0){
			totalResult += DecathlonFormulaArguments.
							FIELD_EVENT_SHOT_PUT_IN_M.
								getFieldEventResult(this.resultShotPut);
		}
		if (resultHighJump != 0){
			totalResult += DecathlonFormulaArguments.
							FIELD_EVENT_HIGH_JUMP_IN_M.
								getFieldEventResult(this.resultHighJump);
		}
		if (result400mSprint != 0){
			totalResult += DecathlonFormulaArguments.
							RUNNING_EVENT_400M_IN_SEC.
								getRunningEventResult(this.result400mSprint);
		}
		if (result110mHurdles != 0){
			totalResult += DecathlonFormulaArguments.
							RUNNING_EVENT_110M_HURDLES_IN_SEC.
								getRunningEventResult(this.result110mHurdles);
		}
		if (resultDiscusThrow != 0){
			totalResult += DecathlonFormulaArguments.
							FIELD_EVENT_DISCUS_THROW_IN_M.
								getFieldEventResult(this.resultDiscusThrow);
		}
		if (resultPoleVault != 0){
			totalResult += DecathlonFormulaArguments.
							FIELD_EVENT_POLE_VAULT_IN_M.
								getFieldEventResult(this.resultPoleVault);
		}
		if (resultJavelinThrow != 0){
			totalResult += DecathlonFormulaArguments.
							FIELD_EVENT_JAVELIN_THROW_IN_M.
								getFieldEventResult(this.resultJavelinThrow);
		}
		if (result1500mRace != 0){
			totalResult += DecathlonFormulaArguments.
							RUNNING_EVENT_1500M_IN_SEC.
								getRunningEventResult(this.result1500mRace);
		}
		
		return totalResult;
	}

	/**
	 * Get 100m race result
	 * @return the result100mRace
	 */
	public float getResult100mRace() {
		return result100mRace;
	}

	/**
	 * Set 100m race result
	 * @param result100mRace the result100mRace to set
	 */
	public void setResult100mRace(float result100mRace) {
		this.result100mRace = result100mRace;
	}

	/**
	 * Get long jump result
	 * @return the resultLongJump
	 */
	public float getResultLongJump() {
		return resultLongJump;
	}

	/**
	 * Set long jump result
	 * @param resultLongJump the resultLongJump to set
	 */
	public void setResultLongJump(float resultLongJump) {
		this.resultLongJump = resultLongJump;
	}

	/**
	 * Get shot put result
	 * @return the resultShotPut
	 */
	public float getResultShotPut() {
		return resultShotPut;
	}

	/**
	 * Set shot put result
	 * @param resultShotPut the resultShotPut to set
	 */
	public void setResultShotPut(float resultShotPut) {
		this.resultShotPut = resultShotPut;
	}

	/**
	 * Get high juml result
	 * @return the resultHighJump
	 */
	public float getResultHighJump() {
		return resultHighJump;
	}

	/**
	 * Set high jump result
	 * @param resultHighJump the resultHighJump to set
	 */
	public void setResultHighJump(float resultHighJump) {
		this.resultHighJump = resultHighJump;
	}

	/**
	 * Get 400m sprint result
	 * @return the result400mSprint
	 */
	public float getResult400mSprint() {
		return result400mSprint;
	}

	/**
	 * Set 400m sprint result
	 * @param result400mSprint the result400mSprint to set
	 */
	public void setResult400mSprint(float result400mSprint) {
		this.result400mSprint = result400mSprint;
	}

	/**
	 * Get 110m hurdles result
	 * @return the result110mHurdles
	 */
	public float getResult110mHurdles() {
		return result110mHurdles;
	}

	/**
	 * Set 110m hurdles result
	 * @param result110mHurdles the result110mHurdles to set
	 */
	public void setResult110mHurdles(float result110mHurdles) {
		this.result110mHurdles = result110mHurdles;
	}

	/**
	 * Get discus throw result
	 * @return the resultDiscusThrow
	 */
	public float getResultDiscusThrow() {
		return resultDiscusThrow;
	}

	/**
	 * Set discus throw result
	 * @param resultDiscusThrow the resultDiscusThrow to set
	 */
	public void setResultDiscusThrow(float resultDiscusThrow) {
		this.resultDiscusThrow = resultDiscusThrow;
	}

	/**
	 * Get pole vault result
	 * @return the resultPoleVault
	 */
	public float getResultPoleVault() {
		return resultPoleVault;
	}

	/**
	 * Set pole vault result
	 * @param resultPoleVault the resultPoleVault to set
	 */
	public void setResultPoleVault(float resultPoleVault) {
		this.resultPoleVault = resultPoleVault;
	}

	/**
	 * Get javelin throw result
	 * @return the resultJavelinThrow
	 */
	public float getResultJavelinThrow() {
		return resultJavelinThrow;
	}

	/**
	 * Set javelin throw result
	 * @param resultJavelinThrow the resultJavelinThrow to set
	 */
	public void setResultJavelinThrow(float resultJavelinThrow) {
		this.resultJavelinThrow = resultJavelinThrow;
	}

	/**
	 * Get 1500m race result
	 * @return the result1500mRace
	 */
	public float getResult1500mRace() {
		return result1500mRace;
	}

	/**
	 * Set 1500m race result
	 * @param result1500mRace the result1500mRace to set
	 */
	public void setResult1500mRace(float result1500mRace) {
		this.result1500mRace = result1500mRace;
	}
	
	
}
