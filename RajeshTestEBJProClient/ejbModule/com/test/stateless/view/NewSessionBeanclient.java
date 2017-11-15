package com.test.stateless.view;

import javax.ejb.Remote;

@Remote
public interface NewSessionBeanclient {
	int add(int a, int b);
}
