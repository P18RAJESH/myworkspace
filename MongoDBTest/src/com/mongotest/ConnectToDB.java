package com.mongotest;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import java.util.Iterator;

import org.bson.Document;

import com.mongodb.MongoClient; 
import com.mongodb.MongoCredential;  

public class ConnectToDB { 
   
	public static void main( String args[] ) {  
	      
	      // Creating a Mongo client 
	      MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
	     
	      // Creating Credentials 
	      MongoCredential credential; 
	      credential = MongoCredential.createCredential("sampleUser", "mydb", 
	         "password".toCharArray()); 
	      System.out.println("Connected to the database successfully");  
	      
	      // Accessing the database 
	      MongoDatabase database = mongo.getDatabase("mydb");  
	      
	       // Creating a collection 
	      // System.out.println("Collection created successfully"); 
	     // database.createCollection("sampleCollection"); 
	      
	      MongoCollection<Document> collection = database.getCollection("sampleCollection"); 

	      //updating document
	      
	      collection.updateOne(Filters.eq("id", 15), Updates.set("likes", 1500));       
	      System.out.println("Document update successfully...");  
	      
	      //creating a document
	      Document document = new Document("title", "MongoDB") 
	    	      .append("id", 20)
	    	      .append("description", "database") 
	    	      .append("likes", 100) 
	    	      .append("url", "http://www.tutorialspoint.com/mongodb/") 
	    	      .append("by", "tutorials point");
	      
	      collection.insertOne(document); 
	      
	      System.out.println("Document inserted successfully"); 
	      
	      
	      // Getting the iterable object 
	      FindIterable<Document> iterDoc = collection.find(); 
	      int i = 1; 

	      // Getting the iterator 
	      Iterator it = iterDoc.iterator(); 
	    
	      while (it.hasNext()) {  
	         System.out.println(it.next());  
	      i++; 
	      }
	      
	      // Deleting the documents 
	      collection.deleteOne(Filters.eq("id", 13)); 
	      System.out.println("Document deleted successfully..."); 
	      
	   // Accessing the database 
	      System.out.println("Collection created successfully"); 
	      for (String name : database.listCollectionNames()) { 
	         System.out.println(name); 
	      } 
	      
	   // Dropping a Collection 
	      collection.drop(); 
	      System.out.println("Collection dropped successfully");
	      
	   }
}