package finalteststudy;

public class SamsungTV implements PowerControl{
	
	String device="Samsung";
	public void powerOn()
	{
		System.out.println("PowerOn-> "+this.device);
	}
	
	public void powerOff()
	{
		System.out.println("PowerOff-> "+this.device);
	}
}
