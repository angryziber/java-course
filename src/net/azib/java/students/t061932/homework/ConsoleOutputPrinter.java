package net.azib.java.students.t061932.homework;

import java.util.ArrayList;


class ConsoleOutputPrinter extends OutputPrinter {



	public void print() 
	{
		String beginingMessage = new String("You are now viewing the results of the competiion: \n");
		String table = buildTable();
		System.out.println(beginingMessage + table);
	}
	
	

}
