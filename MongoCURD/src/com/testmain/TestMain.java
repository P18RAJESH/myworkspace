package com.testmain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;

import com.bean.Employee;
import com.dao.EmployeeDao;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.utility.MongoConnection;

public class TestMain {
	
	public static void main(String[] args) {
		Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
		mongoLogger.setLevel(Level.SEVERE);
		menu();
	}
	
	public static void menu()
	{
		System.setProperty("DEBUG.MONGO", "false");
		int ch1=0;
		int emp_id =0;
		String db=null;
		EmployeeDao edao=new EmployeeDao();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter collection name : ");
        db = sc.nextLine();
		while(true)
		{	for (int i = 0; i < 50; ++i) System.out.println();
			System.out.println("        Employee Menu        ");
			System.out.println("=============================");
			System.out.println("  1. INSERT RECORD           ");
			System.out.println("  2. UPDATE RECORD           ");
			System.out.println("  3. DELETE RECORD           ");
			System.out.println("  4. SELECT RECORD           ");
			System.out.println("  5. SELECT ALL RECORD       ");
			System.out.println("  6. EXIT                    ");
			System.out.println("=============================");
			System.out.println("  ENTER YOUR CHOICE(1-5) :    ");
			ch1 = sc.nextInt();
			switch (ch1) 
			{
			  case 1:
					edao.insert(db);
					break;
			  case 2:
			        System.out.println("Enter the employee No. :");
			        emp_id = sc.nextInt();
			        edao.update(emp_id,db);
			        break;

			  case 3:
			        System.out.println("Enter the employee No. :");
			        emp_id = sc.nextInt();
				  	edao.delete(emp_id,db);
			        break;

			  case 4:
				  	Employee emp=new Employee();
				  	System.out.println("Enter the employee No. :");
			        emp_id = sc.nextInt();
				  	emp=edao.select(emp_id,db);
				  	edao.displayOneEmployee(emp);
			        break;

			  case 5:
				  	ArrayList<Employee> elist=new ArrayList<Employee>();
				  	elist=edao.selectAll(db);
				  	for(Employee e :elist)
				  	{
				  		edao.displayOneEmployee(e);
				  	}
			        break;

			  case 6:
			        System .exit(0);
			        break;
					
			}
		}
	}

}

		//System.out.println("Do you Want to continue with operations with mongo (y/n) :");
		//ch = sc.next();
		//String database="mydb";
		//MongoClient con =MongoConnection.getConnection();
		//List of database available
		//List<String> dbs = con.getDatabaseNames();
		//System.out.println(dbs);
		//DB db=con.getDB(database);
		//List the collection in database
		//Set<String> collections = db.getCollectionNames();
		//System.out.println(collections);
		//DBCollection col = db.getCollection("myemployees");
		//System.out.println("Collection retrived ");
		//System.out.println("Count :"+ col.count());
		//EmployeeDao edao=new EmployeeDao();
		//Employee emp=edao.createOneEmployee();
		//edao.displayOneEmployee(emp);
		//DBObject doc = edao.createDBObject(emp);
		//WriteResult result = col.insert(doc);
		//System.out.println(result.getUpsertedId());
		//System.out.println(result.getN());
		//System.out.println(result.isUpdateOfExisting());
		//System.out.println(result.getLastConcern());
		//con=MongoConnection.closeConnection(con);
		//edao.insert("myemployees");
		//edao.selectAll("myemployees");
		//edao.update(103,"myemployees");
		//edao.delete(102,"myemployees");