package p1;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Writetotext
{
	public static void main(String[] args) 
	{

	    FileWriter writer;
		try {
			writer = new FileWriter("C:/My Workspace/R_W_Text_file/src/write.txt");
			  List<String> test = new ArrayList<>();
			    test.add("Word1");
			    test.add("Word2");
			    test.add("Word3");
			    test.add("Word4");

			    String collect = test.stream().collect(Collectors.joining(","));
			    System.out.println(collect);

			    writer.write(collect);
			    writer.close();

		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

	  
	}
}
