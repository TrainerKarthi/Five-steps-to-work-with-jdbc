package com.tyss.First;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UsingPreparedStatementAndInputFromUser {

	static Scanner os = new Scanner(System.in);
		public static void main(String[] args) 
		{
			String s = "com.mysql.cj.jdbc.Driver";
			String url ="jdbc:mysql://localhost:3306/first";
			String user_name = "root";
			String password = "root";
			String query = "Insert into employee values(?,?,?)";
			System.out.println("Enter Id");
			int id = os.nextInt();
			System.out.println("Enter name");
			String name = os.next();
			System.out.println("Enter phone Number");
			int phno = os.nextInt();
			try 
			{
				//1.load and register driver
				Class.forName(s);
				
				//2.Establish connection
				Connection connection = DriverManager.getConnection(url,user_name,password);
				
	
				//3.Create Statement
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				
				//4.execute statement
				preparedStatement.setInt(1, id);
				preparedStatement.setString(2, name);
				preparedStatement.setDouble(3, phno);
				preparedStatement.execute();
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
