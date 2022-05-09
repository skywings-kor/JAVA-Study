package study05_09;

public class StarTriangle2 {
	
	public void run()
	{
		for(int i=1; i<=10;i++)
		{
			for(int j=1;j<=10-i;j++)
			{
				System.out.printf(" ");
			}
			for(int k=1;k<=i;k++)
			{
				System.out.printf("*");
			}
			System.out.printf("\n");
		}
	}
}
