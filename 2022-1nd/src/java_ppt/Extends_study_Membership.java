package java_ppt;

public class Extends_study_Membership extends Extends_study_Human{
	
	String work;
	String hobby;
	
	
	public Extends_study_Membership(String n,String a,String g,String c,String w,String h)
	{
		super(n, g, a, c);
		this.work=w;
		this.hobby=h;
	}
	
	public void memberprint()
	{
		super.print();
		System.out.printf("����:%s\n���:%s\n",this.work,this.hobby);
		
	}
}
