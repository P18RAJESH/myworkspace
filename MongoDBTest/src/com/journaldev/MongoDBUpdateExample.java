package com.journaldev;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

public class MongoDBUpdateExample {

	public static void main(String[] args) throws UnknownHostException {

		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("journaldev");
		
		DBCollection col = db.getCollection("Persons");
		
		//Update single field in a single document
				DBObject query = new BasicDBObject("name", "Pankaj");
				DBObject update = new BasicDBObject();
				update.put("$set", new BasicDBObject("country","India"));
				
				WriteResult result = col.update(query, update);
		
		//Update multiple field in a single document
				DBObject query = new BasicDBObject("name", "David");
				DBObject update = new BasicDBObject();
				update.put("$set", new BasicDBObject("country","India").append("name", "David New"));
				
				WriteResult result = col.update(query, update);
		
		//Add a new field in a single document
				DBObject query = new BasicDBObject("_id", 123);
				DBObject update = new BasicDBObject();
				update.put("$set", new BasicDBObject("city","San Jose"));
				
				WriteResult result = col.update(query, update);
		
		//Update sub-document in a single document
				DBObject query = new BasicDBObject("_id", 100);
				DBObject update = new BasicDBObject();
				update.put("$set", new BasicDBObject("address.city","Santa Clara"));
				
				WriteResult result = col.update(query, update);
		
		//Remove a field in a single document
				DBObject query = new BasicDBObject("_id", 100);
				DBObject update = new BasicDBObject();
				update.put("$unset", new BasicDBObject("address.city",""));
				
				WriteResult result = col.update(query, update);
		
		//insert document if no match found
				DBObject query = new BasicDBObject("name", "Lisa");
				DBObject update = new BasicDBObject();
				update.put("$set", new BasicDBObject("city","San Jose"));
				
				WriteResult result = col.update(query, update, true, false);
		
		//Update multiple document - $inc example
		DBObject query = new BasicDBObject("salary", new BasicDBObject("$lt", 9000));
		DBObject update = new BasicDBObject();
		update.put("$inc", new BasicDBObject("salary",1000));
		
		WriteResult result = col.updateMulti(query, update);
		mongo.close();
				
	}

}
