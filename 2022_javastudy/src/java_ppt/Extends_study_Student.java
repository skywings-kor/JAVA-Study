package java_ppt;

public class Extends_study_Student extends Extends_study_Human{
	String st;
	String sn;
	String grade;
	
	public Extends_study_Student(String n,String a,String g,String c,String inst,String insn,String ingrade)
	{
		super(n, a, g, c);
		this.st=inst;
		this.sn=insn;
		this.grade=ingrade;
	}
	
	public void stuprint()
	{
		super.print();
		System.out.printf("�а�:%s\n�й�:%s\n�г�:%s\n",st,sn,grade);
	}
}
