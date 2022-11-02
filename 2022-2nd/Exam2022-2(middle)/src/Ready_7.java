import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.tree.*;
import javax.swing.table.*;

public class Ready_7 extends JFrame{
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
	
	JTable table;
	DefaultTableModel tablemodel;
	JTree tree;
	DefaultMutableTreeNode root;
	DefaultTreeModel model;
	
	JCheckBox check1;
	JCheckBox check2;
	
	JMenuBar bar=new JMenuBar();
	JMenu m1=new JMenu("테1");
	JMenu m2=new JMenu("테2");
	JMenuItem mi1=new JMenu("Open");
	JMenuItem mi2=new JMenu("Close");
	
	JLabel lab=new JLabel("Select User Class");
	
	JPanel basePanel=new JPanel(new BorderLayout());
	JPanel westPanel=new JPanel();
	JPanel centerPanel=new JPanel();
	
	
	Ready_7()
	{
		setTitle("다시 도전!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		m1.add(mi1);
		m1.add(mi2);
		bar.add(m1);
		bar.add(m2);
		setJMenuBar(bar);
		
		setContentPane(basePanel);
		basePanel.add(westPanel,BorderLayout.WEST);
		basePanel.add(centerPanel,BorderLayout.CENTER);
		
		westPanel.setLayout(new FlowLayout());
		westPanel.setPreferredSize(new Dimension(160,basePanel.getHeight()));
		
		lab.setPreferredSize(new Dimension(150,20));
		westPanel.add(lab);
		
		tablemodel=new DefaultTableModel(students,columName);
		table=new JTable(tablemodel);
		
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(table);

		check1=new JCheckBox("학부생");		
		check2=new JCheckBox("대학원생");
		check1.setPreferredSize(new Dimension(70,20));
		check2.setPreferredSize(new Dimension(80,20));
		westPanel.add(check1);
		westPanel.add(check2);
	
		root=new DefaultMutableTreeNode("학과");
		tree=new JTree(root);
		tree.setPreferredSize(new Dimension(150,250));
		
		for(int i=0; i<departments.length;i++)
		{
			DefaultMutableTreeNode node=new DefaultMutableTreeNode(departments[i]);
			root.add(node);
			model=(DefaultTreeModel)tree.getModel();
			model.setRoot(root);		}
		
		westPanel.add(tree);
		
		
		
		JScrollPane scroll=new JScrollPane(table);
		centerPanel.add(scroll,BorderLayout.CENTER);
		
		setVisible(true);
		setSize(1000,400);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ready_7 run=new Ready_7();
	}

}
