package com.appendJson;

public class Test {
    private String Name;
	private int id;
	public String getName() {
		return Name;
	}
	public Test(String name, int id) {
		super();
		Name = name;
		this.id = id;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
