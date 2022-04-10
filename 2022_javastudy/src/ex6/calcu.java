package ex6;

public class calcu {
	
	int first,second;
	int res=0;
	
	static int plus(int a,int b)
	{
		return a+b;
	}
	
	static int minus(int a,int b)
	{
		return a-b;
	}
	
	static int gob(int a, int b)
	{
		return a*b;
	}
	
	public void nanu(int a, int b)
	{
		int nabig;
		float nares;
		nabig=a/b;
		nares=a%b;
		System.out.printf("결과는: %d, 나머지는: %.1f",nabig,nares);
	}
	
}
