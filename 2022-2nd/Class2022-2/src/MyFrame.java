import javax.swing.*;
import java.awt.*;

//자바 이벤트는 이벤트에 따라서 내 프로그램이 어떻게 동작해야하는지가 결정됨... 
//GUI를 이용해서 이벤트를 들을 수 도 있어야하고 처리할 수도 있어야함.		
import java.awt.event.*;
import javax.swing.event.*;

public class MyFrame extends JFrame {
	
	MyFrame()
	{
		setTitle("나의 첫번째 프레임!!");
		setSize(300,500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame mf1=new MyFrame();
		
		
	}

}
