package com.journaldev;


import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;

public class MongoDBExists {
	
	public static void main(String[] args) throws UnknownHostException {
		// Get a db connection
        MongoClient m1 = new MongoClient("localhost");
 
        // connect to test db,use your own here
        DB db = m1.getDB("test");
 
        // obtain the car collection
        DBCollection coll = db.getCollection("car");
     //@@@ method to check whether the field exists
        // checking whether regno field exists by setting exists to true
        DBObject query = new BasicDBObject("regno", new BasicDBObject("$exists", true));
        
     // store the documents in cursor car
        DBCursor car = coll.find(query);
 
        // iterate and print the contents of cursor
        try {
            while (car.hasNext()) {
                System.out.println(car.next());
            }
        } finally {
            // close the cursor
            car.close();
        }
        
        //@@@ method to check the fields along along with the criteria entered
        
        // check whether speed fields exists and speed greater than 80
        DBObject query1 = new BasicDBObject("speed", new BasicDBObject("$exists", true).append("$gt", 80));
 
         car = coll.find(query1);
 
        System.out.println("-----------------------------------");
        try {
            while (car.hasNext()) {
                System.out.println(car.next());
            }
        } finally {
            car.close();
        }
        
     // @@@@method to check the field does not exist
        // checking for mfdcountry field by setting exists to false
        DBObject query2 = new BasicDBObject("mfdcountry", new BasicDBObject("$exists", false));
 
          car = coll.find(query2);
 
        System.out.println("-------------------------------------------------");
        try {
            while (car.hasNext()) {
                System.out.println(car.next());
            }
        } finally {
            car.close();
        }
        
        // returns documents with null values
        DBObject query3 = new BasicDBObject("regno", new BasicDBObject(
                "$exists", true));
 
         car = coll.find(query3);
 
        System.out.println("---------------------------------------------");
        try {
            while (car.hasNext()) {
                System.out.println(car.next());
            }
        } finally {
            car.close();
        }
    }

}
