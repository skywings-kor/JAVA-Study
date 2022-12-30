package java_ppt;

public class Ex4_student {
	String name;
	String id;
	String department;
	
	public Ex4_student(String inname,String inid,String indepartment)
	{
		name=inname;
		id=inid;
		department=indepartment;
	}
	
	public void setName(String setname)
	{
		this.name=setname;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setId(String setid)
	{
		this.id=setid;
	}
	
	public String getId()
	{
		return id;
	}
	
	public void setDepartment(String indepart)
	{
		this.department=indepart;
	}
	
	public String getDepartment()
	{
		return department;
	}
	
	public void printStudentInfo()
	{
		System.out.printf("이름:%s 아이디:%s 부서:%s\n",this.name,this.id,this.department);
	}
	
	
	
	
	
}
