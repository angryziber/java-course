package net.azib.java.students.t030633;

/**
 * CalculatorOperator
 * 
 * @author t030633
 */
public enum CalculatorOperator {

	CLEAR(""), PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/");

	private String sign;

	CalculatorOperator(String sign) {
		this.sign = sign;
	}

	public String getSign() {
		return sign;
	}

	public double operate(double data1, double data2) {
		switch (this) {
		case PLUS:
			return data1 + data2;
		case MINUS:
			return data1 - data2;
		case MULTIPLY:
			return data1 * data2;
		case DIVIDE:
			return data1 / data2;
		default:
			return data2;
		}
	}

}
