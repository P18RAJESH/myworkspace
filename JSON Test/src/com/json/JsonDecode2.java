package com.json;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

class JsonDecode2 {

	public static void main(String[] args) {

		JSONParser parser = new JSONParser();

		String JString = "{\"balance\":1000.21,\"is_vip\":true,\"num\":100,\"name\":\"foo\"}";

		try {
			Object obj = parser.parse(JString);
			System.out.println(obj);
			// JSONArray array = (JSONArray) obj;
			// System.out.println(array.get(1));
		} catch (ParseException pe) {
			System.out.println("position: " + pe.getPosition());
			System.out.println(pe);
		}
	}
}
