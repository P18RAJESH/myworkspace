package p1;


	import java.nio.file.Files;
	import java.nio.file.Path;
	import java.nio.file.Paths;

	public class MoveAText {
	    public static void main(String[] args){ 
	        try {
	           Path afile = Paths.get("C:\\Test\\b.txt");
	           System.out.println(afile.getFileName().toString());
	           Files.move(afile,Paths.get("C:\\Test\\mvtest",  afile.getFileName().toString()));
	           System.out.println("File Moved sucessfully !");
	        }
	        catch(Exception e){
	            e.printStackTrace();
	        }
	   }
	 }
