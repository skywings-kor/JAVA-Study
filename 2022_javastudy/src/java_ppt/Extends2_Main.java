package java_ppt;

public class Extends2_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Extends2_StudentExam se[]=new Extends2_StudentExam[3];
		
		se[0]=new Extends2_StudentExam("ȫ�浿",15, 181, 91,"201101");
		se[1]=new Extends2_StudentExam("���浿",17, 169, 69,"191101");
		se[2]=new Extends2_StudentExam("�ڱ浿",19, 174, 82,"181101");
		
		for(Extends2_StudentExam sm:se)
		{
			System.out.println(sm.toString());
		}
		
	}

}
