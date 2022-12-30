package study05_30;

//이건 너무 노가다성이 심하니
//import study05_30_yourpackage.sub.Yourinfo;
//import study05_30_yourpackage.sub.Your2nd;

//이걸 사용함(모든 클래스 다 참조한다는 뜻)
import study05_30_yourpackage.sub.*;

public class ExRun {
	
	//static 메소드 내에서는 메소드나 그런것들을 쓸 수 없어서 오류뜸
	//int a=10;
	
	//a라는게 메모리 상에 존재하려면 이미 객체에 생성되어있어야 함으로 
	//객체 생성이 필요'
	static int a=10;
	
	
	static public void print()
	{
		System.out.println("my class ExRun");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Myinfo my=new Myinfo();
//		
//		my.print();
//		
//		
//		이건 너무 노가다가 심하니 저위에 import 전체 해당 페키지 참조를 하여 가볍게 한다
//		study05_30_yourpackage.sub.Yourinfo your =new study05_30_yourpackage.sub.Yourinfo();
//		your.print();
//		
//		Yourinfo your2=new Yourinfo();		
//		Your2nd your3=new Your2nd();
//		
//		
//		
//		//두번쨰 수업
//		Person p1=new Person("kim");
//		System.out.println("My name is "+p1.getName());
//		System.out.println("Count: "+p1.getCount());
//		
//		Person p2=new Person("yoon");
//		System.out.println("My name is "+p2.getName());
//		System.out.println("Count: "+p2.getCount());
//		
//		Person p3=new Person("park");
//		System.out.println("My name is "+p3.getName());
//		System.out.println("Count: "+p3.getCount());
//		
		
		
		
//		//세번째 수업
//		ExRun er=new ExRun();		//이렇게 객체 생성을해서 접근할 수 있도록함
//		System.out.println(er.a);		//이렇게 접근
//		er.print();
	
		//이렇게 최종적으로 하면 됨
		System.out.println(ExRun.a);
		print();
		
		
		//static이 가지고 있는 의미를 알고있어야함
		//정적메소드 내에서는 클래스의 인스턴스 내부에 접근이 불가능
		
		//시험주의
//		//public class ExRun{ int a=10;
//		public static void ~~(){
//			System.out.println(a);
//			
//			}
//		
//		}
//		이렇게 하여 		
		
	}

}
