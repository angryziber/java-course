package net.azib.java.students.t030630.homework;

/**
 * a class that parses results got in format "min:sec" to format "sec"
 * 
 * @author Sergei
 */
public class MinSecHolder {
	private int min;
	private float sec;
	private float insec;

	public MinSecHolder(String minsec) {
		if (minsec.indexOf(":") != -1) {
			min = Integer.parseInt(minsec.substring(0, minsec.indexOf(":")));
			sec = Float.parseFloat(minsec.substring(minsec.indexOf(":") + 1));
			insec = min * 60 + sec;
		}
		else {
			min = 0;
			sec = Float.parseFloat(minsec);
			insec = sec;
		}
		if (sec > 60) {
			min = (int) (insec / 60);
			sec = insec % (min * 60);
		}
	}

	public int getMin() {
		return min;
	}

	public float getSec() {
		return sec;
	}

	public float getInsec() {
		return insec;
	}
}
