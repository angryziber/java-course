package net.azib.java.students.t030657.homework;

import java.util.Collections;
import java.util.List;

/**
 * @author Karina
 * public class Decathlon
 * Main project's class - all important classes (according to the selected 
 * IO source reading, writing data of new athlete, configuration, etc) are being used here
 * Once operation on data is finished, the positions' update is executed
 *
 */

public class Decathlon {

	public static void main(String[] args) {
		try {
			Configuration conf = new Configuration(args);

			Reader reader = conf.getReader();
			List<Results> results = reader.readAll();

			Collections.sort(results);
			updatePositions(results);
			
			Writer writer = conf.getWriter();
			for (Results r : results)
				writer.write(r);
			writer.close();
			
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(Configuration.getUsage());
		}
	}
	
	static void updatePositions(List<Results> results) {
		int size = results.size();
		for (int i = 0; i < results.size();) {
			int score = results.get(i).getScore();
			int j = i;
			while (++j < size) {
				if (score != results.get(j).getScore())
					break;
			}
			String pos = Integer.toString(i+1);
			if (j - i > 1)
				pos += "-" + j;
			for (; i < j; i++)
				results.get(i).setPosition(pos);
		}
	}
}
