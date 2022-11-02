import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.*;
import javax.swing.event.*;

public class Ready_4 extends JFrame{
	
	JLabel l1=new JLabel("MOUSE EVENT");
	Ready_4()
	{
		setTitle("Moust Event");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		
		
		c.addMouseListener(new MyMouseListener());
		c.setLayout(null);
		l1.setSize(100,20);
		l1.setLocation(350,350);
		c.add(l1);
		setSize(800,800);
		setVisible(true);
	}
	
	class MyMouseListener implements MouseListener
	{
		public void mousePressed(MouseEvent e)
		{
			int x=e.getX();
			int y=e.getY();
			
			l1.setLocation(x,y);
		}
		public void mouseReleased(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ready_4 r1=new Ready_4();
		
	}
	
	
	

}
