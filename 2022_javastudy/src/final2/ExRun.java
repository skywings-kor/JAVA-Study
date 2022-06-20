package final2;

public class ExRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RemoteControl rc=new RemoteControl();
		
		Audio ad=new Audio();
		TV tv=new TV();
		
		rc.turnOn(ad);
		rc.turnOff(ad);
		
		rc.turnOn(tv);
		rc.turnOff(tv);
		
	}

}
