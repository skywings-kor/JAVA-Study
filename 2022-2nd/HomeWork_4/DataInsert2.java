import java.sql.*;
import java.util.*;
import java.io.*;
import java.util.StringTokenizer;
import java.awt.*;
import java.awt.event.*;

//2019243064 컴퓨터공학부 박규민
//개발일자: 
//
//ver4.0: 22.11.19(토) 완성

public class DataInsert2 {
	
	String URL="jdbc:mysql://localhost:3306/university?serverTimezone=Asia/Seoul";
	Connection con=null;
	String id="root";
	String password="root";
	
	//insertData부분
	Statement stmt=null;
	
	//파일 체크
	File df=new File("C:\\Users\\v2109\\Desktop\\java_study\\students.txt");
	
	
	DataInsert2()
	{
		
		try
		{
			BufferedReader br= new BufferedReader(new FileReader(df));
			String readData;
			StringTokenizer st;
			makeConnection();
			stmt=con.createStatement();
			String command;
			
			//txt파일에서 불러온 정보들을 담아두기 위한 변수 선언
			String name,num,grade,depart;
			String year;
			int chyear;
			//몇개의 정보가 업로드 되었는지 카운트 해주는 용도
			int count=0;
			
			while((readData=br.readLine())!=null)
			{
				st=new StringTokenizer(readData," ");
				System.out.println(readData);
				//변수에 값 넣기
				depart=st.nextToken();
				year=st.nextToken();
				name=st.nextToken();
				grade=st.nextToken();
				num=st.nextToken();
				
				chyear=Integer.parseInt(year);
				
				//DB 추가를 위한 선언
				command="INSERT INTO students_table VALUES ('"+name+"','"+num+"',"+chyear+",'"+grade+"','"+depart+"')";
				stmt.executeUpdate(command);
				count++;
			}
			
			System.out.println(count+"개의 정보 레코드가 업로드되었습니다");	
			
		}
		
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		
		
		//DataInsert2()엔드라인
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
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataInsert2 run=new DataInsert2();
		
		
	}
}
