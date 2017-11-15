package com.journaldev;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
//A simple program inserting a single document using MongoCollection.insertOne method.
public class MongoDBInsertExample {

	public static void main(String[] args) throws UnknownHostException {

		MongoClient mongo = new MongoClient("localhost", 27017);
		MongoDatabase db = mongo.getDatabase("journaldev");

		MongoCollection<Document> col = db.getCollection("Persons");

		//Inserting single documnet
		//Document document = new Document();
		//document.append("name", "Pankaj");
		//document.append("country", "USA");

		//jSON string also can be inserted
		String json = "{ 'name' : 'Pankaj', 'country' : 'USA' }";
		Document document = Document.parse(json);
		
		//We can insert a Map easily as a document
		//Map<String,Object> dataMap = new HashMap<String,Object>();
		//dataMap.put("name", "Pankaj");
		//dataMap.put("country", "USA");
		//dataMap.put("_id",new ObjectId("123459789012".getBytes()));

		//Document document = new Document(dataMap);
		
		//We can also pass our own id parameter like below.
		//document.append("_id",new ObjectId("123456789012".getBytes()));
		//minimum byte array length should be 12 otherwise it will through ilegal exception
		//document.append("_id", new ObjectId(new Date())); 
		// ObjectId constructor also takes Date as argument
		
		col.insertOne(document);

		System.out.println("ID Generated=" + document.getObjectId("_id").toString());
		mongo.close();
		// inserting multiple documents 
		/*List<Document> docs = new ArrayList<>();
		docs.add(new Document("name", "Pankaj"));
		docs.add(new Document().append("name", "David"));
		
		col.insertMany(docs);
		
		for(Document doc : docs) {
			System.out.println("Name="+doc.getString("name")+", ID="+doc.getObjectId("_id").toString());
		}
		mongo.close();*/
	}

}