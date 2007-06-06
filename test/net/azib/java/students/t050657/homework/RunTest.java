package net.azib.java.students.t050657.homework;

/**
 * RunTest
 *
 * @author Boriss
 */
public class RunTest {
	
	public static void main(String[] args) {
		 org.junit.runner.JUnitCore.main("net.azib.java.students.t050657.homework.dao.CompetitionDaoTest");
		 org.junit.runner.JUnitCore.main("net.azib.java.students.t050657.homework.dao.ResultsDaoTest");
		 org.junit.runner.JUnitCore.main("net.azib.java.students.t050657.homework.model.AthletTest");
		 org.junit.runner.JUnitCore.main("net.azib.java.students.t050657.homework.model.DecathlonCoeficientTest");
		 org.junit.runner.JUnitCore.main("net.azib.java.students.t050657.homework.model.ResultTest");
	}
}
