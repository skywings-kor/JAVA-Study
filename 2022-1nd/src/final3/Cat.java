package final3;

public class Cat implements Animal{
	
	public void sound(int time)
	{
		for(int i=1; i<=time; i++)
		{
			System.out.println("�Ŀ�");
		}
	}
	
	public void eat(String food)
	{
		System.out.println(food+"�ȳ�");
	}
}
