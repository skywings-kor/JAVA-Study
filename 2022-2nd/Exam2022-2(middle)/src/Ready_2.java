import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.*;
import javax.swing.event.*;

public class Ready_2 extends JFrame{
	
	JButton b1=new JButton("OK");
	JButton b2=new JButton("Cancel");
	
	JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	JTextField t3=new JTextField();
	JTextField t4=new JTextField();
	
	JLabel l1=new JLabel("이름");
	JLabel l2=new JLabel("학번");
	JLabel l3=new JLabel("학과");
	JLabel l4=new JLabel("과목");
	
	
	Ready_2()
	{
		setTitle("GridLayout준비");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c=getContentPane();
		GridLayout grid=new GridLayout(5,2);
		grid.setVgap(5);
		
		c.setLayout(grid);
		c.add(l1);
		c.add(t1);
		c.setLayout(grid);
		c.add(l2);
		c.add(t2);
		
		c.setLayout(grid);
		c.add(l3);
		c.add(t3);
		
		c.setLayout(grid);
		c.add(l3);
		c.add(t3);
		
		c.add(l4);
		c.add(t4);
		
		//이건 왜 쓰는 것인가? 여쭤보기
		c.setLayout(grid);
		c.add(b1);
		c.add(b2);
		setSize(500,500);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ready_2 r1=new Ready_2();
		
	}

}
