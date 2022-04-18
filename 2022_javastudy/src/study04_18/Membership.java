package study04_18;

public class Membership extends Human{

	
	//추가정보
	String job;
	String hobby;
	public Membership(String n,String a,String g, String c,String job, String hobby)
	{
		super(n,a,g,c);
		this.job=job;
		this.hobby=hobby;
	}
	public void print()
	{
		super.print();
		System.out.printf("직업:%s\n"+"취미:%s\n",this.job,this.hobby);
	} 
	
	
}
