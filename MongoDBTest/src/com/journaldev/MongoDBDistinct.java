package com.journaldev;


import java.net.UnknownHostException;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongoDBDistinct {
	 public static void main(String[] args) throws UnknownHostException{
		// Get a new connection to the db assuming it is running.
			MongoClient mongoClient = new MongoClient("localhost");
			// use test as the database. Use your database here.
			DB db = mongoClient.getDB("test");

			DBCollection coll = db.getCollection("car");
			//call distinct method and store the result in list l1
	        List cl1= coll.distinct("speed");
	        
	        //iterate through the list and print the elements
	        for(int i=0;i<cl1.size();i++){
	            System.out.println(cl1.get(i));
	        }
	     
	        //condition to fetch the car document whose speed is greater than 50
	        DBObject o1 = new BasicDBObject("speed",new BasicDBObject("$gt",50));
	        
	        //call distinct method by passing the field name and object o1
	        List l1= coll.distinct("name", o1);
	        
	        System.out.println("-----------------------");
	        
	        for(int i=0;i<l1.size();i++){
	            System.out.println(l1.get(i));           
	        }
	        
	    }
}
