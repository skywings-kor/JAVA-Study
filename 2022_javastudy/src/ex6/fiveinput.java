package ex6;
import java.util.Scanner;
public class fiveinput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		int num1;
		System.out.print("1��° ������ �Է��Ͻÿ�: ");
		num1=scan.nextInt();
		
		int num2;
		System.out.print("2��° ������ �Է��Ͻÿ�: ");
		num2=scan.nextInt();
		
		int num3;
		System.out.print("3��° ������ �Է��Ͻÿ�: ");
		num3=scan.nextInt();
		
		int num4;
		System.out.print("4��° ������ �Է��Ͻÿ�: ");
		num4=scan.nextInt();
		
		int num5;
		System.out.print("5��° ������ �Է��Ͻÿ�: ");
		num5=scan.nextInt();
		
		float res=0;
		res=(num1+num2+num3+num4+num5)/5;
		
		System.out.printf("5���� ���� �����: %.1f",res);
		
	}

}
