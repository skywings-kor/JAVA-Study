package Class_0927;
//개발자: 2019243064 박규민
//개발목적: 학생 관리 프로그램 개발로 효율적인 학생 명단 관리와 추가적으로 GUI 기반으로 사용자가 더욱 손쉽게 명단 관리를 진행할 수 있도록 하기 위함
//개발일: 2022.09.27 ~ 2022.10.01
//수정일자: 

//이것이 패키지인데 패키지는 하나의 폴더라고 생각하면 됨..
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.tree.*;		//한놈만 지정해서 써도 됨

public class MainFrame extends JFrame{
	
	String [] departments= {"컴퓨터공학부", "전자공학과", "기계공학과", "영어영문학과", "AI소프트웨어학과","간호학과"};
	Object[][] students = {
			   {"컴퓨터공학부", "1학년", "홍길동", "학부생", "111111"},
			   {"컴퓨터공학부", "4학년", "김철수", "학부생", "123467"},
			   {"컴퓨터공학부", "4학년", "이병헌", "학부생", "100011"},
			   {"컴퓨터공학부", "2학년", "푸하하", "학부생", "145361"},
			   {"컴퓨터공학부", "1학년", "하하하", "학부생", "111551"},
			   {"컴퓨터공학부", "1학년", "강호동", "학부생", "123111"},
			   {"컴퓨터공학부", "3학년", "이수근", "학부생", "165101"},
			   {"컴퓨터공학부", "1학년", "서장훈", "학부생", "133411"},
			   {"전자공학과", "1학년", "홍길동", "학부생", "111111"},
			   {"전자공학과", "1학년", "김철수", "학부생", "123467"},
			   {"전자공학과", "4학년", "이병헌", "학부생", "100011"},
			   {"전자공학과", "4학년", "푸하하", "학부생", "145361"},
			   {"전자공학과", "1학년", "하하하", "학부생", "111551"},
			   {"전자공학과", "2학년", "강호동", "학부생", "123111"},
			   {"전자공학과", "1학년", "이수근", "대학원생", "165101"},
			   {"전자공학과", "3학년", "서장훈", "대학원생", "133411"}
			    };
	
	//공간제어용
	JPanel basePanel=new JPanel(new BorderLayout());
	JPanel westPanel=new JPanel();
	JPanel centerPanel =new JPanel();
	
	//메뉴 제작을 위한 필드
	JMenuBar mb = new JMenuBar();
	JMenu homeMenu=new JMenu("HOME");
	JMenu controlMenu=new JMenu("CONTROL");
	JMenuItem openMI=new JMenuItem("Open");
	JMenuItem newMI=new JMenuItem("New");
	JMenuItem exitMI=new JMenuItem("Exit");
	
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
	
	MainFrame()
	{
		setTitle("PGM의 학생관리 프로그램.ver1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		//메뉴작업
		homeMenu.add(openMI);
		homeMenu.addSeparator();
		homeMenu.add(newMI);
		homeMenu.addSeparator();
		homeMenu.add(exitMI);
		mb.add(homeMenu);
		mb.add(controlMenu);
		setJMenuBar(mb);	//현재 이 메뉴바 영역을 책임지는 객체로 만들어라.
		
		//컨테이너(패널) 배치 및 크기조정
		westPanel.setPreferredSize(new Dimension(160,basePanel.getHeight()));		//크기를 160으로 고정하고 있게 됨
		setContentPane(basePanel);		//내가 만든 베이스 패널 객체로 대체되게 하는 것
		
//		westPanel.setBackground(Color.PINK);
//		centerPanel.setBackground(Color.BLUE);
		basePanel.add(westPanel,BorderLayout.WEST);
		basePanel.add(centerPanel,BorderLayout.CENTER);
		westPanel.setLayout(new FlowLayout());
		
		//웨스트 패널의 컴포넌트 작업
		comboBox=new JComboBox(departments);
		
		titleLabel.setPreferredSize(new Dimension(160,20));
		comboBox.setPreferredSize(new Dimension(160,20));
		usCheck.setPreferredSize(new Dimension(70,20));
		gsCheck.setPreferredSize(new Dimension(80,20));
		
		
		//트리 제작이요
		root=new DefaultMutableTreeNode("학과");
		tree=new JTree(root);
		tree.setPreferredSize(new Dimension(160,140));
		
		for(int i=0; i<departments.length;i++)
		{
			DefaultMutableTreeNode node = new DefaultMutableTreeNode(departments[i]);
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
		tableModel=new DefaultTableModel(students,columName);
		table=new JTable(tableModel);
		JScrollPane sp=new JScrollPane(table);
		
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(sp,BorderLayout.CENTER);
				
		setSize(900,300);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame mf=new MainFrame();
	}

}
