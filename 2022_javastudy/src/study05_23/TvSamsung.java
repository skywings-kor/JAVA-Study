package study05_23;

public class TvSamsung implements IPowerControl{
	
	String device = "Samsung TV";
	
	//�������̽��� �������̵� ���� �ʿ����
	
	//�������̽����� ���� �Լ����� �״�� ������ �־���� ��!!���!!
	
	//@Override
	public void powerOn()
	{
		System.out.println("Power On- "+this.device);
	}
	
	//
	//@Override
	public void powerOff()
	{
		System.out.println("Power Off- "+this.device);
	}
	
}
