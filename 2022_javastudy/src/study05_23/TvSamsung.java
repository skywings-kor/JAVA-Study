package study05_23;

public class TvSamsung implements IPowerControl{
	
	String device = "Samsung TV";
	
	//인터페이스라서 오버라이딩 써줄 필요없음
	
	//인터페이스에서 만든 함수들을 그대로 가지고 있어야함 꼭!!기억!!
	
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
