import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.tree.*;
import javax.swing.event.*;
import javax.swing.border.LineBorder;

//2019243064 선문대학교-컴퓨터공학부-박규민
//12.19일 완성
//12.20일 버그 Fix 및 추천 일자 기능 추가

public class WeatherMain extends JFrame{
	
	//SQL 세팅 부분
	String URL="jdbc:mysql://localhost:3306/university?serverTimezone=Asia/Seoul";
	Connection con=null;
	String id="root";
	String password="root";
	Statement stmt=null;
	
	//체크박스용 String 문자열 전달용
	String treeState;
	
	//부서 필드 배열 선언(11개 학과라 11로 지정)
	String userSelect;
	
	//트리 노드로 들어갈 학년표시용
	String [] treeGrade= {};
	
	//공간 패널 선언용 (위에 중간 아래)
	JPanel basePanel=new JPanel(new BorderLayout());
	JPanel westPanel=new JPanel();
	JPanel centerPanel =new JPanel();
	JPanel eastPanel=new JPanel();
	JPanel southPanel=new JPanel();
	JPanel northPanel=new JPanel();
	
	//로그인 한 사용자 이름 불러오기
	String loginName="";
	
	//로그인한 사용자 나이 불러오기
	String loginAgeStr="";
	int loginUserAge=0;
	
	//패널에 이미지 넣는 용
	int w=670;
	int h=725;
	Image korea;
	
	//년도배열
	String [] yearData= {"년도선택","2022","2023","2024","2025","2026","2027","2028","2029","2030"};
	
	//월배열
	String [] monthData= {"월선택","01","02","03","04","05","06","07","08","09","10","11","12"};

	//일배열
	
	String [] dayData31= {"일자선택","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	String [] dayData30= {"일자선택","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
	String [] dayData29= {"일자선택","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29"};
	String [] dayData28= {"일자선택","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28"};
	
	//지역 배열
	String [] areaData= {"지역선택","서울특별시","강원도(남)","강원도(북)","강원도(동)","경기도(남부)","경기도(북부)","경상남도","경상북도","광주광역시","대구광역시","대전광역시","부산광역시","울산광역시","인천광역시","전라남도","전라북도","제주도","충청남도","충청북도"};
	
	//영어 지역 배열
	String [] areaEng= {"seoul","wonju","chuncheon","gangneung","suwon","paju","jinju","andong","gwangju","daegu","daejeon","busan","ulsan","incheon","mokpo","jeonju","jeju","cheonan","cheongju"};
	String [] areaKor= {"서울특별시","강원도(남)","강원도(북)","강원도(동)","경기도(남부)","경기도(북부)","경상남도","경상북도","광주광역시","대구광역시","대전광역시","부산광역시","울산광역시","인천광역시","전라남도","전라북도","제주도","충청남도","충청북도"};
	
	//메인 라벨
	JLabel mname;
	JLabel sLabelMonth=new JLabel("월");
	JLabel sLabelDay=new JLabel("일");
	JLabel sSpace=new JLabel("                        ");
	
	//상세 검색 라벨
	JLabel dLabelYear=new JLabel("년");
	JLabel dLabelMonth=new JLabel("월");
	
	//메인 상단 콤보박스
	JComboBox sComboMonth;
	JComboBox sComboDay;
	
	//콤보박스 이벤트 필드선언부
	int usercomboInt;
	int usercomboDay;
	
	//기초 날씨 데이터 제공 테이블 선언
	JTable simpleInfor;
	DefaultTableModel tableModel;
	String columName[]= {"지역","날씨"};
	
	//상세 기능 검색 기능
	JComboBox detailComboYear;
	JComboBox detailComboMonth;
	JComboBox detailComboArea;
	
	JButton wtSearch=new JButton("<HTML>날씨<br>검색</HTML>");
	JButton svSearch=new JButton("<HTML>맞춤여행 <br>서비스</HTML>");
	
	//유저 맞춤 서비스 기능
	JLabel spaceL1=new JLabel("  ");
	//JLabel inforUser=new JLabel("<HTML>[자주 조회하는<br> 지역 날씨]</HTML>");
	//JButton userSearch=new JButton("상세 조회");
	JTable userInfor;
	DefaultTableModel tableModelUser;
	
	//상세 날씨 검색 관련 전달 변수
	String userYear;
	String userMonth;
	String userArea;
	
	//외곽선 그릴때 사용하는거
	LineBorder lb = new LineBorder(Color.black, 2, true);
	
	//간단 메인 날씨 검색 변수
	Object [][] weatherData= 
		{
				{"1",""},
				{"2",""},
				{"3",""},
				{"4",""},
				{"5",""},
				{"",""},
				{"",""},
				{"",""},
				{"",""},
				{"",""},
				{"",""},
				{"",""},
				{"",""},
				{"",""},
				{"",""},
				{"",""},
				{"",""},
				{"",""},
				{"",""}
		};
	
	//날씨 카운트용도
	double rain=0;
	double snow=0;
	double cloud=0;
	double avgtempDa=0;
	double[] cloudIndex = new double[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	double[] rainIndex = new double[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	double[] snowIndex = new double[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	double[] avgIndex = new double[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

	WeatherMain(String userID)
	{	
		//타이틀 및 일부 페널 적용
		setTitle("WeatherProvision System");
		
		//테이블 적용
		for(int t=0; t<=18;t++)
		{
			weatherData[t][0]=areaKor[t];
		}
		tableModel=new DefaultTableModel(weatherData,columName);
		simpleInfor=new JTable(tableModel);
		userInfor=new JTable(tableModelUser);
		
		//사용자 이름 불러오기
		loginUser(userID);
		mname=new JLabel("[기상 정보 시스템] - 사용자:"+loginName);
		
		//콤보박스 적용
		sComboMonth=new JComboBox(monthData);
		sComboDay=new JComboBox(dayData31);
		
		detailComboYear=new JComboBox(yearData);
		detailComboMonth=new JComboBox(monthData);
		detailComboArea=new JComboBox(areaData);
		
		//상대 경로로 하면 이미지가 안잡혀서 일단 절대경로로 진행하였습니다.ㅠㅠ
		ImageIcon koreaIcon=new ImageIcon("C:\\Users\\v2109\\eclipse-workspace\\Weather_System\\src\\image\\korea.jpg");
		korea=koreaIcon.getImage();
		
		
		
		westPanel.setPreferredSize(new Dimension(160,basePanel.getHeight()));		//크기를 160으로 고정하고 있게 됨
		
		setContentPane(basePanel);		//내가 만든 베이스 패널 객체로 대체되게 하는 것
		basePanel.setBackground(Color.white);
		centerPanel.setBackground(Color.white);
		eastPanel.setBackground(Color.white);
		northPanel.setBackground(Color.white);
		westPanel.setBackground(Color.white);
		southPanel.setBackground(Color.white);
		//패널에 이미지 적용
		centerPanel=new ImagePanel();
		
		//패널 세팅
		basePanel.add(westPanel,BorderLayout.WEST);
		basePanel.add(centerPanel,BorderLayout.CENTER);
		basePanel.add(eastPanel,BorderLayout.EAST);
		basePanel.add(northPanel,BorderLayout.NORTH);
		basePanel.add(southPanel,BorderLayout.SOUTH);
		westPanel.setLayout(new FlowLayout());
		northPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//라벨 크기 조절
		//inforUser.setPreferredSize(new Dimension(100,70));
		mname.setPreferredSize(new Dimension(500,50));
		mname.setHorizontalAlignment(JLabel.CENTER);
		
		//콤보박스 크기 조절
		sComboMonth.setPreferredSize(new Dimension(100,50));
		sComboDay.setPreferredSize(new Dimension(100,50));
		sSpace.setPreferredSize(new Dimension(600,50));
		
		detailComboYear.setPreferredSize(new Dimension(100,40));
		detailComboMonth.setPreferredSize(new Dimension(100,40));
		detailComboArea.setPreferredSize(new Dimension(150,60));

		//테이블 크기 조절
		simpleInfor.setPreferredSize(new Dimension(150,500));
		userInfor.setPreferredSize(new Dimension(150,200));
		
		//버튼 크기 조절
		wtSearch.setPreferredSize(new Dimension(120,70));
		svSearch.setPreferredSize(new Dimension(120,70));
		//userSearch.setPreferredSize(new Dimension(120,70));
		
		//유저추천 기능 관련 크기 조절
		spaceL1.setPreferredSize(new Dimension(130,100));
		
		//윤곽선 그리는 부분
		mname.setBorder(lb);
		
		//이벤트 추가
		sComboMonth.addActionListener(new smallActionListener());
		sComboDay.addActionListener(new smallDayActionListener());
		wtSearch.addActionListener(new detailButtonAction());
		detailComboYear.addActionListener(new yearComboAction());
		detailComboMonth.addActionListener(new monthComboAction());
		detailComboArea.addActionListener(new areaComboAction());
		svSearch.addActionListener(new userTripButtonAction());
		
		//위쪽 패널 추가
		northPanel.add(mname);
		
		
		northPanel.add(sComboMonth);
		northPanel.add(sLabelMonth);
		northPanel.add(sComboDay);
		northPanel.add(sLabelDay);
		
		
		//우측 패널의 심플 정보 테이블 값 넣는 기능
		
		//오른쪽 패널 추가
		eastPanel.add(simpleInfor);
		
		//왼쪽 패널 추가
		westPanel.add(detailComboYear);
		westPanel.add(dLabelYear);
		westPanel.add(detailComboMonth);
		westPanel.add(dLabelMonth);
		westPanel.add(detailComboArea);
		westPanel.add(wtSearch);
		westPanel.add(svSearch);
		westPanel.add(spaceL1);
		//westPanel.add(inforUser);
		westPanel.add(userInfor);
		
		//westPanel.add(userSearch);
		
		setSize(1100,820);
		setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginSys check=new LoginSys();
		
	}
	
	//우측 패널 간단 날씨 데이터 제공
	void simpleInforExp()
	{
		
		
		try
		{
			makeConnection();
			stmt=con.createStatement();
			
			//영어로 된 테이블 이름을 저장해둔 것에 접근하여 모든 지역에 대한 날씨 조회를 실시하게 됩니다
			for(int c=0;c<=areaEng.length;c++)
			{
				//년도 카운트 용도
				int yearCount=0;
				int yearTempBefore=0;
				int yearTempNow=0;
				String yearToken;
				
				String areaName=null;
				//날씨 값 임시 저장용
				String rainTemp;
				String cloudTemp;
				String snowTemp;
				String avgTemper;
				
				StringTokenizer st;
				//DB에서 불러온 날짜
				String strTemp;
				String dayTemp;
				String monthTemp;
				int dbMonth;
				int dbDay;
				
				//날씨 데이터 저장을 위한 구간
				int rainRes=0;
				int snowRes=0;
				int cloudRes=0;
				int sunRes=0;
				
				int cloudInt;
				int snowInt;
				int rainInt;
				
				
				ResultSet result=stmt.executeQuery("SELECT * FROM weather."+areaEng[c]);
				
				while (result.next())
				{
					//date에 해당하는 값 가져오고
					strTemp=result.getString("date");
					//DB에 저장되어있는 data관련에는 "-"로 년도 월 일 구분이 되어있어 이런 조건이 필요합니다
					st=new StringTokenizer(strTemp,"-");
					yearToken=st.nextToken();//년도
					monthTemp=st.nextToken();//월
					dayTemp=st.nextToken();//일
					
					yearTempNow=Integer.parseInt(yearToken);
					dbDay=Integer.parseInt(dayTemp);
					dbMonth=Integer.parseInt(monthTemp);
					
					if(yearTempBefore!=yearTempNow)
					{
						//년도가 바뀐거니까 전에 있던 년도는 최신 년도로 변경에서 변수에 넣습니다.
						yearTempBefore=yearTempNow;
						//년도 카운트는 1 늘립니다.
						yearCount++;
					}
					
					if(dbMonth==usercomboInt)
					{
						if(dbDay==usercomboDay)
						{
							
							cloudTemp=result.getString("cloud");
							rainTemp=result.getString("rain");
							snowTemp=result.getString("snow");
							avgTemper=result.getString("avgtemp");
							
							//문자열 변수를 double형 변수로 바꾸고
							cloud=(Double.parseDouble(cloudTemp));
							rain=(Double.parseDouble(rainTemp));
							snow=(Double.parseDouble(snowTemp));
							avgtempDa=(Double.parseDouble(avgTemper));
							
							//구름의 양이 6할이 넘을 경우 날씨 흐림으로 판단하게 하였습니다
							if(cloud>6)
							{
								cloudInt=1;
							}
							else
							{
								cloudInt=0;
							}
							//눈이 조금이라도 내렸으면 날씨 눈으로 조정!
							if(snow>0)
							{
								snowInt=1;
							}
							else
							{
								snowInt=0;
							}
							//비 일정 이상 내렸으면 비로 조정!
							if(rain>0.5)
							{
								rainInt=1;
							}
							else
							{
								rainInt=0;
							}
							
							
							cloudRes=cloudInt+cloudRes;
							rainRes=rainInt+rainRes;
							snowRes=snowInt+snowRes;
						}
					}
					
					
				}
				
				//여기서부터 그 심플웨더 테이블에 적용하면됨
				cloudRes=cloudRes*100/yearCount;
				rainRes=rainRes*100/yearCount;
				snowRes=snowRes*100/yearCount;
				
				//날씨 기상 특이사항이 전체 날씨의 50%가 넘을 경우
				if(cloudRes+rainRes+snowRes>50)
				{
					if(cloudRes<=rainRes)
					{
						if(rainRes<=snowRes)
						{
							//1순위
							weatherData[c][1]="눈: "+snowRes+"%";
							
						}
						else
						{
							//1순위
							weatherData[c][1]="비: "+rainRes+"%";
							
						}
					}
					else
					{
						if(cloudRes<=snowRes)
						{
							//1순위
							weatherData[c][1]="눈: "+snowRes+"%";
							
						}
						else
						{
							//1순위
							weatherData[c][1]="흐림: "+cloudRes+"%";
							
						}
					}
				}
				
				else
				{
					weatherData[c][1]="맑음: "+(100-cloudRes-rainRes-snowRes)+"%";
				}
				
				
				
			}
			
			
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	//이미지패널 class를 이용하여 컴포넌트에 이미지 넣기 위한 기능
	class ImagePanel extends JPanel{
		private static final long serialVersionUID=1L;
		@Override
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawImage(korea,0,0,null);
		}
	}
	
	//로그인을 위한 메소드
	void loginUser(String userID)
	{
		try
		{
			makeConnection();
			stmt=con.createStatement();
			ResultSet result=stmt.executeQuery("SELECT * FROM weather.user");
			
			
			//db에 있는 값이 다 불러와질때까지..
			while (result.next())
			{
				String dbID=result.getString("id");
				
				//유저가 입력한 거하고 DB에 저장되어있는 ID하고 비번이 일치할 경우
				if((userID.equals(dbID)==true))
				{
					loginName=result.getString("name");
					loginAgeStr=result.getString("age");
					loginUserAge=Integer.parseInt(loginAgeStr);
					break;
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
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
	
	//콤보박스이벤트 리스너 메소드
	private class smallActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			JComboBox actCombo =(JComboBox)e.getSource();
			//유저가 클릭한 콤보박스가 몇번쨰인지 int로 저장해두는것
			usercomboInt=actCombo.getSelectedIndex();
			
			if((usercomboInt==0)||(usercomboInt==2)||(usercomboInt==4)||(usercomboInt==6)||(usercomboInt==7)||(usercomboInt==9)||(usercomboInt==11))
			{
				sComboDay.removeAllItems();
				
				//31일까지 추가
				for(int a=0; a<=30;a++)
				{
					sComboDay.addItem(dayData31[a]);
				}
			}
			
			else if((usercomboInt==3)||(usercomboInt==5)||(usercomboInt==8)||(usercomboInt==10))
			{
				sComboDay.removeAllItems();
				
				//30일까지 추가
				for(int a=0; a<=29;a++)
				{
					sComboDay.addItem(dayData31[a]);
				}
			}
			
			else if(usercomboInt==1)
			{
				sComboDay.removeAllItems();
				
				//29일까지 추가
				for(int a=0; a<=28;a++)
				{
					sComboDay.addItem(dayData31[a]);
				}					 
			}
		
		
		}
		//이 밑에가 private action listen 끝나는거
	}	
	
	//상단 일자 관련 조정 이벤트
	private class smallDayActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			JComboBox actCombo =(JComboBox)e.getSource();
			//유저가 클릭한 콤보박스가 몇번쨰인지 int로 저장해두는것
			usercomboDay=actCombo.getSelectedIndex();
			
			simpleInforExp();
			int i=0;
			//반복문 용도
			int a=0;
			//현재 테이블에 적혀있는 열을 세줍니다
			int maxc=simpleInfor.getRowCount();
			//현재 테이블에 있는거 싹 지웁니다!
			for(a=0;a<maxc;a++)
			{
				tableModel.removeRow(0);
			}
			
			for(i=0;i<=18;i++)
			{
				
				tableModel.addRow(weatherData[i]);
			}
			
		}
		//이 밑에가 private action listen 끝나는거
	}	
	
	//
	private class detailButtonAction implements ActionListener
	{
		public void actionPerformed(ActionEvent et)
		{
			detailSearch te = new detailSearch(userYear,userMonth,userArea);
		}
	//이 밑에 private action listen 끝남
	}
	
	//이건 여행 버튼 이벤트
	private class userTripButtonAction implements ActionListener
	{
		public void actionPerformed(ActionEvent et)
		{
			userTrip ut = new userTrip(loginName,loginUserAge,userMonth,userArea);
		}
	//이 밑에 private action listen 끝남
	}
	
	
	private class yearComboAction implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			JComboBox actCombo =(JComboBox)event.getSource();
			//유저가 클릭한 콤보박스가 어떤것인지 string 문자열로 저장해둡니다
			userYear=actCombo.getSelectedItem().toString();
		}
	//이 밑에 private action listen 끝남
	}
	
	private class monthComboAction implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			JComboBox actCombo =(JComboBox)event.getSource();
			//유저가 클릭한 콤보박스가 어떤것인지 string 문자열로 저장해둡니다
			userMonth=actCombo.getSelectedItem().toString();
		}
	//이 밑에 private action listen 끝남
	}
	
	private class areaComboAction implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			JComboBox actCombo =(JComboBox)event.getSource();
			//유저가 클릭한 콤보박스가 어떤것인지 string 문자열로 저장해둡니다
			userArea=actCombo.getSelectedItem().toString();
		}
	//이 밑에 private action listen 끝남
	}
	
}
