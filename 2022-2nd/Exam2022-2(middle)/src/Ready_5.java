import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.*;
import javax.swing.event.*;

public class Ready_5 extends JFrame{
	JPanel p1=new JPanel();
	JLabel l1=new JLabel("HELLO");
	int speed=10;
	Container c=getContentPane();
	
	Ready_5()
	{
		setTitle("moveKey");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(p1);
		
		p1.add(l1);
		p1.setLayout(null);
		p1.addKeyListener(new MyActionEvent());
		
		l1.setLocation(50,50);
		l1.setSize(100,200);
		
		
		
		setSize(600,600);
		setVisible(true);

		p1.requestFocus();
	}
	
	class MyActionEvent extends KeyAdapter
	{
		public void keyPressed(KeyEvent e)
		{
			int keyCode=e.getKeyCode();
			switch(keyCode)
			{
			case KeyEvent.VK_UP:
				l1.setLocation(l1.getX(),l1.getY()-speed);
				break;
			case KeyEvent.VK_DOWN:
				l1.setLocation(l1.getX(),l1.getY()+speed);
				break;
			case KeyEvent.VK_LEFT:
				l1.setLocation(l1.getX()-speed,l1.getY());
				break;
			case KeyEvent.VK_RIGHT:
				l1.setLocation(l1.getX()+speed,l1.getY());
				break;
			
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ready_5 r1=new Ready_5();
		
	}
	
	
	

}
