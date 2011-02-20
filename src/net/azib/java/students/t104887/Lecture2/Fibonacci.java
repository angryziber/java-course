package net.azib.java.students.t104887.Lecture2;

/**
 * Created by IntelliJ IDEA.
 * User: BJU
 * Date: 20.02.11
 * Time: 22:58
 * To change this template use File | Settings | File Templates.
 */
public class Fibonacci extends MathSequence
{
	public Fibonacci(int depth)
	{
		initialize(depth);
	}

	void calculate()
	{
		values[0] = 1;
		values[1] = 1;

		for (int index = 2; index < depth; index++)
		{
			values[index] = values[index - 2] + values[index - 1];
		}
	}
}
