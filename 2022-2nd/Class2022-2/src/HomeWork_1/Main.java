package HomeWork_1;
//개발자: 2019243064 박규민
//개발목적: 자바 스윙 이해도 향상과 기본적인 계산기 라는 프로그램을 제작해봄으로써 SW 지식을 향상시킬 수 있음
//개발일: 2022.09.28 ~ 2022.10.05
//최종수정일자: 2022.10.06

//이것이 패키지인데 패키지는 하나의 폴더라고 생각하면 됨..
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.tree.*;		//한놈만 지정해서 써도 됨

//해당 엑션을 기능이 인식하고 행동하려면 actionListener을 포함해줘야 작동해요!
public class Main extends JFrame implements ActionListener{
	
	//공간제어용
	JPanel northPanel=new JPanel();
	JPanel southPanel=new JPanel();
	JPanel centerPanel =new JPanel();
	
	//버튼 기능을 넣기 위한 선언용
	JButton n0=new JButton("0");
	JButton n1=new JButton("1");
	JButton n2=new JButton("2");
	JButton n3=new JButton("3");
	JButton n4=new JButton("4");
	JButton n5=new JButton("5");
	JButton n6=new JButton("6");
	JButton n7=new JButton("7");
	JButton n8=new JButton("8");	
	JButton n9=new JButton("9");
	JButton plus=new JButton("+");
	JButton minus=new JButton("-");
	JButton multi=new JButton("*");
	JButton divi=new JButton("/");
	JButton root=new JButton("rot");
	JButton dot=new JButton(".");
	JButton Clean=new JButton("Clear");
	JButton Clbu=new JButton("BackSpace");
	JButton Enbu=new JButton("Enter");
	
	//입력 공간
	JTextField inU=new JTextField();
	
	//계산기 비교할 값 저장용 num1은 숫자 저장용, oper는 연산자 저장용
	String num1="";
	String oper="";
	
	//결과 표시 하기 위한 변수
	double res=0;
	
	Main()
	{
		//타이틀은 제가 만들었다는 것을 나타낼 수 있게 만들었습니다.
		setTitle("Made By PGM-Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//배경 준비
		Container co=getContentPane();
		co.setLayout(new BorderLayout(10,10));		
		
		//그리드 레이아웃으로 공간을 3x1로 분할배치하였습니다. 가로 세로 간격을 8씩 떨어지게
		northPanel.setLayout(new GridLayout(3,1,8,8));
		//그리드 레이아웃 4x4 분할배치, 가로+세로:5씩 떨어지게
		centerPanel.setLayout(new GridLayout(4,4,15,15));		
		southPanel.setLayout(new FlowLayout());
		
		//공간 할당(가로 450 세로 50)
		inU.setPreferredSize(new Dimension(450,50));
		Clbu.setPreferredSize(new Dimension(450,50));
		Clean.setPreferredSize(new Dimension(450,50));
		
		//상단 입력부분 northPanel에 추가하였습니다
		northPanel.add(inU);
		northPanel.add(Clean);
		northPanel.add(Clbu);
		
		//중앙 버튼쪽 centerPanel에 추가하였습니다
		centerPanel.add(n1);
		centerPanel.add(n2);
		centerPanel.add(n3);
		centerPanel.add(plus);
		centerPanel.add(n4);
		centerPanel.add(n5);
		centerPanel.add(n6);
		centerPanel.add(minus);
		centerPanel.add(n7);
		centerPanel.add(n8);
		centerPanel.add(n9);
		centerPanel.add(multi);
		centerPanel.add(n0);
		centerPanel.add(dot);
		centerPanel.add(root);
		centerPanel.add(divi);
		
		//엔터 버튼 크기하고 패널에 추가하였습니다
		Enbu.setPreferredSize(new Dimension(500,50));
		southPanel.add(Enbu);
		
		//northPanel에 할당한 것은 위쪽 공간에!
		co.add(northPanel,BorderLayout.NORTH);
		//centerPanel에 할당한 것은 가운데 공간에!
		co.add(centerPanel,BorderLayout.CENTER);
		//southPanel에 할당한 것은 아래쪽 공간에!
		co.add(southPanel,BorderLayout.SOUTH);
		
		//버튼을 눌렀을 때 듣도록 하기 위한 기능
		Clbu.addActionListener(this);
		n0.addActionListener(this);
		n1.addActionListener(this);
		n2.addActionListener(this);
		n3.addActionListener(this);
		n4.addActionListener(this);
		n5.addActionListener(this);
		n6.addActionListener(this);
		n7.addActionListener(this);
		n8.addActionListener(this);
		n9.addActionListener(this);
		minus.addActionListener(this);
		plus.addActionListener(this);
		divi.addActionListener(this);
		multi.addActionListener(this);
		dot.addActionListener(this);
		root.addActionListener(this);
		Enbu.addActionListener(this);
		Clean.addActionListener(this);
		
		
		
		//프레임 창 사이즈와 표시할건지 안할건지 사이즈는 500x500으로
		setSize(500,500);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//이걸 선언해야 코드를 돌립니다
		Main mt=new Main();
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		
		//버튼을 눌렀을 때 어떤 것을 눌렀는지 해당 값을 받아와서 st라는 변수에 넣습니다.
		String st=a.getActionCommand();
		
		//이거는 아까 위에 입력 공간을 선언한 inU에서 현재 적혀있는 것이 어떤 것인지 가져와서 string으로 usertext변수에 넣습니다
		String usertext=inU.getText();
		
		//위에 버튼 눌렀을 때 이벤트 발생으로 받아온 내용이 만일 숫자에 해당하는 것이 있으면 해당 숫자를 그대로 Text 칸 안에 넣도록 하는 것입니다.
		if(st=="0"||st=="1"||st=="2"||st=="3"||st=="4"||st=="5"||st=="6"||st=="7"||st=="8"||st=="9"||st==".")
		{
			//숫자나 .을 눌렀을 경우에는 기존 있던 inU창에 적혀있던 것에다가 추가로 적혀지게 하는 코드입니다.
			inU.setText(usertext+st);
		}
		
		//BackSpace버튼 누를경우
		if(st=="BackSpace")
		{
			//지우는 기능 같은 경우에는 현재 적힌 공간에 문자 길이를 하나 줄이고 그것을 또 다시 저장하면 하나 삭제된 것처럼 됩니다.
			usertext=usertext.substring(0,usertext.length()-1);
			inU.setText(usertext);
		}
		
		
		//Clear버튼 누를 경우
		if(st=="Clear")
		{
			//결과값 기존 저장되있던 것들 초기화하고 변수에 저장되어 있던 것들을 싹 지우도록 해주는 역할입니다
			res=0;
			oper="";
			num1="";
			inU.setText("");
		}
		
		//루트 버튼 누를 경우
		if(st=="rot")
		{
			//현재 적혀진 값이 어떤 것인지 가져오고 이 가져온 값을 double형으로 변환 후 Math.sqrt 기능이 루트라서 이렇게 하면 됩니다.
			num1=usertext;
			res=Double.parseDouble(num1);
			res=Math.sqrt(res);
			System.out.println(res);
			inU.setText(""+res);
		}
		
		//- + * / 버튼을 눌렀을 경우에는
		if(st=="-" || st=="+"||st=="*" || st=="/")
		{
			num1=usertext;
			//이미 oper에 + - * / 가 있을 경우 해당 연산을 위해서 if~else로 나누었습니다
			//sysout에 있는 내용들은 제가 코드들이 잘 연산되고 있는지 확인하고
			//혹시라도 연산에 문제가 있을 경우 어느 부분에서 문제가 발생하였는지 알기 위해
			//해당 코드를 임의로 추가하여 콘솔창에서 확인만 진행하였습니다!
			if(oper=="+")
			{
				res=res+Double.parseDouble(num1);
				System.out.println(res);
			}
			
			else if(oper=="-")
			{
				res=res-Double.parseDouble(num1);
				System.out.println(res);
			}
			
			else if(oper=="*")
			{
				res=res*Double.parseDouble(num1);
				System.out.println(res);
			}
			
			else if(oper=="/")
			{
				res=res/Double.parseDouble(num1);
				System.out.println(res);
			}
			
			else
			{
				res=Double.parseDouble(num1);
			}
			
			//저장된 값이 없는 경우에는 Clear 이후 처음 작성하는 연산자이기에 각 역할 변수에 저장해줍니다.
			oper=st;
			inU.setText("");
			
		}
		
		//enter를 누를 경우에 실행하는 문장
		if(st=="Enter")
		{
			
			if(oper=="+")
			{
				res=res+Double.parseDouble(usertext);;
				inU.setText(""+res);
			}
			
			else if(oper=="-")
			{
				res=res-Double.parseDouble(usertext);
				inU.setText(""+res);
			}
			
			else if(oper=="*")
			{
				res=res*Double.parseDouble(usertext);
				inU.setText(""+res);
			}
			
			else if(oper=="/")
			{
				res=res/Double.parseDouble(usertext);
				inU.setText(""+res);
			}
			
			
		}
		
		
		
		
		
	}

}
