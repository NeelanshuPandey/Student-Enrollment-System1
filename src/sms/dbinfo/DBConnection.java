package sms.dbinfo;

import java.sql.*;

public class DBConnection {

	
	
	private static Connection con;
	
	public static Connection createConnection()
	{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms_db","root","Manu@8808");
		}
		catch(ClassNotFoundException|SQLException cne) {
			cne.printStackTrace();
		}
		return con;
	}
	
	public static void main(String[] args) {
		Connection c=createConnection();
		System.out.println(c);
	}
	
}
