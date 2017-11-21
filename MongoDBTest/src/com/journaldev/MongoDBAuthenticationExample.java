package com.journaldev;

import java.net.UnknownHostException;
import java.util.Arrays;
 
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
 
public class MongoDBAuthenticationExample {
 
    public static void main(String[] args) throws UnknownHostException {
 
        // create user with username,password and specify the database name
        MongoCredential credential = MongoCredential.createCredential(
                "Adam", "admin", "admin".toCharArray());
 
        // create an instance of mongoclient
        MongoClient mongoClient = new MongoClient(new ServerAddress(),
                Arrays.asList(credential));
 
        // get the test db useyour own here
        DB db = mongoClient.getDB("admin");
 
        // get the car collection
        DBCollection coll = db.getCollection("car");
 
        // create new car object to insert
        BasicDBObject b1 = new BasicDBObject("name", "Qualis");
 
        // shows user privileges
        DBObject d1 = new BasicDBObject("usersInfo", new BasicDBObject("user",
                "journaldev").append("db", "admin")).append("showPrivileges", true);
 
        // insert new document
        coll.insert(b1);
 
        // execute the command for privileges
        System.out.println(db.command(d1));
 
        // cursor to store the result
        DBCursor c = coll.find();
        // iterate through cursor
        try {
            while (c.hasNext()) {
 
                System.out.println(c.next());
            }
        } finally {
            c.close();
        }
 
    }
 
}