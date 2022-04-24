package java_book;

public class Q9_1_circle {
	int xPos;
	int yPos;
	int radius;
	Q9_1_point center;
	
	public Q9_1_circle(int a,int b, int inradius)
	{
		xPos=a;
		yPos=b;
		radius=inradius;
		center=new Q9_1_point(xPos,yPos);
	}
	
	public void showcircleInfo()
	{
		center.showPointInfo();
		System.out.printf("¹ÝÁö¸§:%d",radius);
	}
	
	
}
