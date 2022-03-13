
public class ch2to7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int score =100;		//final로 상수로 만든것임	 final로 선언하면 값 못바꾼다는 뜻
		
		boolean power=true;
		
		byte b=127;
		
		int oct=010;
		int hex=0x10;
		
		long l=10_000_000_000L;
		
		float f = 3.14f;
		double d=3.14f;
		
		char ch='A';	//두개 이상이거나 하나도 없으면 오류 뜸
		int i='A';		
		
		String str2="ABCD";		//하나도 없어도, 하나만 있어도, 여러개 있어도 가능
		String str3="123";		
		String str4=str2+str3;
		
		System.out.println(""+7+7);		//결과 77
		System.out.println(7+7+"");		//결과 14			
		
		
		
	
	}

}
