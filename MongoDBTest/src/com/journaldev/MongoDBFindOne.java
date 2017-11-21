package com.journaldev;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;

public class MongoDBFindOne {
	
	public static void main(String[] args) throws UnknownHostException {
		
		MongoClient mongoClient = new MongoClient("localhost");
		DB db = mongoClient.getDB("test");
		DBCollection coll = db.getCollection("col");
		
		// invoking findOne() method
				DBObject doc = coll.findOne();

		// prints the resultant document
				System.out.println(doc);
				System.out.println("------------------------------------------");
		// query to filter the document based on name and speed values by
		// creating new object
				DBObject query = new BasicDBObject("name", "Zen").append("speed",
						new BasicDBObject("$gt", 30));
		// resultant document fetched by satisfying the criteria
				DBObject d1 = coll.findOne(query);

		// prints the document on console
				System.out.println(d1);
				System.out.println("------------------------------------------");
				
				
				// creates new db object
				BasicDBObject b1 = new BasicDBObject();

				// criteria to display only name and color fields in the resultant
				// document
				BasicDBObject fields = new BasicDBObject("name", 1).append("color", 1).append("_id", 0);

				// method that retrieves the documents by accepting fields and object
				// criteria
				DBObject d2 = coll.findOne(b1, fields);

				System.out.println(d2);
				System.out.println("------------------------------------------");
				
				
				// filter criteria for car name volkswagen
				DBObject query1 = new BasicDBObject("name", "Volkswagen");

				// excluding the fields mfdcountry,cno and id fields
				BasicDBObject fields1 = new BasicDBObject("mfdcountry", 0).append("cno",
						0).append("_id", 0);

				DBObject d11 = coll.findOne(query1, fields1);
				System.out.println(d11);
				System.out.println("------------------------------------------");
				
				DBObject d12 = coll.findOne();
				
				// prints only the name of the car
				System.out.println((d12.get("name")));
	}

}
