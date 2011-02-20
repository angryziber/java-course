package net.azib.java.students.t104887.Lecture2;


/**
 * Created by IntelliJ IDEA.
 * User: BJU
 * Date: 20.02.11
 * Time: 22:58
 * To change this template use File | Settings | File Templates.
 */
abstract class MathSequence
{
	protected double[] values;
	protected int depth;
	private String outStr;

	protected MathSequence(){}

	protected void initialize(int depth)
	{
		this.depth = depth;
		values = new double [depth+1];
		calculate();
	}

	abstract void calculate();

	protected String getValues()
	{
		for (double value : values)
		{
			outStr += value + ", ";
		}

		outStr = outStr.substring(0, outStr.length() - 2);

		return outStr;
	}
}
