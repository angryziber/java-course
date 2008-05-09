package net.azib.java.students.t011861.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * DataInputModule
 *
 * @author 011861
 */

public class DataFromConsole {
	 /**
	 * Ask data from human
	 * @param String order - command to human
	 * @return String commandNumber - inserted symbol 
	 */
	List<String[]> athletesDatas = new ArrayList<String[]>();
	private static final String[] sportsArts = {"100 m", "long jump", "shot put", "high jump", "400 m",
		"110 m hurdles", "discus throw", "pole vault", "javelin throw",
		"1500 m"};
	public List<String[]> getData() {
		return athletesDatas;
	}
	
	public DataFromConsole() throws Exception{
		BufferedReader in = null;
		List<String> athleteData = new ArrayList<String>();
		System.out.println("Please insert athlete's name: ");
		try {
			in = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
			String command = "";
			int i = 0;
			//Enter needed data
				while (true) 
					//Enter name
					{
						command = in.readLine();
							if (command.equals("quit"))
								break;
							switch (i) 
							{
							//Enter date of birth
							case 0: {
								athleteData.add(command);
								i++;
								System.out.println("Insert date of birth: ");
								}
								break;
								//Enter country code
							case 1: {
								athleteData.add(command);
								i++;
								System.out.println("Insert country code: ");
								}
								break;
								//Enter results
							case 2: {
								athleteData.add(command);
								i++;
								System.out.println("Insert results!");
								BufferedReader getResult = null;
								for (int j = 0; j < 10; j++)
								{
									System.out.println("Enter a "+sportsArts[j]+" result: ");
									getResult = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
									athleteData.add(getResult.readLine());
								}
									athletesDatas.add((String[]) athleteData.toArray(new String[athleteData.size()]));
									athleteData.clear();		
									i = 0;
									System.out.println("Insert new athlete's name or see results (quit)");
								}
								break;
							}
					}
			} catch (IOException e) 
				{
					System.out.println("Problems with reading from the console!");
				}
	}
}