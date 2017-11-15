package com.readebean2xml;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesXMLRead {

	 public static void main(String[] args) throws IOException
	    {
	    	Properties props = new Properties();

	    	InputStream is = new FileInputStream("C:\\My Workspace\\JAXBXMLParser\\PFile.xml");
	    	//load the xml file into properties format
	    	props.loadFromXML(is);

	    	String name = props.getProperty("name");
	    	String age = props.getProperty("age");
	    	String id = props.getProperty("id");
	    	
	    	System.out.println("Name : "+ name +", Age : "+ age+", ID : "+id);

	    }
}
