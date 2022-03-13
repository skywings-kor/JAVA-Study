import java.util.Scanner;
//import java.util.*; 해도 됨 (이건 전체 기능선언)


public class ch2to14
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		
//		int num=scanner.nextInt();
//		int num2=scanner.nextInt();
//		System.out.println(num);
//		System.out.println(num2);
		
		//라인 단위로 입력받으려면
		String input=scanner.nextLine();
		int num=Integer.parseInt(input);
		
		System.out.println(num);
	}

}
