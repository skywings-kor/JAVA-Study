import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.tree.*;
import javax.swing.*;
import javax.swing.event.*;

public class Ready_6 extends JFrame{
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
	
	String columName[]= {"학과","학년","성명","구분","학번"};
	
	JTree tree;
	DefaultMutableTreeNode root;
	DefaultTreeModel model;
	
	JPanel basePanel=new JPanel(new BorderLayout());
	JPanel centerPanel=new JPanel();
	JPanel westPanel=new JPanel();
	
	JTable t1;
	DefaultTableModel tablemodel;
	
	JMenuBar bar1=new JMenuBar();
	JMenu m1=new JMenu("HOME");
	JMenu m2=new JMenu("CONTROL");
	JMenuItem mi1=new JMenuItem("Open");
	JMenuItem mi2=new JMenuItem("New");
	JMenuItem mi3=new JMenuItem("Exit");
	
	JLabel l1=new JLabel("Select Student Type");
	
	JComboBox combo;
	JCheckBox check1;
	JCheckBox check2;
	
	Ready_6()
	{
		setTitle("StudentPG");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(basePanel);
		
		basePanel.add(westPanel,BorderLayout.WEST);
		basePanel.add(centerPanel,BorderLayout.CENTER);
		
		tablemodel=new DefaultTableModel(students,columName);
		t1=new JTable(tablemodel);
		
		
		westPanel.setLayout(new FlowLayout());
		
		centerPanel.setLayout(new BorderLayout());
		
		centerPanel.add(t1);
		
		westPanel.setPreferredSize(new Dimension(160,basePanel.getHeight()));
		
		m1.add(mi1);
		m1.add(mi2);
		m1.add(mi3);
		bar1.add(m1);
		bar1.add(m2);
		setJMenuBar(bar1);
		
		combo=new JComboBox(departments);
		check1=new JCheckBox("학부생");
		check2=new JCheckBox("대학원생");
		
		
		root=new DefaultMutableTreeNode("학과");
		tree=new JTree(root);
		tree.setPreferredSize(new Dimension(150,200));
		
		for(int i=0; i<departments.length;i++)
		{
			DefaultMutableTreeNode node=new DefaultMutableTreeNode(departments[i]);
			root.add(node);
			model=(DefaultTreeModel)tree.getModel();
			model.setRoot(root);
		}
		
		
		l1.setPreferredSize(new Dimension (150,20));
		combo.setPreferredSize(new Dimension(160,20));
		check1.setPreferredSize(new Dimension(70,20));
		check2.setPreferredSize(new Dimension(80,20));
		
		
		
		westPanel.add(l1);
		westPanel.add(check1);
		westPanel.add(check2);
		westPanel.add(combo);
		westPanel.add(tree);
		
		JScrollPane scroll=new JScrollPane(t1);
		centerPanel.add(scroll,BorderLayout.CENTER);
		
		setSize(1000,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ready_6 r1=new Ready_6();
		
	}
	
	
	

}
