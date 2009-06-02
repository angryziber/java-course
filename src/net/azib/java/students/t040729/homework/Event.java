package net.azib.java.students.t040729.homework;

/**
 * Decathlon events with their corresponding parameters for
 * points calculation.
 *
 * @author ValleTon
 */
public enum Event {
	
	E_100_M			(25.4347f,	18f,	1.81f,	Constants.RUNNING),
	E_LONG_JUMP		(0.14354f,	220f,	1.4f,	Constants.JUMPING),
	E_SHOT_PUT		(51.39f,	1.5f,	1.05f,	Constants.THROWING),
	E_HIGH_JUMP		(0.8465f,	75f,	1.42f,	Constants.JUMPING),
	E_400_M			(1.53775f,	82f,	1.81f,	Constants.RUNNING),
	E_110_M_HURDLES	(5.74352f,	28.5f,	1.92f,	Constants.RUNNING),
	E_DISCUS_THROW	(12.91f,	4f,		1.1f,	Constants.THROWING),
	E_POLE_VAULT	(0.2797f,	100f,	1.35f,	Constants.JUMPING),
	E_JAVELIN_THROW	(10.14f,	7f,		1.08f,	Constants.THROWING),
	E_1500_M		(0.03768f,	480f,	1.85f,	Constants.RUNNING);

	private final float aParam;
	private final float bParam;
	private final float cParam;
	private final byte discipline;
	
	/**
	 * @param aParam A parameter for the event for points calculation
	 * @param bParam B parameter for the event for points calculation
	 * @param cParam D parameter for the event for points calculation
	 * @param discipline The type of event
	 */
	Event (float aParam, float bParam, float cParam, byte discipline){
		this.aParam = aParam;
		this.bParam = bParam;
		this.cParam = cParam;
		this.discipline = discipline;
	}
	
	/**
	 * @return true if current event is a track event, false otherwise
	 */
	boolean isTrackEvent(){
		return (discipline==Constants.RUNNING)?true:false;
	}
	
	/**
	 * Calculates points for the event
	 * @param performance Competitors result on that event
	 * @return Points for that event
	 */
	short calculatePoints(float performance){
		short pts = 0;
		
		switch (discipline){
			case Constants.RUNNING:
				pts = new Float(this.aParam * Math.pow((this.bParam - performance), this.cParam)).shortValue();
				break;
			case Constants.THROWING:
				pts = new Float(this.aParam * Math.pow((performance - this.bParam), this.cParam)).shortValue();
				break;
			case Constants.JUMPING:
				pts = new Float(this.aParam * Math.pow((performance * 100 - this.bParam), this.cParam)).shortValue();
				break;
		}
		
		return pts;
	}
}
