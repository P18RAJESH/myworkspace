package p1;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.beanio.BeanIOConfigurationException;
import org.beanio.BeanReader;
import org.beanio.StreamFactory;

public class Read_text 
{	
	InputStream in = null;
	Reader reader = null;
	BeanReader beanReader = null;
	StreamFactory factory=null;
	int count=0;
	public void readCSVFileUsingBeanIo()
	{
		try
		{	
			factory = StreamFactory.newInstance();
			in = new FileInputStream("C://My Workspace//BeanIOTest//NewFile.xml");
			reader = new InputStreamReader(new FileInputStream("C://My Workspace//BeanIOTest//data.txt"));
			factory.load(in);
			beanReader = factory.createReader("EmployeeStream", reader);	   
		} 
		catch (BeanIOConfigurationException | IOException e)
	    {
			e.printStackTrace();
		}
	    
		//beanReader = factory.createReader("EmployeeStream", reader);
	    Object record = null;
	    List<Employee> emps = new ArrayList<Employee>();
	        
	    while(true)
	    {
				try{
					count++;
					record = beanReader.read();
					if(null != record)
					{
						Employee emp = (Employee) record;
						emps.add(emp);
						System.out.println(emp.getEmpid()+","+emp.getEname()+","+emp.getSalary());
					}
					else
					{
						break;
					}
				}
				catch(Exception e)
				{
					System.out.println("Row Num :: "+ (count) +  " Exception Message :: " + e.getMessage());
				}
		}
	}
	    
	public static void main(String[] args)
	{
		new Read_text().readCSVFileUsingBeanIo();
	       
	}
	
}
