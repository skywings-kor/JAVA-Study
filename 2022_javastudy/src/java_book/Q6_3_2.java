package java_book;

public class Q6_3_2 {

	public static void main(String[] args) {	
		// TODO Auto-generated method stub
		
		lee(8);

	}
	
	public static int lee(int a)
	{
		int bin=0;
		if(a>0)
		{
			bin=a%2;
			a=a/2;
			System.out.println(bin);
			return lee(a);
			
		}
		
		else
		{
			return 0;
		}
		
	}

}
