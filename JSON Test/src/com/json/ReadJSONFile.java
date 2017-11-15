package com.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSONFile {

	public static void main(String[] args) {

		JSONParser parser = new JSONParser();

		try {
			Object obj = parser.parse(new FileReader("C:/My Workspace/JSON Test/file.json"));

			JSONArray array = (JSONArray) obj;
			for (int i = 0; i < array.size(); i++) {
				JSONObject jsonObject = (JSONObject) array.get(i);

				String name = (String) jsonObject.get("name");
				System.out.println("NAME :" + name);

				String city = (String) jsonObject.get("city");
				System.out.println("CITY :" + city);

				String job = (String) jsonObject.get("job");
				System.out.println("JOB :" + job);

				System.out.print("CARS : [");
				JSONArray cars = (JSONArray) jsonObject.get("cars");
				Iterator<String> iterator = cars.iterator();
				while (iterator.hasNext()) {
					System.out.print(" " + iterator.next() + ",");
				}
				System.out.print(" ]\n\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
