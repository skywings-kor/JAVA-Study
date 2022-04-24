package java_ppt;

public class Extends3_study_school extends Extends3_study_Basic{
	
	String studentnum;
	int birth;
	public Extends3_study_school(String id,String ps,String name,String live, String instnum,int inbirth)
	{
		super(id,ps,name,live);
		this.studentnum=instnum;
		this.birth=inbirth;
	}
	
	public void printstnum()
	{
		super.printmain();
		System.out.printf(" 학번:%s, 생일:%d",this.studentnum,this.birth);
	}
}
