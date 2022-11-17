import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.tree.*;

import javax.swing.event.*;

public class CreateSys extends JFrame{
	//SQL부분
	String URL="jdbc:mysql://localhost:3306/university?serverTimezone=Asia/Seoul";
	Connection con=null;
	String id="root";
	String password="root";
	Statement stmt=null;
	
	//패널 부분
	JPanel basePanel=new JPanel(new BorderLayout());
	JPanel centerPanel =new JPanel();
	JPanel southPanel=new JPanel();
	
	//회원가입 버튼
	JButton okB=new JButton("OK");
	
	//회원가입 입력 라벨
	JLabel idL=new JLabel("Create ID");
	JLabel pwL=new JLabel("Create PW");
	
	//로그인 입력 칸
	JTextField idT=new JTextField();
	JTextField pwT=new JTextField();
	
	CreateSys()
	{
		setTitle("Create User Information");
		
		//패널 세팅
		setContentPane(basePanel);
		basePanel.add(centerPanel,BorderLayout.CENTER);
		basePanel.add(southPanel,BorderLayout.SOUTH);
		southPanel.setLayout(new FlowLayout());
		centerPanel.setLayout(new FlowLayout());
		
		//크기 조정
		idL.setPreferredSize(new Dimension(70,50));
		idT.setPreferredSize(new Dimension(220,50));
		pwL.setPreferredSize(new Dimension(70,50));
		pwT.setPreferredSize(new Dimension(220,50));
		okB.setPreferredSize(new Dimension(150,50));
		
		
		//패널 추가 부분
		centerPanel.add(idL);
		centerPanel.add(idT);
		centerPanel.add(pwL);
		centerPanel.add(pwT);
		southPanel.add(okB);
		
		//이벤트 리스너 부분
		okB.addActionListener(new MyActionListener());
		
		
		setSize(350,250);
		setLocation(700,200);
		setVisible(true);
	}
	
	//이벤트 메소드
	private class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			String st=e.getActionCommand();
			
			if(st=="OK")
				create();
		}
		
	}
	
	//회원가입 메소드
	void create()
	{
		String createID=idT.getText();
		String createPW=pwT.getText();
		
		JOptionPane infor=new JOptionPane();
		try
		{
			makeConnection();
			stmt=con.createStatement();
			ResultSet result=stmt.executeQuery("SELECT * FROM university.usertable");
			String command;
			//같은 아이디 체크 용도
			int check=0;
			
			//db에 있는 값이 다 불러와질때까지..
			while (result.next())
			{
				String dbID=result.getString("id");
				
				//동일한 아이디가 존재할 경우 안된다는 것을 위한 알림
				if((createID.equals(dbID)==true))
				{
					check+=1;
					break;
				}
			}
			
			//check가 1일경우는 동일한 ID가 존재하여 회원가입 거부
			if(check==1)
				infor.showMessageDialog(null,"서버에 동일한 ID가 존재합니다");
			
			else
			{
				command="INSERT INTO usertable VALUES ('"+createID+"','"+createPW+"')";
				stmt.executeUpdate(command);
				infor.showMessageDialog(null,"정상적으로 회원가입이 완료되었습니다");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
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
	
	//main 마지막 부분 알림용
}
