package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static DBConnection singleInstance = null;
	
	public static DBConnection getSingleInstance()
	{
		if(singleInstance == null)
		{
			singleInstance = new DBConnection();
		}
		return singleInstance;
	}
	
	public static Connection getConnection()
	{
         Connection myConnection = null;		
	     String userName, password, service, url;
		
		 userName = "vehiclesfleetdb" ;
		 password = "123" ;
		 service = "localhost" ;
		
		 url = "jdbc:oracle:thin:";
		
		try {
			
	            myConnection = DriverManager.getConnection(url + userName + "/" + password + "@" + service);
	     	    
	            System.out.println("Connection successful");
		
		} catch (SQLException ex) {
			  ex.printStackTrace();
			      System.out.println("Connection failed  ");
		}
		
		return myConnection;		
	}
}
