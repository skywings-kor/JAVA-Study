package Class_0922;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

//주말에 2장 PPT에 있는거 공부해오기, 경험해보기.
public class KeyEvent_1 extends JFrame{
	JPanel contentPane=new JPanel();
	JLabel la=new JLabel("HELLO");
	int speed=10;
	KeyEvent_1(){
		super("상,하,좌,우 키를 이용하여 텍스트 움직이기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.addKeyListener(new MyKeyListener());
		
		la.setLocation(50,50);
		la.setSize(100,200);
		contentPane.add(la);
		
		setSize(600,600);
		setVisible(true);
		
		contentPane.requestFocus();
		//focus는 현재 관심을 받는 것을 뜻하고 "나한테 포커스를 맞춰주세요" 라는 뜻.
	}
	
	
	class MyKeyListener extends KeyAdapter
	{
		public void keyPressed(KeyEvent e)
		{
			int keyCode=e.getKeyCode();
			switch(keyCode)
			{
			case KeyEvent.VK_UP:
				la.setLocation(la.getX(),la.getY()-speed);
				break;
				
			case KeyEvent.VK_DOWN:
				la.setLocation(la.getX(),la.getY()+speed);
				break;
				
			case KeyEvent.VK_LEFT:
				la.setLocation(la.getX()-speed,la.getY());
				break;
				
			case KeyEvent.VK_RIGHT:
				la.setLocation(la.getX()+speed,la.getY());
				break;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new KeyEvent_1();
	}

}
