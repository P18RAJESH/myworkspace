package p1;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReadAndWriteToText {

	public static void main(String[] args) 
	{
		List<Integer> numbers = new ArrayList<>();
		List<String> test = new ArrayList<>();
		FileWriter writer;
		Integer sum=0;

		try 
		{
			for (String line : Files.readAllLines(Paths.get("C:/My Workspace/R_W_Text_file/src/read.txt"))) 
			{
			    for (String part : line.split("\\s+")) 
			    {
			        Integer i = Integer.valueOf(part);
			        numbers.add(i);
			        test.add(i.toString());
			        sum=sum+i;
			    }
			}
		}
		catch (NumberFormatException e) 
		{
			System.out.println("Only Integers allowed in the text file !! Check and modify !!");
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			System.out.println("Please check the file location avaliablity");
			e.printStackTrace();
		}
		numbers.add(sum);
		test.add(sum.toString());
		//System.out.println(numbers);
		try 
		{
			writer = new FileWriter("C:/My Workspace/R_W_Text_file/src/read.txt");
			String collect = test.stream().collect(Collectors.joining(" "));
			//System.out.println(collect);
		    writer.write(collect);
		    writer.close();

		} 
		catch (IOException e1) 
		{
			System.out.println("Please check the file location avaliablity");
			e1.printStackTrace();
		}
	}

}
