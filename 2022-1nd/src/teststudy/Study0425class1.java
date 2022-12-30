package teststudy;

public class Study0425class1 extends Study0425class2{
	int e;
	String f;
	public Study0425class1 (String ina,int inb,String inc,int ind,int ine, String inf)
	{
		super(ina,inb,inc,ind);
		e=ine;
		f=inf;
		
	}
	
	public void printclass1()
	{
		super.printclass2();
		System.out.printf(" %d %s ",this.e,this.f);
	}
}
