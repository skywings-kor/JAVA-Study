import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
import java.awt.*;

public class SearchFromCustomer {
	String URL="jdbc:mysql://localhost:3306/banksystem?serverTimezone=Asia/Seoul";
	Connection con=null;
	String id="root";
	String password="root";

	//insertData부분
	Statement stmt=null;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchFromCustomer sc=new SearchFromCustomer();
		sc.makeConnection();
		sc.searchCustomer();
		try
		{
			//객체의 필드기 때문에 객체를 지정해줘야 빨간색이 사라진다. 그래서 ic.  사용해서 지정해주는 이유임 
			
			//데이터 베이스 중요, 데이터 불러와서 사용하는 방식이 제일 중요함 
			if(sc.stmt!= null)
			{
				sc.stmt.close();
			}
			if(sc.con !=null)
			{
				sc.con.close();
			}
		}
		catch(Exception a)
		{
			
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
	
	void insertData()
	{
		//10월 25일 수업 추가내용
		String tableName="customer";
		
		//공백을 넣어야 DB에 정상적으로 값을 넣을 수 있음 
		//공백 안넣으면 저 문장이 다 붙여져서 나와서 미리 저렇게 띄어놓고 해야 정상적인 작동이 가능함
		String insertString="INSERT INTO "+tableName+" VALUES";
		String records[]=
			{
				insertString + "('C-1001','홍길동','010-1234-1234','서울')",
				insertString + "('C-1002','김기민','010-1234-1234','천안')",
				insertString + "('C-1004','박기민','010-1234-1234','아산')",
				insertString + "('C-1005','남기민','010-1234-1234','인천')",
				insertString + "('C-1006','조기민','010-1234-1234','경기')",
				insertString + "('C-1077','김하늘','010-1234-1234','온양')"
			};
		
		try
		{
			stmt=con.createStatement();
			int i=0;
			while(i<records.length)
			{
				//어떤 내용을 업데이트 시킬 껀지 내용을 괄호 안에 넣으면 됨
				stmt.executeUpdate(records[i]);
				i+=1;
			}
			System.out.println(i+"개의 고객 레코드가 업로드(추가)되었습니다");
		}
		
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		
	}
	
	void searchCustomer()
	{
	
		try
		{
			stmt=con.createStatement();
			//resultset은 하나의 클래스입니다.
			//이 클래스가 객체가 되면 어떠한 역할을 객체가 되면
			//DB에서 보내준 값을 자신이 들고있어 줌
			//항상 쓰는게 아니라 statement중 하나인 executeQuery query가 뭐죠? 질의..
			//그 답을 resultset 객체로 들고있게 하는거
			//executequery는 특정 문자열이 들어올건데 
			//그 문자열을 쿼리로 삼는다는거
			ResultSet result=stmt.executeQuery("SELECT * FROM customer");
			
			int count =0;
			while (result.next())
			{
				String resultStr=result.getString("customer_id")+"\t\t"+result.getString("customer_name")+"\t\t"+result.getString("customer_tel")+"\t\t"+result.getString("customer_addr");
				System.out.println(resultStr);
				count++;
			}
			System.out.println("Searched Record:"+count);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	

}
