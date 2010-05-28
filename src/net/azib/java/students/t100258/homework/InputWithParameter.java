package net.azib.java.students.t100258.homework;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * InputWithParameter
 *
 * @author mihkel
 */
public interface InputWithParameter {
	
	
	ArrayList <Object> getResults(String s) throws FileNotFoundException, IOException, SQLException;

}
