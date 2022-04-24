package java_ppt;

public class Extends1_Class2 extends Extends1_Class1{
	
	String department;
	public Extends1_Class2(String inname,String indepart,int insa)
	{
		super(inname,insa);
		department=indepart;
		
	}
	
	public void getInformation()
	{
		System.out.printf("이름:%s , 연봉:%d, 부서:%s",getName(),getSalary(),department);
	}
	
	public void callSuper()
	{
		super.prn();
		this.prn();
	}
	
	public void prn()
	{
		System.out.println("서브클래스");
	}
	
}
