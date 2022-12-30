package teststudy;

public class Study0425class2 extends Study0425classbasic{
	
	String c;
	int d;
	public Study0425class2 (String ina, int inb, String inc, int ind)
	{
		super(ina,inb);
		this.c=inc;
		this.d=ind;
	}
	
	public void printclass2()
	{
		super.printmain();
		System.out.printf(" %s, %d ",this.c,this.d);
	}
}
