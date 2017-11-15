package p1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyAText 
{
	    public static void main(String[] args)
	    {    
	        try {

	            Path afile = Paths.get("C:\\Test\\a.txt");
	            Path bfile = Paths.get("C:\\Test\\cptest\\a.txt");
	            Files.copy(afile, bfile);

	            /**_IF YOU WANT_ to delete the original file.*/
	            //afile.delete();

	            System.out.println("File is copied successful!");
	        }
	        catch(IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
