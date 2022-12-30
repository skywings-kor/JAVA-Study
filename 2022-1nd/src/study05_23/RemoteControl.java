package study05_23;

public class RemoteControl{
	
	
	public void turnOn(IPowerControl device)
	{
		if(device instanceof Audio)
		{
			System.out.printf("�������ġ: ");
			device.powerOn();
		}
		
		else if(device instanceof Aircon)
		{
			System.out.printf("������: ");
			device.powerOn();
		}
		
		else if(device instanceof TvLg)
		{
			System.out.printf("LGTV: ");
			device.powerOn();
		}
		
		else if(device instanceof TvSamsung)
		{
			System.out.printf("SamsungTV: ");
			device.powerOn();
		}
		
		else
		{
			device.powerOn();
		}
		
		
	}

	
	public void turnOff(IPowerControl device)
	{
		if(device instanceof Audio)
		{
			System.out.printf("�������ġ: ");
			device.powerOff();
		}
		
		else if(device instanceof Aircon)
		{
			System.out.printf("������: ");
			device.powerOff();
		}
		
		else if(device instanceof TvLg)
		{
			System.out.printf("LGTV: ");
			device.powerOff();
		}
		
		else if(device instanceof TvSamsung)
		{
			System.out.printf("SamsungTV: ");
			device.powerOff();
		}
		
		else
		{
			device.powerOff();
		}
	}
	
	
	//�Ʒ� �ּ�ó�� �̷��� ������ ����� �ʿ䰡 ���� �� 2���� �Լ��� ����ؼ�
	//�ᱹ �������̽� Ÿ������ �޾Ƽ� ó���� ����!`
	
	
//	
//	//���߿� �߰��� Ŭ���� Ÿ���� �޼ҵ� �����ε� �߰�
//		public void turnOn(Audio device)
//		{
//			device.powerOn();
//		}
//		
//		public void turnOff(Audio device)
//		{
//			device.powerOff();
//		}
//		
//	
//	public void turnOn(TvSamsung device)
//	{
//		device.powerOn();
//	}
//	
//	public void turnOff(TvSamsung device)
//	{
//		device.powerOff();
//	}
//	
//	public void turnOn(TvLg device)
//	{
//		device.powerOn();
//	}
//	
//	public void turnOff(TvLg device)
//	{
//		device.powerOff();
//	}
//	
//	public void turnOn(Aircon device)
//	{
//		device.powerOn();
//	}
//	
//	public void turnOff(Aircon device)
//	{
//		device.powerOff();
//	}
	
	
	
	
	
}
