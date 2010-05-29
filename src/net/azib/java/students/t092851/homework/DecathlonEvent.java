package net.azib.java.students.t092851.homework;

/**
 * DecathlonEvent
 *
 * @author Lauri
 */
public enum DecathlonEvent {    
    EVENT_100_METERS  (0, "100 m sprint",  "sec", 25.43470,  18.0, 1.81, true,    1, "race_100m"    ),
    EVENT_LONG_JUMP   (1, "Long jump",     "m",    0.14354, 220.0, 1.40, false, 100, "long_jump"    ),
    EVENT_SHOT_PUT    (2, "Shot put",      "m",   51.39000,   1.5, 1.05, false,   1, "shot_put"     ),
    EVENT_HIGH_JUMP   (3, "High jump",     "m",    0.84650,  75.0, 1.42, false, 100, "high_jump"    ),
    EVENT_400_METERS  (4, "400 m sprint",  "sec",  1.53775,  82.0, 1.81, true,    1, "race_400m"    ),
    EVENT_HURDLES     (5, "110 m hurdles", "sec",  5.74352,  28.5, 1.92, true,    1, "hurdles_110m" ),
    EVENT_DISCUS      (6, "Discus throw",  "m",   12.91000,   4.0, 1.10, false,   1, "discus_throw" ),
    EVENT_POLE_VAULT  (7, "Pole vault",    "m",    0.27970, 100.0, 1.35, false, 100, "pole_vault"   ),
    EVENT_JAVELIN     (8, "Javelin throw", "m",   10.14000,   7.0, 1.08, false,   1, "javelin_throw"),
    EVENT_1500_METERS (9, "1500 m race",   "sec",  0.03768, 480.0, 1.85, true,    1, "race_1500m"   );
    
    private final int index;
    private final String name;
    private final String units;
    private final double a;
    private final double b;
    private final double c;
    private final boolean trackEvent;
    private final double conversion; // units conversion factor
    private final String databaseHeader;
    
    private DecathlonEvent(int index, String name, String units, double a, double b, double c, boolean trackEvent, double conversion, String databaseHeader) {
        this.index = index;
        this.name  = name;
        this.units = units;
        this.a = a;
        this.b = b;
        this.c = c;
        this.trackEvent = trackEvent;
        this.conversion = conversion;
        this.databaseHeader = databaseHeader;
    }
    
    public long calcPoints(Double result) {
    	long points;
    	
    	if (result == null)
    		return 0;
    	
    	if (trackEvent)
    		points = (long)(a * Math.pow(b - conversion * result, c));
    	else
    		points = (long)(a * Math.pow(conversion * result - b, c));
    		
    	return points;
    }
    
    public int getIndex() {
    	return index;
    }
    
    public String getName() {
    	return name;
    }
    
    public String getDatabaseHeader() {
    	return databaseHeader;
    }
    
    public String getUnits() {
    	return units;
    }
    
    static public int countEvents() {
    	return values().length;
    }

}
