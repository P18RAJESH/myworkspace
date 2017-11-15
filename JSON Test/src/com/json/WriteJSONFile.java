package com.json;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class WriteJSONFile {

	public static void main(String[] args) {

		JSONObject obj = new JSONObject();
		obj.put("name", "rajesh");
		obj.put("age", new Integer(25));

		JSONArray list = new JSONArray();
		list.add("TCS");
		list.add("DELOITTE");
		list.add("AMAZONE");

		obj.put("company", list);

		try (FileWriter file = new FileWriter("C:\\My Workspace\\JSON Test\\wfile.json")) {

			file.write(obj.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.print(obj);

	}

}
