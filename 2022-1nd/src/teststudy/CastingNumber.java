package teststudy;

public class CastingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		short a,b;
		a=10;
		b=10;
		int c=a+b;
		
		short s=10;
		float f=s;
		f=f+3.5f;
		
		int largeNumber=200;
		byte smallNumber;
		smallNumber=(byte)largeNumber;
		
		System.out.println("int를 short로: "+smallNumber);
		
		float numf=3.4f;
		int numint=(int)numf;
		
		System.out.println("float를 int로: "+numint)	;
	}

}
