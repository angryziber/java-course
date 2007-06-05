package net.azib.java.students.t020543;



public class DataActivator {

	public static void main(String[] args) throws Exception {

		DataAcessor db = new DataAcessor();
		
		db.initializeConnection("jdbc:mysql://srv.azib.net:3306/decathlon?user=java&password=java");
		
		db.releaseConnection();
		

	}

}
