package study05_23;

public class Aircon implements IPowerControl{
	
	String device = "Air conditioner";
	
	public void powerOn()
	{
		System.out.println("Power On- "+this.device);

	}
	
	public void powerOff()
	{
		System.out.println("Power Off- "+this.device);

	}
	
}
