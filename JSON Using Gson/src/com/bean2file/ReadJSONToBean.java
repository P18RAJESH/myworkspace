package com.bean2file;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ReadJSONToBean {
	
	public static void main(String[] args) {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try (Reader reader = new FileReader("C:\\My Workspace\\JSON Using Gson\\writeJSON.json")) {

			Staff staff []= gson.fromJson(reader, Staff[].class);
			String jsonInString = gson.toJson(staff[0]);
			System.out.println("object 1 :\n"+jsonInString);
			jsonInString = gson.toJson(staff[1]);
			System.out.println("Object 2 :\n"+ jsonInString);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
