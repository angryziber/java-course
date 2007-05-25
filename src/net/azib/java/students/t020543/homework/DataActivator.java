package net.azib.java.students.t020543.homework;



public class DataActivator {

	public static void main(String[] args) throws Exception {

		DataAcessor db = new DataAcessor();
		
		db.initializeConnection("“jdbc:mysql://srv.azib.net:3306", "java", "java");
		db.releaseConnection();
		

	}

}
