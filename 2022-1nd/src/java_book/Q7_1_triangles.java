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
		
		System.out.printf("�ﰢ���� ���̴� %.1f �Դϴ�\n",res);
	}
	
}
