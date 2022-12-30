package study05_23;

public class Audio implements IPowerControl{
	String device="My Audio";
	
	public void powerOn()
	{
		System.out.println("Power On- " +this.device);
	}
	
	public void powerOff()
	{
		System.out.println("Power Off- "+this.device);
	}
}