package com.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.bean.Employee;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import com.utility.MongoConnection;

public class EmployeeDao {
	
	public static int emp_id = 100;
	public int insert(String database) {
		System.setProperty("DEBUG.MONGO", "false");
		MongoClient con = MongoConnection.getConnection();
		DB db = con.getDB(database);
		DBCollection col = db.getCollection(database);
		//System.out.println("Total " + col.count() + " Records already exist !!!");
		Employee emp = createOneEmployee();
		displayOneEmployee(emp);
		try {
			DBObject doc = createDBObject(emp);
			WriteResult result = col.insert(doc);
			System.out.println(result.getUpsertedId());
			System.out.println(result.getN());
			System.out.println(result.isUpdateOfExisting());
		} catch (Exception e) {
			System.out.println("Failed to write object to database !!");
			return -1;
		}
		con = MongoConnection.closeConnection(con);
		return 1;
	}

	public int update(int emp_id,String database) {
		System.setProperty("DEBUG.MONGO", "false");
		Employee emp=select(emp_id,database);
		if(emp==null)
		{
			return -1;
		}
		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB(database);
		
		DBCollection col = db.getCollection(database);
		DBObject query = new BasicDBObject("_id",emp_id );
		DBObject update = new BasicDBObject();
		emp=createOneEmployee();
		emp.setEmp_id(emp_id);
		DBObject doc = createDBObject(emp);
		update.put("$set", doc);
		WriteResult result = col.update(query, update);
		return 1;
	}

	public int delete(int emp_id,String database) {
		System.setProperty("DEBUG.MONGO", "false");
		if(select(emp_id,database)==null)
		{
			return -1;
		}
		DBObject query = BasicDBObjectBuilder.start().add("_id",emp_id).get();
		MongoClient con = MongoConnection.getConnection();
		DB db = con.getDB(database);
		DBCollection col = db.getCollection(database);
		WriteResult result = col.remove(query);
		System.out.println(result.getUpsertedId());
		System.out.println(result.getN());
		System.out.println(result.isUpdateOfExisting());		
		return 0;
	}

	public Employee select(int emp_id,String database) {
		System.setProperty("DEBUG.MONGO", "false");
		ArrayList<Employee> elist=new ArrayList<Employee>();
		Employee emp=null;
		elist=selectAll(database);
		if(elist.size()>0)
		{
			for(int i=0;i<elist.size();i++)
			{	emp=elist.get(i);
				if(emp.getEmp_id()==emp_id)
				{
					//displayOneEmployee(emp);
					return emp;
				}
			}
		}
		System.out.println("Employee with "+emp_id+" not found !!! ");
		return null;
	}

	public ArrayList<Employee> selectAll(String database) {
		System.setProperty("DEBUG.MONGO", "false");
		ArrayList<Employee> elist=new ArrayList<Employee>();
		Employee emp=null;
		MongoClient con = MongoConnection.getConnection();
		DB db = con.getDB(database);
		DBCollection col = db.getCollection(database);
		System.out.println("Total " + col.count() + " Records already exist !!!");
		 // Getting the iterable object 
	      DBCursor iterDoc = col.find(); 
	      // Getting the iterator 
	      Iterator it = iterDoc.iterator(); 
	      while (it.hasNext()) {  
	    	  emp=new Employee();
	    	  BasicDBObject obj=(BasicDBObject) it.next();
	    	  emp.setEmp_id(obj.getInt("_id"));
	    	  emp.setName(obj.getString("name"));
	    	  emp.setDt_of_joining(obj.getDate("Date_of_joining"));
	    	  emp.setSalary(obj.getDouble("Salary"));
	    	  emp.setSkills((ArrayList<String>)obj.get("Skills"));
	         elist.add(emp);
	        // displayOneEmployee(emp);
	      }
	      con = MongoConnection.closeConnection(con);
		return elist;
	}

	public void displayOneEmployee(Employee emp) {
		System.setProperty("DEBUG.MONGO", "false");
		System.out.println("##################################");
		System.out.println("Emp ID : " + emp.getEmp_id());
		System.out.println("Emp Name : " + emp.getName());
		System.out.println("Emp Salary : " + emp.getSalary());
		System.out.println("Emp D_O_J : " + emp.getDt_of_joining());
		System.out.println("Emp Skills : " + emp.getSkills());
		System.out.println("###################################");
	}

	public Employee createOneEmployee() {
		System.setProperty("DEBUG.MONGO", "false");
		Random r=new Random();
		Scanner sc = new Scanner(System.in);
		Employee employee = new Employee();
		System.out.println("Enter Name :");
		employee.setName(sc.nextLine());
		System.out.println("Enter Joining date (dd/mm/yyyy ) :");
		Date dt_of_joining = null;
		try {
			dt_of_joining = new SimpleDateFormat("dd/mm/yyyy").parse(sc.nextLine());
		} catch (ParseException e) {
			System.out.println("Invalid date format");
			e.printStackTrace();
		}
		employee.setDt_of_joining(dt_of_joining);
		System.out.println("Enter Salary :");
		employee.setSalary(sc.nextDouble());
		ArrayList<String> skills = new ArrayList<String>();
		String ch = "N";
		do {
			System.out.println("Enter skill for the employee");
			skills.add(sc.next());
			System.out.println("Do you Want to continue entering skills for employee (y/n) :");
			ch = sc.next();
		} while (ch.equalsIgnoreCase("Y"));
		employee.setSkills(skills);
		employee.setEmp_id(r.nextInt(30) + emp_id++);
		return employee;
	}

	public DBObject createDBObject(Employee emp) {
		System.setProperty("DEBUG.MONGO", "false");
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		docBuilder.append("_id", emp.getEmp_id());
		docBuilder.append("name", emp.getName());
		docBuilder.append("Date_of_joining", emp.getDt_of_joining());
		docBuilder.append("Salary", emp.getSalary());
		docBuilder.append("Skills", emp.getSkills());
		return docBuilder.get();
	}
}
