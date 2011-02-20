package net.azib.java.students.t104887.Lecture2;

/**
 * Created by IntelliJ IDEA.
 * User: BJU
 * Date: 20.02.11
 * Time: 22:58
 * To change this template use File | Settings | File Templates.
 */
public class Factorial extends MathSequence
{
	public Factorial(int depth)
	{
		initialize(depth);
	}

	void calculate()
	{
		for (int index = 0; index <= depth; index++)
		{
			values[index] = index == 0 || index == 1 ? 1 : values[index - 1] * values[index - 1] + 1;
		}
	}
}
