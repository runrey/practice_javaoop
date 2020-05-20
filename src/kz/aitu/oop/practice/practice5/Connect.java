package kz.aitu.oop.practice.practice5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
	private Connection con;
	private Statement stmt;
	private static boolean isConnected;
	
	public Connect(String hostname, String portname, String username, String pass, String dbName) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");  
		this.con = DriverManager.getConnection("jdbc:mysql://" + hostname + ":" + portname + "/" + dbName+"", username, pass);   
		this.stmt = con.createStatement();
		Connect.setConnected(true);
	}
	
	public void closeCon() throws SQLException {
		con.close();
	}
	
	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

	public static boolean isConnected() {
		return isConnected;
	}

	public static void setConnected(boolean isConnected) {
		Connect.isConnected = isConnected;
	}
}
