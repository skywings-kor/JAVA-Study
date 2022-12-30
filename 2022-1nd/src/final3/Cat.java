package final3;

public class Cat implements Animal{
	
	public void sound(int time)
	{
		for(int i=1; i<=time; i++)
		{
			System.out.println("³Ä¿Ë");
		}
	}
	
	public void eat(String food)
	{
		System.out.println(food+"³È³È");
	}
}
