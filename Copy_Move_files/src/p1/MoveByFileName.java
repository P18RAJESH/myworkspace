package p1;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class MoveByFileName 
{

	public static void main(String[] args) throws IOException
	{
        try (DirectoryStream<Path> dir = Files.newDirectoryStream(Paths.get("C:\\Test"))) 
        {

            for (Path file : dir) 
            { 
                String name = file.getFileName().toString();
                System.out.println("Processing file :"  + name +" with lenght " +name.length());
                
                if (!Files.isDirectory(file) && name.length() == 9)
                {
                	  char ch = name.charAt(0);
                	  System.out.println("Folder character is :" + ch);
                      Path destDir = Paths.get("C:\\Test\\f" + ch);
                      Files.createDirectories(destDir);
                      System.out.println(name + " file moved to " +destDir.toString() +" folder.");
                      Files.move(file, destDir.resolve(name));
                	
                }
            }
        }   
                    
        
	  }

}
