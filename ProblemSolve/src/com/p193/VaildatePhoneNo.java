package com.p193;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class VaildatePhoneNo {

	public static void main(String[] args) {
		// (xxx) xxx-xxxx or xxx-xxx-xxxx
		List<Integer> numbers = new ArrayList<>();
		int sum = 0;
		try {
			for (String line : Files.readAllLines(Paths.get("C:/My Workspace/R_W_Text_file/src/read.txt"))) {
				for (String part : line.split("\\s+")) {
					Integer i = Integer.valueOf(part);
					numbers.add(i);
					sum = sum + i;
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
