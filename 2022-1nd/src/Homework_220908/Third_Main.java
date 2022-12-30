
public class Third_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a;
		
		Third_Input in=new Third_Input();
		System.out.println("정수입력(1~10):");
		a=in.userin();
		
		
		
		Third_Cal ch=new Third_Cal(a);
		ch.change();
		System.out.printf("변환을 마쳤습니다.");
		
	}

}
