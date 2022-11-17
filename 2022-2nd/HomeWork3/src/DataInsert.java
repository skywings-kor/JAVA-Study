import java.sql.*;
import java.util.*;
import java.io.*;
import java.util.StringTokenizer;
import java.awt.*;
import java.awt.event.*;

public class DataInsert {
	//university의 DB를 이용할거기 때문에 아래 university로 url을 바꿔야합니다.
	String URL="jdbc:mysql://localhost:3306/university?serverTimezone=Asia/Seoul";
	Connection con=null;
	String id="root";
	String password="root";
	
	//insertData부분
	Statement stmt=null;
	
	//파일 체크
	File df=new File("C:\\Users\\v2109\\Desktop\\java_study\\users.txt");
	
	public static void main(String[] args)
	{
		DataInsert run1=new DataInsert();
	}
	
	
	DataInsert()
	{
		try 
		{
			BufferedReader br=new BufferedReader(new FileReader(df));
			String readData;
			StringTokenizer st;
			String id,pw;
			int count=0;
			//DB연결확인하고
			makeConnection();
			stmt=con.createStatement();
			String command;
			
			while((readData=br.readLine())!=null)
			{
				st=new StringTokenizer(readData,"//");
				id=st.nextToken();
				pw=st.nextToken();
				
				//DB추가용 라인
				command="INSERT INTO usertable VALUES ('"+id+"','"+pw+"')";
				stmt.executeUpdate(command);
				
				//몇개의 정보를 업로드 했는지 알려주기 위한 용도
				count++;
			}
			
			System.out.println(count+"개의 정보 레코드가 업로드되었습니다");	
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			
		}
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
	
	
	
	
	
	
	//여기가 메인 엔드라인 알려주기 위한 표시용
}

