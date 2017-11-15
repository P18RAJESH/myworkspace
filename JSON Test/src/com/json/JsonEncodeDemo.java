package com.json;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

class JsonEncodeDemo {

	public static void main(String[] args) {
		JSONObject obj = new JSONObject();

		obj.put("name", "foo");
		obj.put("num", new Integer(100));
		obj.put("balance", new Double(1000.21));
		obj.put("is_vip", new Boolean(true));

		System.out.print(obj);
		System.out.println("Ordered List !!!!");
		System.out.println(JSONValue.toJSONString(obj));
	}
}