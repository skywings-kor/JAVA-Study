package teststudy;

public class Star {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=10;i++)
		{
			for(int k=1;k<=10-i;k++)
			{
				System.out.printf(" ");
			}
			for(int j=1;j<=i;j++)
			{
				System.out.printf("*");
			}
			System.out.printf("\n");
			
		}
	}

}
