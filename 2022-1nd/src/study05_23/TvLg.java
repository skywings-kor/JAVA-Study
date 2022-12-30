package study05_23;

public class TvLg implements IPowerControl{
	
	String device = "LG TV";
	
	//인터페이스라서 오버라이딩 써줄 필요없음
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
