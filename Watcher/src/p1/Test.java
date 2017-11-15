package p1;

public class Test {

	public static void main(String[] args) 
	{
		WatchForFile w=new WatchForFile();
		for (int i=0;i<3;i++)
		{
			w.WatchMyFolder("C:/Test");
		}
	}

}
