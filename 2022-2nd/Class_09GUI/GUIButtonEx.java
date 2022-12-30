import javax.swing.*;
import java.awt.*;

//자바 이벤트는 이벤트에 따라서 내 프로그램이 어떻게 동작해야하는지가 결정됨... 
//GUI를 이용해서 이벤트를 들을 수 도 있어야하고 처리할 수도 있어야함.		
import java.awt.event.*;
import javax.swing.event.*;

public class GUIButtonEx extends JFrame{
	public GUIButtonEx()
	{
		setTitle("GUIButtonEx과 JFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//메모리 상에서 아에 꺼져버리도록 실행하는 코드 부분임.
		
		Container contentPane=getContentPane();		//container 창조변수 만듬, 객체처럼, 
		contentPane.setBackground(Color.BLUE);
		contentPane.setLayout(new FlowLayout());
		contentPane.add(new JButton("OK"));
		contentPane.add(new JButton("Cancel"));
		contentPane.add(new JButton("Ignore"));
		
		setSize(350,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GUIButtonEx cp=new GUIButtonEx();
		
		
	}

}
