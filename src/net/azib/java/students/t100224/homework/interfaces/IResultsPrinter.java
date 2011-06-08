package net.azib.java.students.t100224.homework.interfaces;


import net.azib.java.students.t100224.homework.model.Result;

import java.util.List;

public interface IResultsPrinter {

	public void printResults(String filename, List<Result> results);

}