package p1;

import java.util.ArrayList;

public class GenerateXML
{
	public static void main(String args[])
	{
		Employee e=new Employee();
		ArrayList<Employee> elist=new ArrayList<Employee>();
		XmlWriter xwriter=new XmlWriter();
		e.setID(10);
		e.setName("Rajesh");
		e.setDepartment("ECE");
		e.setSalary(10000.00);
		elist.add(e);
		e=new Employee();
		e.setID(101);
		e.setName("Ankit");
		e.setDepartment("CSE");
		e.setSalary(20000.00);
		elist.add(e);
		xwriter.GenerateXMLforEmployeeCollection(elist);
	}
}
