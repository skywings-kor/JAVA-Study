package ex6;
import java.util.Scanner;
public class calmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inin=new Scanner(System.in);
		int user;
		int f,s;
		int alres;
		System.out.println("사칙연산 방법: 1:더하기, 2:뺄셈, 3:곱하기, 4:나누기");
		
		System.out.print("첫번째 숫자: ");
		f=inin.nextInt();
		
		System.out.print("두번째 숫자: ");
		s=inin.nextInt();
		
		System.out.print("사칙연산 방법 선택: ");
		user=inin.nextInt();
		
		if(user==1)
		{
			alres=calcu.plus(f, s);
			System.out.printf("결과:%d",alres);
		}
		
		else if(user==2)
		{
			alres=calcu.minus(f, s);
			System.out.printf("결과:%d",alres);
		}
		else if(user==3)
		{
			alres=calcu.gob(f, s);
			System.out.printf("결과:%d",alres);
		}
		else if(user==4)
		{
			calcu dr1=new calcu();
			dr1.nanu(f, s);
		}
		
		
		
	}

}
