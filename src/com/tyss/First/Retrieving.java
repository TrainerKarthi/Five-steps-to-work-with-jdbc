package com.tyss.First;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Retrieving
{

	public static void main(String[] args) 
	{
		String s = "com.mysql.cj.jdbc.Driver";
		String url ="jdbc:mysql://localhost:3306/first";
		String user_name = "root";
		String password = "root";
		String query = "Select * from employee";
		try 
		{
			//1.load and register driver
			Class.forName(s);
			
			//2.Establish connection
			Connection connection = DriverManager.getConnection(url,user_name,password);
			
			//3.Create Statement
			Statement statement = connection.createStatement();
			
			//4.execute statement
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next())
			{
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getInt(3));
				System.out.println("=================");
			}
			
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
