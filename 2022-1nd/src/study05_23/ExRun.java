package study05_23;

public class ExRun {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	RemoteControl rc=new RemoteControl();
	
	TvSamsung tvS=new TvSamsung();
	TvLg tvL=new TvLg();
	Aircon air=new Aircon();
	
	rc.turnOn(tvS);
	rc.turnOn(tvL);
	rc.turnOn(air);
	
	rc.turnOff(air);
	rc.turnOff(tvL);
	rc.turnOff(tvS);
	
	
	//새로 추가된 장치
	Audio audio = new Audio();
	
	rc.turnOn(audio);
	rc.turnOff(audio);
	}
}
	