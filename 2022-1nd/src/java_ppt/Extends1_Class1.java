package java_ppt;

public class Extends1_Class1 {
	String name;
	int salary;
	
	public Extends1_Class1()
	{
		
	}
	
	Extends1_Class1(String a, int b)
	{
		name=a;
		salary=b;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getSalary()
	{
		return salary;
	}
	
	public void getinformation()
	{
		System.out.printf("�̸�:%s, ����:%d",name,salary);
	}
	
	public void prn()
	{
		System.out.println("����Ŭ����");
	}
}
