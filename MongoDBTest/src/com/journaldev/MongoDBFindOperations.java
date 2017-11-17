package com.journaldev;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class MongoDBFindOperations {
	
	public static void main(String[] args) {
		
	
	// Get a new connection to the db assuming that it is running
			MongoClient mongoClient = new MongoClient("localhost");

			// //use test as a datbase,use your database here
			DB db = mongoClient.getDB("test");
			
			// //fetch the collection object ,car is used here,use your own
			DBCollection coll = db.getCollection("col");

			// //invoking find() method and storing the result in carCursor
			
			DBCursor carCursor =coll.find();
			
			// printing the cursor contents
			try {
				while (carCursor.hasNext()) {
					System.out.println(carCursor.next());
				}
			} finally {
				carCursor.close();// close the cursor
			}
			
			// method to retrieve documents based on the selection criteria
			
			// criteria specified as speed greater than 50
			DBObject query = new BasicDBObject("speed",
					new BasicDBObject("$gt", 50));
			// /result stored in cursor using find() method
			DBCursor carCursor1 = coll.find(query);
			System.out
					.println("нннннннннннннннннннннннннннннннннннннннннннннннннннннн");
			try {
				while (carCursor1.hasNext()) {
					System.out.println(carCursor1.next());
				}
			} finally {
				carCursor1.close();
			}
			
			
			//equlity criteria to select records
			// criteria with id 3 is specified
			DBObject query1 = new BasicDBObject("_id", 3);
			DBCursor c1 = coll.find(query1);
			System.out
					.println("нннннннннннннннннннннннннннннннннннннннннннннннннннннн");
			try {
				while (c1.hasNext()) {
					System.out.println(c1.next());
				}
			} finally {
				c1.close();
			}
			
			
			// criteria with speed greater than 40 and less than 65
			DBObject query2 = new BasicDBObject("speed",
					new BasicDBObject("$gt", 40).append("$lt", 65));
			DBCursor carCursor2 = coll.find(query);
			System.out
					.println("нннннннннннннннннннннннннннннннннннннннннннннннннннннн");
			try {
				while (carCursor2.hasNext()) {
					System.out.println(carCursor2.next());
				}
			} finally {
				carCursor2.close();
			}
			
			
			// fields with name and speed field is specified and only these fields
			// are displayed
			BasicDBObject fields = new BasicDBObject("name", 1).append("speed", 1);
			 carCursor1 = coll.find(query, fields);
			System.out
					.println("нннннннннннннннннннннннннннннннннннннннннннннннннннннн");
			try {
				while (carCursor1.hasNext()) {
					System.out.println(carCursor1.next());
				}
			} finally {
				carCursor1.close();
			}
			
			
			 query = new BasicDBObject("speed",
					new BasicDBObject("$gt", 65));
			// excluding mfdcountry and cno fields by setting to 0
			 fields = new BasicDBObject("mfdcountry", 0).append("cno",
					0);
			 carCursor1 = coll.find(query, fields);
			System.out
					.println("нннннннннннннннннннннннннннннннннннннннннннннннннннннн");
			try {
				while (carCursor1.hasNext()) {
					System.out.println(carCursor1.next());
				}
			} finally {
				carCursor1.close();
			}
			
			
			 query = new BasicDBObject("speed",
					new BasicDBObject("$gt", 65)); // excluding id field by setting
													// to 0
			 fields = new BasicDBObject("_id", 0);
			 carCursor1 = coll.find(query, fields);
			System.out
					.println("нннннннннннннннннннннннннннннннннннннннннннннннннннннн");
			try {
				while (carCursor1.hasNext()) {
					System.out.println(carCursor1.next());
				}
			} finally {
				carCursor1.close();
			}
			System.out.println("----------------------------------------");
			 carCursor = coll.find();
			// sort the car collection in ascending order
			carCursor.sort(new BasicDBObject("name", 1));
			
			try {
				while (carCursor.hasNext()) {

					System.out.println(carCursor.next());
				}
			} finally {
				carCursor.close();
			}
			
			System.out.println("----------------------------------------");
			// limits to only 2 records
			 carCursor = coll.find().limit(2);
			
			try {
				while (carCursor.hasNext()) {

					System.out.println(carCursor.next());
				}
			} finally {
				carCursor.close();
			}
			
			coll = db.getCollection("col");
			// skips the first 10 records
			 carCursor = coll.find().skip(5);
			System.out.println("нннннннннннннннннннннннннннннннннннннннннннннннннннннн");
			try {
				while (carCursor.hasNext()) {
					System.out.println(carCursor.next());
				}
			} finally {
				carCursor.close();
			}
			
			DBCollection col = db.getCollection("col");
			 carCursor = col.find();
			// combining sort and limit methods
			carCursor.sort(new BasicDBObject("name", 1)).limit(2);
			System.out
					.println("нннннннннннннннннннннннннннннннннннннннннннннннннннннн");
			try {
				while (carCursor.hasNext()) {
					System.out.println(carCursor.next());
				}
			} finally {
				carCursor.close();
			}
	}

}
