package ex6;
import java.util.Scanner;
public class fiveinput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		int num1;
		System.out.print("1번째 정수를 입력하시오: ");
		num1=scan.nextInt();
		
		int num2;
		System.out.print("2번째 정수를 입력하시오: ");
		num2=scan.nextInt();
		
		int num3;
		System.out.print("3번째 정수를 입력하시오: ");
		num3=scan.nextInt();
		
		int num4;
		System.out.print("4번째 정수를 입력하시오: ");
		num4=scan.nextInt();
		
		int num5;
		System.out.print("5번째 정수를 입력하시오: ");
		num5=scan.nextInt();
		
		float res=0;
		res=(num1+num2+num3+num4+num5)/5;
		
		System.out.printf("5개의 정수 평균은: %.1f",res);
		
	}

}
