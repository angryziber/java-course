package net.azib.java.students.t100228;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: mart22n
 * Date: 17.05.11
 * Time: 11:17
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		ArrayList<Integer> list = new ArrayList<Integer>();
		ChangeParam(list);
		//System.out.println(i);
	}

	static void ChangeParam(ArrayList<Integer> arrayList)
	{
		arrayList.add(5);
		//java.lang.Exception
		//++i;
	}
}
