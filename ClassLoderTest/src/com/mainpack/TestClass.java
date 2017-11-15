package com.mainpack;

import com.my.employee.Employee;

public class TestClass {
	static {
		System.out.println("Test Class static block executed");
	}
	public static void main(String[] args) throws NoSuchMethodException, SecurityException 
	{
		System.out.println("in main method");
		ClassLoader classLoader = TestClass.class.getClassLoader();
		 try {
		       // Class myClass = classLoader.loadClass("com.my.employee.Employee");
		        Class myClass = Class.forName("com.my.employee.Employee");
		        System.out.println("myClass.getName() = " + myClass.getName());
		        System.out.println("myClass.getMethods() = "+ myClass.getMethod("hello"));
		       new Employee();
		    } catch (ClassNotFoundException e) {
		        e.printStackTrace();
		    }
	}

}
