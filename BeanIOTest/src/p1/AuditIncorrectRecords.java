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

public class AuditIncorrectRecords {
	BeanReader beanReader = null;
	Object record = null;
	static StreamFactory factory = null;
	InputStream in = null;
	Reader reader = null;
	public static void main(String[] args) throws BeanIOConfigurationException, IOException {
		AuditIncorrectRecords auditIncorrectRecords = new AuditIncorrectRecords();
		auditIncorrectRecords.init();
		auditIncorrectRecords.readFileData();
	}
	public void init() throws BeanIOConfigurationException, IOException{
		StreamFactory factory = StreamFactory.newInstance();
		in = new FileInputStream("C:\\My Workspace\\BeanIOTest\\NewFile.xml");
		
		reader = new InputStreamReader(new FileInputStream("C:\\My Workspace\\BeanIOTest\\data.txt"));

		factory.load(in);

		beanReader = factory.createReader("EmployeeStream", reader);
	}
	public void readFileData() throws IOException{
		List<String> lstStr = new ArrayList<String>();
		int count = 0;
		String str = "";
		while(true){
			try{
				count++;
				record = beanReader.read();
				if(null != record){
					Employee emp = (Employee) record;
					str = emp.getEname()+","+String.valueOf(emp.getEmpid())+","+String.valueOf(emp.getSalary());
					lstStr.add(str);
					
				}else{
				
					break;
				}
			}catch(Exception e){
		
				System.out.println("Row Num :: "+ (count) +  " Exception Message :: " + e.getMessage());
			}
		}

		System.out.println(lstStr);
		System.exit(0);
	}
}

