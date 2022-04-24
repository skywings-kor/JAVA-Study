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
		System.out.printf("이름:%s, 아이디:%s , 학과:%s\n",name,id,st);
	}
}
