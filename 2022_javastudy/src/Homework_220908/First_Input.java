import java.util.Scanner;

public class First_Input {
	Scanner sc=new Scanner(System.in);
	public First_Input()
	{
		
	}
	
	int getInt()
	{
		int i;
		i=sc.nextInt();
		return i;
	}
	
	double getDouble()
	{
		double i;
		System.out.println("실수 입력:");
		i=sc.nextDouble();
		return i;
	}
	
	String getString()
	{
		String i;
		System.out.println("문자입력:");
		i=sc.nextLine();
		return i;
	}
}
