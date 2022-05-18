package com.tyss.UsingStandards;

public class Test1
{

	public static void main(String[] args) 
	{
		EmployeeDao emd = new EmployeeDao();
		Employee employee = emd.getEmloyee(6);
//		employee.setId(6);
//		employee.setName("Karthik");
//		employee.setPhoneNum(67890);
//		emd.saveEmployee(employee);
		
		if(employee!=null) {
			System.out.println(employee);
		}
		else
			System.out.println("no data found");
		
	}

}
