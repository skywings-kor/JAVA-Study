
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.tree.*;
import javax.swing.event.*;



public class Main extends JFrame{
	
	
	//전체 인덱스에 해당하는 값으로 초기값지정
		int user=5;
		int split=0;
		String [] Depart = {"컴퓨터공학부","전자공학과","기계공학과","체육학과","영문학과","전체"};
		Object [][] Student= 
			{
				{"컴퓨터공학부","2학년","박규민","학부생","2019292929"},
				{"컴퓨터공학부","3학년","김세린","학부생","2018228374"},
				{"컴퓨터공학부","4학년","사성인","학부생","2017293812"},
				{"컴퓨터공학부","1학년","김구라","학부생","2022123456"},
				{"컴퓨터공학부","2학년","김개미","대학원생","2017123456"},
				{"컴퓨터공학부","3학년","나현민","대학원생","2015938424"},
				{"컴퓨터공학부","4학년","박세린","학부생","2018293845"},
				{"전자공학과","1학년","나전자","학부생","2022938495"},
				{"전자공학과","2학년","나세민","학부생","2020928374"},
				{"전자공학과","2학년","박전자","학부생","2019123456"},
				{"전자공학과","3학년","조하린","학부생","2020837452"},
				{"전자공학과","4학년","김개수","학부생","2017293842"},
				{"전자공학과","1학년","김민수","대학원생","2016293841"},
				{"기계공학과","1학년","박민수","학부생","2022293845"},
				{"기계공학과","2학년","박민규","학부생","2021293895"},
				{"기계공학과","3학년","김세린","학부생","2020938402"},
				{"기계공학과","4학년","김하늘","학부생","2019039482"},
				{"기계공학과","4학년","손병훈","학부생","2017039870"},
				{"기계공학과","1학년","유하린","대학원생","2017229384"},
				{"체육학과","1학년","유히나","학부생","2021294852"},
				{"체육학과","2학년","이수아","학부생","2019293845"},
				{"체육학과","3학년","배민지","학부생","2017294865"},
				{"체육학과","2학년","배상훈","학부생","2021293012"},
				{"체육학과","4학년","김민지","학부생","2016957463"},
				{"체육학과","1학년","유시원","대학원생","2015948563"},
				{"영문학과","1학년","김수라","학부생","2022938403"},
				{"영문학과","2학년","유희원","학부생","2018294857"},
				{"영문학과","2학년","이민우","학부생","2020291023"},
				{"영문학과","3학년","주민상","학부생","2019857302"},
				{"영문학과","4학년","조혜린","학부생","2018847532"},
				{"영문학과","1학년","민설아","대학원생","2017847264"}
				
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
		
		Main()
		{
			int test;
			setTitle("Made By PGM-StudentList");
					
			//컨테이너(패널) 배치 및 크기조정
			westPanel.setPreferredSize(new Dimension(160,basePanel.getHeight()));		//크기를 160으로 고정하고 있게 됨
			setContentPane(basePanel);		//내가 만든 베이스 패널 객체로 대체되게 하는 것
			
			basePanel.add(westPanel,BorderLayout.WEST);
			basePanel.add(centerPanel,BorderLayout.CENTER);
			westPanel.setLayout(new FlowLayout());
					
			//웨스트 패널의 컴포넌트 작업
			comboBox=new JComboBox(Depart);
			
			//각 기능별 크기 할당
			titleLabel.setPreferredSize(new Dimension(160,20));
			comboBox.setPreferredSize(new Dimension(160,20));
			usCheck.setPreferredSize(new Dimension(70,20));
			gsCheck.setPreferredSize(new Dimension(80,20));
					
					
			//트리 제작(수업 참조)
			root=new DefaultMutableTreeNode("학과");
			tree=new JTree(root);
			tree.setPreferredSize(new Dimension(160,140));
			
			
			for(int i=0; i<Depart.length;i++)
			{
				DefaultMutableTreeNode node = new DefaultMutableTreeNode(Depart[i]);
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
			gsCheck.addItemListener(new MyItemListener() );

			
			
			
			
			//콤보박스이벤트 구간 (1개밖에 없어서 단일 지정으로 선언해봤습니다)
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event)
				{
					
					JComboBox actCombo =(JComboBox)event.getSource();
					user=actCombo.getSelectedIndex();
					//컴퓨터공학부가 콤보박스에 존재하였을 때
					if (user==0)
					{
						int i=0;
						//반복문 용도
						int a=0;
						//현재 테이블에 적혀있는 열을 세줍니다
						int maxc=table.getRowCount();
						//현재 테이블에 있는거 싹 지웁니다!
						for(a=0;a<maxc;a++)
						{
							tableModel.removeRow(0);
						}
						
						//학생 정보들이 담겨있는 배열을 살펴봐야해서 해당 열만큼 볼 수 있도록 했습니다
						//왜냐하면 이 다음부터는 null exception 오류가 뜨기 떄문입니다.(경험담...)
						for(i=0; i<Student.length;i++ )
						{
							//컴퓨터 공학부 일때 조건문이 실행되도록 함
							if(Student[i][0]=="컴퓨터공학부")
							{
								//필드값으로 split을 선언하였으면 0일때는 체크박스가 아무것도 안되있는것
								if (split==0)
								{	
									
								}
								
								//1일때는 학부생!
								else if (split==1)
								{
									if(Student[i][3]=="학부생")
									{
										Computer[i][0]=Student[i][0];
										Computer[i][1]=Student[i][1];
										Computer[i][2]=Student[i][2];
										Computer[i][3]=Student[i][3];
										Computer[i][4]=Student[i][4];
										tableModel.addRow(Computer[i]);
									}
								}
								
								//2일때는 대학원생!
								else if (split==2)
								{	
									if(Student[i][3]=="대학원생")
									{
										Computer[i][0]=Student[i][0];
										Computer[i][1]=Student[i][1];
										Computer[i][2]=Student[i][2];
										Computer[i][3]=Student[i][3];
										Computer[i][4]=Student[i][4];
										tableModel.addRow(Computer[i]);
									}
								}
								
								//3일때는 둘 다 체크!
								else if (split==3)
								{				
									Computer[i][0]=Student[i][0];
									Computer[i][1]=Student[i][1];
									Computer[i][2]=Student[i][2];
									Computer[i][3]=Student[i][3];
									Computer[i][4]=Student[i][4];
									tableModel.addRow(Computer[i]);	
								}
							}
						}
					}
					
					//user ==0일떄와 동일합니다! 각 기능별 주석은
					else if (user==1)
					{
						int i=0;
						//반복문 용도
						int a=0;
						//현재 테이블에 적혀있는 열을 세줍니다
						int maxc=table.getRowCount();
						//현재 테이블에 있는거 싹 지웁니다!
						for(a=0;a<maxc;a++)
						{
							tableModel.removeRow(0);
						}
						
						for(i=0; i<Student.length;i++ )
						{
							if(Student[i][0]=="전자공학과")
							{
								if (split==0)
								{	
									
								}
								
								else if (split==1)
								{
									if(Student[i][3]=="학부생")
									{
										Computer[i][0]=Student[i][0];
										Computer[i][1]=Student[i][1];
										Computer[i][2]=Student[i][2];
										Computer[i][3]=Student[i][3];
										Computer[i][4]=Student[i][4];
										tableModel.addRow(Computer[i]);
									}
								}
								
								else if (split==2)
								{	
									if(Student[i][3]=="대학원생")
									{
										Computer[i][0]=Student[i][0];
										Computer[i][1]=Student[i][1];
										Computer[i][2]=Student[i][2];
										Computer[i][3]=Student[i][3];
										Computer[i][4]=Student[i][4];
										tableModel.addRow(Computer[i]);
									}
								}
								
								else if (split==3)
								{				
									Computer[i][0]=Student[i][0];
									Computer[i][1]=Student[i][1];
									Computer[i][2]=Student[i][2];
									Computer[i][3]=Student[i][3];
									Computer[i][4]=Student[i][4];
									tableModel.addRow(Computer[i]);	
								}
							}
						}
					}
					
					else if (user==2)
					{
						int i=0;
						//반복문 용도
						int a=0;
						//현재 테이블에 적혀있는 열을 세줍니다
						int maxc=table.getRowCount();
						//현재 테이블에 있는거 싹 지웁니다!
						for(a=0;a<maxc;a++)
						{
							tableModel.removeRow(0);
						}
						
						for(i=0; i<Student.length;i++ )
						{
							if(Student[i][0]=="기계공학과")
							{
								if (split==0)
								{	
									
								}
								
								else if (split==1)
								{
									if(Student[i][3]=="학부생")
									{
										Computer[i][0]=Student[i][0];
										Computer[i][1]=Student[i][1];
										Computer[i][2]=Student[i][2];
										Computer[i][3]=Student[i][3];
										Computer[i][4]=Student[i][4];
										tableModel.addRow(Computer[i]);
									}
								}
								
								else if (split==2)
								{	
									if(Student[i][3]=="대학원생")
									{
										Computer[i][0]=Student[i][0];
										Computer[i][1]=Student[i][1];
										Computer[i][2]=Student[i][2];
										Computer[i][3]=Student[i][3];
										Computer[i][4]=Student[i][4];
										tableModel.addRow(Computer[i]);
									}
								}
								
								else if (split==3)
								{				
									Computer[i][0]=Student[i][0];
									Computer[i][1]=Student[i][1];
									Computer[i][2]=Student[i][2];
									Computer[i][3]=Student[i][3];
									Computer[i][4]=Student[i][4];
									tableModel.addRow(Computer[i]);	
								}
							}
						}
					}
					
					else if (user==3)
					{
						int i=0;
						//반복문 용도
						int a=0;
						//현재 테이블에 적혀있는 열을 세줍니다
						int maxc=table.getRowCount();
						//현재 테이블에 있는거 싹 지웁니다!
						for(a=0;a<maxc;a++)
						{
							tableModel.removeRow(0);
						}
						
						for(i=0; i<Student.length;i++ )
						{
							if(Student[i][0]=="체육학과")
							{
								if (split==0)
								{	
									
								}
								
								else if (split==1)
								{
									if(Student[i][3]=="학부생")
									{
										Computer[i][0]=Student[i][0];
										Computer[i][1]=Student[i][1];
										Computer[i][2]=Student[i][2];
										Computer[i][3]=Student[i][3];
										Computer[i][4]=Student[i][4];
										tableModel.addRow(Computer[i]);
									}
								}
								
								else if (split==2)
								{	
									if(Student[i][3]=="대학원생")
									{
										Computer[i][0]=Student[i][0];
										Computer[i][1]=Student[i][1];
										Computer[i][2]=Student[i][2];
										Computer[i][3]=Student[i][3];
										Computer[i][4]=Student[i][4];
										tableModel.addRow(Computer[i]);
									}
								}
								
								else if (split==3)
								{				
									Computer[i][0]=Student[i][0];
									Computer[i][1]=Student[i][1];
									Computer[i][2]=Student[i][2];
									Computer[i][3]=Student[i][3];
									Computer[i][4]=Student[i][4];
									tableModel.addRow(Computer[i]);	
								}
							}
						}
					}
					
					else if (user==4)
					{
						int i=0;
						//반복문 용도
						int a=0;
						//현재 테이블에 적혀있는 열을 세줍니다
						int maxc=table.getRowCount();
						//현재 테이블에 있는거 싹 지웁니다!
						for(a=0;a<maxc;a++)
						{
							tableModel.removeRow(0);
						}
						
						for(i=0; i<Student.length;i++ )
						{
							if(Student[i][0]=="영문학과")
							{
								if (split==0)
								{	
									
								}
								
								else if (split==1)
								{
									if(Student[i][3]=="학부생")
									{
										Computer[i][0]=Student[i][0];
										Computer[i][1]=Student[i][1];
										Computer[i][2]=Student[i][2];
										Computer[i][3]=Student[i][3];
										Computer[i][4]=Student[i][4];
										tableModel.addRow(Computer[i]);
									}
								}
								
								else if (split==2)
								{	
									if(Student[i][3]=="대학원생")
									{
										Computer[i][0]=Student[i][0];
										Computer[i][1]=Student[i][1];
										Computer[i][2]=Student[i][2];
										Computer[i][3]=Student[i][3];
										Computer[i][4]=Student[i][4];
										tableModel.addRow(Computer[i]);
									}
								}
								
								else if (split==3)
								{				
									Computer[i][0]=Student[i][0];
									Computer[i][1]=Student[i][1];
									Computer[i][2]=Student[i][2];
									Computer[i][3]=Student[i][3];
									Computer[i][4]=Student[i][4];
									tableModel.addRow(Computer[i]);	
								}
							}
						}
					}
					
					else if (user==5)
					{
						int i=0;
						//반복문 용도
						int a=0;
						//현재 테이블에 적혀있는 열을 세줍니다
						int maxc=table.getRowCount();
						//현재 테이블에 있는거 싹 지웁니다!
						for(a=0;a<maxc;a++)
						{
							tableModel.removeRow(0);
						}
						
						for(i=0; i<Student.length;i++ )
						{
								if (split==0)
								{	
									
								}
								
								else if (split==1)
								{
									if(Student[i][3]=="학부생")
									{
										Computer[i][0]=Student[i][0];
										Computer[i][1]=Student[i][1];
										Computer[i][2]=Student[i][2];
										Computer[i][3]=Student[i][3];
										Computer[i][4]=Student[i][4];
										tableModel.addRow(Computer[i]);
									}
								}
								
								else if (split==2)
								{	
									if(Student[i][3]=="대학원생")
									{
										Computer[i][0]=Student[i][0];
										Computer[i][1]=Student[i][1];
										Computer[i][2]=Student[i][2];
										Computer[i][3]=Student[i][3];
										Computer[i][4]=Student[i][4];
										tableModel.addRow(Computer[i]);
									}
								}
								
								else if (split==3)
								{				
									Computer[i][0]=Student[i][0];
									Computer[i][1]=Student[i][1];
									Computer[i][2]=Student[i][2];
									Computer[i][3]=Student[i][3];
									Computer[i][4]=Student[i][4];
									tableModel.addRow(Computer[i]);	
								}
							
						}
					}
					
					
					
					
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
				
				
				if (user==0)
				{
					int i=0;
					//반복문 용도
					int a=0;
					//현재 테이블에 적혀있는 열을 세줍니다
					int maxc=table.getRowCount();
					//현재 테이블에 있는거 싹 지웁니다!
					for(a=0;a<maxc;a++)
					{
						tableModel.removeRow(0);
					}
					
					for(i=0; i<Student.length;i++ )
					{
						if(Student[i][0]=="컴퓨터공학부")
						{
							if (split==0)
							{	
								
							}
							
							else if (split==1)
							{
								if(Student[i][3]=="학부생")
								{
									Computer[i][0]=Student[i][0];
									Computer[i][1]=Student[i][1];
									Computer[i][2]=Student[i][2];
									Computer[i][3]=Student[i][3];
									Computer[i][4]=Student[i][4];
									tableModel.addRow(Computer[i]);
								}
							}
							
							else if (split==2)
							{	
								if(Student[i][3]=="대학원생")
								{
									Computer[i][0]=Student[i][0];
									Computer[i][1]=Student[i][1];
									Computer[i][2]=Student[i][2];
									Computer[i][3]=Student[i][3];
									Computer[i][4]=Student[i][4];
									tableModel.addRow(Computer[i]);
								}
							}
							
							else if (split==3)
							{				
								Computer[i][0]=Student[i][0];
								Computer[i][1]=Student[i][1];
								Computer[i][2]=Student[i][2];
								Computer[i][3]=Student[i][3];
								Computer[i][4]=Student[i][4];
								tableModel.addRow(Computer[i]);	
							}
						}
					}
				}
						
				else if (user==1)
				{
					int i=0;
					//반복문 용도
					int a=0;
					//현재 테이블에 적혀있는 열을 세줍니다
					int maxc=table.getRowCount();
					//현재 테이블에 있는거 싹 지웁니다!
					for(a=0;a<maxc;a++)
					{
						tableModel.removeRow(0);
					}
					
					for(i=0; i<Student.length;i++ )
					{
						if(Student[i][0]=="전자공학과")
						{
							if (split==0)
							{	
								
							}
							
							else if (split==1)
							{
								if(Student[i][3]=="학부생")
								{
									Computer[i][0]=Student[i][0];
									Computer[i][1]=Student[i][1];
									Computer[i][2]=Student[i][2];
									Computer[i][3]=Student[i][3];
									Computer[i][4]=Student[i][4];
									tableModel.addRow(Computer[i]);
								}
							}
							
							else if (split==2)
							{	
								if(Student[i][3]=="대학원생")
								{
									Computer[i][0]=Student[i][0];
									Computer[i][1]=Student[i][1];
									Computer[i][2]=Student[i][2];
									Computer[i][3]=Student[i][3];
									Computer[i][4]=Student[i][4];
									tableModel.addRow(Computer[i]);
								}
							}
							
							else if (split==3)
							{				
								Computer[i][0]=Student[i][0];
								Computer[i][1]=Student[i][1];
								Computer[i][2]=Student[i][2];
								Computer[i][3]=Student[i][3];
								Computer[i][4]=Student[i][4];
								tableModel.addRow(Computer[i]);	
							}
						}
					}
				}
				else if (user==2)
				{
					int i=0;
					//반복문 용도
					int a=0;
					//현재 테이블에 적혀있는 열을 세줍니다
					int maxc=table.getRowCount();
					//현재 테이블에 있는거 싹 지웁니다!
					for(a=0;a<maxc;a++)
					{
						tableModel.removeRow(0);
					}
					
					for(i=0; i<Student.length;i++ )
					{
						if(Student[i][0]=="기계공학과")
						{
							if (split==0)
							{	
								
							}
							
							else if (split==1)
							{
								if(Student[i][3]=="학부생")
								{
									Computer[i][0]=Student[i][0];
									Computer[i][1]=Student[i][1];
									Computer[i][2]=Student[i][2];
									Computer[i][3]=Student[i][3];
									Computer[i][4]=Student[i][4];
									tableModel.addRow(Computer[i]);
								}
							}
							
							else if (split==2)
							{	
								if(Student[i][3]=="대학원생")
								{
									Computer[i][0]=Student[i][0];
									Computer[i][1]=Student[i][1];
									Computer[i][2]=Student[i][2];
									Computer[i][3]=Student[i][3];
									Computer[i][4]=Student[i][4];
									tableModel.addRow(Computer[i]);
								}
							}
							
							else if (split==3)
							{				
								Computer[i][0]=Student[i][0];
								Computer[i][1]=Student[i][1];
								Computer[i][2]=Student[i][2];
								Computer[i][3]=Student[i][3];
								Computer[i][4]=Student[i][4];
								tableModel.addRow(Computer[i]);	
							}
						}
					}
				}
				
				else if (user==3)
				{
					int i=0;
					//반복문 용도
					int a=0;
					//현재 테이블에 적혀있는 열을 세줍니다
					int maxc=table.getRowCount();
					//현재 테이블에 있는거 싹 지웁니다!
					for(a=0;a<maxc;a++)
					{
						tableModel.removeRow(0);
					}
					
					for(i=0; i<Student.length;i++ )
					{
						if(Student[i][0]=="체육학과")
						{
							if (split==0)
							{	
								
							}
							
							else if (split==1)
							{
								if(Student[i][3]=="학부생")
								{
									Computer[i][0]=Student[i][0];
									Computer[i][1]=Student[i][1];
									Computer[i][2]=Student[i][2];
									Computer[i][3]=Student[i][3];
									Computer[i][4]=Student[i][4];
									tableModel.addRow(Computer[i]);
								}
							}
							
							else if (split==2)
							{	
								if(Student[i][3]=="대학원생")
								{
									Computer[i][0]=Student[i][0];
									Computer[i][1]=Student[i][1];
									Computer[i][2]=Student[i][2];
									Computer[i][3]=Student[i][3];
									Computer[i][4]=Student[i][4];
									tableModel.addRow(Computer[i]);
								}
							}
							
							else if (split==3)
							{				
								Computer[i][0]=Student[i][0];
								Computer[i][1]=Student[i][1];
								Computer[i][2]=Student[i][2];
								Computer[i][3]=Student[i][3];
								Computer[i][4]=Student[i][4];
								tableModel.addRow(Computer[i]);	
							}
						}
					}
				}
				
				else if (user==4)
				{
					int i=0;
					//반복문 용도
					int a=0;
					//현재 테이블에 적혀있는 열을 세줍니다
					int maxc=table.getRowCount();
					//현재 테이블에 있는거 싹 지웁니다!
					for(a=0;a<maxc;a++)
					{
						tableModel.removeRow(0);
					}
					
					for(i=0; i<Student.length;i++ )
					{
						if(Student[i][0]=="영문학과")
						{
							if (split==0)
							{	
								
							}
							
							else if (split==1)
							{
								if(Student[i][3]=="학부생")
								{
									Computer[i][0]=Student[i][0];
									Computer[i][1]=Student[i][1];
									Computer[i][2]=Student[i][2];
									Computer[i][3]=Student[i][3];
									Computer[i][4]=Student[i][4];
									tableModel.addRow(Computer[i]);
								}
							}
							
							else if (split==2)
							{	
								if(Student[i][3]=="대학원생")
								{
									Computer[i][0]=Student[i][0];
									Computer[i][1]=Student[i][1];
									Computer[i][2]=Student[i][2];
									Computer[i][3]=Student[i][3];
									Computer[i][4]=Student[i][4];
									tableModel.addRow(Computer[i]);
								}
							}
							
							else if (split==3)
							{				
								Computer[i][0]=Student[i][0];
								Computer[i][1]=Student[i][1];
								Computer[i][2]=Student[i][2];
								Computer[i][3]=Student[i][3];
								Computer[i][4]=Student[i][4];
								tableModel.addRow(Computer[i]);	
							}
						}
					}
				}
				
				else if (user==5)
				{
					int i=0;
					//반복문 용도
					int a=0;
					//현재 테이블에 적혀있는 열을 세줍니다
					int maxc=table.getRowCount();
					//현재 테이블에 있는거 싹 지웁니다!
					for(a=0;a<maxc;a++)
					{
						tableModel.removeRow(0);
					}
					
					for(i=0; i<Student.length;i++ )
					{
							if (split==0)
							{	
								
							}
							
							else if (split==1)
							{
								if(Student[i][3]=="학부생")
								{
									Computer[i][0]=Student[i][0];
									Computer[i][1]=Student[i][1];
									Computer[i][2]=Student[i][2];
									Computer[i][3]=Student[i][3];
									Computer[i][4]=Student[i][4];
									tableModel.addRow(Computer[i]);
								}
							}
							
							else if (split==2)
							{	
								if(Student[i][3]=="대학원생")
								{
									Computer[i][0]=Student[i][0];
									Computer[i][1]=Student[i][1];
									Computer[i][2]=Student[i][2];
									Computer[i][3]=Student[i][3];
									Computer[i][4]=Student[i][4];
									tableModel.addRow(Computer[i]);
								}
							}
							
							else if (split==3)
							{				
								Computer[i][0]=Student[i][0];
								Computer[i][1]=Student[i][1];
								Computer[i][2]=Student[i][2];
								Computer[i][3]=Student[i][3];
								Computer[i][4]=Student[i][4];
								tableModel.addRow(Computer[i]);	
							}
						
					}
				}
			}
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int test=0;
		LoginSys check=new LoginSys();
		
		
		      
	}

}
