package java_pbl_0404;

public class Student {
	String name;
	String id;
	String department;
	
	//�������� �̸��� �ݵ�� class�� �����ؾ��Ѵ�
	
	public Student(String n,String i,String de)
	{
		
		this.name=n;
		this.id=i;
		this.department=de;
	}
	
	
	
	public void printstu()
	{
		System.out.printf("�̸�-> %s , ID->%s, �μ�->%s \n",this.name,this.id,this.department);
	}
	
}
