import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.*;
import javax.swing.event.*;

public class Ready_1 extends JFrame{
	
	JButton test=new JButton("중간고사 준비");
	
	Ready_1()
	{
		
		setTitle("테스트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentpane=getContentPane();
		contentpane.setLayout(new FlowLayout());
		contentpane.setBackground(Color.BLUE);
		
		//버튼추가
		contentpane.add(test);
		contentpane.add(new JButton("핳"));
		setSize(500,500);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ready_1 r1=new Ready_1();
		
	}

}
