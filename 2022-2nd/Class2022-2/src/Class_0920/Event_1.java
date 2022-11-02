package Class_0920;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.StringTokenizer;

public class Event_1 extends JFrame{
	//actionevent 기본적으로 사용할 수 있어야함.. 
	//MouseEvent 마우스 이벤트 역시 다루고
	//KeyEvent 까지 중점적으로 해봄
	Event_1(){
		setTitle("Action 이벤트 리스너 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		JButton btn=new JButton("Action");
		btn.addActionListener(new MyActionListener());
		c.add(btn);
		
		JButton ptn=new JButton("박규민");
		ptn.addActionListener(new MyActionListener());
		c.add(ptn);
		
		setSize(550,420);
		setVisible(true);
	}
	
	//내부 클래스 선언
	//implements 구현
	//구현클래스의 경우 ActionListener에 있는 추상메소드를 모두 재정의해야함
	private class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			JButton b=(JButton)e.getSource();
			
			
			//b.getText는 String 객체는 문자열 비교를 위한 매소드 equals 같으면은 True, 아니면은 False로 반환
			if(b.getText().equals("Action"))
				b.setText("액션");
			
			else if(b.getText().equals("액션"))
				b.setText("Action");
			
			else if(b.getText().equals("박규민"))
				b.setText("ParkGyuMin");
			
			else if(b.getText().equals("ParkGyuMin"))
				b.setText("박규민");
			
			
			setTitle(b.getText());
			
		}
		
	}
	

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Event_1();
	}

}


