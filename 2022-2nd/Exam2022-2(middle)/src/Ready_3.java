import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.*;
import javax.swing.event.*;

public class Ready_3 extends JFrame{
	
	JButton b1=new JButton("prepare");
	JButton b2=new JButton("exam");
	Ready_3()
	{
		
		setTitle("BUttonActionEvent_test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		

		c.add(b1);
		c.add(b2);
		
		b1.addActionListener(new MyActionListener());
		b2.addActionListener(new MyActionListener());
		
		//버튼추가
		setSize(500,500);
		setVisible(true);
		
		
	}
	
	class MyActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JButton eb=(JButton)e.getSource();
			
			if(eb.getText().equals("prepare"))
			{
				eb.setText("준비");
			}
			
			else if(eb.getText().equals("exam"))
			{
				eb.setText("시험");
			}
			
			else if(eb.getText().equals("준비"))
			{
				eb.setText("prepare");
			}
			
			else if (eb.getText().equals("시험"))
			{
				eb.setText("exam");
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ready_3 r1=new Ready_3();
		
	}

}
