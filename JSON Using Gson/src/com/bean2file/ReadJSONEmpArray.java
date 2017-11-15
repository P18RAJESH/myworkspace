package com.bean2file;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ReadJSONEmpArray {

	public static void main(String[] args) {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		try (Reader reader = new FileReader("C:\\My Workspace\\JSON Using Gson\\ArrayObject.json")) {
			Employee emp = gson.fromJson(reader, Employee.class);
			System.out.println("employee with id < "+emp.getNumber()+" > Json object is :");
			String jsonInString = gson.toJson(emp);
			System.out.println(jsonInString);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
