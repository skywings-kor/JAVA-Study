package java_pbl_0404;

public class Student {
	String name;
	String id;
	String department;
	
	//생성자의 이름은 반드시 class와 동일해야한다
	
	public Student(String n,String i,String de)
	{
		
		this.name=n;
		this.id=i;
		this.department=de;
	}
	
	
	
	public void printstu()
	{
		System.out.printf("이름-> %s , ID->%s, 부서->%s \n",this.name,this.id,this.department);
	}
	
}
