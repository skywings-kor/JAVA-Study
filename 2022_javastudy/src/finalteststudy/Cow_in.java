package finalteststudy;

public class Cow_in implements Animal_in{
	
	public void sound(int time)
	{
		for(int i=1;i<=time;i++)
		{
			System.out.println("음메");
		}
	}
	
	public void eat(String food)
	{
		System.out.println(food+"를 먹습니다");
	}


}
