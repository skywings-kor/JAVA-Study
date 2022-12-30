import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.*;
import javax.swing.tree.*;
import javax.swing.event.*;
import java.awt.BorderLayout;


import java.util.StringTokenizer;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;

import javax.swing.event.*;

public class userTrip extends JFrame{
	//SQL부분
	String URL="jdbc:mysql://localhost:3306/weather?serverTimezone=Asia/Seoul";
	Connection con=null;
	String id="root";
	String password="root";
	Statement stmt=null;
	
	//공간 패널 선언용 (위에 중간 아래)
	JPanel basePanel=new JPanel(new BorderLayout());
	JPanel centerPanel =new JPanel();
	JPanel westPanel=new JPanel();
	JPanel northPanel=new JPanel();
	JPanel southPanel=new JPanel();
	
	//
	String placeN2;
	//이미지 연결 경로 변수
	String ageImage="";
	String monthImage="";
	
	//이미지 변수
	Image Fimage;
	
	//라벨링 데이터 세팅
	JLabel userAge;
	JLabel userName;
	JLabel userName1;
	JLabel userName2;
	
	JLabel test;
	JLabel placeName;
	JLabel placeExplain;
	
	//문장 불러와서 지역값만 추추할 때 쓰기위한 변수
	String tLR;
	String areaName;
	
	//외곽선 그릴때 사용하는거
	LineBorder bb = new LineBorder(Color.black, 1, true);
	
	//추천여행일자
	JLabel yourTrip;
	String [] tripRec= {"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
	int[] cloudIndex = new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	int[] rainIndex = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	int[] snowIndex = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	int[] avgIndex = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	
	JLabel tripRecommend;
	//un-> 로그인한 유저 이름
	//ua-> 로그인한 유저 나이
	//um-> 유저가 입력한 월
	public userTrip(String un,int ua,String um, String area)
	{
		setTitle("Weather Detail System");
		setContentPane(basePanel);		//내가 만든 베이스 패널 객체로 대체되게 하는 것
		
		westPanel.setPreferredSize(new Dimension(300,basePanel.getHeight()));		//크기를 200으로 고정하고 있게 됨
		//나이대별 사진 전송구간
		//0대~10대
		if((0<=ua)&&(ua<20))
		{
			ageImage="10";
		}
		//20~30대
		else if((20<=ua)&&(ua<40))
		{
			ageImage="30";
		}
		
		//40대 이후
		else
		{
			ageImage="50";
		}
		
		System.out.println(um);
		//여기는 그 월별 나누기 위한 것
		if(um.equals("01")==true)
			monthImage="Ja";
		else if(um.equals("02")==true)
			monthImage="Fe";
		else if(um.equals("03")==true)
			monthImage="Ma";
		else if(um.equals("04")==true)
			monthImage="Ap";
		else if(um.equals("05")==true)
			monthImage="Ma";
		else if(um.equals("06")==true) 
			monthImage="Jun";
		else if(um.equals("07")==true) 
			monthImage="Jul";
		else if(um.equals("08")==true) 
			monthImage="Ag";
		else if(um.equals("09")==true) 
			monthImage="Se";
		else if(um.equals("10")==true) 
			monthImage="Oc";
		else if(um.equals("11")==true) 
			monthImage="No";
		else if(um.equals("12")==true) 
			monthImage="De";
				
		//이미지 변수값 저장된거 적용
		ImageIcon koreaIcon=new ImageIcon("C:\\Users\\v2109\\eclipse-workspace\\Weather_System\\src\\image\\"+monthImage+ageImage+".jpg");
		System.out.println(koreaIcon);
		Fimage=koreaIcon.getImage();
		
		//패널에 이미지 적용
		centerPanel=new ImagePanel();
		
		
		basePanel.add(centerPanel,BorderLayout.CENTER);
		basePanel.add(westPanel,BorderLayout.WEST);
		basePanel.add(northPanel,BorderLayout.NORTH);
		basePanel.add(southPanel,BorderLayout.SOUTH);
		westPanel.setLayout(new FlowLayout());
		westPanel.setBackground(Color.white);
		centerPanel.setBackground(Color.white);
		//사진에 알맞는 데이터 불러오는거
		loadData(ageImage,monthImage);
		
		//추천 여행일자
		tripDayUser(um,placeN2);
		
		tripRecommend=new JLabel(tripRec[0]+tripRec[1]+tripRec[2]+tripRec[3]+tripRec[4]+tripRec[5]);
		//라벨에 값 넣기
		int uagetemp=ua/10;
		userName=new JLabel(uagetemp*10+"대 이신");
		userName.setOpaque(true); 
		userName.setBackground(Color.orange);
		userName.setFont(new Font("굴림",Font.BOLD,20));
		userName.setHorizontalAlignment(JLabel.CENTER);
		
		userName1=new JLabel(un+"님을 위한");
		userName1.setOpaque(true); 
		userName1.setBackground(Color.white);
		userName1.setFont(new Font("굴림",Font.BOLD,20));
		userName1.setHorizontalAlignment(JLabel.CENTER);
		
		
		yourTrip=new JLabel("추천 여행일=> ");
		yourTrip.setOpaque(true); 
		yourTrip.setBackground(Color.green);
		yourTrip.setFont(new Font("굴림",Font.BOLD,20));
		yourTrip.setHorizontalAlignment(JLabel.LEFT);
		
		
		//라벨 크기 조절
		userName.setPreferredSize(new Dimension(200,50));
		userName1.setPreferredSize(new Dimension(200,210));
		
		//라벨 윤곽선그리기
		placeName.setBorder(bb);
		userName1.setBorder(bb);
		yourTrip.setBorder(bb);
		
		//센터패널 추가
		
		
		//서쪽패널 추가
		westPanel.add(userName);
		westPanel.add(userName1);
		westPanel.add(placeName);
		westPanel.add(placeExplain);
		
		//남쪽패널 추가
		southPanel.add(yourTrip);
		southPanel.add(tripRecommend);
		
		setSize(700,500);
		setLocation(700,200);
		setVisible(true);
	}
	
	//추천여행일자 구하는 시스템
	void tripDayUser(String umonth,String placeN)
	{
		int yeari;
		int chmonth=0;
		chmonth=Integer.parseInt(umonth);
		if((umonth.equals("04")==true)||(umonth.equals("06")==true)||(umonth.equals("09")==true)||(umonth.equals("11")==true))
		{
			yeari=30;
		}
		else if(umonth.equals("02")==true)
		{
			yeari=28;
		}
		else
		{
			yeari=31;
		}
		
		try
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
			
			double cloud;
			double rain;
			double snow;
			makeConnection();
			stmt=con.createStatement();
			
			//DB에 여행지 추천 이름 분할해서 저장
			st=new StringTokenizer(placeN," ");
			String placeArea=st.nextToken();//지역이름
			String tsArea=null;
			//여기는 그 유저가 콤보박스에서 선택한것은 한국어인데 DB 테이블 이름은 영어라서 변환하기 위해 이 문단들을 실행하게 됩니다
			if(placeArea.equals("서울특별시")==true)
			{
				tsArea="seoul";
			}
			else if(placeArea.equals("강원도(남)")==true)
			{
				tsArea="wonju";
			}
			else if(placeArea.equals("강원도(북)")==true)
			{
				tsArea="chuncheon";
			}
			else if(placeArea.equals("강원도(동)")==true)
			{
				tsArea="gangneung";
			}
			else if(placeArea.equals("경기도(남부)")==true)
			{
				tsArea="suwon";
			}
			else if(placeArea.equals("경기도(북부)")==true)
			{
				tsArea="paju";
			}
			else if(placeArea.equals("경상남도")==true)
			{
				tsArea="jinju";
			}
			else if(placeArea.equals("경상북도")==true)
			{
				tsArea="andong";
			}
			else if(placeArea.equals("광주광역시")==true)
			{
				tsArea="gwangju";
			}
			else if(placeArea.equals("대구광역시")==true)
			{
				tsArea="daegu";
			}
			else if(placeArea.equals("대전광역시")==true)
			{
				tsArea="daejeon";
			}
			else if(placeArea.equals("부산광역시")==true)
			{
				tsArea="busan";
			}
			else if(placeArea.equals("울산광역시")==true)
			{
				tsArea="ulsan";
			}
			else if(placeArea.equals("인천광역시")==true)
			{
				tsArea="incheon";
			}
			else if(placeArea.equals("전라남도")==true)
			{
				tsArea="mokpo";
			}
			else if(placeArea.equals("전라북도")==true)
			{
				tsArea="jeonju";
			}
			else if(placeArea.equals("제주도")==true)
			{
				tsArea="jeju";
			}
			else if(placeArea.equals("충청남도")==true)
			{
				tsArea="cheonan";
			}
			else if(placeArea.equals("충청북도")==true)
			{
				tsArea="cheongju";
			}
			
			
			//영어로 된 테이블 이름을 저장해둔 것에 접근하여 모든 지역에 대한 날씨 조회를 실시하게 됩니다
			ResultSet result=stmt.executeQuery("SELECT * FROM weather."+tsArea);
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
					
					if(chmonth==dbMonth)
					{
							cloudTemp=result.getString("cloud");
							rainTemp=result.getString("rain");
							snowTemp=result.getString("snow");
							
							//문자열 변수를 double형 변수로 바꾸고
							cloud=(Double.parseDouble(cloudTemp));
							rain=(Double.parseDouble(rainTemp));
							snow=(Double.parseDouble(snowTemp));
							
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
							
							
							cloudIndex[dbDay-1]=cloudInt+cloudIndex[dbDay-1];
							rainIndex[dbDay-1]=rainInt+rainIndex[dbDay-1];
							snowIndex[dbDay-1]=snowInt+snowIndex[dbDay-1];
						}
					}
					
					
				
				
				
				
				for(int g=0;g<=tripRec.length;g++)
				{
					
					cloudRes=cloudIndex[g]*100/yearCount;
					rainRes=rainIndex[g]*100/yearCount;
					snowRes=snowIndex[g]*100/yearCount;
					
					//날씨 기상 특이사항이 전체 날씨의 40%가 넘을 경우
					if(cloudRes+rainRes+snowRes>40)
					{
						if(cloudRes<=rainRes)
						{
							if(rainRes<=snowRes)
							{
								//1순위
								
								//weatherData[c][1]="눈: "+snowRes+"%";
								
							}
							else
							{
								//1순위
								//weatherData[c][1]="비: "+rainRes+"%";
								
							}
						}
						else
						{
							if(cloudRes<=snowRes)
							{
								//1순위
								//weatherData[c][1]="눈: "+snowRes+"%";
								
							}
							else
							{
								//1순위
								//weatherData[c][1]="흐림: "+cloudRes+"%";
								
							}
						}
					}
					
					else
					{
						tripRec[g]=Integer.toString(g+1);
						tripRec[g]=tripRec[g]+"일 ";
					}
				}
				
				
				
				
			
			
			
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	
	//DB로부터 데이터를 읽어 여행지 데이터 추출
	void loadData(String Uage,String Umonth)
	{
		try
		{
			makeConnection();
			stmt=con.createStatement();
			ResultSet result=stmt.executeQuery("SELECT * FROM weather.trip");
			
			
			//db에 있는 값이 다 불러와질때까지..
			while (result.next())
			{
				
				//DB에서 나이와 추천월의 데이터들을 임시 변수에 저장하고
				String dbAge=result.getString("age");
				String dbMonth=result.getString("month");
					
				//유저에 저장되어있는 데이터가 추천나이하고 추천월이 같을 경우
				if((Uage.equals(dbAge)==true)&&(Umonth.equals(dbMonth)==true))
				{
					tLR=result.getString("place");
					placeN2=result.getString("place");
					placeName=new JLabel(result.getString("place"));
					placeName.setFont(new Font("굴림",Font.BOLD,20));
					
					placeExplain=new JLabel(result.getString("explain"));
					placeExplain.setFont(new Font("굴림",Font.PLAIN,12));
					//stringTokenizer 지역 이름 나누기 위한용도
					StringTokenizer st;
					st=new StringTokenizer(tLR," ");
					areaName=st.nextToken();
				}
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	class ImagePanel extends JPanel{
		private static final long serialVersionUID=1L;
		@Override
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawImage(Fimage,0,0,null);
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
	
	
}
