package net.azib.java.students.t010687;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class jbsJDBCServletMysql extends HttpServlet {


//*****  Servlet access to data base


    public void doGet (HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException
	{

    	String url   = "jdbc:mysql://sparrow.cs.unc.edu/jbsdb";

    	String query = "SELECT * FROM Person "
        + "WHERE owner = 'jbs'";
						
	try {

		Class.forName  ("com.mysql.jdbc.Driver");
      		//Class.forName("org.gjt.mm.mysql.Driver");

      		Connection con = DriverManager.getConnection 
		  ( url, "your_mysgl_login", "your_mysgl_password" );

            Statement stmt = con.createStatement ();

            ResultSet rs = stmt.executeQuery (query);

            printResultSet ( resp, rs );

            rs.close();
            stmt.close();
            con.close();

        }  // end try

        catch (SQLException ex) {
            
		PrintWriter out = resp.getWriter();
	        resp.setContentType("text/html");
			
		while (ex != null) {  
                	out.println ("SQL Exception:  " + ex.getMessage ());
                	ex = ex.getNextException ();  
              }  // end while

        }  // end catch SQLException

        catch (java.lang.Exception ex) {

      	PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");	
		out.println ("Exception:  " + ex.getMessage ());
	  }

    }  // end doGet


    private void printResultSet ( HttpServletResponse resp, ResultSet rs )
        throws SQLException  {

        try  {

		PrintWriter out = resp.getWriter();

	        out.println("<html>");
	        out.println("<head><title>jbs jdbc/mysql servlet</title></head>");
	        out.println("<body>");
	        out.println("<center><font color=AA0000>");
	        out.println("<h3>jbsJDBCServlet</h3>");
	        out.println("<h3>Data Retrieved:</h3>");
	        
	        out.println("<table border='1'>");

           	int numCols = rs.getMetaData().getColumnCount ();
                while ( rs.next() ) {
		  out.println("<tr>");
               	  for (int i=1; i<=numCols; i++) {
                    out.print("<td>" + rs.getString(i) + "</td>" );
                  }  // end for
                  out.println("</tr>");
                }  // end while

	        out.println("</table>");
	        
	        out.println("</font></center>");
	        out.println("</body>");
	        out.println("</html>");
	        out.close();

	    }  // end try
        catch ( IOException except)  {
        }  // end catch

    }  // end returnHTML


}  // end jbsJDBCServlet