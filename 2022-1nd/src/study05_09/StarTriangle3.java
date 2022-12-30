package study05_09;

public class StarTriangle3 {
	
	public void run()
	{
		for(int i=0; i<=9;i++)
		{
			for(int j=0;j<=9-i;j++)
			{
				System.out.printf(" ");
			}
			
			for(int k=1;k<=i*2+1;k++)
			{	
				System.out.printf("*");
			}
			
			
			for(int q=0;q<=9-i;q++)
			{
				System.out.printf(" ");
			}
			System.out.printf("\n");
		}
	}
	
}
