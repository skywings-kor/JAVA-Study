package ex6;
import java.util.Scanner;
public class calmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inin=new Scanner(System.in);
		int user;
		int f,s;
		int alres;
		System.out.println("��Ģ���� ���: 1:���ϱ�, 2:����, 3:���ϱ�, 4:������");
		
		System.out.print("ù��° ����: ");
		f=inin.nextInt();
		
		System.out.print("�ι�° ����: ");
		s=inin.nextInt();
		
		System.out.print("��Ģ���� ��� ����: ");
		user=inin.nextInt();
		
		if(user==1)
		{
			alres=calcu.plus(f, s);
			System.out.printf("���:%d",alres);
		}
		
		else if(user==2)
		{
			alres=calcu.minus(f, s);
			System.out.printf("���:%d",alres);
		}
		else if(user==3)
		{
			alres=calcu.gob(f, s);
			System.out.printf("���:%d",alres);
		}
		else if(user==4)
		{
			calcu dr1=new calcu();
			dr1.nanu(f, s);
		}
		
		
		
	}

}
