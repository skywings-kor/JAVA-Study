package Class_1004_BookMGM_PGM;

import java.util.*;
import java.io.*;
import java.util.StringTokenizer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class MainFrame extends JFrame{
	//동적 배열이라 100권에 대한게 있으면 배열 100개의 크기가 만들어짐
	ArrayList<Book> bookList = new ArrayList<>();
	
	JTable table;
	DefaultTableModel tModel;
	BookInformationReader r = new BookInformationReader();
	
	MainFrame()
	{
		String columName[]= {"ID","TITLE","AUTHOR","PUBL","YEAR","TYPE"};
		
		//this는 자기 내 객체를 너도 알고 있으라고 넘겨주는거  bookList의 배열을 사용하라고, 너도 사용하라고 내가 가지고 있는거 그런 뜻
		r.readBokkInformationReader(this);
		
		//arrayList에 10개의 북 개체가 있으면 10이 반환 , booklist.size로 크기 알 수 있음
		Object[][] bData = new Object[bookList.size()][6];
		for(int i=0; i<bookList.size();i++)
		{
			int j=0;
			bData[i][j]=(Object)(bookList.get(i).id); j++;
			bData[i][j]=(Object)(bookList.get(i).title); j++;
			bData[i][j]=(Object)(bookList.get(i).author); j++;
			bData[i][j]=(Object)(bookList.get(i).bulisher); j++;
			bData[i][j]=(Object)(bookList.get(i).year); j++;
			bData[i][j]=(Object)(bookList.get(i).type); j++;
			
		}
		Container c=getContentPane();
		c.setLayout(new BorderLayout());
		
		tModel=new DefaultTableModel(bData,columName);
		table=new JTable(tModel);
		JScrollPane sp=new JScrollPane(table);
		c.add(sp,BorderLayout.CENTER);
		setSize(900,800);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		MainFrame mf=new MainFrame();
		// TODO Auto-generated method stub
//		
//		mf.readBokkInformationReader(mf);
	}

}
