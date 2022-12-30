package finalteststudy;

public class Audio implements PowerControl{
	String device="Audio";
	
	public void powerOn()
	{
		System.out.println("PowerOn-> "+this.device);
	}
	
	public void powerOff()
	{
		System.out.println("PowerOff-> "+this.device);
	}
}
