package com.my.employee;

public class Employee {
	public Employee()
	{
		System.out.println("Object Created !!! in constructer");
	}
	public void hello()
	{
		System.out.println("hellomethod called");
	}
	static
	{
		System.out.println("Static block executed");
	}

}
