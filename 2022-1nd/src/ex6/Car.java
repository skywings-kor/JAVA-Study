package ex6;

public class Car {
	String company;
	String model;
	String color;
	String maxSpeed;
	String speed;
	
	public Car(String c,String m, String ic,String ms, String s)
	{
		company=c;
		model=m;
		color=ic;
		maxSpeed=ms;
		speed=s;
	}
	
	public void printinfo()
	{
		System.out.printf("����ȸ��:%s \n",this.company);
		System.out.printf("����ȸ��:%s \n",this.model);
		System.out.printf("����ȸ��:%s \n",this.color);
		System.out.printf("����ȸ��:%s \n",this.maxSpeed);
		System.out.printf("����ȸ��:%s \n",this.speed);
	}
	
}
