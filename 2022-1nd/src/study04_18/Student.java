package study04_18;

public class Student extends Human{
	
	//�л�����
	String depart;
	String snumber;
	String grade;

	
	public Student(String n, String a,String g,String c,String depart,String snum,String grade)
	{
		
		//�θ��� �����ڰ� �ֿ켱���� ȣ��Ǿ� ó���ȴ�.
		super(n,a,g,c );//�ݵ�� ù ���ο� �;��Ѵ�.
		this.depart=depart;
		this.snumber=snum;
		this.grade=grade;
	}
	
	public void print()
	{
		super.print();

		System.out.printf("�а�:%s\n"+"�й�:%s\n"+"�г�:%s\n",this.depart,this.snumber,this.grade);
		
	}	
	
	
}
