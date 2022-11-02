import java.sql.*;

public class DataInsert {
	
	String URL="jdbc:mysql://localhost:3306/banksystem?serverTimezone=Asia/Seoul";
	Connection con=null;
	String id="root";
	String password="root";
	
	//insertData부분
	Statement stmt=null;
	
	DataInsert()
	{
		
	}
	
	void makeConnection()
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			
		}
		
		try 
		{
			con=DriverManager.getConnection(URL,"root","root");
			System.out.println("OK");
		}
		catch(Exception t)
		{
			System.out.println(t.toString());
		}
	}
	
}

