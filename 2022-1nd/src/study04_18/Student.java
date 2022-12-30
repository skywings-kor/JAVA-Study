package study04_18;

public class Student extends Human{
	
	//학생정보
	String depart;
	String snumber;
	String grade;

	
	public Student(String n, String a,String g,String c,String depart,String snum,String grade)
	{
		
		//부모의 생성자가 최우선으로 호출되어 처리된다.
		super(n,a,g,c );//반드시 첫 라인에 와야한다.
		this.depart=depart;
		this.snumber=snum;
		this.grade=grade;
	}
	
	public void print()
	{
		super.print();

		System.out.printf("학과:%s\n"+"학번:%s\n"+"학년:%s\n",this.depart,this.snumber,this.grade);
		
	}	
	
	
}
