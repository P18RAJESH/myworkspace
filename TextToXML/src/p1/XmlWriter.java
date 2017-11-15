package p1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class XmlWriter 
{
	public static XMLStreamWriter generateXMLForSingleEmployee( Employee emp,XMLStreamWriter writer) throws XMLStreamException
	{
		
		writer.writeCharacters("\n");
		writer.writeStartElement("Employee");
		writer.writeCharacters("\n");
		writer.writeStartElement("ID");
		writer.writeCharacters(emp.getID().toString());
		writer.writeEndElement();
		writer.writeCharacters("\n");
		writer.writeStartElement("NAME");
		writer.writeCharacters(emp.getName());
		writer.writeEndElement();
		writer.writeCharacters("\n");
		writer.writeStartElement("DEPARTMENT");
		writer.writeCharacters(emp.getDepartment());
		writer.writeEndElement();
		writer.writeCharacters("\n");
		writer.writeStartElement("SALARY");
		writer.writeCharacters(emp.getSalary().toString());
		writer.writeEndElement();
		writer.writeCharacters("\n");
		writer.writeEndElement();
		return writer;
	}

	public void GenerateXMLforEmployeeCollection(ArrayList<Employee> employees) 
	{

		System.out.println("Started writing to XML !!");
		try {
		XMLOutputFactory factory = XMLOutputFactory.newInstance();
		XMLStreamWriter writer = factory.createXMLStreamWriter(new FileOutputStream("C:\\My Workspace\\TextToXML\\src\\Test.xml"));
		writer.writeStartDocument();
		writer.writeCharacters("\n");
		writer.writeStartElement("Employees");
		for(Employee e:employees)
		{
			writer=generateXMLForSingleEmployee(e,writer);
		}
		writer.writeCharacters("\n");
		writer.writeEndElement();
		writer.writeCharacters("\n");
		writer.writeEndDocument();
		writer.close();
		System.out.println("Finished writing to XML !!");
		} 
		catch (XMLStreamException e)
		{
			e.printStackTrace();
		}
		catch (FileNotFoundException e2) 
		{
			e2.printStackTrace();
		} 
	}

}
