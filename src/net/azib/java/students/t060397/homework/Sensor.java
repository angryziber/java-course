package net.azib.java.students.t060397.homework;

/**
 * Sensor class an abstract class for inherit sumorobot sensors
 *
 * @author Margus Ernits
 */
public abstract class Sensor {
	
	public enum Type {
		DOWN_LEFT,
		DOWN_CENTRE,
		DOWN_RIGHT,
		ENEMY_LEFT,
		ENEMY_RIGTH
	}
	private int x,y;
	
	private Type type;
	private boolean value;
	
	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}
	/**
	 * @return the value
	 */
	public abstract boolean isValue();
	/**
	 * @param value the value to set
	 */
	public void setValue(boolean value) {
		this.value = value;
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	

}
