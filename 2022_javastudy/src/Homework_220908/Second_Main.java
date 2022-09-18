
public class Second_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a;
		
		Second_Input in=new Second_Input();
		System.out.println("인치입력:");
		a=in.userin();
		
		
		
		Second_Cal ch=new Second_Cal(a);
		ch.change();
		System.out.printf("변환: %f cm",ch.res);
		
	}

}
