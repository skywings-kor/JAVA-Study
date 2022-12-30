package java_book;

public class Q6_3_1 {

	public static void main(String[] args) {	
		// TODO Auto-generated method stub
		int res;
		res=seung(5);
		System.out.println(res);
	}
	
	public static int seung(int a)
	{
		
		if(a==0)
		{
			return 1;
		}
		
		return 2*seung(a-1);
		
	}

}
