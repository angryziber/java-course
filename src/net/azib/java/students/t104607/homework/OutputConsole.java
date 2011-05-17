package net.azib.java.students.t104607.homework;

import java.io.*;
import java.util.List;

/**
 * @author 104607 IASM
 */
public class OutputConsole {
	public void save (OutputStream outputStream, List<Athlete> athletes) throws IOException {
		final String LINE_FORMAT = "%5s %5s %7s %7s %7s %7s %8s %7s %7s %7s %7s %8s %11s %3s  %s\n";

		PrintWriter out = new PrintWriter(outputStream);

		out.format(LINE_FORMAT,"Place","Score",
				"Sprint","Long","Shot","High","Sprint","Hurdles","Discus","Pole","Javelin","Race","Birthday","Country","Name");
		out.format(LINE_FORMAT,"","",
				"100m","jump","put","jump","400m","110m","throw","vault","throw","1500m","","","");
		for (Athlete athlete : athletes) {
			out.format(LINE_FORMAT,
					athlete.getPosition(),
					Integer.toString(athlete.getScore()),
					athlete.getSprint100m(),
					athlete.getLongJump(),
					athlete.getShotPut(),
					athlete.getHighJump(),
					athlete.getSprint400m(),
					athlete.getHurdles110m(),
					athlete.getDiscusThrow(),
					athlete.getPoleVault(),
					athlete.getJavelinThrow(),
					athlete.getRace1500m(),
					athlete.getBirthday(),
					athlete.getCountry(),
					athlete.getName());
		}
		out.close();
	}
}
