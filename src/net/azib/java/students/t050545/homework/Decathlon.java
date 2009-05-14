package net.azib.java.students.t050545.homework;

import net.azib.java.students.t050545.homework.sportman.Sportman;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

/**
 * Decathlon
 * 
 * @author libricon
 */
public class Decathlon {
	public static void main(String[] args) throws ParseException, IOException {

		/*
		 * FileInputStream inputstr = new FileInputStream("c:\\sport_utf8.txt");
		 * InputStreamReader r = new InputStreamReader(inputstr); BufferedReader
		 * reader = new BufferedReader(r);
		 */
		BufferedReader reader = new BufferedReader(new FileReader("c:\\sport_utf8.txt"));
		while (reader.ready() == true) {
			Sportman sportman = Splitter.splitLine(reader.readLine());
			System.out.println(sportman);
		}
	}
}
