package final2;

public class RemoteControl {
	
	public void turnOn(PowerControl device)
	{
		if(device instanceof Audio)
		{
			System.out.printf("오디오 : ");
			device.powerOn();
		}
		
		else if(device instanceof TV)
		{
			System.out.printf("TV: ");
			device.powerOn();
		}
		
		
	}
	
	public void turnOff(PowerControl device)
	{
		if (device instanceof Audio)
		{
			System.out.printf("오디오 : ");
			device.powerOff();
		}
		
		else if(device instanceof TV)
		{
			System.out.printf("TV: ");
			device.powerOff();
		}
	}
}
