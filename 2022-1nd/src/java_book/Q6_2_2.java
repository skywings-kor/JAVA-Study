package java_book;

public class Q6_2_2 {

	public static void main(String[] args) {	
		// TODO Auto-generated method stub
		int tf;

		int user=23;
		int count=0;
		tf=truefalse(user);
		
		if(tf==1)		//소수일경우
		{
	 		for(int i=1;i<=100;i++)
			{
				count=0;
				for(int j=1;j<=i;j++)
				{
					if(i%j==0)
					{
						count+=1;
					}
				}
				if(count==2)
				{
					System.out.println(i);
				}
			}
		}
		else
		{
			System.out.println("소수가 아닙니다");
		}
		
		
	}
	
	public static int truefalse(int a)
	{
		int count=0;
		for(int i=1; i<=a;i++)
		{
			if(a%i==0)
			{
				count+=1;
			}
			
		}
		
		if (count==2)
		{
			return 1;
		}
		
		else
		{
			return 0;
		}
		
	}
	
	

}
