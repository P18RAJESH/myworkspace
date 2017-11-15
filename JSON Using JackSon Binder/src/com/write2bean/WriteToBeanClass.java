package com.write2bean;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.fasterxml.jackson.core.JsonGenerationException;

public class WriteToBeanClass {

	public static void main(String[] args) {

		ObjectMapper mapper = new ObjectMapper();

		// For testing
		List<Staff> staff = createDummyObject();

		try {
			// Convert object to JSON string and save into file directly
			mapper.writeValue(new File("C:\\My Workspace\\JSON Using JackSon Binder\\writefile.json"), staff);

			// Convert object to JSON string
			String jsonInString = mapper.writeValueAsString(staff);
			// System.out.println(jsonInString);

			// Convert object to JSON string and pretty print
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff);
			System.out.println(jsonInString);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<Staff> createDummyObject() {
		Staff staff = new Staff();
		List<Staff> s = new ArrayList<Staff>(5);
		staff.setName("Rajesh");
		staff.setAge(25);
		staff.setPosition("Developer");
		staff.setSalary(45000.00);

		List<String> skills = new ArrayList<>();
		skills.add("java");
		skills.add("sql");
		skills.add("unix");

		staff.setSkills(skills);
		Staff staff2 = new Staff();
		staff2.setName("Raje");
		staff2.setAge(2);
		staff2.setPosition("Dev");
		staff2.setSalary(4500.00);

		List<String> skills2 = new ArrayList<>();
		skills2.add("-java");
		skills2.add("-sql");
		skills2.add("-unix");

		staff2.setSkills(skills2);
		s.add(staff);
		s.add(staff2);
		System.out.println(s.size());
		return s;
	}
}
