package finalteststudy;

public class RemoteControl{
	
	public void turnOnObject(PowerControl device)
	{
		if(device instanceof SamsungTV)
		{
			System.out.printf("Samsung TV: ");
			device.powerOn();
		}
		
		else if(device instanceof Audio)
		{
			System.out.printf("Audio: ");
			device.powerOn();
		}
		
		
		else
		{
			device.powerOn();
		}
		
	}
	
	public void turnOffObject(PowerControl device)
	{
		if(device instanceof SamsungTV)
		{
			System.out.printf("Samsung TV: ");
			device.powerOff();
		}
		
		else if(device instanceof Audio)
		{
			System.out.printf("Audio: ");
			device.powerOff();
		}
		
		else
		{
			device.powerOff();
		}
	}
	
}
