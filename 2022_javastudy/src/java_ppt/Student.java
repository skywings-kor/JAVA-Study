package java_ppt;

public class Student {
	String name;
	String id;
	String st;
	
	public Student(String inname,String inid,String inst)
	{
		name=inname;
		id=inid;
		st=inst;
	}
	
	public void print()
	{
		System.out.printf("�̸�:%s, ���̵�:%s , �а�:%s\n",name,id,st);
	}
}
