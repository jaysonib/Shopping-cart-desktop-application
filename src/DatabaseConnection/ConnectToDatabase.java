package DatabaseConnection;

import java.sql.*;

public class ConnectToDatabase  {
	
	
	static final String jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static final String jdbcCon = "jdbc:sqlserver://localhost:1433;user=sa;password=pass@123;databaseName=shopping_data";
	public static Connection cn;
	//method to connect with a database;
	public static void connectionDatabase() {
		//first load jdbc Driver class with exception ClassNotFoundException
		//then provide connection String to the cn with SQLException
		try {
			Class.forName(jdbcDriver);
			cn = DriverManager.getConnection(jdbcCon);
		}catch(ClassNotFoundException e) {
			System.out.println("Class not found Exception 1");
		}catch(SQLException e) {
			System.out.println("Problem with driver manager Exception 2");
		}
		/*
		 * CallableStatement cstmt = null
		 * 
		 * (){
		 * String sql = "{call Brands_Table("0","1")}";
		 * cstmt = .preparedStatement(sql);
		 * }
		 * */
		
	}
	//To disconnect with database with SQLException
	public static void disconnectDatabase() {
		try {
			cn.close();
		}catch(SQLException e) {
			System.out.println("Error to closing database connection");
		}
	}
}