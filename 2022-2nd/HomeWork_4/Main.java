//개발자: 2019243064 박규민
//개발목적: 학생 관리 프로그램 개발로 효율적인 학생 명단 관리와 추가적으로 GUI 기반으로 사용자가 더욱 손쉽게 명단 관리를 진행할 수 있도록 하기 위함
//개발일: 2022.09.27 ~ 2022.11.20
//수정일자: 
//ver1.0 -> 22.09.27(학생정보관리 시스템 기본)
//ver2.0 -> 22.10.13(콤보박스 및 체크박스 필터링 기능 추가)
//ver3.0 -> 22.11.12(회원가입 시스템 적용)
//ver4.0 -> 22.11.20 (DB 데이터 삽입 및 DB 데이터 불러와서 활용)


import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.tree.*;
import javax.swing.event.*;



public class Main extends JFrame{
	
	//SQL 세팅 부분
	String URL="jdbc:mysql://localhost:3306/university?serverTimezone=Asia/Seoul";
	Connection con=null;
	String id="root";
	String password="root";
	Statement stmt=null;
	
	//체크박스용 String 문자열 전달용
	String treeState;
	
	//부서 필드 배열 선언(11개 학과라 11로 지정)
	String [] Depart= new String[11];
	String userSelect;
	
	//트리 노드로 들어갈 학년표시용
	String [] treeGrade= {"1학년","2학년","3학년","4학년"};
	
	//전체 인덱스에 해당하는 값으로 초기값지정
		int user=5;
		int split=0;
		
		Object [][] Student= 
			{
					{"콤보박스에서","학과 선택 후","체크박스를 선택하여","학생 검색 서비스를","이용할 수 있습니다"},
					{"","","","",""},
					{"","","","",""},
					{"","","","",""},
					{"","","","",""},
					{"","","","",""},
					{"","","","",""},
					{"","","","",""},
					{"","","","",""},
					{"","","","",""},
					{"","","","",""},
					{"","","","",""},
					{"","","","",""},
					{"","","","",""},
					{"","","","",""},
					{"","","","",""},
			};
		
		Object [][] Computer= new Object[Student.length][Student[0].length];
		
		
		
		//공간 패널 선언용 (위에 중간 아래)
		JPanel basePanel=new JPanel(new BorderLayout());
		JPanel westPanel=new JPanel();
		JPanel centerPanel =new JPanel();
		
		//West Panel용 컴포넌트들
		JLabel titleLabel=new JLabel("Select Student Type");
		JCheckBox usCheck=new JCheckBox("학부생");	
		JCheckBox gsCheck=new JCheckBox("대학원생");
		JComboBox comboBox;
		JTree tree;	//tree 선언이고
		//내용물은 이 두개로 정의하는 것임
		DefaultMutableTreeNode root;
		DefaultTreeModel treemodel;
		
		//센터 패널에 들어갈 컴포넌트들
		JTable table;
		DefaultTableModel tableModel;
		String columName[]= {"학과","학년","성명","구분","학번"};
		
		//메뉴 제작을 위한 필드
		JMenuBar mb = new JMenuBar();
		JMenu homeMenu=new JMenu("Main");
		JMenuItem stIn=new JMenuItem("학생등록");
		JMenuItem stDel=new JMenuItem("학생삭제");
		JMenuItem exitM=new JMenuItem("종료");
		
		
		Main()
		{
			insertDepart();
			
			int test;
			setTitle("학생정보관리시스템_박규민");
					
			//컨테이너(패널) 배치 및 크기조정
			westPanel.setPreferredSize(new Dimension(160,basePanel.getHeight()));		//크기를 160으로 고정하고 있게 됨
			setContentPane(basePanel);		//내가 만든 베이스 패널 객체로 대체되게 하는 것
			
			basePanel.add(westPanel,BorderLayout.WEST);
			basePanel.add(centerPanel,BorderLayout.CENTER);
			westPanel.setLayout(new FlowLayout());
					
			//메뉴작업
			homeMenu.add(stIn);
			homeMenu.addSeparator();
			homeMenu.add(stDel);
			homeMenu.addSeparator();
			homeMenu.add(exitM);
			mb.add(homeMenu);
			setJMenuBar(mb);	//현재 이 메뉴바 영역을 책임지는 객체로 만들어라.
			
			//웨스트 패널의 컴포넌트 작업
			comboBox=new JComboBox(Depart);
			
			//각 기능별 크기 할당
			titleLabel.setPreferredSize(new Dimension(160,20));
			comboBox.setPreferredSize(new Dimension(160,20));
			usCheck.setPreferredSize(new Dimension(70,20));
			gsCheck.setPreferredSize(new Dimension(80,20));
					
			
			//트리 제작(수업 참조)
			root=new DefaultMutableTreeNode(userSelect);
			tree=new JTree(root);
			
			
			//트리 사이즈 조정
			tree.setPreferredSize(new Dimension(160,140));
			
			
			for(int i=0; i<treeGrade.length;i++)
			{
				DefaultMutableTreeNode node = new DefaultMutableTreeNode(treeGrade[i]);
				root.add(node);		//아까 root 만들었떤거에 추가가 되는 것임
				treemodel=(DefaultTreeModel) tree.getModel();
				treemodel.setRoot(root);
			}
					
			westPanel.add(titleLabel);
			westPanel.add(usCheck);
			westPanel.add(gsCheck);
			westPanel.add(comboBox);
			westPanel.add(tree);
					
			//센터패널 작업
			tableModel=new DefaultTableModel(Student,columName);
			table=new JTable(tableModel);
			JScrollPane sp=new JScrollPane(table);
			
			centerPanel.setLayout(new BorderLayout());
			centerPanel.add(sp,BorderLayout.CENTER);
			
			//이벤트 선언을 함으로써 해당 칸에서 어떤 동작이 일어날 시 해당 담당을 맡은 구간이 실행됨
			//예시: usCheck-> "저 이제 들을 수 있어요!!!!"
			usCheck.addItemListener(new MyItemListener());
			gsCheck.addItemListener(new MyItemListener());
			exitM.addActionListener(new MenuActionListener());
			stIn.addActionListener(new MenuActionListener());
			stDel.addActionListener(new MenuActionListener());
			
			tree.addTreeSelectionListener(new TreeSelectionListener() {
					public void valueChanged(TreeSelectionEvent te)
					{
						//배열 넣기 위한 카운트용
						int incount=0;
						
						JTree actTree = (JTree)te.getSource();
						
						String segr=te.getNewLeadSelectionPath().getLastPathComponent().toString();
						
						//대학원체크에도 전달
						treeState=segr;
						
						//DB에서 가져온 값 보관할 변수선언
						String dbName,dbNum,dbGrade,dbDepart;
						int dbYear;
						
						//treeState에서 숫자만 추출되도록 하기 위한
						String tempStr=treeState;
						//0~9의 숫자가 아닌 것들을 공백으로 변경하도록 하여 changeStr에 담았습니다
						String changeStr=tempStr.replaceAll("[^0-9]","");
						//그리고 숫자만 추출한 문자열을 int형으로 변경하여줍니다.
						int changeInt=Integer.parseInt(changeStr);
						
						//테이블 한 번 초기화
						int maxc=table.getRowCount();
						
						//현재 테이블에 있는거 싹 지웁니다!
						for(int c=0;c<maxc;c++)
						{
							tableModel.removeRow(0);
						}
						try
						{
							//students_table에서 가져올거를 알리는거
							ResultSet data1=stmt.executeQuery("SELECT * FROM university.students_table");
							

							System.out.println("현재숫자"+changeStr);
							
							//해당 테이블의 마지막까지
							while(data1.next())
							{
								dbName=data1.getString("sname");
								dbNum=data1.getString("snum");
								dbYear=data1.getInt("year");
								dbGrade=data1.getString("grade");
								dbDepart=data1.getString("department");
								
								
								//학부생을 클릭했을 때 + 현재 db에서 가져온 학년하고 사용자가 누른 하위노드 학년이 같을 때 + user가 콤보박스에서 클릭했던 학과명이 같을 때
								if((split==1)&&(dbGrade.equals("학부생")==true)&&(changeInt==dbYear)&&((dbDepart.equals(userSelect))==true))
								{
									//컴퓨터라는 2차원 배열에 넣고 테이블에 한줄씩 추가하는 요소입니다
									Computer[incount][0]=dbDepart;
									Computer[incount][1]=dbYear;
									Computer[incount][2]=dbName;
									Computer[incount][3]=dbGrade;
									Computer[incount][4]=dbNum;
									tableModel.addRow(Computer[incount]);
									//다음 배열칸에 값들을 넣기위해서 카운트를 +1해줍니다
									incount++;
								}
								
								//대학원생을 클릭했을 때 + 현재 db에서 가져온 학년하고 사용자가 누른 하위노드 학년이 같을 때 + user가 콤보박스에서 클릭했던 학과명이 같을 때
								else if((split==2)&&(dbGrade.equals("대학원생")==true)&&(changeInt==dbYear)&&((dbDepart.equals(userSelect))==true))
								{
									//컴퓨터라는 2차원 배열에 넣고 테이블에 한줄씩 추가하는 요소입니다
									Computer[incount][0]=dbDepart;
									Computer[incount][1]=dbYear;
									Computer[incount][2]=dbName;
									Computer[incount][3]=dbGrade;
									Computer[incount][4]=dbNum;
									tableModel.addRow(Computer[incount]);
									//다음 배열칸에 값들을 넣기위해서 카운트를 +1해줍니다
									incount++;
								}
								
								//학부생과 대학원생을 클릭했을 때 + 현재 db에서 가져온 학년하고 사용자가 누른 하위노드 학년이 같을 때 + user가 콤보박스에서 클릭했던 학과명이 같을 때
								else if((split==3)&&(changeInt==dbYear)&&((dbDepart.equals(userSelect))==true))
								{
									//컴퓨터라는 2차원 배열에 넣고 테이블에 한줄씩 추가하는 요소입니다
									Computer[incount][0]=dbDepart;
									Computer[incount][1]=dbYear;
									Computer[incount][2]=dbName;
									Computer[incount][3]=dbGrade;
									Computer[incount][4]=dbNum;
									tableModel.addRow(Computer[incount]);
									//다음 배열칸에 값들을 넣기위해서 카운트를 +1해줍니다
									incount++;
								}
								
								else
								{
									
								}
								
								
							}
								
						}
						catch(Exception et)
						{
							System.out.println(et.getMessage());
						}
						
						
							
						
					}
					
			});
			
			
			
			//콤보박스이벤트 구간 (1개밖에 없어서 단일 지정으로 선언해봤습니다)
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event)
				{
					JComboBox actCombo =(JComboBox)event.getSource();
					user=actCombo.getSelectedIndex();
					
					//유저가 클릭한 콤보박스가 어떤것인지 string 문자열로 저장해둡니다
					userSelect=actCombo.getSelectedItem().toString();
					
					//유저가 클릭한 콤보박스 문자열을 노드로 하기 위해 준비합니다
					root.setUserObject(userSelect);
					//nodeChanged로 기존 트리모델을 root에 적용된 유저가 클릭한 콤보박스 이름으로 변경합니다.
					treemodel.nodeChanged(root);
					
					
					
				}	
			});
			
			//컴포넌트 크기 900x300
			//true로해야 보입니다!
			setSize(900,300);
			setVisible(true);
			
		}
		
		//이거는 이벤트 지정해야할 것이 2개라서 액션이벤트 class를 제작하였습니다
		class MyItemListener implements ItemListener
		{
			public void itemStateChanged(ItemEvent event)
			{
				//split이 0인 경우에는 아무도 표시 x
				//split이 1일 경우에는 학부생만
				//split이 2일 경우에는 대학원생만
				//split이 3일 경우에는 학부생,대학원생 모두 다 표시
				
				if(event.getSource()==usCheck)
				{
					if(event.getStateChange()==1)
					{
						split=split+1;
					}
					else
					{
						split=split-1;
					}
					//잘 적용 되는지 콘솔 로그 확인 용
					System.out.println(split);
				}
				
				else if(event.getSource()==gsCheck)
				{
					if(event.getStateChange()==1)
					{
						split=split+2;
					}
					else
					{
						split=split-2;
					}
					//잘 적용되는지 콘솔 로그 확인
					System.out.println(split);
				}
				
				//테이블 한 번 초기화
				int maxt=table.getRowCount();
				
				//현재 테이블에 있는거 싹 지웁니다!
				for(int d=0;d<maxt;d++)
				{
					tableModel.removeRow(0);
				}
				
				//DB 데이터 가져옴
				String dbName2,dbNum2,dbGrade2,dbDepart2;
				int dbYear2;
				
				//배열에 값 넣기 위한 변수용
				int count2=0;
				
				
				//treeState에서 숫자만 추출되도록 하기 위한
				String tempStr2=treeState;
				//0~9의 숫자가 아닌 것들을 공백으로 변경하도록 하여 changeStr에 담았습니다
				String changeStr2=tempStr2.replaceAll("[^0-9]","");
				//그리고 숫자만 추출한 문자열을 int형으로 변경하여줍니다.
				int changeInt2=Integer.parseInt(changeStr2);
				
				
				try
				{
					ResultSet data2=stmt.executeQuery("SELECT * FROM university.students_table");
					while(data2.next())
					{
						dbName2=data2.getString("sname");
						dbNum2=data2.getString("snum");
						dbYear2=data2.getInt("year");
						dbGrade2=data2.getString("grade");
						dbDepart2=data2.getString("department");
						
						//학부생을 클릭했을 때 + 현재 db에서 가져온 학년하고 사용자가 누른 하위노드 학년이 같을 때 + user가 콤보박스에서 클릭했던 학과명이 같을 때
						if((split==1)&&(dbGrade2.equals("학부생")==true)&&(changeInt2==dbYear2)&&((dbDepart2.equals(userSelect))==true))
						{
							//컴퓨터라는 2차원 배열에 넣고 테이블에 한줄씩 추가하는 요소입니다
							Computer[count2][0]=dbDepart2;
							Computer[count2][1]=dbYear2;
							Computer[count2][2]=dbName2;
							Computer[count2][3]=dbGrade2;
							Computer[count2][4]=dbNum2;
							tableModel.addRow(Computer[count2]);
							//다음 배열칸에 값들을 넣기위해서 카운트를 +1해줍니다
							count2++;
						}
						
						//대학원생을 클릭했을 때 + 현재 db에서 가져온 학년하고 사용자가 누른 하위노드 학년이 같을 때 + user가 콤보박스에서 클릭했던 학과명이 같을 때
						else if((split==2)&&(dbGrade2.equals("대학원생")==true)&&(changeInt2==dbYear2)&&((dbDepart2.equals(userSelect))==true))
						{
							//컴퓨터라는 2차원 배열에 넣고 테이블에 한줄씩 추가하는 요소입니다
							Computer[count2][0]=dbDepart2;
							Computer[count2][1]=dbYear2;
							Computer[count2][2]=dbName2;
							Computer[count2][3]=dbGrade2;
							Computer[count2][4]=dbNum2;
							tableModel.addRow(Computer[count2]);
							//다음 배열칸에 값들을 넣기위해서 카운트를 +1해줍니다
							count2++;
						}
						
						//학부생과 대학원생을 클릭했을 때 + 현재 db에서 가져온 학년하고 사용자가 누른 하위노드 학년이 같을 때 + user가 콤보박스에서 클릭했던 학과명이 같을 때
						else if((split==3)&&(changeInt2==dbYear2)&&((dbDepart2.equals(userSelect))==true))
						{
							//컴퓨터라는 2차원 배열에 넣고 테이블에 한줄씩 추가하는 요소입니다
							Computer[count2][0]=dbDepart2;
							Computer[count2][1]=dbYear2;
							Computer[count2][2]=dbName2;
							Computer[count2][3]=dbGrade2;
							Computer[count2][4]=dbNum2;
							tableModel.addRow(Computer[count2]);
							//다음 배열칸에 값들을 넣기위해서 카운트를 +1해줍니다
							count2++;
						}
						
						else
						{
							
						}
						
						
					}
				}
				catch(Exception ep)
				{
					System.out.println(ep.getMessage());
				}
				
				
				
				
				
				
			}
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LoginSys check=new LoginSys();
		
		      
	}
	
	//DB 연결 메소드
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
	
	void insertDepart()
	{
		//Depart에 DB 데이터 넣기
		try
		{
			makeConnection();
			stmt=con.createStatement();
			ResultSet result=stmt.executeQuery("SELECT * FROM university.departments_table");
			
			//배열 값 넣을 용도 카운트
			int lscount=0;
			
			//DB에 있는 값이 다 불러와질 때까지
			while(result.next())
			{
				//dname이라는 곳에 존재하는 문자열을 가져와서 dbpart에 넣습니다
				String dbpart=result.getString("dname");
				
				//Depart 배열에 하나씩 db에서 가져온 학과명들 넣기
				Depart[lscount]=dbpart;
				
				//다음 배열에 넣을 수 있게 lscount 1 증가
				lscount++;
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	//메뉴 액션 리스너
	class MenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent me) {
			String mSelect = me.getActionCommand();
			
			if(mSelect.equals("종료")==true)
			{
				System.exit(0);
			}
			
			else if(mSelect.equals("학생등록")==true)
			{
				//일단 과제4번에 종료 버튼 이벤트만 활성화 내용만 있어서 따로 이벤트 기능은 넣지 않았습니다!
			}

			else if(mSelect.equals("학생삭제")==true)
			{
				//얘도 DB에서 검색하여 삭제하는 기능은 생각하였는데 종료 버튼 이벤트 활성화 내용만 있어서 따로 이벤트 기능은 넣지 않았습니다!
			}
			
			
		}
	}
	
	
	
	
	//마지막 문단 구분용
}
