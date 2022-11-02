import java.sql.*;

public class CreateCustomer {

	public static void main(String[] args) {
		//URL은 리소스의 주소, 시간 넣어줘야하는 경우는 가끔 있는데 이때 banksystem앞에  ?serverTimezone=Asia/Seoul  이거 붙여주면 됨
		String URL="jdbc:mysql://localhost:3306/banksystem?serverTimezone=Asia/Seoul";
		Connection con=null;
		
		//목적: 연결이 잘 되고 나면 명령어를 던져야 하는데, 명령어가 statement라고 생각하면 됨
		//DB에 보내주는 거 
		Statement stmt = null;
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			
		}
		
		String createString = "CREATE TABLE customer "+
		"(customer_id char(6) not null primary key, "+
		"customer_name varchar(15) not null, "+
		"customer_tel varchar(13), "+
		"customer_addr varchar(20))";
		
		try 
		{
			con=DriverManager.getConnection(URL,"root","root");
			System.out.println("OK");
			stmt=con.createStatement();
			stmt.executeUpdate(createString);
			System.out.println("OK");
		}
		catch(Exception t)
		{
			System.out.println(t.toString());
		}
		finally//연결을 계쏙하면 안되고 다 되면 끊는 것임, 하나만 계쏙 연결되어있으면 서버 입장은 부담이 됨
		{
			try
			{
				if(stmt!= null)
				{
					stmt.close();
				}
				if(con !=null)
				{
					con.close();
				}
			}
			catch(Exception a)
			{
				
			}
			
		}
		
		
	}

}
