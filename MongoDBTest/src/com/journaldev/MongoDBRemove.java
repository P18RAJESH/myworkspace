package com.journaldev;
import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

public class MongoDBRemove {
	 public static void main(String[] args) throws UnknownHostException {
		 
		// Get a new connection to the db assuming that it is running
	        MongoClient m1 = new MongoClient();
	 
	        // use test as a database,use your database here
	        DB db = m1.getDB("test");
	 
	        // fetch the collection object ,car is used here,use your own
	        DBCollection coll = db.getCollection("car");
	        
	     // builds query for car whose speed is less than 45
	        BasicDBObject b1 = new BasicDBObject("speed", new BasicDBObject("$lt",
	                45));
	 
	        // invoke remove method
	        WriteResult c1 = coll.remove(b1);
	 
	        // print the number of documents using getN method
	        System.out.println("Number of documents removed:" + c1.getN());
	        
	        //Remove single document
	        BasicDBObject b = new BasicDBObject("speed", new BasicDBObject("$gt",
	                45));
	 
	        // invoke findOne so that the first document is fetched
	        DBObject doc = coll.findOne(b); // get first document
	 
	        // remove the document fetched using findOne method
	        WriteResult r1 = coll.remove(doc);
	 
	        System.out.println("------------------------------------");
	 
	        System.out.println("Number of documents removed:" + r1.getN());
	        
	        
	        // remove all documents in the collection with empty object
	        WriteResult r = coll.remove(new BasicDBObject());
	 
	        System.out.println("------------------------------------");
	 
	        System.out.println("Number of documents removed:" + r1.getN());
	 
	    }
}
