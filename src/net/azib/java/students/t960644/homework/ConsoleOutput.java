package net.azib.java.students.t960644.homework;

import java.sql.Date;

/**
 * ConsoleOutput
 * 
 * @author Lembit
 */
public class ConsoleOutput {
	int RESULT_WIDTH = 6;
	int DATE_WIDTH = 10;

	public void WriteData(Competition competition) {
		int posWidth = 3;
		int nameWidth = 4;
		for (Result r : competition.getResults()) {
			nameWidth = nameWidth < r.getAthlete().getName().length() ? r.getAthlete().getName().length() : nameWidth;
			posWidth = posWidth < r.getPosition().length() ? r.getPosition().length() : posWidth;
		}
	}

	protected StringBuffer WriteLine(int posWidth, int nameWidth, Result result) {

		return padLeft(result.getPosition(), posWidth).append("|").
			append(padRight(result.getAthlete().getName(), nameWidth)).append("|").
			append(result.getAthlete().getBorn().toString());
	}

	protected StringBuffer spaces(int length) {
		StringBuffer dst = new StringBuffer();
		for (int i = 0; i < length; i++) {
			dst = dst.append(" ");
		}
		return dst;
	}

	protected StringBuffer padLeft(String src, int length) {
		return spaces(length - src.length()).append(src);
	}

	protected StringBuffer padRight(String src, int length) {
		return spaces(length - src.length()).insert(0, src);
	}

	public static void main(String[] args) {
		ConsoleOutput co = new ConsoleOutput();
		Result res = new Result();
		Athlete a = new Athlete();
		a.setName("Juri Gagarin");
		a.setBorn(Date.valueOf("1950-01-01"));
		a.setCountryCode("SU");
		res.setAthlete(a);
		res.setPosition("1");
		System.out.println(co.WriteLine(6,20,res));
	}
}
