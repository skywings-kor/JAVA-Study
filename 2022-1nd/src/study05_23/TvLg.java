package study05_23;

public class TvLg implements IPowerControl{
	
	String device = "LG TV";
	
	//�������̽��� �������̵� ���� �ʿ����
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
