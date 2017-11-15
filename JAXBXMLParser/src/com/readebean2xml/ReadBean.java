package com.readebean2xml;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.Customer;

public class ReadBean {

	public static void main(String[] args) {
		 try {

				File file = new File("C:\\My Workspace\\JAXBXMLParser\\BFile.xml");
				JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);
				System.out.println("Age : "+customer.getAge()+", Id : "+customer.getId()+", Name : "+customer.getName());

			  } catch (JAXBException e) {
				e.printStackTrace();
			  }
	}
}
