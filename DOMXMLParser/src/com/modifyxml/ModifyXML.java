package com.modifyxml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ModifyXML {
	
	public static void main(String[] args) {
		try {
			String path="C:\\My Workspace\\DOMXMLParser\\MFile.xml";
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(path);
			// Get the root element
			Node company = doc.getFirstChild();
			// Get the staff element 
			// Node staff = company.getFirstChild();
			Node staff = doc.getElementsByTagName("staff").item(0);
			NamedNodeMap attr = staff.getAttributes();
			//update the staff attribute
			Node nodeAttr = attr.getNamedItem("id");
			nodeAttr.setTextContent("2");
			//Create a new element and append
			Element age = doc.createElement("age");
			age.appendChild(doc.createTextNode("28"));
			staff.appendChild(age);
			
			NodeList list = staff.getChildNodes();
			
			for (int i = 0; i < list.getLength(); i++) {

                Node node = list.item(i);

		   // get the salary element, and update the value
		   if ("salary".equals(node.getNodeName())) {
			node.setTextContent("2000000");
		   }

                //remove firstname
		   if ("firstname".equals(node.getNodeName())) {
			staff.removeChild(node);
		   }

		}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(path));
			transformer.transform(source, result);

			System.out.println("Done");
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
