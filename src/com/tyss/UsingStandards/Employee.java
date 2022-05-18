package com.tyss.UsingStandards;

public class Employee
{
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phoneNum=" + phoneNum + "]";
	}
	private int id;
	private String name;
	private int phoneNum;
	public int getId()
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public int getPhoneNum()
	{
		return phoneNum;
	}
	public void setPhoneNum(int phoneNum)
	{
		this.phoneNum = phoneNum;
	}
	
}
