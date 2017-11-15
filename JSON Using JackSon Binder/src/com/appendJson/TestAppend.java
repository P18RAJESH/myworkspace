package com.appendJson;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

public class TestAppend {
	
	public static void testAppendToFile() throws IOException {

	    ObjectMapper mapper = new ObjectMapper();
	    String json1 = mapper.writeValueAsString(new Test("Rajesh",4));
	    Files.write(new File("C:\\My Workspace\\JSON Using JackSon Binder\\testappend.json").toPath(), Arrays.asList(json1), StandardOpenOption.CREATE);
	    final String json2 = mapper.writeValueAsString(new Test("Raju",3));
	    Files.write(new File("C:\\My Workspace\\JSON Using JackSon Binder\\testappend.json").toPath(), Arrays.asList(json2), StandardOpenOption.APPEND);
	    List<String> lines = Files.readAllLines(new File("C:\\My Workspace\\JSON Using JackSon Binder\\testappend.json").toPath());
	    for(String s: lines)
	    {
	    	System.out.println(s);
	    }
	}

	public static void main(String[] args) {
		try {
			testAppendToFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
