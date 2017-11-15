package com.utility;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoConnection {
	
	
	public static MongoClient getConnection() 
	{
		MongoClient mclient=null;
		String dbURI = "mongodb://localhost";
		try 
		{
			if(mclient==null)
			{
			 mclient = new MongoClient(new MongoClientURI(dbURI));
			}
			System.out.println("Sucessfully Connected to MongoDB !!!");
		} 
		catch (Exception e) 
		{
			System.out.println("Failed to establish connection to MongoDB !!!");
			System.out.println(e.getMessage());
		}
		return mclient;
	}
	
	public static MongoClient closeConnection(MongoClient con)
	{
		if (con != null) {
			System.out.println("MongoClient connection closed !!!");
			con.close();
			return null;
		} else {
			System.out.println("MongoClient connection already closed !!!");
			return null;
		}
	
	}

}
