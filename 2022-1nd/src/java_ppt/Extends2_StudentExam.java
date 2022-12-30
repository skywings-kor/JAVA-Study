package java_ppt;

public class Extends2_StudentExam extends Extends2_Human
{
	String number;
	
	public Extends2_StudentExam(String inname,int inage,int inheight,int inweight,String innumber)
	{
		super(inname,inage,inheight,inweight);
		this.number=innumber;
	}
	
	public String toString()
	{
		String alldata;
		
		alldata=super.toString()+"\t"+number;
		
		return alldata;
		
	}
	
	public void prn()
	{
		
	}
	
}
