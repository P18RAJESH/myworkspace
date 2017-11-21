package com.journaldev;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongoDBFindAndModify {
	public static void main(String[] args) throws UnknownHostException {
		// Get a new connection to the db assuming it is running.
		MongoClient mongoClient = new MongoClient("localhost");
		// use test as the database. Use your database here.
		DB db = mongoClient.getDB("test");

		DBCollection coll = db.getCollection("car");
		
		// insert some test data to start with.
		BasicDBObject obj = new BasicDBObject();
		obj.append("name", "Volkswagen");
		obj.append("color", "JetBlue");
		obj.append("cno", "H672");
		obj.append("speed", 62);
		obj.append("mfdcountry", "Italy");
		coll.insert(obj);
		
		// findAndModify operation. Update colour to blue for cars having speed
		// < 45
		DBObject query = new BasicDBObject("speed",new BasicDBObject("$lt", 45));
		DBObject update = new BasicDBObject();
		update.put("$set", new BasicDBObject("color", "Blue"));
		DBCursor cursor = coll.find();
		try {
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}
		} finally {
			cursor.close();
		}
		System.out.println("-----------------------------------");
		coll.findAndModify(query, update);
}

}
