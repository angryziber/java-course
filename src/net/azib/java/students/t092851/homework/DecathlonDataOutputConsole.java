package net.azib.java.students.t092851.homework;

/**
 * DecathlonDataOutputConsole
 *
 * @author Lauri
 */
public class DecathlonDataOutputConsole implements DecathlonDataOutput {

	@Override
	public boolean writeData(DecathlonData data) {
		if (data == null) {
			System.out.println("No records to display.");
			return false;
		}
		System.out.println(data);
		return true;
	}
}
