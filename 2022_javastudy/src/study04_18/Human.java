package study04_18;

public class Human {
	//신상정보
	String name;
	String address;		//==private String address 랑 같음
	protected String gender;		//
	String cellphone;
	
	public Human(String n, String a, String g, String c)
	{
		this.name=n;
		this.address=a;
		this.gender=g;
		this.cellphone=c;
	}
	
	public void print()
	{
		System.out.printf(""+"<신상정보>\n"+"이름:%s\n"+"주소:%s\n"+"성별:%s\n"+"연락처:%s\n",this.name,this.address,this.gender,this.cellphone);
	}
	
	
	
}
