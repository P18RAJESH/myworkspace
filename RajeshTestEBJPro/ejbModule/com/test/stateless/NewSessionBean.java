package com.test.stateless;

import com.test.stateless.view.NewSessionBeanclient;
import javax.ejb.Stateless;

@Stateless(mappedName = "st1")
public class NewSessionBean implements NewSessionBeanclient {
	public int add(int a, int b) {
		return a + b;
	}

}
