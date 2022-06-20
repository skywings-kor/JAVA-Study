package finalteststudy;

public class Cat_in implements Animal_in{
	
	public void sound(int time)
	{
		for(int i=1;i<=time;i++)
		{
			System.out.println("³Ä¿Ë");
		}
	}
	
	public void eat(String food)
	{
		System.out.println(food+"¸¦ ¸Ô½À´Ï´Ù");
	}
	
	

}
