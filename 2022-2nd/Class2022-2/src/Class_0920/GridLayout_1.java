package Class_0920;
import javax.swing.*;
import java.awt.*;

public class GridLayout_1 extends JFrame{
	GridLayout_1(){
		setTitle("GridLayout S");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		
		GridLayout grid=new GridLayout(5,2);
		grid.setVgap(5);
		c.setLayout(grid);
		c.add(new JLabel(" 이름"));
		c.add(new JTextField(""));
		//c.setLayout(grid);
		c.add(new JLabel(" 학번"));
		c.add(new JTextField(""));
		//c.setLayout(grid);
		c.add(new JLabel(" 학과"));
		c.add(new JTextField(""));
		//c.setLayout(grid);
		c.add(new JLabel(" 과목"));
		c.add(new JTextField(""));
		//c.setLayout(grid);
		c.add(new JButton(" OK"));
		c.add(new JButton(" Cancel"));
		
		setSize(500,400);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GridLayout_1();
	}

}
