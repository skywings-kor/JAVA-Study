package java_ppt;

public class Extends3_study_studentnumber extends Extends3_study_Basic{
	String school;
	int age;
	
	public Extends3_study_studentnumber(String a,String b,String c,String d,String inschool,int inage)
	{
		super(a,b,c,d);
		this.school=inschool;
		this.age=inage;
	}
	
	public void stnumprint()
	{
		super.printmain();
		System.out.printf(" �б�:%s, ����:%d",this.school,this.age);
	}

}
