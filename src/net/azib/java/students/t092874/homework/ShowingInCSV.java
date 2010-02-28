package net.azib.java.students.t092874.homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ShowingInCSV
 * 
 * @author Aleksandr Gladki
 */
class ShowingInCSV {
	String fileOrPath = "";

	/**
	 * 
	 */
	ShowingInCSV(String fileName) {
		this.fileOrPath = fileName;
		System.out.println(fileName);
	}

	/**
	 * @return the fileOrPath
	 */
	public String getFileOrPath() {
		if (fileOrPath.contains("/")) {
			return System.getProperty("user.dir") + fileOrPath;
		}
		else {
			return System.getProperty("user.dir") + "/" + fileOrPath;
		}
	}

	/**
	 *@param source
	 *            List and "path or file", write in file List
	 */
	void write(List<Result> list) {
		BufferedWriter out;
		try {

			File theDir = new File(Util.getDirFromString(getFileOrPath()));
			// if the directory does not exist, create it
			if (!theDir.exists()) {
				theDir.mkdir();
			}

			out = new BufferedWriter(new FileWriter(getFileOrPath()));
			int placeNum = 0, pointsNum = 0;
			for (Result result : list) {
				if (placeNum == 0) {
					placeNum = 1;
					pointsNum = result.getPoints();
				}
				else if (result.getPoints() != pointsNum) {
					placeNum++;
				}
				pointsNum = result.getPoints();

				out.write(placeNum + "," + result.putToString());
				out.newLine();
			}
			out.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 *@return List<Result> from file
	 */
	List<Result> read() {
		List<Result> resultsList = new ArrayList<Result>();
		try {
			File theDir = new File(Util.getDirFromString(getFileOrPath()));
			// if the directory does not exist, create it
			if (!theDir.getName().isEmpty() && !theDir.exists()) {
				theDir.mkdir();
			}

			BufferedReader reader = new BufferedReader(new FileReader(getFileOrPath()));
			String strLine;
			// Read File Line By Line
			while ((strLine = reader.readLine()) != null) {
				resultsList.add(new Result(strLine.split(",")));
			}
			reader.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return resultsList;
	}
}
