package com.tyss.First;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class UsingStatementInterface
{

	public static void main(String[] args) 
	{
		String s = "com.mysql.cj.jdbc.Driver";
		String url ="jdbc:mysql://localhost:3306/first";
		String user_name = "root";
		String password = "root";
		try 
		{
			//1.load and register driver
			Class.forName(s);
			
			//2.Establish connection
			Connection connection = DriverManager.getConnection(url,user_name,password);
			
			
			
			//3.Create Statement
			
			Statement statement = connection.createStatement();
			//here we do hard coding

			
			//4.execute statement
			statement.execute("INSERT INTO employee VALUES(3,'bad',947)");
			//if we want to get the details from the user then we go for PreparedStatement
			
			//5.close the connection
			connection.close();
			System.out.println("Data added");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
