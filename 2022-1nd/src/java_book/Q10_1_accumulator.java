package java_book;

public class Q10_1_accumulator {
	static int sum=0;
	
	static void add(int a)
	{
		sum=sum+a;
	}
	
	static void showResult()
	{
		System.out.println("1부터 10까지 더한결과-> "+sum);
	}
	
}
