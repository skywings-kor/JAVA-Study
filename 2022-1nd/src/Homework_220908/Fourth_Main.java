
public class Fourth_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] user=new int[5];
		Fourth_Input in=new Fourth_Input();
		System.out.println("1번째 정수:");
		user[0]=in.userin();
		System.out.println("2번째 정수:");
		user[1]=in.userin();
		System.out.println("3번째 정수:");
		user[2]=in.userin();
		System.out.println("4번째 정수:");
		user[3]=in.userin();
		System.out.println("5번째 정수:");
		user[4]=in.userin();
		
		
		Fourth_Cal ch=new Fourth_Cal(user);
		ch.calres();
		System.out.printf("평균:%d",ch.res);
		
	}

}
