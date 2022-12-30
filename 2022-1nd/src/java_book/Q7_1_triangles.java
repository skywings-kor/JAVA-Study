package java_book;

public class Q7_1_triangles {
	int down;
	int height;
	
	public Q7_1_triangles(int indown,int inheight)
	{
		down=indown;
		height=inheight;
	}
	
	public void downchange(int a)
	{
		down=a;
	}
	
	public void heightchange(int b)
	{
		height=b;
	}
	
	public void result()
	{
		float res=0;
		res=(float)(down*height/2);
		
		System.out.printf("삼각형의 넓이는 %.1f 입니다\n",res);
	}
	
}
