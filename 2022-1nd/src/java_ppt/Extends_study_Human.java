package java_ppt;

public class Extends_study_Human {
	String name;
	String gender;
	String address;
	String cellphone;
	
	public Extends_study_Human(String n,String g,String a,String c)
	{
		this.name=n;
		this.gender=g;
		this.address=a;
		this.cellphone=c;
	}
	
	public void print()
	{
		System.out.printf("이름:%s\n주소:%s\n성별:%s\n연락처:%s\n",this.name,this.gender,this.address,this.cellphone);
	}
}
