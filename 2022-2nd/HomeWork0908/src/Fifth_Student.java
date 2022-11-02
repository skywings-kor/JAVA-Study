
public class Fifth_Student extends Fifth_Person {
	String school;
	String dong;
	
	public Fifth_Student(String na,String ag, String sc,String don)
	{
		super(na,ag);//Person 클래스의 것을 상속받습니다
		this.school=sc;
		this.dong=don;
	}
	
	
	public void printper()
	{
		super.username();
		super.userage();
	}
	
	public void print()
	{
		printper();
		System.out.printf("<학교:%s> <나이:%s> \n",this.school,this.dong);
	}
	
	
}
