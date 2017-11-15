package com.readfrombean;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.write2bean.Staff;

public class ReadJSONFromFile {

	public static void main(String[] args) {

		ObjectMapper mapper = new ObjectMapper();

		try {
			// Convert JSON string from file to Object
			//	Staff staff = mapper.readValue(new File("C:\\My Workspace\\JSON Using JackSon Binder\\writefile.json"),Staff.class);
			Staff staff[] = mapper.readValue(new File("C:\\My Workspace\\JSON Using JackSon Binder\\writefile.json"),
					Staff[].class);
			System.out.println(staff[0].getName()+","+staff[1].getName());
			// Convert JSON string to Object
			String jsonInString = "{\"name\":\"Raju\",\"age\":25,\"position\":\"Developer\",\"salary\":45000.0,\"skills\":[\"java\",\"sql\",\"unix\"]}";
			Staff Staff1 = mapper.readValue(jsonInString, Staff.class);
			System.out.println(Staff1.getName());

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
