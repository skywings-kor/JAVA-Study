package study04_18;

public class Human {
	//�Ż�����
	String name;
	String address;		//==private String address �� ����
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
		System.out.printf(""+"<�Ż�����>\n"+"�̸�:%s\n"+"�ּ�:%s\n"+"����:%s\n"+"����ó:%s\n",this.name,this.address,this.gender,this.cellphone);
	}
	
	
	
}
