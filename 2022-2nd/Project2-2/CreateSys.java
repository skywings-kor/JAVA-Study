import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.tree.*;
import javax.swing.event.*;
import javax.swing.border.LineBorder;

import javax.swing.event.*;

public class CreateSys extends JFrame{
	
	//SQL 도시 이름 연결
	String [] City= new String[17];
	int usercomboInt;
	String usercomboString;
	
	//SQL부분
	String URL="jdbc:mysql://localhost:3306/weather?serverTimezone=Asia/Seoul";
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
	JButton noB=new JButton("Cancel");
	
	//회원가입 입력 라벨
	JLabel idL=new JLabel("Create ID");
	JLabel pwL=new JLabel("Create PW");
	JLabel nameL=new JLabel("Name ");
	JLabel ageL=new JLabel("Age ");
	JLabel liveL=new JLabel("Living Area ");
	
	//로그인 입력 칸
	JTextField idT=new JTextField();
	JTextField pwT=new JTextField();
	
	JTextField nameT=new JTextField();
	JTextField ageT=new JTextField();
	
	//회원가입 콤보박스
	JComboBox liveC;
	
	//이미지
	Image createImage;
		
	CreateSys()
	{
		//콤보박스 부분
		insertCity();
		liveC=new JComboBox(City);
		
		setTitle("Create User Information");
		
		//이미지 변수값 저장된거 적용
		ImageIcon koreaIcon=new ImageIcon("C:\\Users\\v2109\\eclipse-workspace\\Weather_System\\src\\image\\weatherSignup.png");
		System.out.println(koreaIcon);
		createImage=koreaIcon.getImage();
		
		//패널에 이미지 적용
		centerPanel=new ImagePanel();
		
		//패널 세팅
		setContentPane(basePanel);
		basePanel.add(centerPanel,BorderLayout.CENTER);
		basePanel.add(southPanel,BorderLayout.SOUTH);
		southPanel.setLayout(new FlowLayout());
		centerPanel.setLayout(new FlowLayout());
		
		//패널 색깔 조정
		southPanel.setBackground(Color.white);
		
		//크기 조정
		idL.setPreferredSize(new Dimension(120,60));
		idT.setPreferredSize(new Dimension(300,60));
		pwL.setPreferredSize(new Dimension(120,60));
		pwT.setPreferredSize(new Dimension(300,60));
		
		nameT.setPreferredSize(new Dimension(120,60));
		ageT.setPreferredSize(new Dimension(120,60));
		liveC.setPreferredSize(new Dimension(150,60));
		
		nameL.setPreferredSize(new Dimension(60,60));
		ageL.setPreferredSize(new Dimension(60,60));
		liveL.setPreferredSize(new Dimension(120,60));
		
		okB.setPreferredSize(new Dimension(150,60));
		noB.setPreferredSize(new Dimension(150,60));
		
		//글자 색상 조정
		idL.setForeground(Color.white);
		pwL.setForeground(Color.white);
		nameL.setForeground(Color.white);
		ageL.setForeground(Color.white);
		liveL.setForeground(Color.white);
		
		//글자 크기 조정
		idL.setFont(new Font("Serif",Font.BOLD,18));
		pwL.setFont(new Font("Serif",Font.BOLD,18));
		nameL.setFont(new Font("Serif",Font.BOLD,18));
		ageL.setFont(new Font("Serif",Font.BOLD,18));
		liveL.setFont(new Font("Serif",Font.BOLD,18));
		
		//패널 추가 부분
		centerPanel.add(idL);
		centerPanel.add(idT);
		centerPanel.add(pwL);
		centerPanel.add(pwT);
		centerPanel.add(nameL);
		centerPanel.add(nameT);
		centerPanel.add(ageL);
		centerPanel.add(ageT);
		centerPanel.add(liveL);
		centerPanel.add(liveC);
		southPanel.add(okB);
		southPanel.add(noB);
		
		
		//이벤트 리스너 부분
		okB.addActionListener(new MyActionListener());
		noB.addActionListener(new MyActionListener());
		
		
		
		liveC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				JComboBox actCombo =(JComboBox)event.getSource();
				usercomboInt=actCombo.getSelectedIndex();
				
				//유저가 클릭한 콤보박스가 어떤것인지 string 문자열로 저장해둡니다
				usercomboString=actCombo.getSelectedItem().toString();
				
			}	
		});
		

		
		setSize(450,400);
		setLocation(700,200);
		setVisible(true);
	}
	
	class ImagePanel extends JPanel{
		private static final long serialVersionUID=1L;
		@Override
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawImage(createImage,0,0,null);
		}
	}
	
	
	//이벤트 메소드
	private class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			String st=e.getActionCommand();
			
			if(st=="OK")
				create();
			
			else if(st=="Cancel")
				dispose();
				
		}
		
	}
	
	//회원가입 메소드
	void create()
	{
		String createID=idT.getText();
		String createPW=pwT.getText();
		String createName=nameT.getText();
		String temp1=ageT.getText();
		int createAge=Integer.parseInt(temp1);
		
		String createArea=usercomboString;
		
		JOptionPane infor=new JOptionPane();
		try
		{
			makeConnection();
			stmt=con.createStatement();
			ResultSet result=stmt.executeQuery("SELECT * FROM weather.user");
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
				//차례대로 id, pw, 이름, 사는 지역, 나이가 DB로 들어갑니다
				command="INSERT INTO user VALUES ('"+createID+"','"+createPW+"','"+createName+"','"+createArea+"','"+createAge+"')";
				stmt.executeUpdate(command);
				
				//정상적으로 완료될 경우 해당 메시지로 사용자에게 알려줍니다
				infor.showMessageDialog(null,"정상적으로 회원가입이 완료되었습니다");
				
				//현재 회원가입창 닫는 기능
				dispose();
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
	
	void insertCity()
	{
		//Depart에 DB 데이터 넣기
		try
		{
			makeConnection();
			stmt=con.createStatement();
			ResultSet result=stmt.executeQuery("SELECT * FROM weather.krcity");
			
			//배열 값 넣을 용도 카운트
			int lscount=0;
			
			//DB에 있는 값이 다 불러와질 때까지
			while(result.next())
			{
				//dname이라는 곳에 존재하는 문자열을 가져와서 dbpart에 넣습니다
				String dbcity=result.getString("areaName");
				
				//Depart 배열에 하나씩 db에서 가져온 학과명들 넣기
				City[lscount]=dbcity;
				
				//다음 배열에 넣을 수 있게 lscount 1 증가
				lscount++;
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	//main 마지막 부분 알림용
}
