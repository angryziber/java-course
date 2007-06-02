package net.azib.java.students.t030647.homework;

import java.text.ParseException;
/**
 * CompetitionData
 * Collects information about participants
 * @author Igor
 */
public class CompetitionData {
	
	private Competitor[] participants; 
	
	/**
	 * Store data about participants
	 * @param data 
	 * @throws ParseException
	 */
	public boolean setData(String[] data) throws ParseException {
		
		boolean ok = true;
		
		participants = new Competitor[data.length];
		for (int i =0 ; i < data.length; i++) {
			participants[i] = new Competitor();
			boolean ok2 = participants[i].setData(data[i]);
			if (!ok2) return false;
		}
		
		return ok;
		
	}

	/**
	 * Sends data about participants
	 * @return
	 */
	public String[] getData() {
		
		String[] outputData = null;
		String[][] data = null;
		if (participants.length!=0) {
			data = new String[participants.length][3];
			for (int i=0; i<participants.length; i++) {
				data[i][0] = String.valueOf(i+1);
				data[i][1] = String.valueOf(participants[i].getResult());
				data[i][2] = participants[i].toString();
			}
		}
		data = sortData(data);
		outputData = new String[data.length];
		for (int j=0; j<data.length; j++) {
			outputData[j] = data[j][0]+","+data[j][1]+","+data[j][2];
		}
		return outputData;
	}
	
	/**
	 * Sort participants according to their result
	 * @param data
	 * @return
	 */
	private String[][] sortData(String[][] data) {
		
		for (int i=0; i<data.length; i++) {
			int v1 = Integer.parseInt(data[i][1]);
			for (int j = i+1; j < data.length; j++) {
				int v2 = Integer.parseInt(data[j][1]);
				if (v2>v1) {
					String[] buf = data[i];
					data[i] = data[j];
					data[j] = buf;
					data[i][0] = String.valueOf(i+1);
					data[j][0] = String.valueOf(j+1);
					v1 = v2;
				}
				else if (v2 == v1) {
					String[] buf = data[i+1];
					data[i+1] = data[j];
					data[j] = buf;
					data[i+1][0] = String.valueOf(i+1);
					data[j][0] = String.valueOf(j+1);
					data[i][0] = String.valueOf((i+1)+"-"+(i+2));
					data[i+1][0] = String.valueOf((i+1)+"-"+(i+2));
				}
			}
		}
		
		return data;
	}
	
}
