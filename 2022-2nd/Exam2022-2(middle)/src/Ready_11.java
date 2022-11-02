import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.*;
import javax.swing.table.*;
import javax.swing.tree.*;

public class Ready_11 extends JFrame{
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
	String columName[]= {"학과","학년","성명","구분","학번"};
	
	Object [][] UTemp= new Object[Student.length][Student[0].length];
	
	JComboBox combo;
	JCheckBox c1=new JCheckBox("학부생");
	JCheckBox c2=new JCheckBox("대학원생");
	JTable table;
	DefaultTableModel model;
	JLabel l1=new JLabel("Select Student Type");
	JPanel basePanel=new JPanel(new BorderLayout());
	JPanel centerPanel=new JPanel();
	JPanel westPanel=new JPanel();
	
	JTree tree;
	DefaultMutableTreeNode node;
	DefaultTreeModel treemodel;
	Ready_11()
	{
		setTitle("PGM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		westPanel.setPreferredSize(new Dimension(160,basePanel.getHeight()));
		setContentPane(basePanel);
		basePanel.add(centerPanel,BorderLayout.CENTER);
		basePanel.add(westPanel,BorderLayout.WEST);
		
		westPanel.setLayout(new FlowLayout());
		centerPanel.setLayout(new BorderLayout());
		
		model=new DefaultTableModel(Student,columName);
		table=new JTable(model);
		centerPanel.add(table);
		
		l1.setPreferredSize(new Dimension(150,20));
		c1.setPreferredSize(new Dimension(70,20));
		c2.setPreferredSize(new Dimension(80,20));
		combo=new JComboBox(Depart);
		combo.setPreferredSize(new Dimension(160,20));
		
		node=new DefaultMutableTreeNode("학과");
		tree=new JTree(node);
		tree.setPreferredSize(new Dimension(160,300));
		
		for(int i=0; i<Depart.length;i++)
		{
			DefaultMutableTreeNode temp= new DefaultMutableTreeNode(Depart[i]);
			node.add(temp);
			treemodel=(DefaultTreeModel) tree.getModel();
			treemodel.setRoot(node);
		}
		
		westPanel.add(l1);
		westPanel.add(c1);
		westPanel.add(c2);
		westPanel.add(combo);
		westPanel.add(tree);
		JScrollPane sc=new JScrollPane(table);
		centerPanel.add(sc,BorderLayout.CENTER);
		setSize(1000,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ready_11 r1=new Ready_11();
		
	}
}
