package study05_23;

public class RemoteControl{
	
	
	public void turnOn(IPowerControl device)
	{
		if(device instanceof Audio)
		{
			System.out.printf("오디오장치: ");
			device.powerOn();
		}
		
		else if(device instanceof Aircon)
		{
			System.out.printf("에어컨: ");
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
			System.out.printf("오디오장치: ");
			device.powerOff();
		}
		
		else if(device instanceof Aircon)
		{
			System.out.printf("에어컨: ");
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
	
	
	//아래 주석처럼 이렇게 개많이 고생할 필요가 없다 위 2가지 함수만 사용해서
	//결국 인터페이스 타입으로 받아서 처리가 가능!`
	
	
//	
//	//나중에 추가된 클래스 타입을 메소드 오버로딩 추가
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
