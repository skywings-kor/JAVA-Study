
public class Fifth_HighStudent extends Fifth_Student{
	String univ;		//목표대학
	String type;	//희망전공
	
	public Fifth_HighStudent(String na,String ag, String sc,String don,String uni,String ty)
	{
		super(na,ag,sc,don);
		this.univ=uni;
		this.type=ty;
	}
	
	@Override
	public void print()
	{
		printper();
		System.out.printf("<학교:%s> <나이:%s> <목표대학:%s> <희망전공:%s>\n",this.school,this.dong,this.univ,this.type);
		
	}

}
