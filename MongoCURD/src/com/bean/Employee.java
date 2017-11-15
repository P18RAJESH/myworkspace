package com.bean;

import java.util.ArrayList;
import java.util.Date;

public class Employee 
{
	Integer emp_id;
	private String name;
	double salary;
	Date dt_of_joining;
	ArrayList<String> skills=null;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getDt_of_joining() {
		return dt_of_joining;
	}
	public void setDt_of_joining(Date dt_of_joining) {
		this.dt_of_joining = dt_of_joining;
	}
	public ArrayList<String> getSkills() {
		return skills;
	}
	public void setSkills(ArrayList<String> skills) {
		this.skills = skills;
	}
}
