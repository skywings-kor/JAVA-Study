
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.tree.*;
import javax.swing.event.*;
import javax.swing.JOptionPane;

public class LoginSys extends JFrame{
	//SQL부분
	String URL="jdbc:mysql://localhost:3306/university?serverTimezone=Asia/Seoul";
	Connection con=null;
	String id="root";
	String password="root";
	Statement stmt=null;
	
	
	//안내 페이지 라벨
	JLabel systitle=new JLabel("                                        <<학생 관리 프로그램 시스템>>");
	
	//로그인 창 패널 부분
	JPanel basePanel=new JPanel(new BorderLayout());
	JPanel southPanel=new JPanel();
	JPanel centerPanel =new JPanel();
	
	//로그인 버튼 부분
	JButton loginB=new JButton("Login");
	JButton createB=new JButton("Sign Up");
	
	//로그인 입력 라벨
	JLabel idL=new JLabel("ID: ");
	JLabel pwL=new JLabel("PW: ");
	
	//로그인 입력 칸
	JTextField idT=new JTextField();
	JTextField pwT=new JTextField();
	
	
	LoginSys()
	{
		setTitle("Made By PGM-LoginSystem");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//패널 세팅
		setContentPane(basePanel);
		basePanel.add(southPanel,BorderLayout.SOUTH);
		basePanel.add(centerPanel,BorderLayout.CENTER);
		southPanel.setLayout(new FlowLayout());
		centerPanel.setLayout(new FlowLayout());
		
		//크기 조정
		systitle.setPreferredSize(new Dimension(400,70));
		loginB.setPreferredSize(new Dimension(160,60));
		createB.setPreferredSize(new Dimension(160,60));
		idL.setPreferredSize(new Dimension(70,50));
		pwL.setPreferredSize(new Dimension(70,50));		
		idT.setPreferredSize(new Dimension(300,50));
		pwT.setPreferredSize(new Dimension(300,50));
		
		centerPanel.add(systitle);
		centerPanel.add(idL);
		centerPanel.add(idT);
		centerPanel.add(pwL);
		centerPanel.add(pwT);
		
		southPanel.add(loginB);
		southPanel.add(createB);
		
		
		//이벤트리스너 추가
		loginB.addActionListener(new MyActionListener());
		createB.addActionListener(new MyActionListener());
		
		setSize(400,400);
		setLocation(700,200);
		setVisible(true);
		
		
	}
	
	//이벤트 리스너 메소드
	private class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			String st=e.getActionCommand();
			
			if(st=="Login")
				login();
			
			else if(st=="Sign Up")
				create();
			
		}
		
	}
	
	//로그인을 위한 메소드
	void login()
	{
		String userID=idT.getText();
		String userPW=pwT.getText();
		
		JOptionPane infor=new JOptionPane();
		try
		{
			makeConnection();
			stmt=con.createStatement();
			ResultSet result=stmt.executeQuery("SELECT * FROM university.usertable");
			
			//로그인 체크 용도
			int check=0;
			
			//db에 있는 값이 다 불러와질때까지..
			while (result.next())
			{
				String dbID=result.getString("id");
				String dbPW=result.getString("password");
				
				//유저가 입력한 거하고 DB에 저장되어있는 ID하고 비번이 일치할 경우
				if((userID.equals(dbID)==true)&&(userPW.equals(dbPW)==true))
				{
					Main run=new Main();
					check+=1;
					break;
				}
			}
			
			//check가 0일경우는 로그인이 실패한 것으로 나타내었습니다.
			if(check==0)
				infor.showMessageDialog(null,"아이디 또는 비밀번호가 틀렸습니다");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	void create()
	{
		CreateSys ss=new CreateSys();
	}
	
	//서버와 통신을 위한 메소드
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
