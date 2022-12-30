package java_ppt;

public class Extends3_study_Basic {
	String id;
	String password;
	String name;
	String live;
	
	public Extends3_study_Basic(String inid,String inps,String inname,String inlive)
	{
		this.id=inid;
		this.password=inps;
		this.name=inname;
		this.live=inlive;
	}
	
	
	public void printmain()
	{
		
		System.out.printf("아이디:%s, 비번:%s, 이름:%s, 사는곳:%s",this.id,this.password,this.name,this.live);
		
	}
	
}
