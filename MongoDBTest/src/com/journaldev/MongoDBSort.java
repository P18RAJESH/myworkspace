package com.journaldev;
import java.net.UnknownHostException;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
public class MongoDBSort {
	public static void main(String[] args) throws UnknownHostException {
		// Get a new connection to the db assuming that it is running
				MongoClient m1 = new MongoClient("localhost");

				// use test as a datbase,use your database here
				DB d1 = m1.getDB("test");

				// fetch the collection object ,car is used here,use your own
				DBCollection coll = d1.getCollection("car");

				// find method is called and result stored in cursor
				DBCursor car = coll.find();

				// sorting the cursor based in ascending order based on name field
				car.sort(new BasicDBObject("name", 1));
				
				// sorting the cursor based in descending order based on speed field
				car.sort(new BasicDBObject("speed", -1));
				
				// sort speed in descending order then name in ascending order
				car.sort(new BasicDBObject("speed", -1).append("name", 1));
				
				DBObject q1 = new BasicDBObject("speed", new BasicDBObject("$gt", 15));

				BasicDBObject fields = new BasicDBObject("name", 1).append("speed", 1);
				// find method is called and result stored //fetch the collection object
				// ,car is used here,use your ownin cursor
				DBCursor car2 = coll.find(q1, fields);

				// sorting the cursor based in ascending order based on name field
				car2.sort(new BasicDBObject("name", -1)).limit(2);
				
				// sorting the cursor based in ascending order based on name field
				car.sort(new BasicDBObject("$natural", -1));
				
	}
}
