package com.bean2file;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class WriteBeanToJSON {

	public static void main(String[] args) {

		List<Staff> staff = createDummyObject();

		Gson gson = new Gson();
		String json = gson.toJson(staff);
		System.out.println(json);

		try (FileWriter writer = new FileWriter("C:\\My Workspace\\JSON Using Gson\\writeJSON.json")) {

			gson.toJson(staff, writer);
			// gson.toJson(staff.get(1), writer);

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
