package com.writebean2xml;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesXMLWrite {
	
	public static void main(String[] args) throws IOException
    {
		
    	Properties props = new Properties();
    	props.setProperty("name", "Rajesh");
    	props.setProperty("id", "1008110");
    	props.setProperty("age", "28");
    	//where to store?
    	OutputStream os = new FileOutputStream("C:\\My Workspace\\JAXBXMLParser\\PFile.xml");

    	//store the properties detail into a pre-defined XML file
    	props.storeToXML(os, "Employee","UTF-8");

    	System.out.println("Done");
    }

}
