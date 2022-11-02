import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.*;
import javax.swing.table.*;

public class Ready_10 extends JFrame{
	ArrayList<Ready_10_book> booklist=new ArrayList<>();
	
	JTable table;
	DefaultTableModel tmodel;
	
	JPanel centerPanel;
	
	Ready_10_bookinformation fr=new Ready_10_bookinformation();
	
	Ready_10()
	{
		String columname[]= {"ID","TITLE","AUTHOR","MADE","YEAR","TYPE"};
		setTitle("book 파일");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		centerPanel=new JPanel();
		setContentPane(centerPanel);
		centerPanel.setLayout(new BorderLayout());
		
		
		fr.fileReadBook(this);
		Object [][] booktemp= new Object[booklist.size()][6];
		
		for(int i=0; i<booklist.size();i++)
		{
			booktemp[i][0]=(Object)(booklist.get(i).id);
			booktemp[i][1]=(Object)(booklist.get(i).title);
			booktemp[i][2]=(Object)(booklist.get(i).author);
			booktemp[i][3]=(Object)(booklist.get(i).made);
			booktemp[i][4]=(Object)(booklist.get(i).year);
			booktemp[i][5]=(Object)(booklist.get(i).type);
		}
		 
		tmodel=new DefaultTableModel(booktemp,columname);
		table=new JTable(tmodel);
		centerPanel.add(table);
		
		
		JScrollPane js=new JScrollPane(table);
		centerPanel.add(js);
		setSize(1000,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ready_10 r1=new Ready_10();
		
	}
}
