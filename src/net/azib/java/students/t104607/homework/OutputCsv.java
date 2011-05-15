package net.azib.java.students.t104607.homework;

import java.io.*;
import java.util.List;

/**
 * @author 104607 IASM
 */
public class OutputCsv {
	public void save(OutputStream outputStream, List<Athlete> athletes) throws IOException {
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(outputStream));
		out.write("#position,score,name,birthday,country,sprint100m,longjump,shotput,highjump,sprint400m," +
				"hurdles110m,discusthrow,polevault,javelinthrow,race1500m\n");
		for (Athlete athlete : athletes) {
			out.write(athlete.getPosition() + ",");
			out.write(athlete.getScore() + ",");
			out.write("\"" + athlete.getName() + "\",");
			out.write(athlete.getBirthday() + ",");
			out.write(athlete.getCountry() + ",");
			out.write(athlete.getSprint100m() + ",");
			out.write(athlete.getLongJump() + ",");
			out.write(athlete.getShotPut() + ",");
			out.write(athlete.getHighJump() + ",");
			out.write(athlete.getSprint400m() + ",");
			out.write(athlete.getHurdles110m() + ",");
			out.write(athlete.getDiscusThrow() + ",");
			out.write(athlete.getPoleVault() + ",");
			out.write(athlete.getJavelinThrow() + ",");
			out.write(athlete.getRace1500m() + "\n");
		}
		out.close();
	}
}
