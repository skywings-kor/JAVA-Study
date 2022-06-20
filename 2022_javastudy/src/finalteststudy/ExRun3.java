package finalteststudy;

public class ExRun3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RemoteControl rc=new RemoteControl();
		
		SamsungTV st= new SamsungTV();
		Audio ad=new Audio();
		
		rc.turnOnObject(st);
		rc.turnOnObject(ad);
		
		rc.turnOffObject(ad);
		rc.turnOffObject(st);
		
		
	}

}
