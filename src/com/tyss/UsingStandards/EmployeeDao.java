package com.tyss.UsingStandards;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

public class EmployeeDao 
{
	public void saveEmployee(Employee employee)
	{
		String s = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/first";
		String userName = "root";
		String password = "root";
		String sql = "INSERT INTO employee values(?,?,?)";
		
		try 
		{
			//1.load and register
			Class.forName(s);
			
			//2.establish connection
			Connection connection = DriverManager.getConnection(url,userName,password);
			
			//3.establish the statement
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			//4.execute the statement
			preparedStatement.setInt(1, employee.getId());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setInt(3, employee.getPhoneNum());
			preparedStatement.execute();
			
			//5.close the connection
			connection.close();
			System.out.println("Data Added successfully");
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public Employee getEmloyee(int id)
	{
		String url = "jdbc:mysql://localhost:3306/first";
		String uname = "root";
		String pwd ="root";
		String sql = "Select * from employee where id =?";
		
		
		Connection connection=null;
		
		try
		{
			//1.load and registration
			Driver d = new Driver();
			DriverManager.registerDriver(d);
			
			//2.Establish the connection
			connection= DriverManager.getConnection(url,uname,pwd);
			
			//3.Establish the statement
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			//4.Execute the statement/query
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				Employee employee=new Employee();
				employee.setId(resultSet.getInt(1));
				employee.setName(resultSet.getString(2));
				employee.setPhoneNum(resultSet.getInt(3));
				return employee;
			}
			
		
			
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
