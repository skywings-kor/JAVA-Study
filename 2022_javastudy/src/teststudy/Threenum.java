package teststudy;

public class Threenum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res=0;
		for(int i=1;i<=100;i++)
		{
			
			if(i%3==0)
			{
				System.out.println(i);
				res=res+i;
			}
		}
		
		System.out.println();
		System.out.println("3ÀÇ¹è¼ö ÃÑÇÕ:"+res);
		
	}

}
