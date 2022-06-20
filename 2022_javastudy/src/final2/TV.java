package final2;

public class TV implements PowerControl{
	String device="TV";
	
	public void powerOn()
	{
		System.out.println("PowerOn-> "+this.device);
	}
	
	public void powerOff()
	{
		System.out.println("PowerOff-> "+this.device);
	}
}
