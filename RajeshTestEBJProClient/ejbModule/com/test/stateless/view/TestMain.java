package com.test.stateless.view;

import javax.naming.Context;
import javax.naming.InitialContext;

public class TestMain {
	public static void main(String[] args) throws Exception {
		Context context = new InitialContext();
		NewSessionBeanclient remote = (NewSessionBeanclient) context.lookup("st1");
		System.out.println(remote.add(32, 32));
	}

}
