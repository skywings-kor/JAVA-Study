package java_ppt;

public class Extends2_Human {
	String name;
	int age;
	int height;
	int weight;
	
	public Extends2_Human(String inname,int inage,int inheight,int inweight)
	{
		name=inname;
		age=inage;
		height=inheight;
		weight=inweight;
		
	}

	public String toString()
	{
		String data=name+"\t"+age+"\t"+height+"\t"+weight;
		return data;
	}
}
