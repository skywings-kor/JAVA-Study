import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.tree.*;
import java.util.StringTokenizer;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;

import javax.swing.event.*;

public class detailSearch extends JFrame{
	//SQL부분
	String URL="jdbc:mysql://localhost:3306/weather?serverTimezone=Asia/Seoul";
	Connection con=null;
	String id="root";
	String password="root";
	Statement stmt=null;
	
	//공간 패널 선언용 (위에 중간 아래)
	JPanel basePanel=new JPanel(new BorderLayout());
	JPanel centerPanel =new JPanel();
	JPanel eastPanel=new JPanel();
	JPanel northPanel=new JPanel();
	
	//테이블 선언
	JTable inforTable;
	DefaultTableModel tableModel;
	
	//테이블 배열 선언
	String columName[]= {"년도","월","일","요일","지역","상세 관측지역","평균 온도","예상 날씨1","예상 날씨2"};
	
	//날씨 테이블 세팅 위한 변수
	int DBcloud=0;
	int DBmintemp=0;
	int DBmaxtemp=0;
	int DBrain=0;
	int DBsnow=0;
	int DBavgtemp=0;
	
	//날씨 카운트용도
	double rain=0;
	double snow=0;
	double cloud=0;
	double avgtempDa=0;
	double[] cloudIndex = new double[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	double[] rainIndex = new double[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	double[] snowIndex = new double[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	double[] avgIndex = new double[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	
	
	//테이블 배열
	Object [][] weatherData= 
	{
		{"","","","","","","","",""},
		{"","","","","","","","",""},
		{"","","","","","","","",""},
		{"","","","","","","","",""},
		{"","","","","","","","",""},
		{"","","","","","","","",""},
		{"","","","","","","","",""},
		{"","","","","","","","",""},
		{"","","","","","","","",""},
		{"","","","","","","","",""},
		{"","","","","","","","",""},
		{"","","","","","","","",""},
		{"","","","","","","","",""},
		{"","","","","","","","",""},
		{"","","","","","","","",""},
		{"","","","","","","","",""},
		{"","","","","","","","",""},
		{"","","","","","","","",""},
		{"","","","","","","","",""},
		{"","","","","","","","",""},
		{"","","","","","","","",""},
		{"","","","","","","","",""},
		{"","","","","","","","",""},
		{"","","","","","","","",""},
		{"","","","","","","","",""},
		{"","","","","","","","",""},
		{"","","","","","","","",""},
		{"","","","","","","","",""},
		{"","","","","","","","",""},
		{"","","","","","","","",""},
		{"","","","","","","","",""}
	};

	
	public detailSearch(String uy,String um, String ua)
	{
		System.out.println(uy+um+ua);
		setTitle("Weather Detail System");
		setContentPane(basePanel);		//내가 만든 베이스 패널 객체로 대체되게 하는 것
		
		basePanel.add(centerPanel,BorderLayout.CENTER);
		basePanel.add(eastPanel,BorderLayout.EAST);
		basePanel.add(northPanel,BorderLayout.NORTH);
		
		//테이블 세팅을 위한 DB에서 가져오기 위한 함수!
		dataTableSet(uy,um,ua);
		
		//테이블 세팅
		tableModel=new DefaultTableModel(weatherData,columName);
		inforTable=new JTable(tableModel);
		JScrollPane sp=new JScrollPane(inforTable);
		
		System.out.println(inforTable.getValueAt(29, 3));
		//현재 테이블에 적혀있는 열을 세줍니다
		int maxc=inforTable.getRowCount();
		//현재 테이블에 있는거 싹 지웁니다!
		for(int a=0;a<maxc;a++)
		{
			if(inforTable.getValueAt(a, 3)==null)
			{
				tableModel.removeRow(a);
			}
		}
		
		//테이블 크기 조정
		sp.setPreferredSize(new Dimension(700,600));
				
		
		
		//centerPanel적용
		centerPanel.add(sp);
		
		setSize(800,600);
		setLocation(700,200);
		setVisible(true);
	}
	
	//테이블세팅 함수
	void dataTableSet(String ty,String tm,String ta)
	{
		
		String tsArea = null;
		try
		{
			makeConnection();
			stmt=con.createStatement();
			
			//여기는 그 유저가 콤보박스에서 선택한것은 한국어인데 DB 테이블 이름은 영어라서 변환하기 위해 이 문단들을 실행하게 됩니다
			if(ta.equals("서울특별시")==true)
			{
				tsArea="seoul";
			}
			else if(ta.equals("강원도(남)")==true)
			{
				tsArea="wonju";
			}
			else if(ta.equals("강원도(북)")==true)
			{
				tsArea="chuncheon";
			}
			else if(ta.equals("강원도(동)")==true)
			{
				tsArea="gangneung";
			}
			else if(ta.equals("경기도(남부)")==true)
			{
				tsArea="suwon";
			}
			else if(ta.equals("경기도(북부)")==true)
			{
				tsArea="paju";
			}
			else if(ta.equals("경상남도")==true)
			{
				tsArea="jinju";
			}
			else if(ta.equals("경상북도")==true)
			{
				tsArea="andong";
			}
			else if(ta.equals("광주광역시")==true)
			{
				tsArea="gwangju";
			}
			else if(ta.equals("대구광역시")==true)
			{
				tsArea="daegu";
			}
			else if(ta.equals("대전광역시")==true)
			{
				tsArea="daejeon";
			}
			else if(ta.equals("부산광역시")==true)
			{
				tsArea="busan";
			}
			else if(ta.equals("울산광역시")==true)
			{
				tsArea="ulsan";
			}
			else if(ta.equals("인천광역시")==true)
			{
				tsArea="incheon";
			}
			else if(ta.equals("전라남도")==true)
			{
				tsArea="mokpo";
			}
			else if(ta.equals("전라북도")==true)
			{
				tsArea="jeonju";
			}
			else if(ta.equals("제주도")==true)
			{
				tsArea="jeju";
			}
			else if(ta.equals("충청남도")==true)
			{
				tsArea="cheonan";
			}
			else if(ta.equals("충청북도")==true)
			{
				tsArea="cheongju";
			}
			
			//유저가 입력한 지역을 영어로 변환한 문자열을 여기에 연결시켜서 바로 지역 데이터에 해당되는 테이블로 이동!
			ResultSet result=stmt.executeQuery("SELECT * FROM weather."+tsArea);
			
			String dayStr;
			
			//년도 카운트 용도
			int yearCount=0;
			int yearTempBefore=0;
			int yearTempNow=0;
			String yearToken;
			
			//월
			String monthToken;
			//일
			String dayToken;
			int tsDay;
			//stringTokenizer date 나누기 위한용도
			StringTokenizer st;
			
			//날씨 값 임시 저장용
			String rainTemp;
			String cloudTemp;
			String snowTemp;
			String avgTemper;
			
			//관측지역 이름
			String checkArea = null;
			
			//맑음 변수
			double sunnyTemp;
			
			
			
			//db에 있는 값이 다 불러와질때까지..
			while (result.next())
			{
				//date에 해당하는 값 가져오고
				dayStr=result.getString("date");
				//DB에 저장되어있는 data관련에는 "-"로 년도 월 일 구분이 되어있어 이런 조건이 필요합니다
				st=new StringTokenizer(dayStr,"-");
				yearToken=st.nextToken();
				yearTempNow=Integer.parseInt(yearToken);
				
				//월 들어오는거
				monthToken=st.nextToken();
				
				//일 들어오는거
				dayToken=st.nextToken();
				
				if(yearTempBefore!=yearTempNow)
				{
					//년도가 바뀐거니까 전에 있던 년도는 최신 년도로 변경에서 변수에 넣습니다.
					yearTempBefore=yearTempNow;
					//년도 카운트는 1 늘립니다.
					yearCount++;
				}
				
				//유저가 메인에서 선택한 '월'이 db에서 month랑 같을 경우
				if(tm.equals(monthToken)==true)
				{
					if(dayToken.equals("01"))
					{
						tsDay=0;
					}
					else if(dayToken.equals("02"))
					{
						tsDay=1;
					}
					else if(dayToken.equals("03"))
					{
						tsDay=2;
					}
					else if(dayToken.equals("04"))
					{
						tsDay=3;
					}
					else if(dayToken.equals("05"))
					{
						tsDay=4;
					}
					else if(dayToken.equals("06"))
					{
						tsDay=5;
					}
					else if(dayToken.equals("07"))
					{
						tsDay=6;
					}
					else if(dayToken.equals("08"))
					{
						tsDay=7;
					}
					else if(dayToken.equals("09"))
					{
						tsDay=8;
					}
					else
					{
						tsDay=Integer.parseInt(dayToken);
						//배열은 -1 된 채로 공간이 잡히기 때문입니다.
						tsDay=tsDay-1;
					}
					
					//먼저 string열로 저장된 값을 변수에 넣고
					cloudTemp=result.getString("cloud");
					rainTemp=result.getString("rain");
					snowTemp=result.getString("snow");
					avgTemper=result.getString("avgtemp");
					
					//관측지역 넣어주기
					checkArea=result.getString("area");
					
					//문자열 변수를 double형 변수로 바꾸고
					cloud=(Double.parseDouble(cloudTemp));
					rain=(Double.parseDouble(rainTemp));
					snow=(Double.parseDouble(snowTemp));
					avgtempDa=(Double.parseDouble(avgTemper));
					
					//구름의 양이 6할이 넘을 경우 날씨 흐림으로 판단하게 하였습니다
					if(cloud>6)
					{
						cloud=1;
					}
					else
					{
						cloud=0;
					}
					//눈이 조금이라도 내렸으면 날씨 눈으로 조정!
					if(snow>0)
					{
						snow=1;
					}
					else
					{
						snow=0;
					}
					//비 일정 이상 내렸으면 비로 조정!
					if(rain>0.5)
					{
						rain=1;
					}
					else
					{
						rain=0;
					}
					
					
					cloudIndex[tsDay]=cloud+cloudIndex[tsDay];
					rainIndex[tsDay]=rain+rainIndex[tsDay];
					snowIndex[tsDay]=snow+snowIndex[tsDay];
					avgIndex[tsDay]=avgtempDa+avgIndex[tsDay];
				}
			}
			
			double temperatureAvr;
			System.out.println(yearCount);
			//여기는 weatherData 테이블에 들어갈 변수에 값을 넣는 것 입니다.
			for(int i=0; i<avgIndex.length;i++)
			{
				int yearChange;
				yearChange=Integer.parseInt(ty);
				if((yearChange % 4==0 && yearChange % 100 != 0) || yearChange%400 == 0)
				{
					if(i==29)
					{
						break;
					}
				}
				
				else
				{
					if(tm.equals("02")==true)
					{
						if(i==28)
						{
							break;
						}
					}
				}
				
				if((tm.equals("04")==true)||(tm.equals("06")==true)||(tm.equals("09")==true)||(tm.equals("11")==true))
				{
					if(i==30)
					{
						break;
					}
				}
				
				//날짜 데이터에 넣는거
				//년도
				weatherData[i][0]=ty;
				
				//월
				weatherData[i][1]=tm;
				
				//일
				weatherData[i][2]=i+1;
				
				//요일
				LocalDate date=LocalDate.of(Integer.parseInt(ty),Integer.parseInt(tm),i+1);
				weatherData[i][3]=(date.getDayOfWeek()).getDisplayName(TextStyle.FULL, Locale.KOREAN);
				
				//지역
				weatherData[i][4]=ta;
				
				//관측지역
				weatherData[i][5]=checkArea;
				
				//평균온도
				temperatureAvr=avgIndex[i]/yearCount;
				weatherData[i][6]=temperatureAvr;
				
				//예상날씨 순위 정렬
				cloudIndex[i]=(cloudIndex[i]/yearCount)*100;
				rainIndex[i]=(rainIndex[i]/yearCount)*100;
				snowIndex[i]=(snowIndex[i]/yearCount)*100;
				sunnyTemp=(100-cloudIndex[i]-rainIndex[i]-snowIndex[i])*100;
				
				if(cloudIndex[i]<=rainIndex[i])
				{
					if(rainIndex[i]<=snowIndex[i])
					{
						//1순위
						weatherData[i][7]="눈:"+snowIndex[i]+"%";
						if(cloudIndex[i]<=rainIndex[i])
						{
							//2순위
							weatherData[i][8]="비:"+rainIndex[i]+"%";
						}
						else
						{
							//2순위
							weatherData[i][8]="흐림:"+cloudIndex[i]+"%";
						}
					}
					else
					{
						//1순위
						weatherData[i][7]="비:"+rainIndex[i]+"%";
						if(cloudIndex[i]<=snowIndex[i])
						{
							//2순위
							weatherData[i][8]="눈:"+snowIndex[i]+"%";
						}
						else
						{
							//2순위
							weatherData[i][8]="흐림:"+cloudIndex[i]+"%";
						}
					}
				}
				else
				{
					if(cloudIndex[i]<=snowIndex[i])
					{
						//1순위
						weatherData[i][7]="눈:"+snowIndex[i]+"%";
						if(cloudIndex[i]<=rainIndex[i])
						{
							//2순위
							weatherData[i][8]="비:"+rainIndex[i]+"%";
						}
						else
						{
							//2순위
							weatherData[i][8]="흐림:"+cloudIndex[i]+"%";
						}
					}
					else
					{
						//1순위
						weatherData[i][7]="흐림:"+cloudIndex[i]+"%";
						if(rainIndex[i]<=snowIndex[i])
						{
							//2순위
							weatherData[i][8]="눈:"+snowIndex[i]+"%";
						}
						else
						{
							//2순위
							weatherData[i][8]="비:"+rainIndex[i]+"%";
						}
					}
				}
				
				//여기는 맑음까지 포함하였을 때 나타는 확률입니다. 이런 경우 맑음이 너무 잦아 기상 특이사항 확률로 진행하였습니다.
//				if(cloudIndex[i]<=rainIndex[i])
//				{
//					if(rainIndex[i]<=snowIndex[i])
//					{
//						if(snowIndex[i]<=sunnyTemp)
//						{
//							//1순위
//							weatherData[i][7]=sunnyTemp;
//							if(cloudIndex[i]<=rainIndex[i])
//							{
//								if(rainIndex[i]<=snowIndex[i])
//								{
//									//2순위값 넣는곳
//									weatherData[i][8]=snowIndex[i];
//								}
//								else
//								{
//									//2순위값 넣는곳
//									weatherData[i][8]=rainIndex[i];
//								}
//							}
//							else
//							{
//								if(cloudIndex[i]<=snowIndex[i])
//								{
//									//2순위값 넣는곳
//									weatherData[i][8]=snowIndex[i];
//								}
//								else
//								{
//									//2순위 값 넣는곳
//									weatherData[i][8]=cloudIndex[i];
//								}
//							}
//						}
//						else
//						{
//							//1순위
//							weatherData[i][7]=snowIndex[i];
//							if(cloudIndex[i]<=rainIndex[i])
//							{
//								if(rainIndex[i]<=sunnyTemp)
//								{
//									//2순위값 넣는곳
//									weatherData[i][8]=sunnyTemp;
//								}
//								else
//								{
//									//2순위값 넣는곳
//									weatherData[i][8]=rainIndex[i];
//								}
//							}
//							else
//							{
//								if(cloudIndex[i]<=sunnyTemp)
//								{
//									//2순위값 넣는곳
//									weatherData[i][8]=sunnyTemp;
//								}
//								else
//								{
//									//2순위 값 넣는곳
//									weatherData[i][8]=cloudIndex[i];
//								}
//							}
//						}
//					}
//					else
//					{
//						if(rainIndex[i]<=sunnyTemp)
//						{
//							//1순위
//							weatherData[i][7]=rainIndex[i];
//							if(cloudIndex[i]<=snowIndex[i])
//							{
//								if(snowIndex[i]<=sunnyTemp)
//								{
//									//2순위값 넣는곳
//									weatherData[i][8]=sunnyTemp;
//								}
//								else
//								{
//									//2순위값 넣는곳
//									weatherData[i][8]=snowIndex[i];
//								}
//							}
//							else
//							{
//								if(cloudIndex[i]<=sunnyTemp)
//								{
//									//2순위값 넣는곳
//									weatherData[i][8]=sunnyTemp;
//								}
//								else
//								{
//									//2순위 값 넣는곳
//									weatherData[i][8]=cloudIndex[i];
//								}
//							}
//						}
//						else
//						{
//							//1순위
//							weatherData[i][7]=rainIndex[i];
//							if(cloudIndex[i]<=snowIndex[i])
//							{
//								if(snowIndex[i]<=sunnyTemp)
//								{
//									//2순위값 넣는곳
//									weatherData[i][8]=sunnyTemp;
//								}
//								else
//								{
//									//2순위값 넣는곳
//									weatherData[i][8]=snowIndex[i];
//								}
//							}
//							else
//							{
//								if(cloudIndex[i]<=sunnyTemp)
//								{
//									//2순위값 넣는곳
//									weatherData[i][8]=sunnyTemp;
//								}
//								else
//								{
//									//2순위 값 넣는곳
//									weatherData[i][8]=cloudIndex[i];
//								}
//							}
//						}
//					}
//				}
//				else
//				{
//					if(cloudIndex[i]<=snowIndex[i])
//					{
//						if(snowIndex[i]<=sunnyTemp)
//						{
//							//1순위
//							weatherData[i][7]=sunnyTemp;
//							if(cloudIndex[i]<=rainIndex[i])
//							{
//								if(rainIndex[i]<=snowIndex[i])
//								{
//									//2순위값 넣는곳
//									weatherData[i][8]=snowIndex[i];
//								}
//								else
//								{
//									//2순위값 넣는곳
//									weatherData[i][8]=rainIndex[i];
//								}
//							}
//							else
//							{
//								if(cloudIndex[i]<=snowIndex[i])
//								{
//									//2순위값 넣는곳
//									weatherData[i][8]=snowIndex[i];
//								}
//								else
//								{
//									//2순위 값 넣는곳
//									weatherData[i][8]=cloudIndex[i];
//								}
//							}
//						}
//						else
//						{
//							//1순위
//							weatherData[i][7]=snowIndex[i];
//							if(cloudIndex[i]<=rainIndex[i])
//							{
//								if(rainIndex[i]<=sunnyTemp)
//								{
//									//2순위값 넣는곳
//									weatherData[i][8]=sunnyTemp;
//								}
//								else
//								{
//									//2순위값 넣는곳
//									weatherData[i][8]=rainIndex[i];
//								}
//							}
//							else
//							{
//								if(cloudIndex[i]<=sunnyTemp)
//								{
//									//2순위값 넣는곳
//									weatherData[i][8]=sunnyTemp;
//								}
//								else
//								{
//									//2순위 값 넣는곳
//									weatherData[i][8]=cloudIndex[i];
//								}
//							}
//						}
//					}
//					else
//					{
//						if(cloudIndex[i]<=sunnyTemp)
//						{
//							//1순위 값 넣는 곳
//							weatherData[i][7]=sunnyTemp;
//							if(cloudIndex[i]<=rainIndex[i])
//							{
//								if(rainIndex[i]<=snowIndex[i])
//								{
//									//2순위값 넣는곳
//									weatherData[i][8]=snowIndex[i];
//								}
//								else
//								{
//									//2순위값 넣는곳
//									weatherData[i][8]=rainIndex[i];
//								}
//							}
//							else
//							{
//								if(cloudIndex[i]<=snowIndex[i])
//								{
//									//2순위값 넣는곳
//									weatherData[i][8]=snowIndex[i];
//								}
//								else
//								{
//									//2순위 값 넣는곳
//									weatherData[i][8]=cloudIndex[i];
//								}
//							}
//						}
//						else
//						{
//							//1순위 값 넣는 곳
//							weatherData[i][7]=cloudIndex;
//							if(rainIndex[i]<=snowIndex[i])
//							{
//								if(snowIndex[i]<=sunnyTemp)
//								{
//									//2순위값 넣는곳
//									weatherData[i][8]=sunnyTemp;
//								}
//								else
//								{
//									//2순위값 넣는곳
//									weatherData[i][8]=snowIndex[i];
//								}
//							}
//							else
//							{
//								if(rainIndex[i]<=sunnyTemp)
//								{
//									//2순위값 넣는곳
//									weatherData[i][8]=sunnyTemp;
//								}
//								else
//								{
//									//2순위 값 넣는곳
//									weatherData[i][8]=rainIndex[i];
//								}
//							}
//						}
//					}
//				}
				
				
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
	
	
}
